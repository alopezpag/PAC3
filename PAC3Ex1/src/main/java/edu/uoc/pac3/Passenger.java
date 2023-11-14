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
    private Passport passport;

    // constructors
    public Passenger(String name, LocalDate birthday, String address, String phoneNumber,
                     double height, String nationality, boolean specialNeeds, String occupation) {
        setName(name);
        setBirthday(birthday);
        setAddress(address);
        setPhoneNumber(phoneNumber);
        this.height = height;
        this.nationality = nationality;
        this.specialNeeds = specialNeeds;
        this.occupation = occupation;
        this.passport = null;
    }

    public Passenger(String name, LocalDate birthday, String address, String phoneNumber,
                     double height, String nationality, String occupation, boolean specialNeeds,
                     String passportNumber, LocalDate issueDate, LocalDate expirationDate, int visaType) {
        this(name, birthday, address, phoneNumber, height, nationality, specialNeeds, occupation);
        setPassport(passportNumber, issueDate, expirationDate, visaType);
    }

    //setters & getters
    public Passport getPassport() {
        return passport;
    }

    public void setPassport(String passportNumber, LocalDate issueDate, LocalDate expirationDate, int visaType) {
        this.passport = new Passport(passportNumber, issueDate, expirationDate, visaType);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) throws IllegalArgumentException {
        if (name == null || name.isEmpty() || name.length() > NAME_MAX_LENGTH) {
            throw new IllegalArgumentException(INVALID_NAME);
        }

        this.name = name;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) throws IllegalArgumentException {
        if (birthday == null) {
            throw new IllegalArgumentException(INVALID_BIRTHDAY);
        }

        final int MAX_YEARS = 110;
        LocalDate now = LocalDate.now();
        int age = now.getYear() - birthday.getYear();

        if (birthday.isAfter(now) || age > MAX_YEARS) {
            throw new IllegalArgumentException(INVALID_BIRTHDAY);
        }

        this.birthday = birthday;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) throws IllegalArgumentException {
        if (address == null || address.isEmpty()) {
            throw new IllegalArgumentException(INVALID_ADDRESS);
        }

        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) throws IllegalArgumentException {
        // regex code
        String phoneRegex = "^\\+\\d{1,3}-\\d{1,12}$";

        if (phoneNumber == null || !phoneNumber.matches(phoneRegex) ) {
            throw new IllegalArgumentException(INVALID_PHONE_NUMBER_FORMAT);
        }

        this.phoneNumber = phoneNumber;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) throws IllegalArgumentException {
        this.nationality = nationality;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) throws IllegalArgumentException {
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
