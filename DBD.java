import java.io.*;
import java.util.*;
import java.sql.*;

class DBD {
    public static void main(String args[]) {
        Connection con;
        Statement st;
        int no;
        String str;
        Scanner s = new Scanner(System.in);
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ems_db?CharacterEncoding=utf8", "root", "");
            st = con.createStatement();
            System.out.println("Enter the number to be deleted");
            no = s.nextInt();
            str = "DELETE FROM emp WHERE eno=" + no;
            System.out.println(str); // Print the SQL query for verification
            int rowsAffected = st.executeUpdate(str);
            System.out.println(rowsAffected + " record(s) deleted");
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
    }
}