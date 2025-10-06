package warehouse;

import warehouse.operations.HumanOperation;
import warehouse.operations.TransportOperation;
import warehouse.processes.IndustrialProcess;
import warehouse.processes.ManagementProcess;
import warehouse.resources.*;

public class WarehouseDemo {
    public static void main(String[] args) {
        // --------------------------
        // Define resources
        // --------------------------
        HumanResource worker = new HumanResource("Worker", 25.0);          // €/hour
        HumanResource supervisor = new HumanResource("Supervisor", 40.0);  // €/hour

        SoftwareResource inventory = new SoftwareResource("Inventory software", 2.0); // €/license-hour
        AGV agv1 = new AGV("AGV1", 20.0, 100.0, 10.0); // €20 per hour, 10% battery/hour
        MaterialResource packaging = new MaterialResource("Packaging material", 5.0); // € per unit

        // --------------------------
        // Create operations
        // --------------------------
        HumanOperation picking = new HumanOperation(
                "Picking", "Pick items from shelves", 1.0);
        picking.addResource(worker, 1.0)
               .addResource(inventory, 0.5); // use half license-hour

        TransportOperation moveToDock = new TransportOperation(
                "Transport", "Move items to docking area", 2.0, 4.0); // 2km @ 4 km/h -> 0.5h
        moveToDock.addResource(agv1, 0.5)
                  .addResource(packaging, 5.0);

        // --------------------------
        // Create processes
        // --------------------------
        IndustrialProcess receiving = new IndustrialProcess("Receiving");
        receiving.addOperation(picking)
                 .addOperation(moveToDock);

        ManagementProcess inspection = new ManagementProcess("Inspection");
        inspection.addOperation(
                new HumanOperation("Quality Control", "Inspect items for defects", 0.5)
                    .addResource(supervisor, 0.5)
        );

        // --------------------------
        // Execute processes
        // --------------------------
        double totalCost = 0.0;
        double totalDuration = 0.0;

        totalCost += receiving.execute();
        totalDuration += receiving.getLastDuration();

        totalCost += inspection.execute();
        totalDuration += inspection.getLastDuration();

        // --------------------------
        // Final warehouse summary
        // --------------------------
        System.out.println("\n===============================");
        System.out.println("   TOTAL WAREHOUSE SUMMARY");
        System.out.println("===============================");
        System.out.printf(" Total Duration: %.2f h%n", totalDuration);
        System.out.printf(" Total Cost: €%.2f%n", totalCost);
        System.out.println("===============================");
    }
}
