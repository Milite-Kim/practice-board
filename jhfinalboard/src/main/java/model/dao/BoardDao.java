package model.dao;

import java.sql.*;
import java.util.ArrayList;

import db.DB;
import db.DBDao;
import model.dto.BoardDto;

public class BoardDao extends DBDao {

	/* 글 쓰기 */
	public void write(BoardDto d) {
		Connection con = null;
		PreparedStatement pst = null;
		try {
			String sql = "insert into " + DB.board
					+ " (title, content, creator, time, category) values (?, ?, ?, now(), ?)";
			con = getConnection();
			pst = con.prepareStatement(sql);

			pst.setString(1, d.getTitle());
			pst.setString(2, d.getContent());
			pst.setString(3, d.getCreator());
			pst.setString(4, d.getCategory());

			pst.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(con, pst);
		}
	}

	/* 글 수정 */
	public void modify(BoardDto d, String num) {
		Connection con = null;
		PreparedStatement pst = null;
		try {
			String sql = "update " + DB.board + " set title=?, content=?, time=now(), category=? where num=?";
			con = getConnection();
			pst = con.prepareStatement(sql);
			pst.setString(1, d.getTitle());
			pst.setString(2, d.getContent());
			pst.setString(3, num);
			pst.setString(4, d.getCategory());
			pst.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(con, pst);
		}
	}

	/* 글 삭제 */
	public void del(String num) {
		Connection con = null;
		PreparedStatement pst = null;
		try {
			String sql = "delete from " + DB.board + " where num=?";
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

	/* 글 읽기 */
	public BoardDto read(String num) {
		BoardDto post = null;
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		try {
			String sql = "select * from " + DB.board + " where num = ?";
			con = getConnection();
			pst = con.prepareStatement(sql);
			pst.setString(1, num);
			rs = pst.executeQuery();
			if (rs.next()) {
				post = new BoardDto(rs.getString("num"), rs.getString("title"), rs.getString("content"),
						rs.getString("creator"), rs.getString("time"), rs.getString("hit"), rs.getString("rp_count"),
						rs.getString("category"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(con, pst, rs);
		}
		return post;
	}

	/* 글 리스트 */
	public ArrayList<BoardDto> list(String category, int startIndex, int pageSize) {
		ArrayList<BoardDto> posts = new ArrayList<>();
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		try {
			String sql;
			if (category == null || category.isEmpty() || category.equals("all")) {
				sql = "SELECT * FROM " + DB.board + " ORDER BY num DESC LIMIT ?, ?";
				con = getConnection();
				pst = con.prepareStatement(sql);
				pst.setInt(1, startIndex);
				pst.setInt(2, pageSize);
			} else {
				sql = "SELECT * FROM " + DB.board + " WHERE category = ? ORDER BY num DESC LIMIT ?, ?";
				con = getConnection();
				pst = con.prepareStatement(sql);
				pst.setString(1, category);
				pst.setInt(2, startIndex);
				pst.setInt(3, pageSize);
			}
			rs = pst.executeQuery();
			while (rs.next()) {
				posts.add(new BoardDto(rs.getString("num"), rs.getString("title"), rs.getString("content"),
						rs.getString("creator"), rs.getString("time"), rs.getString("hit"), rs.getString("rp_count")));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(con, pst, rs);
		}
		return posts;
	}

	/* 페이지 처리 */
	public int page(String category) {
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;

		int pagetotal = 0;
		try {
			String sql;
			if (category == null || category.isEmpty() || category.equals("all")) {
				sql = "select count(*) from " + DB.board;
				con = getConnection();
				pst = con.prepareStatement(sql);
			} else {
				sql = "select count(*) from " + DB.board + " where category = ?";
				con = getConnection();
				pst = con.prepareStatement(sql);
				pst.setString(1, category);
			}

			rs = pst.executeQuery();
			if (rs.next()) {
				int posts = rs.getInt(1);
				pagetotal = (int) Math.ceil(posts / 5.0);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(con, pst, rs);
		}

		return pagetotal;
	}
	
	/* 검색 */
	public ArrayList<BoardDto> search(String s, int startindex, int pagesize){
		ArrayList<BoardDto> result = new ArrayList<>();
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		
		try {
			String sql = "select * from " + DB.board + " where title like ? order by num desc limit ?, ?";
			con = getConnection();
			pst = con.prepareStatement(sql);
			pst.setString(1, "%" + s + "%");
			pst.setInt(1, startindex);
			pst.setInt(2, pagesize);
			rs = pst.executeQuery();
			while (rs.next()) {
				result.add(new BoardDto(rs.getString("num"), rs.getString("title"), rs.getString("content"),
						rs.getString("creator"), rs.getString("time"), rs.getString("hit"), rs.getString("rp_count")));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			close(con, pst, rs);
		}
		
		return result;
	}
}
