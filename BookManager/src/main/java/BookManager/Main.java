package BookManager;

import BookManager.menus.mainMenu;
import Tools.manage.Book;
import Tools.manage.Borrow;
import Tools.manage.Student;
import Tools.mappers.deleteMapper;
import Tools.mappers.insertMapper;
import Tools.mybatisUtil;
import org.apache.ibatis.session.SqlSession;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Start();
    }

    public static void Start() {
        mainMenu.showMainMenu();
        try(Scanner scanner = new Scanner(System.in)) {
            try {
                System.out.println("输入操作编号：");
                Integer op = scanner.nextInt();
//                scanner.nextLine();
                if (op == 99) {
                    Start();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
    }

}
