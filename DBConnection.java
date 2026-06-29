// Source code is decompiled from a .class file using FernFlower decompiler (from Intellij IDEA).
package backend.src.main.java;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
   private static final String URL = "jdbc:mysql://localhost:3307/clinic_data.sql";
   private static final String USER = "root";
   private static final String PASSWORD = " ";

   public DBConnection() {
   }

   public static Connection getConnection() throws SQLException {
      try {
         Class.forName("com.mysql.cj.jdbc.Driver");
         return DriverManager.getConnection(URL, USER, PASSWORD);
      } catch (ClassNotFoundException var1) {
         throw new SQLException("MySQL Driver not found!", var1);
      }
   }
}