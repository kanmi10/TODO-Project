package com.test.todo.member;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * 
 * UnregisterOk 클래스입니다.
 * 회원의 회원 탈퇴를 진행합니다.
 * 
 * @author 김경현
 *
 */
@WebServlet("/member/unregisterok.do")
public class UnregisterOk extends HttpServlet {

	/**
	 * 메소드입니다.
	 * 
	 * 회원탈퇴를 진행하고 성공유무에 따라 메세지를 출력합니다.
	 */
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		//UnregisterOk.java
		
		HttpSession session = req.getSession();
		
		String seq = (String)session.getAttribute("seq");
		
		MemberDAO dao = new MemberDAO();
		
		int result = dao.unRegisterMember(seq);
		
		if (result == 1) {
			
			session.invalidate(); 
			
			resp.sendRedirect("/todo/home.do");
			
		} else {
			
			PrintWriter writer = resp.getWriter();
			
			writer.print("<script>");
			writer.print("alert('failed');");
			writer.print("history.back();");
			writer.print("</script>");
			
			writer.close();
			
		}
		

	}

}
