package BookManager.Utils;

import BookManager.menus.errorsMenu;
import BookManager.menus.successMenu;
import BookManager.menus.updateMenu;
import Tools.manage.Book;
import Tools.manage.Borrow;
import Tools.manage.Student;
import Tools.mybatisUtil;

import java.util.Scanner;

public class infoUpdate {
    public static void function(Scanner sc) {
        updateMenu.showUpdateMenu();
        int op = checkInput.checkInt(sc);
        switch (op) {
            case 1:
                deleteStu(sc);
                break;
            case 2:
                deleteBook(sc);
                break;
            case 3:
                deleteBorr(sc);
                break;
            case 4:
                updateStuName(sc);
                break;
            case 5:
                updateStuSex(sc);
                break;
            case 6:
                updateBookName(sc);
                break;
            case 7:
                updateBookPrice(sc);
                break;
            default:
        }
    }

    private static void updateBookPrice(Scanner sc) {
        int bid;
        System.out.print("请输入书籍编号："); bid = checkInput.checkInt(sc);
        mybatisUtil.selectManage(selectMapper -> {
            Book book = selectMapper.selectBookByBid(bid);
            if (book != null) {
                double price;
                System.out.print("请输入书籍价格："); price = checkInput.checkDouble(sc);
                mybatisUtil.updateManage(updateMapper -> {
                    updateMapper.updateBookPrice(bid, price);
                });
                successMenu.showInfo();
            }
            else errorsMenu.noBookError();
        });
    }

    private static void updateBookName(Scanner sc) {
        int bid;
        System.out.print("请输入书籍编号："); bid = checkInput.checkInt(sc);
        mybatisUtil.selectManage(selectMapper -> {
            Book book = selectMapper.selectBookByBid(bid);
            if (book != null) {
                String name;
                System.out.print("请输入书籍名称："); name = sc.nextLine();
                mybatisUtil.updateManage(updateMapper -> {
                    updateMapper.updateBookName(bid, name);
                });
                successMenu.showInfo();
            }
            else errorsMenu.noBookError();
        });
    }

    private static void updateStuSex(Scanner sc) {
        int sid;
        System.out.print("请输入学生学号："); sid = checkInput.checkInt(sc);
        mybatisUtil.selectManage(selectMapper -> {
            Student student = selectMapper.selectStudentBySid(sid);
            if (student != null) {
                String sex;
                System.out.print("请输入学生性别："); sex = sc.nextLine();
                mybatisUtil.updateManage(updateMapper -> {
                    updateMapper.updateStudentSex(sid, sex);
                });
                successMenu.showInfo();
            }
            else errorsMenu.noStudentError();
        });
    }

    private static void updateStuName(Scanner sc) {
        int sid;
        System.out.print("请输入学生学号："); sid = checkInput.checkInt(sc);
        mybatisUtil.selectManage(selectMapper -> {
            Student student = selectMapper.selectStudentBySid(sid);
            if (student != null) {
                String name;
                System.out.print("请输入学生姓名："); name = sc.nextLine();
                mybatisUtil.updateManage(updateMapper -> {
                    updateMapper.updateStudentName(sid, name);
                });
                successMenu.showInfo();
            }
            else errorsMenu.noStudentError();
        });
    }

    private static void deleteBorr(Scanner sc) {
        int sid, bid;
        System.out.print("请输入学生学号："); sid = checkInput.checkInt(sc);
        System.out.print("请输入书籍编号："); bid = checkInput.checkInt(sc);
        mybatisUtil.selectManage(selectMapper -> {
            Borrow borrow = selectMapper.selectBorrowBySidAndBid(sid, bid);
            if (borrow != null) {
                mybatisUtil.deleteManage(deleteMapper -> {
                    deleteMapper.deleteBorrowBySidAndBid(sid, bid);
                });
                successMenu.showInfo();
            }
            else errorsMenu.noMatchError();
        });
    }

    private static void deleteBook(Scanner sc) {
        int bid;
        System.out.print("请输入书籍编号："); bid = checkInput.checkInt(sc);
        mybatisUtil.selectManage(selectMapper -> {
            Book book = selectMapper.selectBookByBid(bid);
            if (book != null) {
                mybatisUtil.deleteManage(deleteMapper -> {
                    deleteMapper.deleteBookByBid(bid);
                });
                successMenu.showInfo();
            }
            else errorsMenu.noBookError();
        });
    }

    private static void deleteStu(Scanner sc) {
        int sid;
        System.out.print("请输入学生学号："); sid = checkInput.checkInt(sc);
        mybatisUtil.selectManage(selectMapper -> {
            Student student = selectMapper.selectStudentBySid(sid);
            if (student != null) {
                mybatisUtil.deleteManage(deleteMapper -> {
                    deleteMapper.deleteStudnetBySid(sid);
                });
                successMenu.showInfo();
            }
            else errorsMenu.noStudentError();
        });
    }

}
