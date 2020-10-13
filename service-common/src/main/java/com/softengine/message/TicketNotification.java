package com.softengine.message;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class TicketNotification {
    private String tickedId;
    private String accountId;
    private String ticketDesc;

}
