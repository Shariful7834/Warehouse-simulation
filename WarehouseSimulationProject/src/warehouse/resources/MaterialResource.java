package warehouse.resources;

/** Materials: cost per piece/unit consumed. */
public class MaterialResource extends NonHumanResource {
    public MaterialResource(String name, double unitCost) {
        super(name, unitCost);
    }

    @Override
    public double use(double units) {
        double cost = units * costRate;
        System.out.printf("Using material '%s' for %.2f units @ %.2f/unit = %.2f%n",
                name, units, costRate, cost);
        return cost;
    }
}
