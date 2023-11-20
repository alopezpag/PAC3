package edu.uoc.pac3;

import java.time.LocalDateTime;

public class Flight {
    // const
    public static int NUM_MAX_PASSENGERS;
    public static final String ERROR_ORIGIN = "Origin cannot be null or empty.";
    public static final String ERROR_DESTINATION = "Destination cannot be null or empty.";
    public static final String ERROR_DATES = "Destination date must be previous to arrival date.";
    public static final String ERROR_NULL = "Element is null.";
    public static final String ERROR_PASSENGER_ALREADY_IN_FLIGHT = "The passenger is already in the flight.";
    public static final String ERROR_NO_PASSPORT = "The passport is null.";


    // var
    private int id;
    private static int nextId = 1;
    private String origin;
    private String destination;
    private LocalDateTime departureDate;
    private LocalDateTime arrivalDate;
    private Passenger[] passengers;

    public Flight(int id, String origin, String destination, LocalDateTime departureDate, LocalDateTime arrivalDate, int numPassengers) {
        this.id = id;
        this.origin = origin;
        this.destination = destination;
        this.departureDate = departureDate;
        this.arrivalDate = arrivalDate;
        NUM_MAX_PASSENGERS = numPassengers;
    }

    public static int getNumMaxPassengers() {
        return NUM_MAX_PASSENGERS;
    }

    public static void setNumMaxPassengers(int numMaxPassengers) {
        NUM_MAX_PASSENGERS = numMaxPassengers;
    }

    public int getId() {
        return id;
    }

    private void setId(int id) {
        this.id = id;
    }

    public static int getNextId() {
        return nextId;
    }

    public static void incNextId(int nextId) {
        Flight.nextId = nextId;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public LocalDateTime getDepartureDate() {
        return departureDate;
    }

    public void setDepartureDate(LocalDateTime departureDate) {
        this.departureDate = departureDate;
    }

    public LocalDateTime getArrivalDate() {
        return arrivalDate;
    }

    public void setArrivalDate(LocalDateTime arrivalDate) {
        this.arrivalDate = arrivalDate;
    }

    public Passenger[] getPassengers() {
        return passengers;
    }

//    public double getDuration() {
//        return
//    }

    public boolean addPassenger(Passenger p) {

    }

    public boolean removePassengers (Passenger p) {

    }

    public boolean containsPassenger(Passenger p) {

    }

    private void findPassenger() {

    }

    public int getNumPassenger() {

    }
}
