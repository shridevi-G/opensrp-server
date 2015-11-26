/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.ei.drishti.web.controller;

import com.google.gson.Gson;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import static java.lang.String.valueOf;
import java.util.ArrayList;
import static java.util.Arrays.asList;
import java.util.Collections;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.ei.drishti.form.domain.*;
import java.util.List;
import java.util.Map;
import org.ei.drishti.common.util.HttpAgent;
import org.ei.drishti.common.util.HttpResponse;
import org.ei.drishti.domain.ANMDetail;
import org.ei.drishti.dto.form.FormSubmissionDTO;
import org.ei.drishti.event.FormSubmissionEvent;
import org.ei.drishti.form.domain.FormField;
import org.ei.drishti.form.domain.FormInstance;
import org.ei.drishti.form.domain.FormSubmission;
import org.ei.drishti.form.service.FormSubmissionService;
import org.ei.drishti.form.repository.AllFormSubmissions;

import org.joda.time.DateTime;
import static org.mockito.Mockito.*;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;
import org.motechproject.scheduler.gateway.OutboundEventGateway;
import org.motechproject.util.DateUtil;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.ei.drishti.domain.Multimedia;
import org.ei.drishti.dto.form.MultimediaDTO;
import org.ei.drishti.service.MultimediaService;
import org.junit.Ignore;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.web.multipart.MultipartFile;

public class FormSubmissionControllerTest {

    @Mock
    private FormSubmissionService formSubmissionService;

    @Mock
    private AllFormSubmissions allFormSubmissions;

    @Mock
    private HttpAgent httpAgent;

    @Mock
    private OutboundEventGateway gateway;
    @Mock
    private MultimediaService multimediaService;
    private FormSubmissionController controller;

    private String bind_type = "entity 1";
    private String default_bind_path = "bind path 1";
    private SubFormData subFormData = new SubFormData("sub form name", Collections.<Map<String, String>>emptyList());
    private List<FormField> fields = new ArrayList<>();

    @Before
    public void setUp() throws Exception {
        initMocks(this);

        controller = new FormSubmissionController("http://drishti_form_data_url", httpAgent, formSubmissionService,multimediaService, gateway);
    }

    @Test
    public void getFormSubmissionsForANMTest() throws Exception {
        long baseTimeStamp = DateUtil.now().getMillis();

        FormInstance formInstance = new FormInstance(new FormData(bind_type, default_bind_path, fields, asList(subFormData)));
        FormSubmissionDTO firstFormSubmissionDTO = new FormSubmissionDTO("anm id 1", "instance id 1", "entity id 1", "form name 1", "", valueOf(baseTimeStamp), "1").withServerVersion("0");
        FormSubmissionDTO secondFormSubmissionDTO = new FormSubmissionDTO("anm id 2", "instance id 2", "entity id 2", "form name 1", "", valueOf(baseTimeStamp + 1), "1").withServerVersion("1");
        FormSubmission firstFormSubmission = new FormSubmission("anm id 1", "instance id 1", "form name 1", "entity id 1", baseTimeStamp, "1", null, 0L);
        FormSubmission secondFormSubmission = new FormSubmission("anm id 2", "instance id 2", "form name 1", "entity id 2", baseTimeStamp + 1, "1", null, 1L);
        when(formSubmissionService.getNewSubmissionsForANM("village1", 0L, 2)).thenReturn(asList(firstFormSubmission, secondFormSubmission));

        List<FormSubmissionDTO> formSubmissions = controller.getNewSubmissionsForANM("anm id 1", "village1", 0L, 2);
        assertEquals(asList(firstFormSubmissionDTO, secondFormSubmissionDTO), formSubmissions);

    }

    @Test
    public void pushFormsTest() throws Exception {
        String formData="formdata";
        FormSubmissionDTO formSubmissionDTO = new FormSubmissionDTO("user1", "124558", "sa114454", "EC", "er", "124", "5");
        String formdetails = new Gson().toJson(formSubmissionDTO);
        
        when(httpAgent.post(eq("http://drishti_form_data_url/formdata"), any(String.class), eq("application/json"))).thenReturn(new HttpResponse(true, null));
        
        ResponseEntity<HttpStatus> response = controller.submitForms(asList(formSubmissionDTO));
        
        //verify(httpAgent).post("http://drishti_form_data_url/formdata", formdetails, "application/json");
        verify(gateway).sendEventMessage(new FormSubmissionEvent(asList(formSubmissionDTO))
                .toEvent());
        
        assertEquals(HttpStatus.CREATED,response.getStatusCode());
        
        


    }

    @Test
    public void shouldFetchAllSubmissionsTest() throws Exception {
        long baseTimeStamp = DateUtil.now().getMillis();
        FormSubmissionDTO firstFormSubmissionDTO = new FormSubmissionDTO("anm id 1", "instance id 1", "entity id 1", "form name 1", "", valueOf(baseTimeStamp), "1").withServerVersion("0");
        FormSubmissionDTO secondFormSubmissionDTO = new FormSubmissionDTO("anm id 2", "instance id 2", "entity id 2", "form name 1", "", valueOf(baseTimeStamp + 1), "1").withServerVersion("1");
        FormSubmission firstFormSubmission = new FormSubmission("anm id 1", "instance id 1", "form name 1", "entity id 1", baseTimeStamp, "1", null, 0L);
        FormSubmission secondFormSubmission = new FormSubmission("anm id 2", "instance id 2", "form name 1", "entity id 2", baseTimeStamp + 1, "1", null, 1L);
        when(formSubmissionService.getAllSubmissions(0L, 2)).thenReturn(asList(firstFormSubmission, secondFormSubmission));

        List<FormSubmissionDTO> formSubmissions = controller.getAllFormSubmissions(0L, 2);

        assertEquals(asList(firstFormSubmissionDTO, secondFormSubmissionDTO), formSubmissions);
    }
    @Test
    public void getMultimediaTest(){
        MultimediaDTO multimediaDTO=new MultimediaDTO("caseid1", "anm id 1", "image/jpeg", "location1", "test");
             
        Multimedia multimedia=new Multimedia("caseid1", "anm id 1", "image/jpeg", "location1", "test");
        
        when(multimediaService.getMultimediaFiles("anm id 1")).thenReturn(asList(multimedia));
       
        MultimediaDTO response= controller.getFiles("anm id 1").get(0);
        
        assertEquals(multimediaDTO,response);
//        assertEquals(null,response);
    }
    
    @Test
    public void PushFormTestSample(){
       List<FormSubmissionDTO> formSubmissionDTO = null;
       ResponseEntity<HttpStatus> response = controller.submitForms(formSubmissionDTO);
       assertEquals(HttpStatus.INTERNAL_SERVER_ERROR,response.getStatusCode());
       
    }
    
//    @Test
//    public void uploadFilesTest() throws FileNotFoundException{
//        String path="testpath";
//        FileInputStream fis = new FileInputStream("/home/administrator/Pictures/123456.png");
//        MultipartFile multipart=null;
//        MultimediaDTO multimediaDTO = new MultimediaDTO("entityId", "providerId", "image/png", null, "fileCategory");
//        try {
//			multipart = new MockMultipartFile("file", fis);
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//        when(multimediaService.saveMultimediaFile(multimediaDTO, multipart)).thenReturn("success");
//        ResponseEntity<String> status=controller.uploadFiles("providerId","entityId","image/png","fileCategory", multipart);
//        String stat=new Gson().toJson(status);
//        if(status.equals("sucess")){
//            assertEquals("sucess",status.getBody());
//        }    
//        else{
//            assertEquals("fail",status.getStatusCode());
//        }
//    }
}
