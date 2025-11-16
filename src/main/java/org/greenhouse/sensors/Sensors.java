package org.greenhouse.sensors;

import java.nio.charset.StandardCharsets;
import java.util.Random;

/*
    * Represents a sensor in the greenhouse monitoring system.
    * and gives an initial id and type to the sensor.
 */

public class Sensors {
    private final int sensorId;
    private final String sensorType;
    private double currentValue;
    private final Random rnd = new Random();

    public Sensors(int sensorId, String sensorType) {
        this.sensorId = sensorId;
        this.sensorType = sensorType;
        this.currentValue = initialValue();
    }

    //gives the sensor an initial id
    public int getSensorId() {
        return sensorId;
    }

    //makes a way to set what type of the sensor it is
    public String getSensorType() {
        return sensorType;
    }

    //makes a way to set the initial value of the sensor
    public double getCurrentValue() {
        return currentValue;
    }

    public double initialValue() {
        switch (sensorType.toLowerCase()) {
            case "temperature":
                return 20.0;
            case "humidity":
                return 50.0;
            case "soil_moisture":
                return 30.0;
            default:
                return 0.0;
        }
    }





    //new way to update the sensor value with random variation
    public double readValue() {
        double variation = rnd.nextDouble() * 2 - 1; // Random variation between -1 and +1
        currentValue += variation;
        return currentValue;
    }

    // Placeholder protocol encoder (human-readable)
    public byte[] encode() {
        String s = sensorId + ":" + sensorType + ":" + Double.toString(currentValue);
        return s.getBytes(StandardCharsets.UTF_8);
    }

    @Override
    public String toString() {
        return "Sensor{" +
                "sensorId=" + sensorId +
                ", sensorType='" + sensorType + '\'' +
                ", currentValue=" + currentValue +
                '}';
    }
}
