package servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CookiesServlets
 */
@WebServlet(name="/CookiesServlets", urlPatterns = {"/CookiesServlet"})
public class CookiesServlets extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CookiesServlets() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		boolean nuevoUsuario = true;
		Cookie[] cookies = request.getCookies();
		if (cookies != null) {
			for (Cookie c : cookies) {
                if (c.getName().equals("visitanteRecurrente")
                        && c.getValue().equals("si")) {
                    nuevoUsuario = false;
                    break;
                }
            }//fin del for
		}//
		String mensaje = null;
		if(nuevoUsuario) {
			Cookie visitanteCookie = new Cookie("visitanteRecurrente", "si");
			response.addCookie(visitanteCookie);
			mensaje = "Gracias por visitar nuestro sitio";
		} else {
			mensaje = "Gracias por visitar NUEVAMENTE nuestro sitio";
		}
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("Mensaje:"+ mensaje);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
