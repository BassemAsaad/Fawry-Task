package com.pioneers.fawry;

public class CarFactory {

    public Car createCar(EngineType engineType) {
        return new Car(createEngine(engineType));
    }

    public void replaceEngine(Car car, EngineType engineType) {
        car.replaceEngine(createEngine(engineType));
    }

    private Engine createEngine(EngineType engineType){
        return switch (engineType) {
            case ELECTRIC -> new ElectricEngine();
            case GAS -> new GasEngine();
            case HYBRID -> new HybridEngine();
        };
    }
}
