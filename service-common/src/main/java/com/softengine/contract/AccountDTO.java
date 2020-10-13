package com.softengine.contract;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AccountDTO {

    private String id;
    private String username;
    private String name;
    private String surname;
    private String email;
    private LocalDate dateOfBirth;
    private Boolean active;


    public String getNameSurname(){
        return this.name+" " +this.surname;
    }
}
