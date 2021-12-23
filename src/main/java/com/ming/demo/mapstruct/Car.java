package com.ming.demo.mapstruct;

/**
 * @author Ming
 * @date 23/12/2021-上午 11:09
 */
public class Car {

    private String make;
    private int numberOfSeats;
    private Enum<CarType> type;

    public Car() {
    }

    public Car(String make, int numberOfSeats, Enum<CarType> type) {
        this.make = make;
        this.numberOfSeats = numberOfSeats;
        this.type = type;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public int getNumberOfSeats() {
        return numberOfSeats;
    }

    public void setNumberOfSeats(int numberOfSeats) {
        this.numberOfSeats = numberOfSeats;
    }

    public Enum<CarType> getType() {
        return type;
    }

    public void setType(Enum<CarType> type) {
        this.type = type;
    }
}
