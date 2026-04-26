package com.bassem.fawry;

public final class EngineFactory {

    private EngineFactory() {
        throw new AssertionError("Utility class");
    }

    public static Engine createEngine(EngineType engineType) {
        return switch (engineType) {
            case ELECTRIC -> new ElectricEngine();
            case GAS -> new GasEngine();
            case HYBRID -> new HybridEngine();
        };
    }

}
