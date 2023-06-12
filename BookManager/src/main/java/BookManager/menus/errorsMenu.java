package BookManager.menus;

public class errorsMenu {
    public static void dataError() {
        System.out.println("=============================");
        System.out.println("          数据非法         ");
        System.out.println("=============================");
    }

    public static void existError() {
        System.out.println("=============================");
        System.out.println("        记录已存在         ");
        System.out.println("=============================");
    }

    public static void noStudentError() {
        System.out.println("=============================");
        System.out.println("       找不到对应学生       ");
        System.out.println("=============================");
    }

    public static void noBookError() {
        System.out.println("=============================");
        System.out.println("       找不到对应书籍       ");
        System.out.println("=============================");
    }

    public static void noMatchError() {
        System.out.println("=============================");
        System.out.println("     找不到对应学生和书籍    ");
        System.out.println("=============================");
    }

    public static void emptyError() {
        System.out.println("=============================");
        System.out.println("     查询结果为空    ");
        System.out.println("=============================");
    }
}
