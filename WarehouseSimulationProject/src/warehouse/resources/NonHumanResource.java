package warehouse.resources;

/** Non-human resources base. */
public abstract class NonHumanResource extends Resource {
    protected NonHumanResource(String name, double unitCost) {
        super(name, unitCost);
    }
}
