package tw.test.javaee;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/test07b")
public class test07b extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String x,y,result;
		x = y = result = "";
		
		request.setCharacterEncoding("UTF-8");
		
		if(request.getParameter("x")!=null) {
			
			x = request.getParameter("x");
			y = request.getParameter("y");
			
			try {
				int sum = Integer.parseInt(x) + Integer.parseInt(y);
				result += sum;
			}catch (Exception e) {
				
			}
		}
		
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.println("<meta charset='UTF-8'>");
		out.println("<form action='test07b'>");
		out.println("<input name='x' value="+x+">");
		out.println("+");
		out.println("<input name='y' value="+y+">");
		out.println("<input type='submit' value='='>");
		out.printf("<span>%s</span>\n",result);
		out.println("</form>");

		response.flushBuffer();
	}
}
