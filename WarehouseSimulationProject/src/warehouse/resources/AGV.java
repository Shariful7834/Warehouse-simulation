package warehouse.resources;

/** AGV: hardware with battery + consumption and hourly cost (simplified). */
public class AGV extends HardwareResource {
    private double batteryLevelPct; // 0..100
    private final double consumptionPerHour; // % battery per hour

    public AGV(String name, double hourlyCost, double startBatteryPct, double consumptionPerHour) {
        super(name, hourlyCost);
        this.batteryLevelPct = startBatteryPct;
        this.consumptionPerHour = consumptionPerHour;
    }

    @Override
    public double use(double hours) {
        double consumed = consumptionPerHour * hours;
        batteryLevelPct = Math.max(0, batteryLevelPct - consumed);
        double cost = hours * costRate;
        System.out.printf("AGV '%s' operated for %.2f h: consumption %.2f%%, remaining battery %.1f%%, cost = %.2f%n",
                name, hours, consumed, batteryLevelPct, cost);
        return cost;
    }

    public double getBatteryLevelPct() { return batteryLevelPct; }
}
