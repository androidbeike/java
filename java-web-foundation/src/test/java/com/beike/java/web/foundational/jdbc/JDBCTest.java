package com.beike.java.web.foundational.jdbc;

import com.mysql.cj.jdbc.Driver;
import org.testng.annotations.Test;

import java.sql.*;

/**
 * JDBC编程
 *
 * @author beike
 * @version 2021/8/6 23:47
 * @since JDK11
 */
public class JDBCTest {
    /**
     * 1注册驱动
     * 2获取连接
     * 3获取执行sql的对象
     * 4执行sql获取返回结果
     * 5处理结果
     * 6关闭资源
     */
    @Test
    public void testSelectJDBCTableData(){
        String url="jdbc:mysql://127.0.0.1:3306/jdbc";
        String userName="root";
        String userPassword="bk6813573";
        try {
            //1注册驱动
            DriverManager.registerDriver(new Driver());
            //2获得连接
            Connection connection = DriverManager.getConnection(url, userName, userPassword);
            //3获取执行sql的对象
            Statement statement = connection.createStatement();
            //4执行sql获取返回结果,得到结果集
            ResultSet resultSet = statement.executeQuery("select * from jdbc_user");
            //5处理结果
            while (resultSet.next()){
                //获取表中记录
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String password = resultSet.getString("password");
                Timestamp creatDate = resultSet.getTimestamp("create_date");
                Timestamp updateDate = resultSet.getTimestamp("update_date");
                //打印查询表（jdbc_user）中数据
                System.out.println("id:"+id+"name"+name+"password"
                        +password+"createDate"+creatDate+"updateDate"+updateDate);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
