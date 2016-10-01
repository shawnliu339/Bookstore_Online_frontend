package mybookapp1.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mybookapp1.DAO.UserDAO;
import mybookapp1.DTO.User;
import mybookapp1.message.Message;

public class RegisterServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public RegisterServlet() {
		super();
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		User User = new User();
		User.setUsername(request.getParameter("username"));
		User.setPassword(request.getParameter("Password1"));
		User.setNickname(request.getParameter("Nickname"));
		User.setTruename(request.getParameter("Truename"));
		User.setCardType(request.getParameter("CardType"));
		User.setCardNum(request.getParameter("CardNum"));
		User.setSex(request.getParameter("Sex"));
		User.setTel(request.getParameter("Tel"));
		User.setEmail(request.getParameter("Email"));
		User.setCity(request.getParameter("City"));
		User.setZIP(request.getParameter("ZIP"));
		User.setAddress(request.getParameter("Address"));
		
		UserDAO UserDAO = new UserDAO();
		PrintWriter out = response.getWriter();
		if(UserDAO.findUserByName(User.getUsername()) != null) {
			Message.message(request, response, "back", "该用户已存在，请重新注册！");
		}
		else{
			if(UserDAO.save(User))
				Message.message(request, response, "index.jsp", "用户注册成功！");
			else
				Message.message(request, response, "back", "用户注册失败！");
		}
	}
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		this.doPost(req, resp);
	}
}
