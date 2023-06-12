package BookManager.menus;

public class mainMenu {
    public static void showMainMenu() {
        System.out.println("=========================");
        System.out.println("|    图书馆借还书管理系统   |");
        System.out.println("|-----------------------|");
        System.out.println("|    信息录入: 键入 1     |");
        System.out.println("|    信息修改: 键入 2     |");
        System.out.println("|    信息查询: 键入 3     |");
        System.out.println("|    退出系统: 其他任意键  |");
        System.out.println("=========================");
        System.out.print("请输入操作编号：");
    }

    public static void showEndMenu() {
        System.out.println("=========================");
        System.out.println("|     感谢使用，再见！     |");
        System.out.println("=========================");
    }

}
