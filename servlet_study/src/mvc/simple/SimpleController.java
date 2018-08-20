package mvc.simple;

import java.io.IOException;

import javax.servlet.*;
import javax.servlet.http.*;

public class SimpleController extends HttpServlet{
	
	public void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}
	public void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}

	private void processRequest(HttpServletRequest request, HttpServletResponse response) 
	throws IOException, ServletException {
		
		//requst 객체로부터 사용자의 요청을 파악하는 코드
		String type = request.getParameter("type");
		
		//사용자에 요청에 따라 알맞은 코드
		Object resultObject = null;
		if (type == null || type.equals("greeting")) {
			resultObject = "안녕하세요";
		} else if (type.equals("date")) {
			resultObject = new java.util.Date();
		} else {
			resultObject = "Invalid Type";
		}
		
		//request 나 session 에 처리 결과를 저장
		request.setAttribute("result", resultObject);
		
		//RequestDispatcher 를 사용하여 알맞은 뷰로 포워딩
		RequestDispatcher dispatcher = request.getRequestDispatcher("/simpleView.jsp");
		dispatcher.forward(request, response);
	}
	
}
