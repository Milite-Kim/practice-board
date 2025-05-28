package controller;

import java.io.IOException;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import model.dao.BoardDao;
import model.dto.BoardDto;

@WebServlet("/board/delete")
public class BoardDeleteController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public BoardDeleteController() {
        super();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		HttpSession session = request.getSession();
		String loginID = (String) session.getAttribute("loginID");
		String num = request.getParameter("num");
		BoardDao dao = new BoardDao();
		BoardDto post = dao.read(num);
		String creator = post.getCreator();
		
		if (loginID.equals(creator)&&loginID != null) {
		dao.del(num);
		//다음 페이지로 넘기는 코드
		} else {
		// 권한이 없다는 알림을 보내는 코드
		// 해당 글 페이지로 보내는 코드 
		}
	}
}
