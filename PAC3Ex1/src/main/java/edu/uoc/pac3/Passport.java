package edu.uoc.pac3;

import java.time.LocalDate;
import java.time.Period;
import java.util.Locale;

public class Passport {
    public static final String PASSPORT_NUMBER_ERROR = "Passport number cannot be null or empty.";
    public static final String ISSUE_DATE_ERROR = "Passport number cannot be null or empty.";
    public static final String EXPIRATION_DATE_ERROR = "Passport number cannot be null or empty.";
    public static final String VISA_TYPE_ERROR = "Passport number cannot be null or empty.";

    private String passportNumber;
    private LocalDate issueDate;
    private LocalDate expirationDate;
    private int visaType;

    public Passport() {
        // TODO: buscar numeros pasaport
        passportNumber = "\0";
        issueDate = LocalDate.of(2022, 12, 1);
        expirationDate = LocalDate.of(2022, 12, 1);
        visaType = 1;
    }

    public Passport(String passportNumber, LocalDate issueDate, LocalDate expirationDate, int visaType) {
        setPassportNumber(passportNumber);
    }

    // methods

    public String getPassportNumber() {
        return passportNumber;
    }

    private void setPassportNumber(String passportNumber) throws IllegalArgumentException {
        if (passportNumber == null || passportNumber.isEmpty()) {
            throw new IllegalArgumentException(PASSPORT_NUMBER_ERROR);
        }

        this.passportNumber = passportNumber;
    }

    public LocalDate getIssueDate() {
        return issueDate;
    }

    private void setIssueDate(LocalDate issueDate) throws IllegalArgumentException {
        if (issueDate == null) {
            throw new IllegalArgumentException(ISSUE_DATE_ERROR);
        }

        LocalDate now = LocalDate.now();
        // int anys = avui.getYear() - tina.getYear();
        // es podria calcular aixi també però he utilitzat Perdio que ho calcula automàticament,
        // en el cas que fossin dies entre anys seria molt més fàcil utilitzantl-ho.

        Period periode = Period.between(issueDate, now);
        int anys = periode.getYears();
        if (anys >= 10 || issueDate.isAfter(now)) {
            throw new IllegalArgumentException(ISSUE_DATE_ERROR);
        }
        this.issueDate = issueDate;
    }

    public LocalDate getExpirationDate() {
        return expirationDate;
    }

    private void setExpirationDate(LocalDate expirationDate) throws IllegalArgumentException {
        if (expirationDate == null) {
            throw new IllegalArgumentException(EXPIRATION_DATE_ERROR);
        }
        // int anys = avui.getYear() - tina.getYear();
        // es podria calcular aixi també però he utilitzat Perdio que ho calcula automàticament,
        // en el cas que fossin dies entre anys seria molt més fàcil utilitzantl-ho.
        Period periode = Period.between(issueDate, expirationDate);
        int anys = periode.getYears();
        if (anys >= 10 || expirationDate.isBefore(issueDate)) {
            throw new IllegalArgumentException(EXPIRATION_DATE_ERROR);
        }
        this.expirationDate = expirationDate;
    }

    public int getVisaType() {
        return visaType;
    }

    private void setVisaType(int visaType) throws IllegalArgumentException {
        if (visaType < 0) {
            throw new IllegalArgumentException(VISA_TYPE_ERROR);
        }

        this.visaType = visaType;
    }
}
