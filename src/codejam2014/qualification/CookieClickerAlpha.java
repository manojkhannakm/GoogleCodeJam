package codejam2014.qualification;

import java.util.Scanner;

/**
 * @author Manoj Khanna
 */

public class CookieClickerAlpha {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int t = scanner.nextInt();
        scanner.nextLine();

        for (int i = 1; i <= t; i++) {
            double c = scanner.nextDouble(),
                    f = scanner.nextDouble(),
                    x = scanner.nextDouble(), totalCookies = 0.0, totalTime = 0.0, totalRate = 2.0;
            scanner.nextLine();

            while (totalCookies + c < x) {
                totalCookies += c;
                totalTime += c / totalRate;
                totalRate += f;
            }
            totalTime += x / totalRate;

            System.out.println("Case #" + i + ": " + String.format("%.7f", totalTime));
        }
    }

}