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

public class BookSort extends HttpServlet {

	public BookSort() {
		super();
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		List<String> types = new ArrayList<String>();
		BookDAO bookDAO = new BookDAO();
		types = bookDAO.getTypes();
		request.setAttribute("types", types);
		
		String type = request.getParameter("type");
		List<Book> books = bookDAO.findBooksByType(type);
		request.setAttribute("books", books);
		request.setAttribute("type", type);
		request.getRequestDispatcher("bookSort.jsp").forward(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		this.doGet(request, response);
	}

}
