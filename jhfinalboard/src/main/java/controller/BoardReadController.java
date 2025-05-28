package controller;

import java.io.IOException;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import model.dao.BoardDao;
import model.dto.BoardDto;

@WebServlet("/board/read")
public class BoardReadController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public BoardReadController() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		String num = request.getParameter("num");
		BoardDao dao = new BoardDao();
		BoardDto dto = dao.read(num);
		
		request.setAttribute("reading", dto);
	}

}
