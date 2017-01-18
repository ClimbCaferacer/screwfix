package com.screwfix.data;


import org.fluttercode.datafactory.impl.DataFactory;

import java.util.HashMap;

public class ContactInfoDataProvider {

    public String email;
    public String firstName;
    public String lastName;

    DataFactory data = new DataFactory();


    public ContactInfoDataProvider setContactInfo() {
        this.email = data.getRandomChars(2, 10) + "@mailinator.com";
        this.firstName = data.getFirstName();
        this.lastName = data.getLastName();

        return this;
    }

    public String getEmail() {
        return email;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

}
