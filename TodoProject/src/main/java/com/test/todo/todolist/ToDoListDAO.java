package com.test.todo.todolist;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.test.todo.DBUtil;
import com.test.todo.challenge.ChallengeDTO;

public class ToDoListDAO {
		
	private Connection conn;
	private Statement stat;
	private PreparedStatement pstat;
	private ResultSet rs;
	
	public ToDoListDAO() {
		conn = DBUtil.open();
	}

	public ArrayList<ToDoListDTO> todolist(String auth, String type) {
		
		try {
			
			String sql = "select * from tblTodoList where mseq = (select seq from tblMember where email=?) and (TO_CHAR(regdate, 'YYYYMMDD') = TO_CHAR(SYSDATE, 'YYYYMMDD')) and type= ? order by seq desc";
			
			pstat = conn.prepareStatement(sql);
			
			pstat.setString(1, auth);
			pstat.setString(2, type);
			
			rs = pstat.executeQuery();
			
			ArrayList<ToDoListDTO> todolist = new ArrayList<ToDoListDTO>();
			
			while (rs.next()) {
				
				ToDoListDTO dto = new ToDoListDTO();
				
				dto.setSeq(rs.getString("seq"));
				dto.setMseq(rs.getString("mseq"));
				dto.setContent(rs.getString("content"));
				dto.setRegdate(rs.getString("regdate"));
				dto.setType(rs.getString("type"));
				
				todolist.add(dto);
				
			}
			
			return todolist;
			
		} catch (Exception e) {
			System.out.println("ToDoListDAO.todolist");
			e.printStackTrace();
		}
		
		return null;
	}

	public int todolistAdd(String auth, String content, String type) {
		
		try {

			 String sql = "insert into tblTodoList (seq, mseq, content, regdate, type) values (seqTodoList.nextVal,(select seq from tblMember where email=?),?, sysdate,?)";
			 
			 pstat = conn.prepareStatement(sql);
			 
			 pstat.setString(1, auth);
			 pstat.setString(2, content);
			 pstat.setString(3, type);

			 return pstat.executeUpdate();
			 
		} catch (Exception e) {
			System.out.println("ToDoListDAO.todolistAdd");
			e.printStackTrace();
		}
		 
		return 0;
	}

	public int todolistDel(String seq, String type) {
		
		try {
			
			String sql = "delete from tblTodolist where seq = ? and type = ?";
			
			pstat = conn.prepareStatement(sql);
			
			pstat.setString(1, seq);
			pstat.setString(2, type);
			
			return pstat.executeUpdate();
			
		} catch (Exception e) {
			System.out.println("ToDoListDAO.todolistDel");
			e.printStackTrace();
		}
		return 0;
	}


}
