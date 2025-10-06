# Warehouse Simulation Project (Java)  
**Md Shariful Islam – 7213424**

---

## Overview  
This project implements the provided **UML model** using **Object-Oriented Programming in Java**.  
It simulates warehouse processes where operations are carried out by **human workers, supervisors, software systems, packaging materials, and Autonomous Guided Vehicles (AGVs)**.  

The program demonstrates **inheritance, abstraction, polymorphism, and encapsulation** through a modular design.  
Each process is composed of operations, and each operation consumes resources, which together determine the **total cost** and **total duration**.

---

## Implemented Classes

### 1. `ProcessBase` (Abstract Class)  
- Represents a generic process.  
- Stores a list of operations.  
- Provides a method to:  
  - Execute all operations.  
  - Print a detailed process report.  
  - Return total **cost** and **duration**.  

### 2. `IndustrialProcess` and `ManagementProcess`  
- Subclasses of `ProcessBase`.  
- **IndustrialProcess** models tasks such as **Receiving**.  
- **ManagementProcess** models tasks such as **Inspection**.  

### 3. `Operation` (Abstract Class)  
- Base class for all operations.  
- Holds name, description, duration, and assigned resources.  
- Defines `perform()` to calculate the cost of resource usage.  

### 4. `HumanOperation`  
- Represents tasks done by human staff.  
- Duration is fixed.  
- Cost is based on worker or supervisor hourly rate.  

### 5. `TransportOperation`  
- Represents transport tasks inside the warehouse.  
- Duration = **distance ÷ speed**.  
- Resources include **AGVs** and **packaging materials**.  

### 6. `Resource` (Abstract Class)  
- Base class for all resources in the warehouse.  
- Method `use(quantity)` calculates cost depending on type.  

### 7. Resource Subclasses  
- **`HumanResource`** → Worker/Supervisor (cost per hour).  
- **`MaterialResource`** → Packaging materials (cost per unit).  
- **`SoftwareResource`** → Inventory software (cost per license-hour).  
- **`AGV`** → Autonomous Guided Vehicle with:  
  - Hourly cost.  
  - Battery level tracking.  
  - Energy consumption per hour.  

---

## Simulation  
Two warehouse processes were simulated:  

1. **Receiving (IndustrialProcess)**  
   - **Picking** (HumanOperation): Worker + Inventory Software.  
   - **Transport** (TransportOperation): AGV + Packaging Materials.  

2. **Inspection (ManagementProcess)**  
   - **Quality Control** (HumanOperation): Supervisor.  

During execution, the program prints:  
- Each operation and description.  
- Resource usage and costs.  
- Total operation cost and duration.  
- Process summary (cost + duration).  

Finally, it prints a **TOTAL WAREHOUSE SUMMARY** that aggregates all processes.  

---

## Sample Output
