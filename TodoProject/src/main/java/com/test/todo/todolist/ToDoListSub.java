package com.test.todo.todolist;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/todolist/todolistsub.do")
public class ToDoListSub extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		
		//ToDolist

		//세션 열기
		HttpSession session = req.getSession();
		//1. DB 작업 > DAO 위임'
		
		//2. 결과 + ?JSP 호출하기
		
		//1.
		
		ToDoListDAO dao = new ToDoListDAO();
		ArrayList<ToDoListDTO> todolist = dao.todolist((String)session.getAttribute("auth"), "2");
		
		//2.
		req.setAttribute("todolist", todolist);
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/todolist/todolistsub.jsp");
		dispatcher.forward(req, resp);

	}

}
