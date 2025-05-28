package controller;

import java.io.IOException;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import model.dao.UserDao;
import model.dto.UserDto;

@WebServlet("/Register")
public class RegisterController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public RegisterController() {
        super();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		String input_id = request.getParameter("input_id");
		String input_pw = request.getParameter("input_pw");
		String check_pw = request.getParameter("check_pw");
		
		boolean success = false;
		
		if (!input_pw.isEmpty()&&input_pw.equals(check_pw)&&!input_id.equals("Guest")&&!input_id.equals("admin")) {
			UserDto dto = new UserDto(input_id, input_pw);
			UserDao dao = new UserDao();
				
			success = dao.register(dto);
		} else {
			//비밀번호가 일치하지 않음을 알려주는 코드
		}
		
		if(success) {
			//회원가입 완료 문구 및 메인 페이지로 이동하는 링크
		}
	}
}
