/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.text.MessageFormat;
import java.time.LocalDate;

/**
 *
 * @author José
 */
public class PersonAge {

    private String _name;
    private Integer _age;

    public PersonAge(){}

    public PersonAge(String name, Integer age) {
        _name = name;
        _age = age;
    }

    public String getName() {
        return _name;
    }

    public Integer getAge() {
        return _age;
    }

    @Override
    public String toString() {
        return MessageFormat.format("Person [{0}, {1}]", getName(), getAge());
    }
}
