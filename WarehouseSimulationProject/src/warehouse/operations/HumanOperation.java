package warehouse.operations;

/** Human operation with a fixed duration. */
public class HumanOperation extends Operation {

    public HumanOperation(String name, String description, double durationHours) {
        super(name, description);
        this.durationHours = durationHours;
    }

    @Override
    public double perform() {
        System.out.printf("Performing human operation '%s': %s lasting %.2f h%n",
                name, description, durationHours);
        return super.perform();
    }
}
