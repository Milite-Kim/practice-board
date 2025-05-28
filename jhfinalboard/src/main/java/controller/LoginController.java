package controller;

import java.io.IOException;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import model.dao.UserDao;
import model.dto.UserDto;

@WebServlet("/Login")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public LoginController() {
		super();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		HttpSession session = request.getSession();
		String input_id = request.getParameter("id");
		String input_pw = request.getParameter("pw");
		
		if (!input_id.isEmpty()&&!input_pw.isEmpty()) {
			UserDto dto = new UserDto(input_id, input_pw);
			UserDao dao = new UserDao();
			dao.login(dto);
			session.setAttribute("loginID", input_id);
			
			//메인 페이지로 보내는 문구
		} else {
			//아이디와 비밀번호를 입력하라는 문구 출력
		}
	}
}
