package kiemthu;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class KetNoiCoSoDuLieu {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		Class.forName("com.mysql.cj.jdbc.Driver");
		System.out.println("Ket noi thanh cong");
		//Tao ket noi den MySQL
		String url = "jdbc:mysql://192.168.1.7:3306/ontapdb";
		String username = "ontapdbuser2";
        String password = "@Dmin1234";
        
        Connection connection = DriverManager.getConnection(url, username, password);
        // Thực hiện truy vấn đến MySQL
        Statement statement = connection.createStatement();
        
        ResultSet rs = statement.executeQuery("SELECT * FROM student");

        while (rs.next()) {
            System.out.println(rs.getInt("studentID") + "; " +
            					rs.getString("fullname") + "; " +
            					rs.getDate("birthday") + "; " +
            					rs.getString("gender"));
        }

        // Kết thúc kết nối đến MySQL
        connection.close();
        System.out.println("Ket thuc chuong trinh");
	}

}
