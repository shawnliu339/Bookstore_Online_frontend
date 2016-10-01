package mybookapp1.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mybookapp1.DAO.BookDAO;
import mybookapp1.DTO.Book;

public class HistoryServlet extends HttpServlet {

	public HistoryServlet() {
		super();
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Cookie[] cookies = request.getCookies();
		if (cookies != null && cookies.length > 0) {
			//非首次浏览
			for (Cookie cookie : cookies) {
				if (cookie.getName().equals("historyList")) {
					//非首次浏览
					String[] bookIds = cookie.getValue().split("_");
					Book book = new Book();
					BookDAO bookDAO = new BookDAO();
					List<Book> historyList = new ArrayList<Book>();
					for (String bookId : bookIds) {
						book = bookDAO.findBookById(Integer.parseInt(bookId));
						historyList.add(book);
					}
					request.setAttribute("historyList", historyList);
				} else {
					//首次浏览
					request.setAttribute("historyList", null);
				}

			}
		} else {
			//首次浏览
			request.setAttribute("historyList", null);
		}

	}

}
