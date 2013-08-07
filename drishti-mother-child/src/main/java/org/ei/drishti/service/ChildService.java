package org.ei.drishti.service;

import org.ei.drishti.common.AllConstants;
import org.ei.drishti.domain.Child;
import org.ei.drishti.domain.Mother;
import org.ei.drishti.form.domain.FormSubmission;
import org.ei.drishti.form.domain.SubFormData;
import org.ei.drishti.repository.AllChildren;
import org.ei.drishti.repository.AllMothers;
import org.ei.drishti.service.formSubmission.handler.ReportFieldsDefinition;
import org.ei.drishti.service.reporting.ChildReportingService;
import org.ei.drishti.service.scheduling.ChildSchedulesService;
import org.ei.drishti.util.SafeMap;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static org.apache.commons.lang3.StringUtils.isBlank;
import static org.ei.drishti.common.AllConstants.ChildImmunizationFields.PREVIOUS_IMMUNIZATIONS_FIELD_NAME;
import static org.ei.drishti.common.AllConstants.ChildRegistrationECFields.CHILD_ID;
import static org.ei.drishti.common.AllConstants.ChildRegistrationFormFields.BF_POSTBIRTH_FIELD_NAME;
import static org.ei.drishti.common.AllConstants.CommonFormFields.ID;
import static org.ei.drishti.common.AllConstants.DeliveryOutcomeFields.DID_BREAST_FEEDING_START;

@Service
public class ChildService {
    public static final String IMMUNIZATIONS_SEPARATOR = " ";
    private static Logger logger = LoggerFactory.getLogger(ChildService.class.toString());
    private ChildSchedulesService childSchedulesService;
    private AllMothers allMothers;
    private AllChildren allChildren;
    private ChildReportingService childReportingService;
    private ActionService actionService;
    private ReportFieldsDefinition reportFieldsDefinition;

    @Autowired
    public ChildService(ChildSchedulesService childSchedulesService,
                        AllMothers allMothers,
                        AllChildren allChildren,
                        ChildReportingService childReportingService, ActionService actionService, ReportFieldsDefinition reportFieldsDefinition) {
        this.childSchedulesService = childSchedulesService;
        this.allMothers = allMothers;
        this.allChildren = allChildren;
        this.childReportingService = childReportingService;
        this.actionService = actionService;
        this.reportFieldsDefinition = reportFieldsDefinition;
    }

    public void registerChildren(FormSubmission submission) {
        Mother mother = allMothers.findByCaseId(submission.entityId());
        if (mother == null) {
            logger.warn("Failed to handle children registration as there is no mother registered with id: " + submission.entityId());
            return;
        }
        
        SubFormData subFormData = submission.getSubFormByName(AllConstants.DeliveryOutcomeFields.CHILD_REGISTRATION_SUB_FORM_NAME);
        String referenceDate = submission.getField(AllConstants.DeliveryOutcomeFields.REFERENCE_DATE_FIELD_VALUE);

        for (Map<String, String> childFields : subFormData.instances()) {
            Child child = allChildren.findByCaseId(childFields.get(AllConstants.DeliveryOutcomeFields.ID_FIELD));
            child = child.withAnm(submission.anmId()).withDateOfBirth(referenceDate).withThayiCard(mother.thayiCardNo());
            allChildren.update(child);

            SafeMap reportingData = new SafeMap();
            reportingData.put(ID, child.caseId());
            reportingData.put(BF_POSTBIRTH_FIELD_NAME, submission.getField(DID_BREAST_FEEDING_START));
            childReportingService.registerChild(reportingData);

            childSchedulesService.enrollChild(child);
        }
    }

    public void registerChildrenForEC(FormSubmission submission) {
        Child child = allChildren.findByCaseId(submission.getField(CHILD_ID));
        child.withAnm(submission.anmId());
        allChildren.update(child);
    }

    public void updateChildImmunization(FormSubmission submission) {
        if (!allChildren.childExists(submission.entityId())) {
            logger.warn("Found immunization update without registered child for entity ID: " + submission.entityId());
            return;
        }

        String previousImmunizationsField = isBlank(submission.getField(PREVIOUS_IMMUNIZATIONS_FIELD_NAME))
                ? "" : submission.getField(PREVIOUS_IMMUNIZATIONS_FIELD_NAME);
        List<String> previousImmunizations = Arrays.asList(previousImmunizationsField.split(IMMUNIZATIONS_SEPARATOR));

        SafeMap reportFieldsMap = new SafeMap(submission.getFields(reportFieldsDefinition.get(submission.formName())));
        childReportingService.immunizationProvided(reportFieldsMap, previousImmunizations);

        childSchedulesService.updateEnrollments(submission.entityId(), previousImmunizations);
    }

    public void closeChild(FormSubmission submission) {
        if (!allChildren.childExists(submission.entityId())) {
            logger.warn("Found close child request without registered child for entity id: " + submission.entityId());
            return;
        }

        allChildren.close(submission.entityId());
        actionService.markAllAlertsAsInactive(submission.entityId());
        SafeMap reportFieldsMap = new SafeMap(submission.getFields(reportFieldsDefinition.get(submission.formName())));
        childReportingService.closeChild(reportFieldsMap);
        childSchedulesService.unenrollChild(submission.entityId());
    }
}
