import java.util.Arrays;

public class TrainConsistManagementApp {

    // Search operation implementing Defensive Programming and Fail-Fast validation
    public static boolean searchBogie(String[] bogieIds, String targetId) {
        // State Validation: Prevent operations on empty data structures
        if (bogieIds == null || bogieIds.length == 0) {
            throw new IllegalStateException("Search Failed: Bogie collection is empty. Cannot perform search operations.");
        }
        
        // Business logic continues if validation passes
        for (int i = 0; i < bogieIds.length; i++) {
            if (bogieIds[i].equals(targetId)) {
                return true;
            }
        }
        return false;
    }

    // Helper method to gracefully format test execution
    public static void executeTest(String testName, String[] bogieIds, String targetId) {
        System.out.println("[" + testName + "]");
        System.out.println("Searching for: " + targetId + " in " + Arrays.toString(bogieIds));
        
        try {
            boolean result = searchBogie(bogieIds, targetId);
            System.out.println("Result: " + result);
        } catch (IllegalStateException e) {
            System.out.println("Exception Caught: " + e.getClass().getSimpleName());
            System.out.println("Message: " + e.getMessage());
        }
        System.out.println();
    }

    public static void main(String[] args) {
        System.out.println("=== Train Consist Management App ===");
        System.out.println("--- UC20: Exception Handling During Search Operations ---\n");

        String[] emptyBogies = {};
        executeTest("testSearch_ThrowsExceptionWhenEmpty", emptyBogies, "BG101");

        String[] twoBogies = {"BG101", "BG205"};
        executeTest("testSearch_AllowsSearchWhenDataExists", twoBogies, "BG101");

        String[] standardBogies = {"BG101", "BG205", "BG309"};
        executeTest("testSearch_BogieFoundAfterValidation", standardBogies, "BG205");
        executeTest("testSearch_BogieNotFoundAfterValidation", standardBogies, "BG999");
        
        String[] singleBogie = {"BG101"};
        executeTest("testSearch_SingleElementValidCase", singleBogie, "BG101");
    }
}