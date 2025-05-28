package db;

import java.sql.*;

public class DBDao {
	public static Connection getConnection() throws Exception {
		Class.forName(DB.DB_JDBC_DRIVER_PACKAGE_PATH);
		return DriverManager.getConnection(DB.DB_URL, DB.DB_ID, DB.DB_PW);
	}
	
	public static void close(Connection con, PreparedStatement pst) {
		try {
			if (pst != null)
				pst.close();
			if (con != null)
				con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void close(Connection con, PreparedStatement pst, ResultSet rs) {
		try {
			if (rs != null)
				rs.close();
			if (pst != null)
				pst.close();
			if (con != null)
				con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
