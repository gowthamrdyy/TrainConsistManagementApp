import java.util.Arrays;

public class TrainConsistManagementApp {

    // Binary Search Implementation to find a bogie ID
    public static boolean binarySearch(String[] bogieIds, String targetId) {
        // Precondition requirement: Ensure data is sorted before applying binary search
        Arrays.sort(bogieIds);
        
        int low = 0;
        int high = bogieIds.length - 1;
        
        while (low <= high) {
            // Compute mid index correctly
            int mid = low + (high - low) / 2;
            
            // Compare key with mid element using compareTo()
            int comparison = bogieIds[mid].compareTo(targetId);
            
            if (comparison == 0) {
                return true; // Match found
            } else if (comparison < 0) {
                low = mid + 1; // Target is in the right half
            } else {
                high = mid - 1; // Target is in the left half
            }
        }
        
        return false; // Search complete, not found
    }

    // Helper method for clean test output
    public static void testSearch(String testName, String[] bogieIds, String targetId) {
        System.out.println("[" + testName + "]");
        System.out.println("Searching for: " + targetId);
        System.out.println("Search Pool: " + Arrays.toString(bogieIds));
        
        // Clone array safely to pass to binarySearch
        String[] searchPool = bogieIds.clone();
        boolean result = binarySearch(searchPool, targetId);
        System.out.println("Result: " + result + "\n");
    }

    public static void main(String[] args) {
        System.out.println("=== Train Consist Management App ===");
        System.out.println("--- UC19: Binary Search for Bogie ID (Optimized Searching) ---\n");

        String[] standardBogies = {"BG101", "BG205", "BG309", "BG412", "BG550"};

        testSearch("testBinarySearch_BogieFound", standardBogies, "BG309");
        testSearch("testBinarySearch_BogieNotFound", standardBogies, "BG999");
        testSearch("testBinarySearch_FirstElementMatch", standardBogies, "BG101");
        testSearch("testBinarySearch_LastElementMatch", standardBogies, "BG550");
        
        String[] singleBogie = {"BG101"};
        testSearch("testBinarySearch_SingleElementArray", singleBogie, "BG101");
        
        String[] emptyBogie = {};
        testSearch("testBinarySearch_EmptyArray", emptyBogie, "BG101");
        
        String[] unsortedBogies = {"BG309", "BG101", "BG550", "BG205", "BG412"};
        testSearch("testBinarySearch_UnsortedInputHandled", unsortedBogies, "BG205");
    }
}