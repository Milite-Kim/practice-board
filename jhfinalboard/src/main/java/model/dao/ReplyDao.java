package model.dao;

import java.sql.*;
import java.util.ArrayList;
import db.DB;
import db.DBDao;
import model.dto.ReplyDto;

public class ReplyDao extends DBDao {
	/* 댓글 달기 */
	public void rplwrite(ReplyDto d) {
		Connection con = null;
		PreparedStatement pst = null;
		try {
			String sql = "insert into " + DB.reply + " (rp_id, rp_text, rp_ori, rp_time) values (?, ?, ?, now())";
			con = getConnection();
			pst = con.prepareStatement(sql);
			pst.setString(1, d.getRp_id());
			pst.setString(2, d.getRp_text());
			pst.setString(3, d.getRp_ori());
			pst.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(con, pst);
		}
	}

	/* 댓글 삭제 */
	public void rpldelete(String num) {
		Connection con = null;
		PreparedStatement pst = null;
		try {
			String sql = "delete from " + DB.reply + " where rp_num = ?";
			con = getConnection();
			pst = con.prepareStatement(sql);
			pst.setString(1, num);
			pst.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(con, pst);
		}
	}

	/* 댓글 수정 */
	public void rplmodify(ReplyDto d, String num) {
		Connection con = null;
		PreparedStatement pst = null;
		try {
			String sql = "update "+DB.reply+" set rp_text=?, time=now() where rp_num = ?";
			con = getConnection();
			pst = con.prepareStatement(sql);
			pst.setString(1, d.getRp_text());
			pst.setString(2, num);
			pst.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			close(con,pst);
		}
	}
	
	/* 댓글 리스트 */
	public ArrayList<ReplyDto> rpllist(String num) {
		ArrayList<ReplyDto> reply = new ArrayList<>();
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		try {
			String sql = "select * from " + DB.reply + " where rp_ori = ? order by rp_time";
			con = getConnection();
			pst = con.prepareStatement(sql);
			pst.setString(1, num);
			rs = pst.executeQuery();
			while (rs.next()) {
				reply.add(new ReplyDto(rs.getString("rp_id"), rs.getString("rp_text"), rs.getString("rp_ori"),
						rs.getString("rp_time")));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(con, pst, rs);
		}
		return reply;
	}
	
	public String rplid(String num) {
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		String creator = null;
		try {
			String sql = "select * from " + DB.reply + " where rp_num = ?";
			con = getConnection();
			pst = con.prepareStatement(sql);
			pst.setString(1, num);
			rs = pst.executeQuery();
			creator = rs.getString("rp_id");
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			close(con,pst,rs);
		}
		return creator;
	}
}
