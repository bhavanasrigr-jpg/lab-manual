import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        while (true) {

            System.out.println("\n====================================");
            System.out.println("   INSIDER THREAT DETECTOR");
            System.out.println("====================================");
            System.out.println("1. Analyze User");
            System.out.println("2. Exit");
            System.out.print("Enter your choice: ");

            int choice = sc.nextInt();

            switch (choice) {

                case 1:

                    sc.nextLine();

                    System.out.print("\nEnter Username: ");
                    String username = sc.nextLine();

                    System.out.print("Enter Failed Login Attempts: ");
                    int failedLogins = sc.nextInt();

                    System.out.print("Enter Login Hour (0-23): ");
                    int loginHour = sc.nextInt();

                    System.out.print("Sensitive File Accessed? (1 = Yes, 0 = No): ");
                    int sensitive = sc.nextInt();

                    int score = 0;

                    if (failedLogins >= 3)
                        score += 40;

                    if (loginHour >= 0 && loginHour <= 5)
                        score += 30;

                    if (sensitive == 1)
                        score += 30;

                    System.out.println("\n========== SECURITY REPORT ==========");
                    System.out.println("Username           : " + username);
                    System.out.println("Failed Logins      : " + failedLogins);
                    System.out.println("Login Hour         : " + loginHour);
                    System.out.println("Sensitive Access   : " + (sensitive == 1 ? "Yes" : "No"));
                    System.out.println("Risk Score         : " + score);

                    if (score >= 70) {
                        System.out.println("Risk Level         : HIGH");
                    } else if (score >= 40) {
                        System.out.println("Risk Level         : MEDIUM");
                    } else {
                        System.out.println("Risk Level         : LOW");
                    }

                    System.out.println("\nReason(s):");

                    if (failedLogins >= 3)
                        System.out.println("- Multiple failed login attempts");

                    if (loginHour >= 0 && loginHour <= 5)
                        System.out.println("- Login at unusual hours");

                    if (sensitive == 1)
                        System.out.println("- Accessed sensitive file");

                    if (score < 40)
                        System.out.println("- No suspicious activity detected");

                    break;

                case 2:
                    System.out.println("Thank you!");
                    sc.close();
                    System.exit(0);

                default:
                    System.out.println("Invalid Choice!");
            }
        }
    }
}
