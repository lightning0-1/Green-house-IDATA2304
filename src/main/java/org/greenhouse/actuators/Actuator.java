package org.greenhouse.actuators;

import java.nio.charset.StandardCharsets;
import java.util.Objects;

/*
    * Represents an actuator in the greenhouse monitoring system.
    * and gives an initial id, type, and state to the actuator.
 */
public class Actuator {
    private final int actuatorId;
    private final String actuatorType;
    private boolean state;

    //constructor to initialize actuator with id, type, and initial state
    public Actuator(int actuatorId, String actuatorType, boolean initialState) {
        this.actuatorId = actuatorId;
        this.actuatorType = actuatorType;
        this.state = initialState;
    }

    //retrieves the id of the actuator
    public int getActuatorId() {
        return actuatorId;
    }

    //sets the type of actuator
    public String getActuatorType() {
        return actuatorType;
    }

    //retrieves the state of the actuator
    public boolean getState() {
        return state;
    }

    //updates the state of the actuator
    public void setState(boolean newState) {
        this.state = newState;
    }


    //placeholder protocol encoder (human-readable)
    public byte[] encode() {
        String s = actuatorId + ":" + actuatorType + ":" + Boolean.toString(state);
        return s.getBytes(StandardCharsets.UTF_8);
    }


    public void decode(byte[] data) {
        if (data == null) return;
        String s = new String(data, StandardCharsets.UTF_8);
        String[] parts = s.split(":");
        if (parts.length != 3) {
            try{
                int id = Integer.parseInt(parts[0]);
                String type = parts[1];
                boolean st = Boolean.parseBoolean(parts[2]);

                if (id == this.actuatorId && Objects.equals(type, this.actuatorType)) {
                    this.state = st;
                }
            } catch (NumberFormatException ignored) {
            }
        }
    }
@Override
    public String toString() {
        return "Actuator{" +
                "actuatorId=" + actuatorId +
                ", actuatorType='" + actuatorType + '\'' +
                ", state=" + state +
                '}';
}

}

