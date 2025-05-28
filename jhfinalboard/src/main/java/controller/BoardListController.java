package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import model.dao.BoardDao;
import model.dto.BoardDto;

@WebServlet("/board/list")
public class BoardListController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public BoardListController() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		String category = request.getParameter("category");
		String pageParam = request.getParameter("page");
		int page = 1;
		if (pageParam != null && !pageParam.isEmpty()) {
			page = Integer.parseInt(pageParam);
		}
		
		int pageSize = 5;
		int startIndex = (page - 1)*pageSize;
		
		
		BoardDao dao = new BoardDao();
		ArrayList<BoardDto> list = dao.list(category, startIndex, pageSize);
		int pageCount = dao.page(category);
		
		
		request.setAttribute("list", list);
		request.setAttribute("page", page);
		request.setAttribute("pageCount", pageCount);
		request.setAttribute("category", category);
		
		RequestDispatcher rd = request.getRequestDispatcher("/view/board/list.jsp");//이부분은 변경해야할 수 있음
		rd.forward(request, response);
	}

}
