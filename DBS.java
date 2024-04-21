import java.io.*;
import java.util.*;
import java.sql.*;

class DBS {
    public static void main(String args[]) {
        Connection con;
        Statement st;
        int no;
        String str;
        ResultSet rs;
        Scanner s = new Scanner(System.in);
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ems_db?CharacterEncoding=utf8", "root", "");
            st = con.createStatement();
            str = "select * from emp";
            System.out.println(str);
            rs = st.executeQuery(str);
            while(rs.next())
            {
                System.out.println(rs.getString("eno")+""+rs.getString("ename")+""rs.getString("sal"));
            }
            
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
    }
}