import java.io.*;
import java.util.*;
import java.sql.*;

class DBI {
    public static void main(String args[]) {
        Connection con;
        Statement st;
        int no;
        String name;
        Float sal;
        Scanner s = new Scanner(System.in);
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ems_db?CharacterEncoding=utf8", "root", "");
            st = con.createStatement();
            System.out.println("enter no, name and salary");
            no = s.nextInt();
            s.nextLine(); // Consume newline left-over
            name = s.nextLine();
            sal = s.nextFloat();
            String str = "insert into emp values(";
            str = str + no + ",'";
            str = str + name + "',";
            str = str + sal + ")";
            System.out.println(str);
            int rowsAffected = st.executeUpdate(str);
            System.out.println(rowsAffected + " record(s) inserted");
        } catch (Exception e) {
            System.out.println("error: " + e.getMessage());
        }
    }
}