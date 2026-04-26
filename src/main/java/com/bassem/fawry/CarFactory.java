package com.bassem.fawry;

public final class CarFactory {

    private CarFactory() {
        throw new AssertionError("Utility class");
    }

    public static Car createCar(EngineType engineType) {
        return new Car(EngineFactory.createEngine(engineType));
    }

    public static void replaceEngine(Car car, EngineType engineType) {
        car.replaceEngine(EngineFactory.createEngine(engineType));
    }

}
