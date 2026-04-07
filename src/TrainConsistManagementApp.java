import java.util.Arrays;

public class TrainConsistManagementApp {

    // Method to sort an array of bogie names alphabetically using Java's built-in Arrays.sort()
    public static void sortBogieNames(String[] bogieNames) {
        Arrays.sort(bogieNames);
    }

    public static void main(String[] args) {
        System.out.println("=== Train Consist Management App ===");
        System.out.println("--- UC17: Sort Bogie Names Using Arrays.sort() ---\n");

        System.out.println("[testSort_BasicAlphabeticalSorting]");
        String[] bogies1 = {"Sleeper", "AC Chair", "First Class", "General", "Luxury"};
        System.out.println("Original: " + Arrays.toString(bogies1));
        sortBogieNames(bogies1);
        System.out.println("Sorted:   " + Arrays.toString(bogies1));

        System.out.println("\n[testSort_UnsortedInput]");
        String[] bogies2 = {"Luxury", "General", "Sleeper", "AC Chair"};
        System.out.println("Original: " + Arrays.toString(bogies2));
        sortBogieNames(bogies2);
        System.out.println("Sorted:   " + Arrays.toString(bogies2));

        System.out.println("\n[testSort_AlreadySortedArray]");
        String[] bogies3 = {"AC Chair", "First Class", "General"};
        System.out.println("Original: " + Arrays.toString(bogies3));
        sortBogieNames(bogies3);
        System.out.println("Sorted:   " + Arrays.toString(bogies3));

        System.out.println("\n[testSort_DuplicateBogieNames]");
        String[] bogies4 = {"Sleeper", "AC Chair", "Sleeper", "General"};
        System.out.println("Original: " + Arrays.toString(bogies4));
        sortBogieNames(bogies4);
        System.out.println("Sorted:   " + Arrays.toString(bogies4));

        System.out.println("\n[testSort_SingleElementArray]");
        String[] bogies5 = {"Sleeper"};
        System.out.println("Original: " + Arrays.toString(bogies5));
        sortBogieNames(bogies5);
        System.out.println("Sorted:   " + Arrays.toString(bogies5));
    }
}