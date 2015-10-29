/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.ei.drishti.reporting.handler;

import static ch.lambdaj.Lambda.collect;
import static ch.lambdaj.Lambda.on;

import java.util.List;

import org.ei.drishti.reporting.controller.SMSController;

import org.ei.drishti.reporting.domain.ANMVillages;

import org.ei.drishti.reporting.service.ANMService;
;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;



@Component
public class FormDatahandler {

    private SMSController smsController;
    private ANMService anmService;

   
    private static Logger logger = LoggerFactory.getLogger((String) FormDatahandler.class.toString());
    String regNumber = "";
    String wifeName = "";
    String phoneNumber = "";

    @Autowired
    public void FormDataHandler(ANMService anmService, SMSController smsController) {

        this.smsController = smsController;
        this.anmService = anmService;
        
    }

    public void ecRegistration(JSONObject dataObject, String anmPhoneNumber) throws JSONException {
        String entityId = dataObject.getString("entityId");
        logger.info("ecregistration method");
        JSONArray fieldJsonArray = dataObject.getJSONObject("formInstance").getJSONObject("form").getJSONArray("fields");
        for (int i = 0; i < fieldJsonArray.length(); i++) {
            JSONObject jsonObject = fieldJsonArray.getJSONObject(i);

            if (jsonObject.has("name")
                    && jsonObject.getString("name").equals("phoneNumber")) {

                phoneNumber = jsonObject.has("value")
                        && jsonObject.getString("value") != null ? jsonObject
                        .getString("value") : "";
            }
            if (jsonObject.has("name")
                    && jsonObject.getString("name").equals("ecNumber")) {

                regNumber = jsonObject.has("value")
                        && jsonObject.getString("value") != null ? jsonObject
                        .getString("value") : "";
            }
            if (jsonObject.has("name")
                    && jsonObject.getString("name").equals("wifeName")) {

                wifeName = jsonObject.has("value")
                        && jsonObject.getString("value") != null ? jsonObject
                        .getString("value") : "";
            }
        }

        logger.info("invoke sms controller******" + phoneNumber);
        smsController.sendSMSEC(phoneNumber, regNumber, wifeName, "EC");
    }

    public void ancRegistration(JSONObject dataObject, String visittype, String anmNumber) throws JSONException {
        String edd = "";
        String ecNumber = "";
        logger.info("anc_registration handler");
        String anmid = dataObject.getString("anmId");
        String entityId = dataObject.getString("entityId");
        JSONArray fieldJsonArray = dataObject.getJSONObject("formInstance").getJSONObject("form").getJSONArray("fields");
        Integer visitnumber = 1;
        for (int i = 0; i < fieldJsonArray.length(); ++i) {
            JSONObject jsonObject = fieldJsonArray.getJSONObject(i);

            if (jsonObject.has("name")
                    && jsonObject.getString("name").equals("referenceDate")) {

                edd = jsonObject.has("value") && jsonObject.
                        getString("value") != null ? jsonObject
                        .getString("value") : "";

                logger.info("reference date: " + edd);
            }
            if (jsonObject.has("name") && jsonObject.getString("name").equals("phoneNumber")) {;
                phoneNumber = jsonObject.has("value") && jsonObject
                        .getString("value") != null ? jsonObject
                        .getString("value") : "";
            }

            if (jsonObject.has("name")
                    && jsonObject.getString("name").equals("ancNumber")) {

                regNumber = jsonObject.has("value")
                        && jsonObject.getString("value") != null ? jsonObject
                        .getString("value") : "";
            }
            if (jsonObject.has("name")
                    && jsonObject.getString("name").equals("ecNumber")) {

                ecNumber = jsonObject.has("value")
                        && jsonObject.getString("value") != null ? jsonObject
                        .getString("value") : "";
            }
            if (jsonObject.has("name")
                    && jsonObject.getString("name").equals("wifeName")) {

                wifeName = jsonObject.has("value")
                        && jsonObject.getString("value") != null ? jsonObject
                        .getString("value") : "";
            }
        }
        if (visittype.equalsIgnoreCase("anc_registration_oa")) {
             logger.info("trying to send sms");
            smsController.sendSMSEC(phoneNumber, regNumber, wifeName, "ANC");
            logger.info("sms sent done");
        }

    }
    
