import java.util.Scanner;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MainPage2 {

    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        boolean exit = false;
        while (!exit) {
            System.out.println("Menu:");
            System.out.println("1. User Registration");
            System.out.println("2. Login");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");
            int choice;
            try {
                choice = scanner.nextInt();
                scanner.nextLine(); // Consume newline
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
                return;
            }

            switch (choice) {
                case 1:
                    userRegistration();
                    break;
                case 2:
                    if (login(scanner)) { // Pass scanner object as argument
                        int userId = getUserId(scanner); // Retrieve user ID
                        int quizMarks = attendQuiz(scanner); // Pass scanner object as argument and get quiz marks
                        insertQuizMarks(userId, quizMarks); // Insert quiz marks into tbl_result table
                    }
                    break;
                case 3:
                    System.out.println("Exiting...");
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
            }
        }
        // Do not close the Scanner object here
    }

    public static int getUserId(Scanner scanner) {
        // Retrieve the user's ID
        System.out.print("Enter Username: ");
        String username = scanner.nextLine();
        // Assuming the table tbl_reg has a column named id
        int userId = -1; // Initialize with a default value
        try {
            Class.forName("com.mysql.jdbc.Driver");
            try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ems_db?CharacterEncoding=utf8", "root", "");
                 Statement st = con.createStatement()) {
                String query = "SELECT id FROM tbl_reg WHERE uname = '" + username + "'";
                try (ResultSet rs = st.executeQuery(query)) {
                    if (rs.next()) {
                        userId = rs.getInt("id");
                    } else {
                        System.out.println("User not found");
                    }
                }
            }
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
        return userId;
    }

    public static int attendQuiz(Scanner scanner) {
        // ... your quiz logic using the passed scanner object ...
        String[] questions = {
            "1. What is the capital of France?\n(a) London\n(b) Paris\n(c) Rome\n(d) Berlin",
            "2. Who wrote 'Romeo and Juliet'?\n(a) William Shakespeare\n(b) Charles Dickens\n(c) Jane Austen\n(d) Mark Twain",
            "3. What is the chemical symbol for water?\n(a) Wa\n(b) Wt\n(c) H2O\n(d) W"
        };
    
        String[] answers = {"b", "a", "c"};
        int score = 0;
    
        System.out.println("Welcome to the Quiz!");
        for (int i = 0; i < questions.length; i++) {
            System.out.println(questions[i]);
            System.out.print("Your answer: ");
            String userAnswer = scanner.nextLine();
            if (userAnswer.equals(answers[i])) {
                System.out.println("Correct!");
                score++;
            } else {
                System.out.println("Incorrect!");
            }
        }
    
        System.out.println("Quiz complete!");
        System.out.println("Your score: " + score + "/" + questions.length);
        
        // Return the quiz marks
        return score;
    }

    public static void userRegistration() {
        // ... your registration logic ...
        try {
            Class.forName("com.mysql.jdbc.Driver");
            try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ems_db?CharacterEncoding=utf8", "root", "");
                 Statement st = con.createStatement();
                 Scanner scanner = new Scanner(System.in)) {
                System.out.println("User Registration:");
                System.out.print("Enter id: ");
                int id = scanner.nextInt();
                scanner.nextLine(); // Consume newline
                System.out.print("Enter username: ");
                String username = scanner.nextLine();
                System.out.print("Enter password: ");
                String password = scanner.nextLine();
                String query = "INSERT INTO tbl_reg VALUES(" + id + ", '" + username + "', '" + password + "')";
                int rowsAffected = st.executeUpdate(query);
                System.out.println(rowsAffected + " record(s) inserted");
            }
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public static boolean login(Scanner scanner) {
        boolean loggedIn = false;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ems_db?CharacterEncoding=utf8", "root", "");
                 Statement st = con.createStatement()) {
                System.out.print("Enter Username: ");
                String username = scanner.nextLine();
                System.out.print("Enter Password: ");
                String password = scanner.nextLine();
                String query = "SELECT * FROM tbl_reg WHERE uname = '" + username + "' AND password = '" + password + "'";
                try (ResultSet rs = st.executeQuery(query)) {
                    if (rs.next()) {
                        System.out.println("Login successful");
                        loggedIn = true;
                    } else {
                        System.out.println("Invalid user");
                    }
                }
            }
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
        return loggedIn;
    }

    public static void insertQuizMarks(int userId, int quizMarks) {
        // Insert quiz marks into tbl_result table
        try {
            Class.forName("com.mysql.jdbc.Driver");
            try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ems_db?CharacterEncoding=utf8", "root", "");
                 Statement st = con.createStatement()) {
                String query = "INSERT INTO tbl_result (id, quiz_mark) VALUES (" + userId + ", " + quizMarks + ")";
                int rowsAffected = st.executeUpdate(query);
                System.out.println(rowsAffected + " record(s) inserted");
            }
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
