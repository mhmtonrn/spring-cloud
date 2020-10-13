package com.softengine.entity;

import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;

@javax.persistence.Entity
@EqualsAndHashCode(of = {"id"})
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "ticket")
public class Ticket extends BaseEntitiyModel{

    @Id
    @Getter
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "id")
    private String id;

    @Setter
    @Getter
    @Column(name = "desciption", length = 600)
    private String desciption;

    @Setter
    @Getter
    @Column(name = "notes", length = 4000)
    private String notes;

    @Setter
    @Getter
    @Column(name = "assignee", length = 50)
    private String assignee;

    @Setter
    @Getter
    @Column(name = "ticket_date")
    private Date ticketDate;

    @Setter
    @Getter
    @Enumerated
    @Column(name = "priority_type")
    private PriorityType priorityType;

    @Setter
    @Getter
    @Enumerated
    @Column(name = "ticket_status")
    private TicketStatus ticketStatus;

}
