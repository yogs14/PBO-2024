import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class TechSupportSystem {
    private static Map<String, String> responseMap = new HashMap<>();

    static {
        responseMap.put("network", "It seems you are having network issues. Have you tried restarting your router?");
        responseMap.put("error", "Could you specify the error message? It will help in diagnosing the proble.");
        responseMap.put("slow", "A slow system can be caused by many factors. Have you tried closing background programs?");
        responseMap.put("crash", "A crash might be due to memory issues. Have you checked if the system is overheating?");
        responseMap.put("internet", "Is your internet connection stable? Try resetting your modem if needed.");
    }

    private static String defaultResponse = "I'm sorry, I didn't understand that. Could you please elaborate on the issue?";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Hello! I'm your tech suppoert assistant. How can I help you today?");

        while (true) {
            System.out.print(">");
            String input = scanner.nextLine().toLowerCase();

            if (input.equals("quit") || input.equals("exit")) {
                System.out.println("Thank you for contacting tech support. Have a nice day!");
                break;
            }

            String response = getResponse(input);
            System.out.println(response);
        }

        scanner.close();
    }

    private static String getResponse(String input) {
        for (String keyword : responseMap.keySet()) {
            if (input.contains(keyword)) {
                return responseMap.get(keyword);
            }
        }
        return defaultResponse;
    }
}
