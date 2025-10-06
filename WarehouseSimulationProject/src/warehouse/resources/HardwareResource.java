package warehouse.resources;

/** Hardware resource (generic). */
public class HardwareResource extends NonHumanResource {
    public HardwareResource(String name, double unitCost) {
        super(name, unitCost);
    }

    @Override
    public double use(double units) {
        double cost = units * costRate;
        System.out.printf("Using hardware '%s' for %.2f units @ %.2f/unit = %.2f%n",
                name, units, costRate, cost);
        return cost;
    }
}
