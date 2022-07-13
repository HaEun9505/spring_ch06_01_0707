package com.haeun.test;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class MainClass {
	public static void main(String[] args) {
		String config1 = "classpath:applicationCTX.xml";
		String config2 = "classpath:applicationCTX2.xml";
		//Container 파일 불러오기
		AbstractApplicationContext ctx = new GenericXmlApplicationContext(config1,config2);
		
		//applicationCTX.xml에서 설정한 값 가져오기(bean 조회)
	 	Student student1 = ctx.getBean("student1", Student.class);	//bean 조회(객체 얻어오기)
		
	 	StudentInfo studentInfo = ctx.getBean("studentInfo1", StudentInfo.class);
		
	 	System.out.println(student1.getName());
	 	System.out.println(student1.getHobbys());
	 	
	 	Student stu1 = studentInfo.getStudent();	//StudentInfo클래스의 getStudent 호출(실행)
	 	System.out.println(stu1.getName());
	 	System.out.println(stu1.getHobbys());
	 	
	 	
	 	//applicationCTX2.xml에서 설정한 값 가져오기(bean 조회)
	 	Student student2 = ctx.getBean("student2",Student.class);
	 	System.out.println(student2.getName());
	 	System.out.println(student2.getHobbys());
	 	
	 	
	 	Family family = ctx.getBean("family", Family.class);
	 	System.out.println(family.getPapaName());
	 	System.out.println(family.getMamiName());
	 	System.out.println(family.getSisterName());
	 	System.out.println(family.getBrotherName());
	 	
		ctx.close();
	}
}