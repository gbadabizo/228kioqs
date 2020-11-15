package com.all4tic.kioqs.service;

import org.springframework.stereotype.Service;

import com.all4tic.kioqs.dto.Notif;
import com.google.firebase.messaging.FirebaseMessaging;
import com.google.firebase.messaging.FirebaseMessagingException;
import com.google.firebase.messaging.Message;
import com.google.firebase.messaging.Notification;

@Service
public class firebaseMessagingService {

	private final FirebaseMessaging firebaseMessaging;

    public firebaseMessagingService(FirebaseMessaging firebaseMessaging) {
        this.firebaseMessaging = firebaseMessaging;
    }
	 public String sendNotification(Notif note, String topic) throws FirebaseMessagingException {

	        Notification notification = Notification
	                .builder()
	                .setTitle(note.getSubject())
	                .setBody(note.getContent())
	                .setImage(note.getImage()) 
	                .build();

	        Message message = Message
	                .builder()
	                .setTopic(topic)
	                .setNotification(notification)
	                .putAllData(note.getData())
	                .build();

	        return this.firebaseMessaging.send(message);
	    }
}
