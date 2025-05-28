package model.dao;

import java.sql.*;

import db.DB;
import db.DBDao;
import model.dto.UserDto;

public class UserDao extends DBDao {
	/* 로그인 */
	public UserDto login(UserDto d) {
		UserDto result = null;
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;

		try {
			String sql = "select * from " + DB.user + " where id = ? and password = ?";
			con = getConnection();
			pst = con.prepareStatement(sql);
			pst.setString(1, d.getId());
			pst.setString(2, d.getPw());
			rs = pst.executeQuery();
			if (rs.next()) {
				result = new UserDto(rs.getString("id"), rs.getString("pw"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(con, pst, rs);
		}
		return result;
	}

	/* 회원가입 */
	public boolean register(UserDto d) {
		boolean success = false;
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		try {
			String sql = "select * from " + DB.user + " where id = ?";
			con = getConnection();
			pst = con.prepareStatement(sql);
			pst.setString(1, d.getId());
			rs = pst.executeQuery();
			if (rs.next()) {
				return false;
			}
			rs.close();
			pst.close();

			String registersql = "insert into " + DB.user + " (id, password) values (?,?)";
			pst = con.prepareStatement(registersql);
			pst.setString(1, d.getId());
			pst.setString(2, d.getPw());
			int result = pst.executeUpdate();
			if (result == 1) {
				success = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(con, pst, rs);
		}
		return success;
	}
}
