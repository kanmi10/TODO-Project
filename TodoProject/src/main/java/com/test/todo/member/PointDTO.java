package com.test.todo.member;

import lombok.Data;

/**
 * 
 * PointDTO 클래스입니다.
 * 포인트 관련 getter, setter
 * 
 * @author 김경현
 *
 */

@Data
public class PointDTO {
	
	private String seq;
	private String mseq;
	private String regdate;
	private String iseq;
	
	private String itemname;
	private String itemcost;
	private String image;
	
}
