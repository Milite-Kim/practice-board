package controller;

import java.io.IOException;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import model.dao.UserDao;
import model.dto.UserDto;

@WebServlet("/register")
public class RegisterController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public RegisterController() {
		super();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");

		String input_id = request.getParameter("input_id");
		String input_pw = request.getParameter("input_pw");
		String check_pw = request.getParameter("check_pw");

		boolean success = false;

		if (!input_pw.isEmpty() && input_pw.equals(check_pw)) {
			if (!input_id.equals("Guest") && !input_id.equals("admin")) {
				UserDto dto = new UserDto(input_id, input_pw);
				UserDao dao = new UserDao();

				success = dao.register(dto);
			} else {
				request.setAttribute("errorMsg", "사용할 수 없는 아이디입니다");
			}
		} else {
			request.setAttribute("errorMsg", "비밀번호가 일치하지 않습니다");
		}

		if (success) {
			request.setAttribute("msg", "회원가입 완료!");
			request.getRequestDispatcher("/index.jsp").forward(request, response);
		} else {
			request.setAttribute("input_id", input_id);
			request.getRequestDispatcher("/register.jsp").forward(request, response);
		}
	}
}
