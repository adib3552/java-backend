package demo;

import java.io.IOException;

import java.io.PrintWriter;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/add")//using servlet annotation
public class AddServlet extends HttpServlet{
	
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
		
		int i=Integer.parseInt(req.getParameter("num1"));
		int j=Integer.parseInt(req.getParameter("num2"));
		
		int k=i+j;
		
		HttpSession session=req.getSession();
		session.setAttribute("k", k);
		res.sendRedirect("square");
		
		//URL rewriting
		//req.setAttribute("k", k);
		//res.sendRedirect("square?k="+k);   
		
//		RequestDispatcher rd=req.getRequestDispatcher("square");
//		rd.forward(req, res);
	}
}
