package edu.miu.cs489;

import edu.miu.cs489.model.Contact;
import edu.miu.cs489.model.Email;
import edu.miu.cs489.model.PhoneNumber;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Contact> contacts = populateContacts();
        printContacts(contacts);
    }



    private static List<Contact> populateContacts() {
        List<Contact> contacts= new ArrayList<>();
        contacts.add(new Contact("David", "Sanger", "Argos LLC", "Sales Manager"));
        contacts.add(new Contact("Carlos", "Jimenez", "Zappos", "Director"));
        contacts.add(new Contact("Ali", "Gafar", "BMI Services", "HR Manager"));

        contacts.get(0).addPhoneNumber(new PhoneNumber("240-133-0011", "Home"));
        contacts.get(0).addPhoneNumber(new PhoneNumber("240-112-0123", "Mobile"));
        contacts.get(0).addEmail(new Email("dave.sang@gmail.com", "Home"));
        contacts.get(0).addEmail(new Email("dsanger@argos.com", "Work"));
        contacts.get(2).addPhoneNumber(new PhoneNumber("412-116-9988", "Work"));
        contacts.get(2).addEmail(new Email("ali@bmi.com", "Work"));

        return contacts;
    }

    private static void printContacts(List<Contact> contacts) {
        contacts.sort(Comparator.comparing(Contact::getLastName));
        StringBuilder jsonBuilder = new StringBuilder();
        jsonBuilder.append("[");
        for(int i=0;i<contacts.size();i++){
            jsonBuilder.append(contacts.get(i).toJSON());
            if(i!=contacts.size()-1){
                jsonBuilder.append(",");
            }
        }
        jsonBuilder.append("]");
        System.out.println(jsonBuilder);
    }
}