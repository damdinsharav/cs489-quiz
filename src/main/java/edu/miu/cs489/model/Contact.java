package edu.miu.cs489.model;

import java.util.ArrayList;
import java.util.List;

public class Contact {
    String firstName;
    String lastName;
    String company;
    String jobTitle;
    List<PhoneNumber> phoneNumbers;
    List<Email> emails;

    public Contact(String firstName, String lastName, String company, String jobTitle) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.company = company;
        this.jobTitle = jobTitle;
        this.phoneNumbers = new ArrayList<>();
        this.emails = new ArrayList<>();
    }

    public void addPhoneNumber(PhoneNumber phoneNumber) {
        this.phoneNumbers.add(phoneNumber);
    }

    public void addEmail(Email email) {
        this.emails.add(email);
    }

    public String getLastName() {
        return lastName;
    }

    public String toJSON() {
        StringBuilder jsonBuilder = new StringBuilder();
        jsonBuilder.append("{");
        jsonBuilder.append("\"firstName\":\"").append(firstName).append("\",");
        jsonBuilder.append("\"lastName\":\"").append(lastName).append("\",");
        jsonBuilder.append("\"company\":\"").append(company).append("\",");
        jsonBuilder.append("\"jobTitle\":\"").append(jobTitle).append("\",");
        jsonBuilder.append("\"phoneNumbers\":[");
        for (PhoneNumber phoneNumber : phoneNumbers) {
            jsonBuilder.append("{");
            jsonBuilder.append("\"phoneNumber\":\"").append(phoneNumber.getPhoneNumber()).append("\",");
            jsonBuilder.append("\"label\":\"").append(phoneNumber.getLabel()).append("\"");
            jsonBuilder.append("},");
        }
        if (!phoneNumbers.isEmpty()) {
            jsonBuilder.deleteCharAt(jsonBuilder.length() - 1); // Remove the last comma
        }
        jsonBuilder.append("],");
        jsonBuilder.append("\"emails\":[");
        for (Email email : emails) {
            jsonBuilder.append("{");
            jsonBuilder.append("\"email\":\"").append(email.getEmail()).append("\",");
            jsonBuilder.append("\"label\":\"").append(email.getLabel()).append("\"");
            jsonBuilder.append("},");
        }
        if (!emails.isEmpty()) {
            jsonBuilder.deleteCharAt(jsonBuilder.length() - 1); // Remove the last comma
        }
        jsonBuilder.append("]");
        jsonBuilder.append("}");
        return jsonBuilder.toString();
    }
}
