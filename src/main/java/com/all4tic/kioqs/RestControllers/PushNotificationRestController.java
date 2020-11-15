package com.all4tic.kioqs.RestControllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.all4tic.kioqs.dto.Notif;
import com.all4tic.kioqs.service.firebaseMessagingService;
import com.google.firebase.messaging.FirebaseMessagingException;
@RestController
public class PushNotificationRestController {
	@Autowired
	private  firebaseMessagingService firebaseService;
	@RequestMapping("/send-notification")
    @ResponseBody
    public String sendNotification(@RequestBody Notif note,
                                   @RequestParam String topic) throws FirebaseMessagingException {
        return firebaseService.sendNotification(note, topic);
    }
}
