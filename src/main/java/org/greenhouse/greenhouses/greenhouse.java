package org.greenhouse.greenhouses;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class greenhouse {
    private final int greenhouseId;
    private final List<Nodes> nodes = new ArrayList<>();

    public greenhouse(int greenhouseId) {
        this.greenhouseId = greenhouseId;
    }

    public int getGreenhouseId() {
        return greenhouseId;
    }

    public void addNode(Nodes node) {
        if (node != null) nodes.add(node);
    }

    public List<Nodes> getNodes() {
        return Collections.unmodifiableList(nodes);
    }

    public void simulate() {
        for (Nodes node : nodes) {
            node.simulateStep();
        }
    }

    @Override
    public String toString() {
        return "Greenhouse{" +
                "greenhouseId=" + greenhouseId +
                ", nodes=" + nodes +
                '}';
    }
}
