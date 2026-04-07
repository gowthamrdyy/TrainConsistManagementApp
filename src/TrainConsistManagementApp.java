public class TrainConsistManagementApp {

    // Custom Runtime Exception for Cargo Safety
    static class CargoSafetyException extends RuntimeException {
        public CargoSafetyException(String message) {
            super(message);
        }
    }

    // Goods Bogie class
    static class GoodsBogie {
        private String shape;
        private String assignedCargo;

        public GoodsBogie(String shape) {
            this.shape = shape;
            this.assignedCargo = "None";
        }

        public String getShape() {
            return shape;
        }

        public String getAssignedCargo() {
            return assignedCargo;
        }

        public void assignCargo(String cargo) {
            System.out.println("Attempting to assign " + cargo + " to a " + shape + " bogie.");
            try {
                if ("Rectangular".equalsIgnoreCase(shape) && "Petroleum".equalsIgnoreCase(cargo)) {
                    throw new CargoSafetyException("Unsafe assignment: Petroleum cannot be assigned to a Rectangular bogie.");
                }
                this.assignedCargo = cargo;
                System.out.println("Success! Cargo assigned: " + this.assignedCargo);
            } catch (CargoSafetyException e) {
                System.out.println("Error Caught: " + e.getMessage());
            } finally {
                System.out.println("Validation completion message: Cargo assignment process finished.");
            }
        }
    }

    public static void main(String[] args) {
        System.out.println("=== Train Consist Management App ===");
        System.out.println("--- UC15: Safe Cargo Assignment Using try-catch-finally ---\n");

        System.out.println("[Test: Safe Cargo Assignment Behavior]");
        GoodsBogie cylindricalBogie = new GoodsBogie("Cylindrical");
        cylindricalBogie.assignCargo("Petroleum");
        
        System.out.println("\n[Test: Unsafe Cargo Detection & Exception Handling]");
        GoodsBogie rectangularBogie = new GoodsBogie("Rectangular");
        rectangularBogie.assignCargo("Petroleum");
        
        System.out.println("\n[Test: Cargo Not Assigned After Failure]");
        System.out.println("Current cargo in Rectangular bogie: " + rectangularBogie.getAssignedCargo());

        System.out.println("\n[Test: Program Continuation After Exception & Finally Block Execution]");
        System.out.println("Application is still running smoothly. Assigning safe cargo...");
        rectangularBogie.assignCargo("Coal");
        System.out.println("Current cargo in Rectangular bogie: " + rectangularBogie.getAssignedCargo());

        System.out.println("\nAll required tests executed successfully.");
    }
}