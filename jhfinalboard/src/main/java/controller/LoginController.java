package controller;

import java.io.IOException;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import model.dao.UserDao;
import model.dto.UserDto;

@WebServlet("/login")
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

		if (!input_id.isEmpty() && !input_pw.isEmpty() && input_id != null && input_pw != null) {
			UserDto dto = new UserDto(input_id, input_pw);
			UserDao dao = new UserDao();
			UserDto user = dao.login(dto);
			if (user != null) {
				session.setAttribute("loginID", user.getId());

				response.sendRedirect("/index.jsp");
			} else {
				request.setAttribute("errorMsg", "존재하지 않는 아이디 혹은 비밀번호입니다");
				request.setAttribute("input_id", input_id);
				request.getRequestDispatcher("/login.jsp").forward(request, response);
			}
		} else {
			request.setAttribute("errorMsg", "아이디와 비밀번호를 입력해주세요");
			request.setAttribute("input_id", input_id);
			request.getRequestDispatcher("/login.jsp").forward(request, response);
		}
	}
}
