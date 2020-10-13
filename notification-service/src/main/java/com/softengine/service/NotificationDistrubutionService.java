package com.softengine.service;

import com.softengine.message.TicketNotification;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;

@EnableBinding(Sink.class)
public class NotificationDistrubutionService {

    @StreamListener(Sink.INPUT)
    public void onNotification(TicketNotification ticketNotification){
        System.out.println("notificatiob alındı");
        System.out.println(ticketNotification.toString());
    }
}
