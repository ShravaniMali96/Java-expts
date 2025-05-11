import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
public class StudentCRUD {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/college";
        String username = "root";
        String password = "your_password";
        try {
      Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(url, username, password);
            Statement stmt = con.createStatement();
            System.out.println("Initial data:");
            displayStudents(stmt);
            String insertQuery = "INSERT INTO student VALUES (3, 'Amit Kumar', 22)";
            stmt.executeUpdate(insertQuery);
            System.out.println("\nAfter INSERT:");
            displayStudents(stmt);
            String updateQuery = "UPDATE student SET age = 23 WHERE id = 3";
            stmt.executeUpdate(updateQuery);
            System.out.println("\nAfter UPDATE:");
            displayStudents(stmt);
            String deleteQuery = "DELETE FROM student WHERE id = 3";
            stmt.executeUpdate(deleteQuery);
            System.out.println("\nAfter DELETE:");
            displayStudents(stmt);
            stmt.close();
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void displayStudents(Statement stmt) throws Exception {
        ResultSet rs = stmt.executeQuery("SELECT * FROM student");
        System.out.println("ID\tName\t\tAge");
        while (rs.next()) {
            int id = rs.getInt("id");
            String name = rs.getString("name");
            int age = rs.getInt("age");
            System.out.println(id + "\t" + name + "\t" + age);
        }
        rs.close();
    }
}
