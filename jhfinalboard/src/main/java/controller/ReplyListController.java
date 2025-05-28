package controller;

import java.io.IOException;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.util.ArrayList;
import model.dao.ReplyDao;
import model.dto.ReplyDto;

@WebServlet("/reply/list")
public class ReplyListController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ReplyListController() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		ReplyDao dao = new ReplyDao();
		
		String num = request.getParameter("num");
		
		ArrayList<ReplyDto> list = dao.rpllist(num);
		
		request.setAttribute("list", list);
	}

}
