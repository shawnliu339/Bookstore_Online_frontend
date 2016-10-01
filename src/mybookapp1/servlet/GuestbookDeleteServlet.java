package mybookapp1.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mybookapp1.DAO.GuestbookDAO;
import mybookapp1.message.Message;

public class GuestbookDeleteServlet extends HttpServlet {

	public GuestbookDeleteServlet() {
		super();
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Integer guestbookId = Integer.parseInt(request.getParameter("guestbookId"));
		GuestbookDAO guestbookDAO = new GuestbookDAO();
		if(guestbookDAO.deleteById(guestbookId) == false) {
			Message.message(request, response, "back", "…æ≥˝¡Ù—‘–≈œ¢ ß∞‹£°");
		}
		response.sendRedirect("guestbookShow.action");
		return;
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.doGet(request, response);
	}

}
