import java.util.*;

public class TechSupportSystem {
    private static Map<String, String> responseMap = new HashMap<>();
    private static Map<String, List<String>> synonymMap = new HashMap<>();
    
    static {
        responseMap.put("network", "It seems you are having network issues. Have you tried restarting your router?");
        responseMap.put("error", "Could you specify the error message? It will help in diagnosing the problem.");
        responseMap.put("slow", "A slow system can be caused by many factors. Have you tried closing background programs?");
        responseMap.put("crash", "A crash might be due to memory issues. Have you checked if the system is overheating?");
        responseMap.put("internet", "Is your internet connection stable? Try resetting your modem if needed.");
        
        // Define synonyms for each keyword
        synonymMap.put("network", Arrays.asList("wifi", "router", "connection"));
        synonymMap.put("error", Arrays.asList("bug", "issue", "problem", "fault"));
        synonymMap.put("slow", Arrays.asList("lag", "freezing", "unresponsive"));
        synonymMap.put("crash", Arrays.asList("shutdown", "hang", "blue screen"));
        synonymMap.put("internet", Arrays.asList("online", "web", "connection"));
    }

    private static String defaultResponse = "I'm sorry, I didn't understand that. Could you please elaborate on the issue?";
    private static String followUpQuestion = null;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Hello! I'm your tech support assistant. How can I help you today?");

        while (true) {
            System.out.print(">");
            String input = scanner.nextLine().toLowerCase().trim();

            if (input.equals("quit") || input.equals("exit")) {
                System.out.println("Thank you for contacting tech support. Have a nice day!");
                break;
            }

            String response = getResponse(input);
            System.out.println(response);

            if (followUpQuestion != null) {
                System.out.println(followUpQuestion);
                followUpQuestion = null;
            }
        }

        scanner.close();
    }

    private static String getResponse(String input) {
        // Tokenize the input into words
        String[] tokens = input.split("\\s+");

        for (String token : tokens) {
            // Direct keyword matching
            if (responseMap.containsKey(token)) {
                followUpQuestion = generateFollowUpQuestion(token);
                return responseMap.get(token);
            }

            // Synonym matching
            for (String keyword : synonymMap.keySet()) {
                if (synonymMap.get(keyword).contains(token)) {
                    followUpQuestion = generateFollowUpQuestion(keyword);
                    return responseMap.get(keyword);
                }
            }

            // Levenshtein distance check for close matches
            String closestMatch = getClosestKeyword(token);
            if (closestMatch != null) {
                followUpQuestion = generateFollowUpQuestion(closestMatch);
                return responseMap.get(closestMatch);
            }
        }

        return defaultResponse;
    }

    // Generates a follow-up question based on the keyword
    private static String generateFollowUpQuestion(String keyword) {
        switch (keyword) {
            case "network":
                return "Are you able to access other websites?";
            case "error":
                return "Please provide the error code or message.";
            case "slow":
                return "Have you checked if there are background programs running?";
            case "crash":
                return "Have you tried cleaning your system memory?";
            case "internet":
                return "Is your modem/router showing any error lights?";
            default:
                return null;
        }
    }

    // Levenshtein distance calculation
    private static int levenshteinDistance(String a, String b) {
        int[][] dp = new int[a.length() + 1][b.length() + 1];
        for (int i = 0; i <= a.length(); i++) dp[i][0] = i;
        for (int j = 0; j <= b.length(); j++) dp[0][j] = j;

        for (int i = 1; i <= a.length(); i++) {
            for (int j = 1; j <= b.length(); j++) {
                if (a.charAt(i - 1) == b.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.min(Math.min(dp[i - 1][j], dp[i][j - 1]), dp[i - 1][j - 1]) + 1;
                }
            }
        }
        return dp[a.length()][b.length()];
    }

    // Finds the closest keyword by Levenshtein distance
    private static String getClosestKeyword(String token) {
        String closestKeyword = null;
        int minDistance = Integer.MAX_VALUE;

        for (String keyword : responseMap.keySet()) {
            int distance = levenshteinDistance(token, keyword);
            if (distance < 3 && distance < minDistance) {  // Allowing up to 2 typos
                minDistance = distance;
                closestKeyword = keyword;
            }
        }

        return closestKeyword;
    }
}
