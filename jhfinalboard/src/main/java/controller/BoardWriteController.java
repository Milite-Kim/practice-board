package controller;

import java.io.IOException;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import model.dao.BoardDao;
import model.dto.BoardDto;

@WebServlet("/board/write")
public class BoardWriteController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public BoardWriteController() {
        super();

    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		// 사용자 아이디 받기
		HttpSession session = request.getSession();
		String creator = (String) session.getAttribute("loginID");
		
		if (creator == null) {
			creator = "Guest";
		}
		
		// 글 내용 받기
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		String category = request.getParameter("category");
		
		BoardDto dto = new BoardDto(title, content, creator, category);

		// 글 내용 넣기
		BoardDao dao = new BoardDao();
		dao.write(dto);
		
		// 다음 페이지로 보내기
		//response.sendRedirect(category);
	}

}
