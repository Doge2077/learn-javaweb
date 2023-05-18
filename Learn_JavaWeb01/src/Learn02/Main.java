package Learn02;

import java.sql.*;

public class Main {
    public static void main(String[] args) throws SQLException {
        //1. 通过DriverManager来获得数据库连接
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/jwb", "root", "023017lys");
             //2. 创建一个用于执行SQL的Statement对象
             Statement statement = connection.createStatement()) {   //注意前两步都放在try()中，因为在最后需要释放资源！
            //3. 执行SQL语句，并得到结果集
            ResultSet set = statement.executeQuery("SELECT * FROM stu");
            ResultSetMetaData metaData = set.getMetaData();  // 使用ResultSetMetaData类来获取结果集中的元数据信息。ResultSetMetaData对象可以获取结果集的列数和列的名称等信息。
            int columnCount = metaData.getColumnCount();
            //4. 查看结果
            while (set.next()) {
                for (int i = 1; i <= columnCount; i ++){
                    System.out.print(set.getString(i) + " ");
                }

                System.out.println();
            }

//            // 批处理
//            statement.addBatch("INSERT INTO Student VALUES (1008, '谢坤坤', '男')");
//            statement.addBatch("INSERT INTO Student VALUES (1009, '王汝成', '男')");
//            statement.addBatch("INSERT INTO Student VALUES (1010, '杨琳', '女')");
//            statement.executeBatch();  // 一起执行

        } catch (SQLException e) {
            e.printStackTrace();
        }
        //5. 释放资源，try-with-resource语法会自动帮助我们close
//        System.out.println(System.getProperty("java.class.path"));

    }
}
