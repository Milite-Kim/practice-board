package controller;

import java.io.IOException;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import model.dao.ReplyDao;

@WebServlet("/reply/delete")
public class ReplyDeleteController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public ReplyDeleteController() {
        super();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		HttpSession session = request.getSession();
		String loginID = (String) session.getAttribute("loginID");
		
		String rp_num = request.getParameter("rp_num");
		
		ReplyDao dao = new ReplyDao();
		String creator = dao.rplid(rp_num);
		
		if (loginID.equals(creator)) {
			dao.rpldelete(rp_num);
			// 글 페이지로 넘기기 코드
		} else {
			// 삭제 권한 없음 알리기
		}
	}

}
