package BookManager.Utils;

import BookManager.menus.errorsMenu;
import BookManager.menus.selectMenu;
import Tools.manage.Student;
import Tools.manage.StudentInfo;
import Tools.mybatisUtil;

import java.util.LinkedList;
import java.util.Scanner;

public class infoSelect {
    public static void function(Scanner sc) {
        selectMenu.showSelectMenu();
        int op = checkInput.checkInt(sc);
        switch (op) {
            case 1:
                selectStu(sc);
                break;
            case 2:
                selectBook(sc);
                break;
            case 3:
                selectAll(sc);
                break;
            default:
        }
    }

    private static void selectAll(Scanner sc) {
    }

    private static void selectBook(Scanner sc) {
    }

    private static void selectStu(Scanner sc) {
        int sid;
        System.out.print("请输入学生学号："); sid = checkInput.checkInt(sc);
//        try {
            mybatisUtil.selectManage(selectMapper -> {
               LinkedList<StudentInfo> studentInfo = selectMapper.selectStudentInfoBySid(sid);
               studentInfo.forEach(System.out::println);
            });
//        } catch (Exception e) {
//            errorsMenu.noStudentError();
//        }
    }
}
