package controller;

import java.io.IOException;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import model.dao.ReplyDao;
import model.dto.ReplyDto;

@WebServlet("/reply/write")
public class ReplyWriteController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public ReplyWriteController() {
        super();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		HttpSession session = request.getSession();
		String rp_id = (String) session.getAttribute("loginID");
		
		String rp_text = request.getParameter("rp_text");
		String rp_ori = request.getParameter("num");
		
		ReplyDto dto = new ReplyDto(rp_id,rp_text,rp_ori);
		ReplyDao dao = new ReplyDao();
		
		dao.rplwrite(dto);
		
		//해당 페이지 새로고침 or 해당 글로 넘기는 코드
	}

}
