package BookManager.Utils;

import BookManager.menus.errorsMenu;
import BookManager.menus.selectMenu;
import Tools.manage.Book;
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
                selectOneStu(sc);
                break;
            case 2:
                selectOneBook(sc);
                break;
            case 3:
                selectAllStu();
                break;
            case 4:
                selectAllBook();
                break;
            case 5:
                selectStu(sc);
                break;
            case 6:
                selectBook(sc);
                break;
            case 7:
                selectAll();
                break;
            default:
        }
    }

    private static void selectAll() {
        mybatisUtil.selectManage(selectMapper -> {
            LinkedList<StudentInfo> studentinfolist = selectMapper.selectAll();
            if (studentinfolist.size() != 0) {
                studentinfolist.forEach(System.out::println);
            }
            else errorsMenu.emptyError();
        });
    }

    private static void selectBook(Scanner sc) {
        int bid;
        System.out.print("请输入书籍编号："); bid = checkInput.checkInt(sc);
        try {
            mybatisUtil.selectManage(selectMapper -> {
                LinkedList<Student> studentlist = selectMapper.getSutedntByBid(bid);
                if (studentlist.size() != 0) {
                    studentlist.forEach(System.out::println);
                }
                else errorsMenu.emptyError();
            });
        } catch (Exception e) {
            errorsMenu.noBookError();
        }
    }

    private static void selectStu(Scanner sc) {
        int sid;
        System.out.print("请输入学生学号："); sid = checkInput.checkInt(sc);
        try {
            mybatisUtil.selectManage(selectMapper -> {
                LinkedList<Book> booklist = selectMapper.getBookBySid(sid);
                if (booklist.size() != 0) {
                    booklist.forEach(System.out::println);
                }
                else errorsMenu.emptyError();
            });
        } catch (Exception e) {
            errorsMenu.noStudentError();
        }
    }

    private static void selectAllBook() {
        mybatisUtil.selectManage(selectMapper -> {
            LinkedList<Book> booklist = selectMapper.selectAllBook();
            if (booklist.size() != 0) {
                booklist.forEach(System.out::println);
            }
            else errorsMenu.emptyError();
        });
    }

    private static void selectAllStu() {
        mybatisUtil.selectManage(selectMapper -> {
            LinkedList<Student> studentlist = selectMapper.selectAllStu();
            if (studentlist.size() != 0) {
                studentlist.forEach(System.out::println);
            }
            else errorsMenu.emptyError();
        });
    }

    private static void selectOneBook(Scanner sc) {
        int bid;
        System.out.print("请输入书籍编号："); bid = checkInput.checkInt(sc);
        mybatisUtil.selectManage(selectMapper -> {
            Book book = selectMapper.selectBookByBid(bid);
            if (book != null) {
                System.out.println(book);
            }
            else errorsMenu.noBookError();
        });
    }

    private static void selectOneStu(Scanner sc) {
        int sid;
        System.out.print("请输入学生学号："); sid = checkInput.checkInt(sc);
        mybatisUtil.selectManage(selectMapper -> {
            Student student = selectMapper.selectStudentBySid(sid);
            if (student != null) {
                System.out.println(student);
            }
            else errorsMenu.noStudentError();
        });
    }

}
