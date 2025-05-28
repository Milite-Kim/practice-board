package controller;

import java.io.IOException;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import model.dao.BoardDao;
import model.dto.BoardDto;

@WebServlet("/board/modify")
public class BoardModifyController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public BoardModifyController() {
		super();

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");

		HttpSession session = request.getSession();
		String loginID = (String) session.getAttribute("loginID");
		String num = request.getParameter("num");
		BoardDao dao = new BoardDao();
		BoardDto post = dao.read(num);
		String creator = post.getCreator();

		if (loginID.equals(creator) && loginID != null) {
			String title = request.getParameter("title");
			String content = request.getParameter("content");
			String category = request.getParameter("category");

			BoardDto dto = new BoardDto(title, content, category);
			dao.modify(dto, num);
			
			// 다음 페이지로 넘기기
		}else {
			// 권한 없음 알림
			// 원래 글 페이지로 넘기기
		}
	}

}
