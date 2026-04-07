public class TrainConsistManagementApp {

    // Bubble Sort Algorithm implementation to sort without library methods
    public static void bubbleSort(int[] capacities) {
        int n = capacities.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - 1 - i; j++) {
                if (capacities[j] > capacities[j + 1]) {
                    // Swap values when left element is greater than right element
                    int temp = capacities[j];
                    capacities[j] = capacities[j + 1];
                    capacities[j + 1] = temp;
                }
            }
        }
    }

    public static void printArray(int[] array) {
        System.out.print("{");
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i]);
            if (i < array.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("}");
    }

    public static void main(String[] args) {
        System.out.println("=== Train Consist Management App ===");
        System.out.println("--- UC16: Sort Passenger Bogies by Capacity (Bubble Sort) ---\n");

        System.out.println("[testSort_BasicSorting]");
        int[] capacities1 = {72, 56, 24, 70, 60};
        System.out.print("Original: ");
        printArray(capacities1);
        bubbleSort(capacities1);
        System.out.print("Sorted:   ");
        printArray(capacities1);

        System.out.println("\n[testSort_AlreadySortedArray]");
        int[] capacities2 = {24, 56, 60, 70, 72};
        System.out.print("Original: ");
        printArray(capacities2);
        bubbleSort(capacities2);
        System.out.print("Sorted:   ");
        printArray(capacities2);

        System.out.println("\n[testSort_DuplicateValues]");
        int[] capacities3 = {72, 56, 56, 24};
        System.out.print("Original: ");
        printArray(capacities3);
        bubbleSort(capacities3);
        System.out.print("Sorted:   ");
        printArray(capacities3);

        System.out.println("\n[testSort_SingleElementArray]");
        int[] capacities4 = {50};
        System.out.print("Original: ");
        printArray(capacities4);
        bubbleSort(capacities4);
        System.out.print("Sorted:   ");
        printArray(capacities4);

        System.out.println("\n[testSort_AllEqualValues]");
        int[] capacities5 = {40, 40, 40};
        System.out.print("Original: ");
        printArray(capacities5);
        bubbleSort(capacities5);
        System.out.print("Sorted:   ");
        printArray(capacities5);
    }
}