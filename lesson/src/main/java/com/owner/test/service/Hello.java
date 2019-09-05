package com.owner.test.service;

import java.io.IOException;
import java.io.InputStream;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.owner.test.entity.User;

@SuppressWarnings("serial")
public class Hello extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getServletContext().setAttribute("data", "hello world");
//		
		RequestDispatcher requestDispatcher = req.getRequestDispatcher("/index.jsp");
		requestDispatcher.forward(req, resp);
		
		//req.getSession().setAttribute("data", "hello world");
		//resp.sendRedirect("/lesson/index.jsp");
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		int status = Integer.parseInt(req.getParameter("status"));
		long createTime = (System.currentTimeMillis() / 1000);
		
		User user = new User();
		user.setUsername(username);
		user.setPassword(password);
		user.setStatus(status);
		user.setCreateTime(createTime);
		
		String resource = "mybatis/mybatis-config.xml";
		
		InputStream is = Resources.getResourceAsStream(resource);
		
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);
		
		SqlSession sqlSession = sqlSessionFactory.openSession();
		
		sqlSession.insert("com.owner.test.mapper.UserMapper.insertUser",user);
		
		RequestDispatcher requestDispatcher = null;
		
		String path = req.getServletContext().getContextPath();
		
		user.setId(0);
		
		if(user.getId() > 0) {
			req.getServletContext().setAttribute("url", path + "/index.jsp");
			requestDispatcher = req.getRequestDispatcher("/common/success.jsp");
		}else {
			req.getServletContext().setAttribute("url", path + "/index.jsp");
			req.getServletContext().setAttribute("message", "用户注册失败");
			requestDispatcher = req.getRequestDispatcher("/common/error.jsp");
		}
		
		requestDispatcher.forward(req, resp);
		
		//System.out.println(user);
	}
	
	

}
