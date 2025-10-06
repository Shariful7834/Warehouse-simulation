package warehouse.processes;

import warehouse.operations.Operation;
import java.util.ArrayList;
import java.util.List;

/** Abstract Class: Process */
public abstract class ProcessBase {
    protected final String id;
    protected final List<Operation> operations = new ArrayList<>();

    private double lastDuration = 0.0;

    protected ProcessBase(String id) {
        this.id = id;
    }

    public ProcessBase addOperation(Operation op) {
        operations.add(op);
        return this;
    }

    public double getLastDuration() {
        return lastDuration;
    }

    // NOTE: No @Override here, because we are not overriding a supertype method
    public double execute() {
        double totalCost = 0.0;
        double totalDuration = 0.0;

        System.out.printf("%n[Process: %s]  (%s)%n", id, getClass().getSimpleName());
        System.out.println("--------------------------------");

        for (Operation op : operations) {
            System.out.printf(" Operation: %s%n", op.getName());
            double c = op.perform();
            totalCost += c;
            totalDuration += op.getDurationHours();
            System.out.printf("   Total Operation Cost: €%.2f%n", c);
            System.out.printf("   Duration: %.2f h%n%n", op.getDurationHours());
        }

        System.out.printf(" Process Summary:%n   Duration: %.2f h%n   Cost: €%.2f%n",
                totalDuration, totalCost);
        lastDuration = totalDuration; // store for caller
        return totalCost;
    }
}
