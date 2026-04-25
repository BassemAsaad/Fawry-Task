package com.bassem.fawry;

public class Main {

    public static void main(String[] args) {
        CarFactory factory = new CarFactory();

        Car car = factory.createCar(EngineType.ELECTRIC);
        car.start();

        car.accelerate();
        car.accelerate();

        factory.replaceEngine(car, EngineType.GAS);
        car.accelerate();

        car.brake();
        car.brake();
        car.brake();

        car.stop();

        System.out.println("-----------------------------------------------------------------------------------------");
        System.out.println("-----------------------------------------------------------------------------------------");

        Car hybridCar = factory.createCar(EngineType.HYBRID);
        hybridCar.start();

        for (int i = 0; i < 4; i++) {
            hybridCar.accelerate();
        }

        hybridCar.stop();


    }
}
