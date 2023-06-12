package BookManager.menus;

public class errorsMenu {
    public static void dataError() {
        System.out.println("=========================");
        System.out.println("|         数据非法        |");
        System.out.println("=========================");
    }

    public static void matchError() {
        System.out.println("=========================");
        System.out.println("|    找不到对应学生或书籍   |");
        System.out.println("=========================");
    }

    public static void existError() {
        System.out.println("=========================");
        System.out.println("|       记录已存在        |");
        System.out.println("=========================");
    }

}
