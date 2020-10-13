package com.softengine.service.impl;

import com.softengine.entity.Ticket;
import com.softengine.message.TicketNotification;
import com.softengine.service.TicketNotificationService;
import lombok.RequiredArgsConstructor;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

@Service
@EnableBinding(Source.class)
@RequiredArgsConstructor
public class TicketNotificationServiceImpl implements TicketNotificationService {
   private final Source source;
    @Override
    public void sendToQueue(Ticket ticket) {
        TicketNotification ticketNotification = new TicketNotification();
        ticketNotification.setAccountId(ticket.getAssignee());
        ticketNotification.setTickedId(ticket.getId());
        ticketNotification.setTicketDesc(ticket.getDesciption());
        source.output().send(MessageBuilder.withPayload(ticketNotification).build());
    }
}
