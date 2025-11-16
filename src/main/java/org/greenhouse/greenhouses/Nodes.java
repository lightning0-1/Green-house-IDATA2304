package org.greenhouse.greenhouses;

import org.greenhouse.sensors.Sensors;
import org.greenhouse.actuators.Actuator;

import java.util.ArrayList;
import java.util.List;
import java.util.Collections;

public class Nodes {
    private final int nodeId;
    private final int greenhouseId;
    private final List<Sensors> sensors = new ArrayList<>();
    private final List<Actuator> actuators = new ArrayList<>();
    private final List<Double> trendData = new ArrayList<>();


    public Nodes(int nodeId, int greenhouseId) {
        this.nodeId = nodeId;
        this.greenhouseId = greenhouseId;
    }


    public int getNodeId() {
        return nodeId;
    }

    public int getGreenhouseId() {
        return greenhouseId;
    }

    public void addSensors(Sensors s) {
        if (s != null) sensors.add(s);
    }

    public void addActuators(Actuator a) {
        if (a != null) actuators.add(a);
    }

    public List<Sensors> getSensors() {
        return Collections.unmodifiableList(sensors);
    }

    public List<Actuator> getActuators() {
        return Collections.unmodifiableList(actuators);
    }

    public List<Double> getTrendData() {
        return new ArrayList<>(trendData);
    }

    public String simulateStep() {
        double sum = 0.0;
        int count = 0;
        for (Sensors s : sensors) {
            double value = s.readValue();
            sum += value;
            count++;
        }

        if (count > 0) {
            double average = sum / count;
            trendData.add(average);
            if (trendData.size() > 100) {
                trendData.remove(0);
            }
        }

        @Override
        public String toString;
        {
            return "Node{" + "nodeId=" + nodeId + ", greenhouseId=" + greenhouseId + ", sensors=" + sensors.size() + ", actuators=" + actuators.size() + '}';
        }
    }
}
