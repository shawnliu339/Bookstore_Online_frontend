package mybookapp1.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mybookapp1.DAO.OdrDtlDAO;
import mybookapp1.DTO.BookOmit;

public class SalesRankingS extends HttpServlet {

	public SalesRankingS() {
		super();
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		this.doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		OdrDtlDAO odrDtlDAO = new OdrDtlDAO();
		List<BookOmit> rankList = new ArrayList<BookOmit>();
		rankList = odrDtlDAO.getRanking(); 
		request.setAttribute("rankList", rankList);
	}

}
