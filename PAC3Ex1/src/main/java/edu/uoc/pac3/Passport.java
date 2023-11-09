package edu.uoc.pac3;

import java.time.LocalDate;

public class Passport {
    // constants
    public static final String PASSPORT_NUMBER_ERROR = "Passport number cannot be null or empty.";
    public static final String ISSUE_DATE_ERROR = "Issue date must be in the last 10 years.";
    public static final String EXPIRATION_DATE_ERROR = "Expiration date must be 10 years after the issue date.";
    public static final String VISA_TYPE_ERROR = "Visa type must be a non-negative value.";

    // variables
    private String passportNumber;
    private LocalDate issueDate;
    private LocalDate expirationDate;
    private int visaType;

    // constructors
    public Passport(String passportNumber, LocalDate issueDate, LocalDate expirationDate, int visaType) {
        this.passportNumber = passportNumber;
        this.issueDate = issueDate;
        this.expirationDate = expirationDate;
        this.visaType = visaType;
    }

    // methods
    public String getPassportNumber() {
        return passportNumber;
    }

    private void setPassportNumber(String passportNumber) {
        this.passportNumber = passportNumber;
    }

    public LocalDate getIssueDate() {
        return issueDate;
    }

    private void setIssueDate(LocalDate issueDate) {
        this.issueDate = issueDate;
    }

    public LocalDate getExpirationDate() {
        return expirationDate;
    }

    private void setExpirationDate(LocalDate expirationDate) {
        this.expirationDate = expirationDate;
    }

    public int getVisaType() {
        return visaType;
    }

    private void setVisaType(int visaType) {
        this.visaType = visaType;
    }
}
