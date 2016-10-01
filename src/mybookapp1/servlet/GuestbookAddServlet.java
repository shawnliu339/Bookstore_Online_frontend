package mybookapp1.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mybookapp1.DAO.GuestbookDAO;
import mybookapp1.DTO.Guestbook;
import mybookapp1.DTO.User;
import mybookapp1.message.Message;

public class GuestbookAddServlet extends HttpServlet {

	public GuestbookAddServlet() {
		super();
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		User user = (User)request.getSession().getAttribute("user");
		if(user == null) {
			response.sendRedirect("userNull.jsp");
			return;
		}
		Integer userId = user.getId();
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		Guestbook guestbook = new Guestbook();
		guestbook.setUserId(userId);
		guestbook.setTitle(title);
		guestbook.setContent(content);
		GuestbookDAO guestbookDAO = new GuestbookDAO();
		if(guestbookDAO.save(guestbook)) {
			Message.message(request, response, "index.action", "留言成功！感谢您的留言，我们会尽快回复。");
		} else {
			Message.message(request, response, "index.action", "操作错误！请您重新操作。");
		}
	}

}
