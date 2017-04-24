package codejam2014.qualification;

import java.util.Scanner;

/**
 * @author Manoj Khanna
 */

public class A {

    private static int[] getRowDatas(Scanner scanner) {
        int rowIndex = scanner.nextInt();
        int[] rowDatas = new int[4];
        for (int i = 1; i <= 4; i++) {
            scanner.nextLine();

            if (i == rowIndex) {
                for (int j = 0; j < 4; j++) {
                    rowDatas[j] = scanner.nextInt();
                }
            } else {
                for (int j = 1; j <= 4; j++) {
                    scanner.nextInt();
                }
            }
        }
        return rowDatas;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int t = scanner.nextInt();
        scanner.nextLine();

        for (int i = 1; i <= t; i++) {
            int[] rowDatas1 = getRowDatas(scanner),
                    rowDatas2 = getRowDatas(scanner);

            int data = 0, count = 0;
            for (int j = 0; j < 4; j++) {
                for (int k = 0; k < 4; k++) {
                    if (rowDatas1[j] == rowDatas2[k]) {
                        data = rowDatas1[j];
                        count++;
                    }
                }
            }

            if (count == 0) {
                System.out.println("Case #" + i + ": Volunteer cheated!");
            } else if (count == 1) {
                System.out.println("Case #" + i + ": " + data);
            } else {
                System.out.println("Case #" + i + ": Bad magician!");
            }
        }
    }

}