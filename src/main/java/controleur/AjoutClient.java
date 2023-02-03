package controleur;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ClientDao;
import model.Client;

/**
 * Servlet implementation class AjoutClient
 */
@WebServlet("/AjoutClient")
public class AjoutClient extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AjoutClient() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		String etape = request.getParameter("etape");

		Client client = new Client();

		if (etape.equals("premiereSaisie") == true) {
			// nouvelle tentative de saisie
			String nom = request.getParameter("nom");
			String prenom = request.getParameter("prenom");
			String email = request.getParameter("email");
			String telephone = request.getParameter("telephone");
			String adresse = request.getParameter("adresse");

			client.setNom(nom);
			client.setPrenom(prenom);
			client.setEmail(email);
			client.setTelephone(telephone);
			client.setAdresse(adresse);

			// on contextualise l'objet client
			this.getServletContext().setAttribute("clientSession", client);
			
			// si un champ obligatoire est null ...
			if ((client.getNom().equals("") == true) || (client.getAdresse().equals("") == true)
					|| (client.getTelephone().equals("") == true)) {
				// alors retour formulaire à compléter
				this.getServletContext().getRequestDispatcher("/WEB-INF/views/affichClientFormulaireIncomplet.jsp")
				.forward(request, response);
			} else {
				// sinon page de vérif avant enregistrement
				this.getServletContext().getRequestDispatcher("/WEB-INF/views/affichClientVerif.jsp").forward(request, response);
			}
			
		} else if (etape.equals("Retour") == true) {
			// l'user veut effctuer une rectification
			client = (Client) this.getServletContext().getAttribute("clientSessions");
			this.getServletContext().getRequestDispatcher("/WEB-INF/views/affichClientFormulaireIncomplet.jsp").forward(request, response);
		} else if (etape.equals("Enregistrer") == true) {
			//la demande d'enregistrement est confirmée.
			Client clientSession = (Client) request.getServletContext().getAttribute("clientSession");
			ClientDao cd = new ClientDao();
			cd.addClient(clientSession);
			this.getServletContext().getRequestDispatcher("/WEB-INF/views/affichClientInscrit.jsp").forward(request, response);
		}

	}
}
