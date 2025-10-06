package warehouse.resources;

import java.util.Objects;

/** Abstract Class: Resources */
public abstract class Resource {
    protected final String name;
    protected final double costRate; // cost per unit (hour/piece/license-hour)

    protected Resource(String name, double costRate) {
        this.name = name;
        this.costRate = costRate;
    }

    /** Consume/allocate this resource. Return cost for given quantity. */
    public abstract double use(double quantity);

    public String getName() { return name; }
    public double getCostRate() { return costRate; }

    /** Allow using Resource as a Map key (unique by class + name). */
    @Override public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Resource)) return false;
        Resource that = (Resource) o;
        return this.getClass().equals(that.getClass()) && Objects.equals(this.name, that.name);
    }
    @Override public int hashCode() {
        return Objects.hash(getClass(), name);
    }

    @Override public String toString() {
        return getClass().getSimpleName() + "(" + name + ", rate=" + costRate + ")";
    }
}
