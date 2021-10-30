package com;

public class Car {
    @Pseudonym("firstname")
    public String markCar;
    @Ignore
    private String modelCar;

    public Car(String markCar, String modelCar) {
        this.markCar = markCar;
        this.modelCar = modelCar;
    }

}
