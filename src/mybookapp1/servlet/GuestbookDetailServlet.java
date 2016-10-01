package mybookapp1.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mybookapp1.DAO.GuestbookDAO;
import mybookapp1.DTO.Guestbook;

public class GuestbookDetailServlet extends HttpServlet {

	public GuestbookDetailServlet() {
		super();
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		if(request.getSession().getAttribute("user") == null) {
			response.sendRedirect("userNull.jsp");
			return;
		}
		Integer guestbookId = Integer.parseInt(request.getParameter("guestbookId"));
		GuestbookDAO guestbookDAO = new GuestbookDAO();
		Guestbook guestbook = new Guestbook();
		guestbook = guestbookDAO.findGuestbookById(guestbookId);
		request.setAttribute("guestbook", guestbook);
		request.getRequestDispatcher("guestbookDetail.jsp").forward(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doGet(request, response);
	}

}
