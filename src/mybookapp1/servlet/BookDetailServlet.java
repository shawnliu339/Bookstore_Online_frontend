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
		// ���������ʷ
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
			// ���������ʷ��cookie
			for (Cookie temp : cookies) {
				if (temp.getName().equals("historyList")) {
					historyList = temp;
				}
			}
		}

		if (historyList == null) {
			// ��һ�����
			historyList = new Cookie("historyList", bookId);
			historyList.setMaxAge(60 * 60 * 24);
		} else {
			// �ٴ����
			String history = historyList.getValue();
			List<String> list = Arrays.asList(history.split("_"));
			LinkedList<String> linkedList = new LinkedList<String>(list);
			if (linkedList.contains(bookId)) {
				// �û��ظ������ɾ���ظ�id����ӵ���һ��
				linkedList.remove(bookId);
				linkedList.addFirst(bookId);
			} else {
				if (linkedList.size() < 5) {
					// �µ������cookieδ������ӵ���һ��
					linkedList.addFirst(bookId);
				} else {
					// �µ������cookie����ɾ�����һ������ӵ���һ��
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
