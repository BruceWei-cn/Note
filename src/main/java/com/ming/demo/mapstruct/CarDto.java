package com.ming.demo.mapstruct;

public class CarDto {
 
    private String mark;
    private int seatCount;
    private Enum<CarType> type;

    public CarDto() {
    }

    public CarDto(String mark, int seatCount, Enum<CarType> type) {
        this.mark = mark;
        this.seatCount = seatCount;
        this.type = type;
    }

    public String getMark() {
        return mark;
    }

    public void setMark(String make) {
        this.mark = make;
    }

    public int getSeatCount() {
        return seatCount;
    }

    public void setSeatCount(int seatCount) {
        this.seatCount = seatCount;
    }

    public Enum<CarType> getType() {
        return type;
    }

    public void setType(Enum<CarType> type) {
        this.type = type;
    }

    //constructor, getters, setters etc.
}