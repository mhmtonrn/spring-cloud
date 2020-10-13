package com.softengine.service;

import com.softengine.entity.Ticket;

public interface TicketNotificationService {

    void sendToQueue(Ticket ticket);
}
