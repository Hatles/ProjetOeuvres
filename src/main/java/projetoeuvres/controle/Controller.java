package projetoeuvres.controle;

import projetoeuvres.dao.Service;
import projetoeuvres.meserreurs.MyException;
import projetoeuvres.metier.Member;
import projetoeuvres.metier.Member;

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
@WebServlet(name = "Controller", urlPatterns = "/Controller")
public class Controller extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private static final String ACTION_TYPE = "action";
    private static final String GET_MEMBERS = "getMembers";
    private static final String ADD_MEMBER = "addMember";
    private static final String INSERT_MEMBER = "insertMember";
    private static final String GET_WORKS_ON_LOAN = "getWorksOnLoan";
    private static final String GET_WORKS_FOR_SALE = "getWorksForSale";
    private static final String ERROR_KEY = "messageErreur";
    private static final String ERROR_PAGE = "/WEB-INF/jsp/adherents/erreur.jsp";

    /**
     * @see HttpServlet#HttpServlet()
     */
    public Controller() {
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
        if (GET_MEMBERS.equals(actionName)) {
            try {

                Service service = new Service();
                request.setAttribute("members", service.getMembers());

            } catch (MyException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }

            destinationPage = "/WEB-INF/jsp/members/getMembers.jsp";
        }

        if (ADD_MEMBER.equals(actionName)) {

            destinationPage = "/WEB-INF/jsp/members/addMember.jsp";
        } else if (INSERT_MEMBER.equals(actionName)) {
            try {
                Member member = new Member();
                member.setName(request.getParameter("name"));
                member.setFirstName(request.getParameter("firstname"));
                member.setCity(request.getParameter("city"));
                Service service = new Service();
                service.insertMember(member);

            } catch (MyException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            destinationPage = "/";
        }

        else {
            String messageErreur = "[" + actionName + "] n'est pas une action valide.";
            request.setAttribute(ERROR_KEY, messageErreur);
        }

        if (GET_WORKS_ON_LOAN.equals(actionName)) {
            try {

                Service service = new Service();
                request.setAttribute("worksOnLoan", service.getWorksOnLoan());

            } catch (MyException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }

            destinationPage = "/WEB-INF/jsp/works/getWorksOnLoan.jsp";
        }

        if (GET_WORKS_FOR_SALE.equals(actionName)) {
            try {

                Service service = new Service();
                request.setAttribute("worksForSale", service.getWorksForSale());

            } catch (MyException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }

            destinationPage = "/WEB-INF/jsp/works/getWorksForSale.jsp";
        }

        // Redirection vers la page jsp appropriee
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(destinationPage);
        dispatcher.forward(request, response);

    }
}
