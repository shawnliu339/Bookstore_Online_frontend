package mybookapp1.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mybookapp1.DAO.GuestbookDAO;
import mybookapp1.DTO.Guestbook;
import mybookapp1.DTO.User;

public class GuestbookShowServlet extends HttpServlet {

	public GuestbookShowServlet() {
		super();
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		User user = (User) request.getSession().getAttribute("user");
		if(user == null) {
			response.sendRedirect("userNull.jsp");
			return;
		}
		Integer userId = user.getId();
		GuestbookDAO guestbookDAO = new GuestbookDAO();
		List<Guestbook> guestbookList = new ArrayList<Guestbook>();
		guestbookList = guestbookDAO.findAllByUserId(userId);
		request.setAttribute("guestbookList", guestbookList);
		request.getRequestDispatcher("guestbook.jsp").forward(request, response);
	}

}
