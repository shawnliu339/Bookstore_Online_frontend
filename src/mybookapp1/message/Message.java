package mybookapp1.message;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Message {
	public static void message(HttpServletRequest request,
			HttpServletResponse response, String target, String message) throws ServletException, IOException {
		request.setAttribute("target", target);
		request.setAttribute("message", message);
		request.getRequestDispatcher("/message.jsp").forward(request, response);
	}
}
