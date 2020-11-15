package com.all4tic.kioqs.utilities;


import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import com.all4tic.kioqs.dto.SMSRequest;

@Service
public class SendSms2 {
	private static final Logger LOGGER = LoggerFactory.getLogger(SendSms2.class);
     public void send(SMSRequest smsrequest) {
		 // TODO Auto-generated method stub
        MultiValueMap<String, String> headers = new LinkedMultiValueMap<String, String>();
        Map map = new HashMap<String, String>();
        map.put("Content-Type", "application/json");

        headers.setAll(map);

        Map request_payload = new HashMap();
        request_payload.put("SenderId", smsrequest.getSenderId());
        request_payload.put("Message", smsrequest.getMessage());
        request_payload.put("MobileNumbers", smsrequest.getMobileNumbers());
        request_payload.put("ApiKey", Utility.APIKEY);
        request_payload.put("ClientId", Utility.CLIENTID);

        HttpEntity<?> request = new HttpEntity<>(request_payload, headers);
        String url = Utility.URLSMS;

        ResponseEntity<?> response = new RestTemplate().postForEntity(url, request, String.class);
        LOGGER.debug(response.getBody().toString());
       // SMSResponse smsResponse = (SMSResponse) response.getBody();
       // System.out.println(smsResponse.getData());
        
	}
     public Boolean sendRemoteSMS(String text, String destinataire) {
    	 String url = Utility.URLEASYSMS+"username="+Utility.USERNAME+"&password="
    			 +Utility.PASSWORD+"&from=228KIOSQS&to="+destinataire.trim()+"&text="+text+"&type=0";
    	 System.out.println(url);
    	 try {
    		 String response = new RestTemplate().getForObject(url,String.class);
    		 System.out.println(url);
    		 String [] responsetab = response.split(":");
    		 if(responsetab[0].equalsIgnoreCase("OK"))
    			 return true ;
    		 
    	 }catch (Exception e) {
    		 e.printStackTrace();
			return false ;
		}
    	
    	 
    	 return  false ;
     }
	
	}
