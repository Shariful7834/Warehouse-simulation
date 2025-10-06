package warehouse.resources;

/** Software license/time cost (e.g., license-hours). */
public class SoftwareResource extends NonHumanResource {
    public SoftwareResource(String name, double licenseHourCost) {
        super(name, licenseHourCost);
    }

    @Override
    public double use(double licenseHours) {
        double cost = licenseHours * costRate;
        System.out.printf("Using software '%s' for %.2f license-hours @ %.2f = %.2f%n",
                name, licenseHours, costRate, cost);
        return cost;
    }
}
