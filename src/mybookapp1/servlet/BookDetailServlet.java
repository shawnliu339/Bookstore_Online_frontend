package mybookapp1.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mybookapp1.DAO.BookDAO;
import mybookapp1.DTO.Book;

public class BookDetailServlet extends HttpServlet {

	public BookDetailServlet() {
		super();
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Integer id = Integer.parseInt(request.getParameter("id"));
		// 存入浏览历史
		this.readHistory(id.toString(), request, response);
		BookDAO bookDAO = new BookDAO();
		Book book = bookDAO.findBookById(id);
		request.setAttribute("book", book);
		request.getRequestDispatcher("bookdetail.jsp").forward(request,
				response);

	}

	private void readHistory(String bookId, HttpServletRequest request,
			HttpServletResponse response) {
		Cookie historyList = null;
		Cookie[] cookies = request.getCookies();

		if (cookies != null && cookies.length > 0) {
			// 查找浏览历史的cookie
			for (Cookie temp : cookies) {
				if (temp.getName().equals("historyList")) {
					historyList = temp;
				}
			}
		}

		if (historyList == null) {
			// 第一次浏览
			historyList = new Cookie("historyList", bookId);
			historyList.setMaxAge(60 * 60 * 24);
		} else {
			// 再次浏览
			String history = historyList.getValue();
			List<String> list = Arrays.asList(history.split("_"));
			LinkedList<String> linkedList = new LinkedList<String>(list);
			if (linkedList.contains(bookId)) {
				// 用户重复浏览，删掉重复id，添加到第一个
				linkedList.remove(bookId);
				linkedList.addFirst(bookId);
			} else {
				if (linkedList.size() < 5) {
					// 新的浏览，cookie未满，添加到第一个
					linkedList.addFirst(bookId);
				} else {
					// 新的浏览，cookie满，删除最后一个，添加到第一个
					linkedList.removeLast();
					linkedList.addFirst(bookId);
				}
			}
			StringBuilder str = new StringBuilder();
			for (String s : linkedList) {
				str.append(s).append("_");
			}
			str.deleteCharAt(str.length() - 1);
			history = str.toString();
			historyList.setValue(history);
		}

		response.addCookie(historyList);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.doGet(request, response);
	}

}
