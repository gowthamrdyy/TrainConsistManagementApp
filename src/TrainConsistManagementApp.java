public class TrainConsistManagementApp {

    // Linear Search Implementation to find a bogie ID
    public static boolean linearSearch(String[] bogieIds, String targetId) {
        for (int i = 0; i < bogieIds.length; i++) {
            // Early termination once a match is found
            if (bogieIds[i].equals(targetId)) {
                return true;
            }
        }
        return false;
    }

    // Helper method for clean test output
    public static void testSearch(String testName, String[] bogieIds, String targetId) {
        System.out.println("[" + testName + "]");
        System.out.println("Searching for: " + targetId);
        System.out.println("Search Pool: " + java.util.Arrays.toString(bogieIds));
        boolean result = linearSearch(bogieIds, targetId);
        System.out.println("Result: " + result + "\n");
    }

    public static void main(String[] args) {
        System.out.println("=== Train Consist Management App ===");
        System.out.println("--- UC18: Linear Search for Bogie ID (Array-Based Searching) ---\n");

        String[] standardBogies = {"BG101", "BG205", "BG309", "BG412", "BG550"};

        testSearch("testSearch_BogieFound", standardBogies, "BG309");
        testSearch("testSearch_BogieNotFound", standardBogies, "BG999");
        testSearch("testSearch_FirstElementMatch", standardBogies, "BG101");
        testSearch("testSearch_LastElementMatch", standardBogies, "BG550");
        
        String[] singleBogie = {"BG101"};
        testSearch("testSearch_SingleElementArray", singleBogie, "BG101");
    }
}