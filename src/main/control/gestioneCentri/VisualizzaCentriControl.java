package main.control.gestioneCentri;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import main.model.dao.CentroManage;
import main.model.dao.CentroManageDS;
import main.model.dao.IscrizioneManage;
import main.model.dao.IscrizioneManageDS;
import main.model.entity.Centro;
import main.model.entity.Genitore;
import main.model.entity.Iscrizione;
import main.model.entity.Responsabile;
import main.model.entity.Utente;

/**
 * Servlet implementation class VisualizzaCentriControl
 */
@WebServlet("/list_centri")
public class VisualizzaCentriControl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public VisualizzaCentriControl() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Utente u = (Utente) request.getSession(false).getAttribute("utente");
		if(u==null) {
			response.sendError(401, "Autenticazione non effettuata!");
			return;
		} 
		
		if(!(u instanceof Responsabile)) {
			response.sendError(403, "Non sei autorizzato!");
			return;
		}
		
		CentroManage centroman= new CentroManageDS();
		List<Centro> centri = (List<Centro>) centroman.getCentri();
		
		
		request.setAttribute("centri", centri);
		
		
		/**
		 * Dispatch verso la lista delle iscrizioni
		 */
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/list_centri.jsp");
		dispatcher.forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
