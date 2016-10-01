package mybookapp1.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mybookapp1.DAO.UserDAO;
import mybookapp1.DTO.User;

public class UserModifyServlet extends HttpServlet {

	public UserModifyServlet() {
		super();
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		User User = (User) request.getSession().getAttribute("user");
		User.setNickname(request.getParameter("Nickname"));
		User.setCardType(request.getParameter("CardType"));
		User.setCardNum(request.getParameter("CardNum"));
		User.setSex(request.getParameter("Sex"));
		User.setTel(request.getParameter("Tel"));
		User.setCity(request.getParameter("City"));
		User.setZIP(request.getParameter("ZIP"));
		User.setAddress(request.getParameter("Address"));
		
		UserDAO userdao = new UserDAO();
		PrintWriter out = response.getWriter();
		
		if(userdao.update(User)) {
			request.setAttribute("message", "用户资料修改成功！");
			request.setAttribute("target", "index.action");
			request.getRequestDispatcher("message.jsp").forward(request, response);
		}else {
			request.setAttribute("message", "用户资料修改失败！");
			request.setAttribute("target", "back");
			request.getRequestDispatcher("message.jsp").forward(request, response);
		}
	}

}
