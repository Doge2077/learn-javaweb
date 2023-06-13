package BookManager.Utils;

import BookManager.menus.errorsMenu;
import BookManager.menus.insertMenu;
import BookManager.menus.successMenu;
import Tools.manage.Book;
import Tools.manage.Borrow;
import Tools.manage.Student;
import Tools.mybatisUtil;

import java.util.Scanner;

public class infoInsert {
    public static void function(Scanner sc) {
        insertMenu.showInsertMenu();
        int op = checkInput.checkInt(sc);
        switch (op) {
            case 1:
                insertStu(sc);
                break;
            case 2:
                insertBook(sc);
                break;
            case 3:
                insertBorr(sc);
                break;
            default:
        }
    }

    private static void insertBorr(Scanner sc) {
        int sid, bid;
        System.out.print("请输入学生学号："); sid = checkInput.checkInt(sc);
        System.out.print("请输入书籍编号："); bid = checkInput.checkInt(sc);
        Borrow borrow = new Borrow(sid, bid);
        mybatisUtil.selectManage(out_mapper -> {
            Student student = out_mapper.selectStudentBySid(sid);
            Book book = out_mapper.selectBookByBid(bid);
            if (student != null && book != null) {
                try {
                    mybatisUtil.insertManage(mapper -> {
                        int t = mapper.insertBorrow(borrow);
                        if (t > 0) successMenu.showInfo();
                        else errorsMenu.dataError();
                    });
                } catch (Exception e) {
                    errorsMenu.existError();
                }
            }
            else if (student == null && book != null) errorsMenu.noStudentError();
            else if (student != null && book == null) errorsMenu.noBookError();
            else errorsMenu.noMatchError();
        });
    }

    private static void insertBook(Scanner sc) {
        int bid;
        String name;
        double bprice;
        System.out.print("请输入书籍编号："); bid = checkInput.checkInt(sc);
        System.out.print("请输入书籍名称："); name = sc.nextLine();
        System.out.print("请输入书籍价格："); bprice = checkInput.checkDouble(sc);
        Book book = new Book(bid, name, bprice);
        try {
            mybatisUtil.insertManage(mapper -> {
                int t = mapper.insertBook(book);
                if(t > 0) successMenu.showInfo();
                else errorsMenu.dataError();
            });
        } catch (Exception e) {
            errorsMenu.dataError();
        }
    }

    private static void insertStu(Scanner sc) {
        int sid;
        String name, sex;
        System.out.print("请输入学生学号："); sid = checkInput.checkInt(sc);
        System.out.print("请输入学生姓名："); name = sc.nextLine();
        System.out.print("请输入学生性别："); sex = sc.nextLine();
        Student student = new Student(sid, name, sex);
        try {
            mybatisUtil.insertManage(mapper -> {
                int t = mapper.insertStudent(student);
                if(t > 0) successMenu.showInfo();
                else errorsMenu.dataError();
            });
        } catch (Exception e) {
            errorsMenu.dataError();
        }
    }

}
