package edu.uoc.pac3;


import java.io.File;

public class Flight {

    private Passenger[] passengers;
    private int numPassengers;

    public Flight(File file) throws Exception{
        passengers = new Passenger[50];
        populate(file);
    }

    public int getNumPassengers() {
        return numPassengers;
    }

    private void setNumPassengers(int numPassengers) {
        this.numPassengers = numPassengers;
    }

    private void populate(File file) throws Exception{
        //TODO
    }

    public Passenger[] getPassengers(){
        return passengers;
    }


}
