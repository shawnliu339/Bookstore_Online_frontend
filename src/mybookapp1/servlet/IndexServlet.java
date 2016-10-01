package mybookapp1.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class IndexServlet extends HttpServlet {

	public IndexServlet() {
		super();
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		if (request.getAttribute("books") == null) {
			request.getRequestDispatcher("bookshow.action").include(request,
					response);
		}
		if (request.getAttribute("historyList") == null) {
			request.getRequestDispatcher("history.action").include(request,
					response);
		}
		if (request.getAttribute("rankList") == null) {
			request.getRequestDispatcher("rankingS.action").include(request,
					response);
		}
		request.getRequestDispatcher("index.jsp").forward(request, response);
	}

}
