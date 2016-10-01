package mybookapp1.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mybookapp1.DAO.BookDAO;
import mybookapp1.DTO.Book;

public class SearchServlet extends HttpServlet {

	/**
	 * <p>Title:ͼ������ģ�鴦���� </p>
	 * <p>Description:������������������Ҫ��ͼ��</p>
	 * 
	 * @author ��˼Զ
	 */
	public SearchServlet() {
		super();
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
	}
	
	/**
	 * ����ҳ������������
	 * @param request ҳ������
	 * @param response ��������Ӧ
	 * @throws ServletException
	 * @throws IOException
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String keyName = request.getParameter("keyName");
		Book keyBook = new Book();
		keyBook.setName(keyName);
		
		BookDAO bookDAO = new BookDAO();
		List<Book> books = new ArrayList<Book>();
		books = bookDAO.findBookByLike(keyBook);
		request.setAttribute("books", books);
		request.setAttribute("keyName", keyName);
		request.getRequestDispatcher("bookSearch.jsp").forward(request, response);
	}

}
