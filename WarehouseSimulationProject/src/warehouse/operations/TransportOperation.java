package warehouse.operations;

/** Transport operation with distance & speed computing duration. */
public class TransportOperation extends Operation {
    private final double distanceKm;
    private final double speedKmPerHour;

    public TransportOperation(String name, String description, double distanceKm, double speedKmPerHour) {
        super(name, description);
        this.distanceKm = distanceKm;
        this.speedKmPerHour = speedKmPerHour;
        this.durationHours = distanceKm / Math.max(0.1, speedKmPerHour);
    }

    @Override
    public double perform() {
        System.out.printf("Performing transport operation '%s' over %.2f km taking %.2f h%n",
                name, distanceKm, durationHours);
        return super.perform();
    }
}
