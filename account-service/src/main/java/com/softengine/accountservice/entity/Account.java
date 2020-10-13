package com.softengine.accountservice.entity;

import lombok.*;
import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
@ToString
@Table(value = "account")
public class Account implements Serializable {

    @PrimaryKey
    private String id = UUID.randomUUID().toString();

    @Column(value = "username" )
    private String username;

    @Column(value = "name" )
    private String name;

    @Column(value = "surname" )
    private String surname;

    @Column(value = "email")
    private String email;
    @Column("passwd")
    private String passwd;

    @Column("created_date")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate createdDate;

    @Column("date_of_birth")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate dateOfBirth;

    @Column(value = "active")
    private Boolean active;


}
