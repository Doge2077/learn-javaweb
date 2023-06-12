package BookManager.Utils;

import java.util.Scanner;

public class checkInput {
    public static int checkInt(Scanner sc) {
        int op = -1;
        try {
            op = Integer.parseInt(sc.nextLine());
        } catch (Exception e) {
            return -1;
        }
        return op;
    }

    public static double checkDouble(Scanner sc) {
        double op = -1;
        try {
            op = Double.parseDouble(sc.nextLine());
        } catch (Exception e) {
            return -1;
        }
        return op;
    }
}
