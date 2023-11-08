package edu.uoc.pac3;

import java.time.LocalDate;

public class Passenger {
    // constants
    public static final String INVALID_NAME = "Name cannot be null, empty or exceed the maximum number of characters.";
    public static final String INVALID_BIRTHDAY = "Invalid birthday.";
    public static final String INVALID_ADDRESS = "Address cannot be null or empty.";
    public static final String INVALID_PHONE_NUMBER_FORMAT = "Invalid phone number format.";
    public static final String INVALID_HEIGHT = "Height must be between 50 and 250 cm.";
    public static final String INVALID_OCCUPATION = "Occupation cannot be null or empty.";
    public static final String INVALID_NATIONALITY = "Nationality cannot be null or empty.";
    public static final int NAME_MAX_LENGTH = 50;

    // variables
    private String name;
    private LocalDate birthday;
    private String address;
    private String phoneNumber;
    private String nationality;
    private double height;
    private boolean specialNeeds;
    private String occupation;

    // constructors
    public Passenger(String name, LocalDate birthday, String address, String phoneNumber,
                     double height, String nationality, boolean specialNeeds, String occupation) {
        this.name = name;
        this.birthday = birthday;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.height = height;
        this.nationality = nationality;
        this.specialNeeds = specialNeeds;
        this.occupation = occupation;
    }

    public Passenger(String name, LocalDate birthday, String address, String phoneNumber,
                     double height, String nationality, String occupation, boolean specialNeeds,
                     String passportNumber, LocalDate issueDate, LocalDate expirationDate, int visaType) {
        this(name, birthday, address, phoneNumber, height, nationality, specialNeeds, occupation);
        // setPassportNumber(passportNumber);
        // setIssueDate(issueDate);
        // setExpirationDate(expirationDate);
        // setVisaType(visaType);
    }

    //setters & getters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public boolean isSpecialNeeds() {
        return specialNeeds;
    }

    public void setSpecialNeeds(boolean specialNeeds) {
        this.specialNeeds = specialNeeds;
    }

    public String getOccupation() {
        return occupation;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }
}
