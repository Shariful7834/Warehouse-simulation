package warehouse.resources;

/** Human Resources (cost per hour). */
public class HumanResource extends Resource {
    public HumanResource(String name, double hourlyRate) {
        super(name, hourlyRate);
    }

    @Override
    public double use(double hours) {
        double cost = hours * costRate;
        System.out.printf("Using human resource '%s' for %.2f h @ %.2f/h = %.2f%n",
                name, hours, costRate, cost);
        return cost;
    }
}
