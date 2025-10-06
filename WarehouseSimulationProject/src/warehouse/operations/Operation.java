package warehouse.operations;

import warehouse.resources.Resource;
import java.util.LinkedHashMap;
import java.util.Map;

/** Abstract Class: Operation */
public abstract class Operation {
    protected final String name;
    protected final String description;

    // duration of the operation in hours
    protected double durationHours;

    /** Resource allocations for this operation (resource -> quantity). */
    protected final Map<Resource, Double> resources = new LinkedHashMap<>();

    protected Operation(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public Operation addResource(Resource r, double quantity) {
        resources.put(r, quantity);
        return this;
    }

    /** Execute the operation and return its total cost. */
    public double perform() {
        double total = 0.0;
        for (Map.Entry<Resource, Double> e : resources.entrySet()) {
            total += e.getKey().use(e.getValue());
        }
        return total;
    }

    /** Duration in hours for scheduling. */
    public double getDurationHours() {
        return durationHours;
    }

    public String getName() { return name; }
    public String getDescription() { return description; }
}
