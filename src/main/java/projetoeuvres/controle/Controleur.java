package projetoeuvres.controle;

import projetoeuvres.dao.Service;
import projetoeuvres.meserreurs.MonException;
import projetoeuvres.metier.Adherent;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by kifkif on 08/02/2017.
 */
@WebServlet(name = "Controleur", urlPatterns = "/Controleur")
public class Controleur extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private static final String ACTION_TYPE = "action";
    private static final String LISTER_RADHERENT = "listerAdherent";
    private static final String AJOUTER_ADHERENT = "ajouterAdherent";
    private static final String INSERER_ADHERENT = "insererAdherent";
    private static final String LISTER_OEUVRES_PRETS = "listerOeuvresPrets";
    private static final String LISTER_OEUVRES_VENTES = "listerOeuvresVentes";
    private static final String ERROR_KEY = "messageErreur";
    private static final String ERROR_PAGE = "/WEB-INF/jsp/adherents/erreur.jsp";

    /**
     * @see HttpServlet#HttpServlet()
     */
    public Controleur() {
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
        processusTraiteRequete(request, response);
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // TODO Auto-generated method stub
        processusTraiteRequete(request, response);
    }

    protected void processusTraiteRequete(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String actionName = request.getParameter(ACTION_TYPE);
        String destinationPage = ERROR_PAGE;
        // execute l'action
        if (LISTER_RADHERENT.equals(actionName)) {
            try {

                Service unService = new Service();
                request.setAttribute("mesAdherents", unService.consulterListeAdherents());

            } catch (MonException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }

            destinationPage = "/WEB-INF/jsp/adherents/listerAdherent.jsp";
        }

        if (AJOUTER_ADHERENT.equals(actionName)) {

            destinationPage = "/WEB-INF/jsp/adherents/ajouterAdherent.jsp";
        } else if (INSERER_ADHERENT.equals(actionName)) {
            try {
                Adherent unAdherent = new Adherent();
                unAdherent.setNomAdherent(request.getParameter("txtnom"));
                unAdherent.setPrenomAdherent(request.getParameter("txtprenom"));
                unAdherent.setVilleAdherent(request.getParameter("txtville"));
                Service unService = new Service();
                unService.insertAdherent(unAdherent);

            } catch (MonException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            destinationPage = "/";
        }

        else {
            String messageErreur = "[" + actionName + "] n'est pas une action valide.";
            request.setAttribute(ERROR_KEY, messageErreur);
        }

        if (LISTER_OEUVRES_PRETS.equals(actionName)) {
            try {

                Service unService = new Service();
                request.setAttribute("mesOeuvresPrets", unService.consulterListeOeuvresPrets());

            } catch (MonException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }

            destinationPage = "/WEB-INF/jsp/oeuvres/listerOeuvresPrets.jsp";
        }

        if (LISTER_OEUVRES_VENTES.equals(actionName)) {
            try {

                Service unService = new Service();
                request.setAttribute("mesOeuvresVentes", unService.consulterListeOeuvresVentes());

            } catch (MonException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }

            destinationPage = "/WEB-INF/jsp/oeuvres/listerOeuvresVentes.jsp";
        }

        // Redirection vers la page jsp appropriee
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(destinationPage);
        dispatcher.forward(request, response);

    }
}
