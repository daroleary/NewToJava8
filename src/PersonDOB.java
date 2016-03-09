/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.time.LocalDate;

/**
 *
 * @author José
 */
public class PersonDOB {
    
    private String name;
    private LocalDate dateOfBirth;
    
    public PersonDOB(){}
    
    public PersonDOB(String name, LocalDate dateOfBirth) {
        this.name = name;
        this.dateOfBirth = dateOfBirth;
    }

    public String getName() {
        return name;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    @Override
    public String toString() {
        return "PersonDOB{" + "name=" + name + ", dateOfBirth=" + dateOfBirth + '}';
    }
}
