package kiemthu;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class StudentCRUD {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//insertStudent();
		//selectStudent();
		//updateStudent();
		deleteStudent();
		System.out.println("KET THUC CHUONG TRINH");
	}

	public static void insertStudent() {
		String jdbcUrl = "jdbc:mysql://192.168.1.7:3306/ontapdb";
        String username = "ontapdbuser2";
        String password = "@Dmin1234";
        
        try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection connection = DriverManager.getConnection(jdbcUrl, username, password);
			
			// Thêm dữ liệu vào bảng student
            String insertQuery = "INSERT INTO student (fullname, birthday, gender) VALUES (?, ?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(insertQuery);
            preparedStatement.setString(1, "Nguyen Van A");
            preparedStatement.setDate(2, Date.valueOf("2000-01-01"));
            preparedStatement.setString(3, "Nam");
            preparedStatement.executeUpdate();

            System.out.println("Dữ liệu đã được thêm vào bảng student.");

            connection.close();
            System.out.println("Dong ket noi den CSDL");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("MYSQL DRIVER ERROR");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("LOI KET NOI DEN CSDL MYSQL");
		}
        System.out.println("INSERT COMPLETED");
	}
	
	public static void selectStudent() {
		String jdbcUrl = "jdbc:mysql://192.168.1.7:3306/ontapdb";
        String username = "ontapdbuser2";
        String password = "@Dmin1234";
        
        try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection connection = DriverManager.getConnection(jdbcUrl, username, password);
			
			// Thực hiện truy vấn đến MySQL
	        Statement statement = connection.createStatement();
	        
	        ResultSet rs = statement.executeQuery("SELECT * FROM student");

	        while (rs.next()) {
	            System.out.println(rs.getInt("studentID") + "; " +
	            					rs.getString("fullname") + "; " +
	            					rs.getDate("birthday") + "; " +
	            					rs.getString("gender"));
	        }

            System.out.println("Dữ liệu đã lấy từ bảng student.");

            connection.close();
            System.out.println("Dong ket noi den CSDL");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("MYSQL DRIVER ERROR");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("LOI KET NOI DEN CSDL MYSQL");
		}
        System.out.println("SELECT COMPLETED");
	}
	
	public static void updateStudent() {
		String jdbcUrl = "jdbc:mysql://192.168.1.7:3306/ontapdb";
        String username = "ontapdbuser2";
        String password = "@Dmin1234";
        
        try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection connection = DriverManager.getConnection(jdbcUrl, username, password);
			
			// Sửa dữ liệu trong bảng student
            String updateQuery = "UPDATE student SET birthday = ? WHERE studentID = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(updateQuery);
            preparedStatement.setDate(1, Date.valueOf("2004-12-25"));
            preparedStatement.setInt(2, 1);
            int rowsAffected = preparedStatement.executeUpdate();

            if (rowsAffected > 0) {
                System.out.println("Dữ liệu đã được sửa trong bảng student.");
            } else {
                System.out.println("Không tìm thấy bản ghi có studentID = 1.");
            }
            connection.close();
            System.out.println("Dong ket noi den CSDL");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("MYSQL DRIVER ERROR");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("LOI KET NOI DEN CSDL MYSQL");
		}
        System.out.println("UPDATE COMPLETED");
	}
	
	public static void deleteStudent() {
		String jdbcUrl = "jdbc:mysql://192.168.1.7:3306/ontapdb";
        String username = "ontapdbuser2";
        String password = "@Dmin1234";
        
        try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection connection = DriverManager.getConnection(jdbcUrl, username, password);
			
			// Xoá dữ liệu trong bảng student với studentID = 
            String deleteQuery = "DELETE FROM student WHERE studentID = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(deleteQuery);
            preparedStatement.setInt(1, 1);
            int rowsAffected = preparedStatement.executeUpdate();
            connection.commit();
            preparedStatement.closeOnCompletion();

            if (rowsAffected > 0) {
                System.out.println("Dữ liệu đã được xoá trong bảng student.");
            } else {
                System.out.println("Không tìm thấy bản ghi có studentID = 1.");
            }
            
            connection.close();
            System.out.println("Dong ket noi den CSDL");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("MYSQL DRIVER ERROR");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("LOI KET NOI DEN CSDL MYSQL");
		}
        System.out.println("DELETE COMPLETED");
	}
}
