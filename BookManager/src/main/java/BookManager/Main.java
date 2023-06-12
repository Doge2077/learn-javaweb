package BookManager;

import BookManager.Utils.*;
import BookManager.menus.mainMenu;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            Start(sc);
            mainMenu.showEndMenu();
        }
    }

    public static void Start(Scanner sc) {
        while (true) {
            mainMenu.showMainMenu();
            int op = checkInput.checkInt(sc);
            switch (op) {
                case 1:
                    infoInsert.function(sc);
                    break;
                case 2:
                    infoUpdate.function(sc);
                    break;
                case 3:
                    infoSelect.function(sc);
                    break;
                default:
                    return ;
            }
        }
    }

}
