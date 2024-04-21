import java.io.*;
import java.util.*;
import java.sql.*;

class DBU {
    public static void main(String args[]) {
        int no;
        String str, name;
        Float sal;
        Scanner s = new Scanner(System.in);
        try {
            Connection con;
            Statement st;
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ems_db?CharacterEncoding=utf-8", "root", "");
            st = con.createStatement();
            System.out.println("Enter no, name, sal to be updated");
            no = s.nextInt();
            s.nextLine(); // consume newline
            name = s.nextLine();
            sal = s.nextFloat();
            str = "UPDATE emp SET ename='" + name + "', esal=" + sal + " WHERE eno=" + no;
            System.out.println(str); // Print the SQL query for verification
            int rowsAffected = st.executeUpdate(str);
            System.out.println(rowsAffected + " record(s) updated");
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
    }
}