package edu.uoc.pac3;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Objects;

public class Flight {
    // const
    public static final String ERROR_ORIGIN = "Origin cannot be null or empty.";
    public static final String ERROR_DESTINATION = "Destination cannot be null or empty.";
    public static final String ERROR_DATES = "Destination date must be previous to arrival date.";
    public static final String ERROR_NULL = "Element is null.";
    public static final String ERROR_PASSENGER_ALREADY_IN_FLIGHT = "The passenger is already in the flight.";
    public static final String ERROR_NO_PASSPORT = "The passport is null.";

    // static
    public static int NUM_MAX_PASSENGERS;
    private static int nextId = 1;

    // variables
    private int id;
    private String origin;
    private String destination;
    private LocalDateTime departureDate;
    private LocalDateTime arrivalDate;
    private Passenger[] passengers;

    public Flight(int id, String origin, String destination, LocalDateTime departureDate, LocalDateTime arrivalDate, int numPassengers) throws IllegalArgumentException {
        if (departureDate == null || arrivalDate == null || departureDate.isAfter(arrivalDate)) {
            throw new IllegalArgumentException(ERROR_DATES);
        }
        setNumMaxPassengers(numPassengers);
        setOrigin(origin);
        this.destination = destination;
        this.departureDate = departureDate;
        this.arrivalDate = arrivalDate;
        NUM_MAX_PASSENGERS = numPassengers;

        setId(id);
    }

    public static int getNumMaxPassengers() {
        return NUM_MAX_PASSENGERS;
    }

    public static void setNumMaxPassengers(int numMaxPassengers) {
        NUM_MAX_PASSENGERS = numMaxPassengers;
    }

    public static int getNextId() {
        return nextId;
    }

    public static void incNextId() {
        nextId++;
    }

    public int getId() {
        return id;
    }

    private void setId(int id) {
        this.id = nextId;
        incNextId();
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) throws IllegalArgumentException {
        if (origin == null || origin.isEmpty()) throw new IllegalArgumentException(ERROR_ORIGIN);
        this.origin = origin;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) throws IllegalArgumentException {
        if (destination == null || destination.isEmpty()) throw new IllegalArgumentException(ERROR_DESTINATION);
        this.destination = destination;
    }

    public LocalDateTime getDepartureDate() {
        return departureDate;
    }

    public void setDepartureDate(LocalDateTime departureDate) throws IllegalArgumentException {
        if (departureDate != null && !departureDate.isBefore(arrivalDate) && arrivalDate != null) {
            throw new IllegalArgumentException(ERROR_DATES);
        }
        this.departureDate = departureDate;
    }

    public LocalDateTime getArrivalDate() {
        return arrivalDate;
    }

    public void setArrivalDate(LocalDateTime arrivalDate) throws IllegalArgumentException {
        if (arrivalDate != null && !arrivalDate.isAfter(departureDate) && departureDate != null) {
            throw new IllegalArgumentException(ERROR_DATES);
        } else {
            this.arrivalDate = arrivalDate;
        }
    }

    public Passenger[] getPassengers() {
        return passengers;
    }

    public double getDuration() {
        Duration duration = Duration.between(departureDate, arrivalDate);
        return Math.abs(duration.toHours() + duration.toMinutesPart() / 60.0);
    }

    //TODO: fer
    public boolean addPassenger(Passenger p) {

    }

    public boolean removePassengers(Passenger p) {

    }

    //TODO: dubte -> el findPassenger() ja fa la comprovació de ERROR_NO_PASSPORT, realment està duplicada al mètode.
    public boolean containsPassenger(Passenger p) throws NullPointerException {
        if (p == null) throw new NullPointerException(ERROR_NULL);
        if (p.getPassport() == null) throw new NullPointerException(ERROR_NO_PASSPORT);
        return (findPassenger(p) != -1);

    }

    private int findPassenger(Passenger passenger) throws NullPointerException {
        // returns position
        if (passenger == null) throw new NullPointerException(ERROR_NULL);
        else if (passenger.getPassport() == null) throw new NullPointerException(ERROR_NO_PASSPORT);
        else {
            for (int pos = 0; pos < passengers.length; pos++) {
                if (Objects.equals(passengers[pos].getPassport().getPassportNumber(), passenger.getPassport().getPassportNumber())) {
                    return pos;
                }
            }
            return -1;
        }
    }

    public int getNumPassenger() {

    }
}
