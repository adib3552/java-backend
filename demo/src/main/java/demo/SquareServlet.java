package demo;

import java.io.IOException;

import java.io.PrintWriter;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/square")//using servlet annotation
public class SquareServlet extends HttpServlet{
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException {
		
		//int k=(int) req.getAttribute("k"); for RequestDispatcher
		//int k=Integer.parseInt(req.getParameter("k"));//URL rewriting
		
		HttpSession session=req.getSession();
		int k=(int)session.getAttribute("k");
		k*=k;
		
		PrintWriter out=res.getWriter();
		out.println("square of the sum: "+k);
		
		System.out.println("This is square servlet");
	}
}