     public void pncRegistration(JSONObject dataObject, String visittype, String anmNumber) throws JSONException {
        String edd = "";
        String ecNumber = "";
        String ptnumber = "";
        String ecId = "";
        String entityId = dataObject.getString("entityId");
        logger.info("pnc registration");

        JSONArray fieldJsonArray = dataObject.getJSONObject("formInstance").getJSONObject("form").getJSONArray("fields");

        for (int i = 0; i < fieldJsonArray.length(); ++i) {
            JSONObject jsonObject = fieldJsonArray.getJSONObject(i);
            if (jsonObject.has("name")
                    && jsonObject.getString("name").equals("referenceDate")) {

                edd = jsonObject.has("value") && jsonObject.
                        getString("value") != null ? jsonObject
                        .getString("value") : "";

                logger.info("reference date: " + edd);
            }
            if (jsonObject.has("name") && jsonObject.getString("name").equals("phoneNumber")) {
                phoneNumber = jsonObject.has("value") && jsonObject
                        .getString("value") != null ? jsonObject
                        .getString("value") : "";
            }

            if (jsonObject.has("name")
                    && jsonObject.getString("name").equals("pncNumber")) {

                regNumber = jsonObject.has("value")
                        && jsonObject.getString("value") != null ? jsonObject
                        .getString("value") : "";
            }
            if (jsonObject.has("name")
                    && jsonObject.getString("name").equals("ecNumber")) {

                ecNumber = jsonObject.has("value")
                        && jsonObject.getString("value") != null ? jsonObject
                        .getString("value") : "";
            }
            if (jsonObject.has("name")
                    && jsonObject.getString("name").equals("wifeName")) {

                wifeName = jsonObject.has("value")
                        && jsonObject.getString("value") != null ? jsonObject
                        .getString("value") : "";
            }
            if (jsonObject.has("name")
                    && jsonObject.getString("name").equals("ecId")) {

                ecId = jsonObject.has("value")
                        && jsonObject.getString("value") != null ? jsonObject
                        .getString("value") : "";

            }
        }
         if (visittype.equalsIgnoreCase("pnc_registration_oa")) {
            logger.info("phonenumber" + phoneNumber + "*** wife name" + wifeName + "***reg Number" + regNumber);
            smsController.sendSMSEC(phoneNumber, regNumber, wifeName, "PNC"); 
         }
     }
     
     public void childRegistration(JSONObject dataObject, String visittype, String anmNumber) throws JSONException {
        String edd = "2015-09-09";
        String ecNumber = "";
        String motherName = "";
        String childId = "";
        String dateOfBirth = "";

        String entityId = dataObject.getString("entityId");
        String anmid = dataObject.getString("anmId");

        logger.info("child registration handler");
        JSONArray fieldJsonArray = dataObject.getJSONObject("formInstance").getJSONObject("form").getJSONArray("fields");
        Integer visitnumber = 1;
        for (int i = 0; i < fieldJsonArray.length(); ++i) {
            JSONObject jsonObject = fieldJsonArray.getJSONObject(i);

            if (jsonObject.has("name") && jsonObject.getString("name").equals("phoneNumber")) {;
                phoneNumber = jsonObject.has("value") && jsonObject
                        .getString("value") != null ? jsonObject
                        .getString("value") : "";
            }

            if (jsonObject.has("name")
                    && jsonObject.getString("name").equals("motherName")) {

                motherName = jsonObject.has("value")
                        && jsonObject.getString("value") != null ? jsonObject
                        .getString("value") : "";
            }
            if (jsonObject.has("name")
                    && jsonObject.getString("name").equals("wifeName")) {

                wifeName = jsonObject.has("value")
                        && jsonObject.getString("value") != null ? jsonObject
                        .getString("value") : "";
            }
            if (jsonObject.has("name")
                    && jsonObject.getString("name").equals("childId")) {

                childId = jsonObject.has("value")
                        && jsonObject.getString("value") != null ? jsonObject
                        .getString("value") : "";
            }
            if (jsonObject.has("name")
                    && jsonObject.getString("name").equals("dateOfBirth")) {

                dateOfBirth = jsonObject.has("value")
                        && jsonObject.getString("value") != null ? jsonObject
                        .getString("value") : "";
            }
        }
        
        if (visittype.equalsIgnoreCase("child_registration_oa")) {
            logger.info("visittype: child_registration_oa");
            smsController.sendSMSChild(phoneNumber, motherName);
        }
        
     }
}
