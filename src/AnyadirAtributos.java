

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class anyadirAtributos
 */
@WebServlet("/anyadir")
public class AnyadirAtributos extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AnyadirAtributos() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// Recuperamos dos atributos que nos manda el formulario.
		
		String atributo = request.getParameter("atributo");
		String valor = request.getParameter("valor");
		
		HttpSession sesion = request.getSession();
		
		// Añadimos a la sesión la información del formulario.
		
		sesion.setAttribute(atributo, valor);
		
		// Salida del serblet para el usuario.
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<head>");
		out.println("<meta charset='utf-8'>");
		out.println("<title>Encuesta</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<h1>Resultados de la encuesta</h1>");
		
		Enumeration<String> nombreDeAtributos = sesion.getAttributeNames();
		
			while(nombreDeAtributos.hasMoreElements()){
				
				atributo = nombreDeAtributos.nextElement();
				valor = (String) sesion.getAttribute(atributo);
				
				out.println("<p>Atributo: " + atributo + "</p>");
				out.println("<p>Valor: " + valor + "</p><hr>");
				
			}
		
		out.println("</body>");
		out.println("</html>");
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
