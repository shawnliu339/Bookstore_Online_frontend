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
	 * <p>Title:图书搜索模块处理类 </p>
	 * <p>Description:根据搜索条件搜索需要的图书</p>
	 * 
	 * @author 刘思远
	 */
	public SearchServlet() {
		super();
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
	}
	
	/**
	 * 接受页面请求处理搜索
	 * @param request 页面请求
	 * @param response 服务器回应
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
