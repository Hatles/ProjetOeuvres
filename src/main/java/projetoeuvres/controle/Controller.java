package projetoeuvres.controle;

import projetoeuvres.dao.Service;
import projetoeuvres.meserreurs.MyException;
import projetoeuvres.metier.Booking;
import projetoeuvres.metier.Member;
import projetoeuvres.metier.WorkForSale;
import projetoeuvres.metier.WorkOnLoan;
import projetoeuvres.metier.Owner;
import projetoeuvres.utilitaires.FonctionsUtiles;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;

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

    private static final String GET_OWNERS = "getOwners";
    private static final String ADD_OWNER = "addOwner";
    private static final String INSERT_OWNER= "insertOwner";

    private static final String GET_WORKS_FOR_SALE = "getWorksForSale";
    private static final String ADD_WORk_FOR_SALE = "addWorkForSale";
    private static final String EDIT_WORk_FOR_SALE = "editWorkForSale";
    private static final String DELETE_WORk_FOR_SALE = "deleteWorkForSale";
    private static final String INSERT_WORk_FOR_SALE = "insertWorkForSale";

    private static final String GET_WORKS_ON_LOAN = "getWorksOnLoan";
    private static final String ADD_WORk_ON_LOAN = "addWorkOnLoan";
    private static final String INSERT_WORk_ON_LOAN= "insertWorkOnLoan";

    private static final String BOOKINGS= "getBookings";
    private static final String CONFIRM_BOOKING= "confirmBooking";
    private static final String BOOK_WORK = "bookWork";
    private static final String INSERT_BOOKING= "insertBooking";

    private static final String ERROR_KEY = "messageErreur";
    private static final String ERROR_PAGE = "/WEB-INF/jsp/error.jsp";

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
                destinationPage = "/WEB-INF/jsp/members/getMembers.jsp";
            } catch (Exception e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }

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
                destinationPage = "/";
            } catch (Exception e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }

        else {
            String messageErreur = "[" + actionName + "] n'est pas une action valide.";
            request.setAttribute(ERROR_KEY, messageErreur);
        }

        if (GET_OWNERS.equals(actionName)) {
            try {
                Service service = new Service();
                request.setAttribute("owners", service.getOwners());
                destinationPage = "/WEB-INF/jsp/owners/getOwners.jsp";
            } catch (Exception e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }

        if (ADD_OWNER.equals(actionName)) {
            destinationPage = "/WEB-INF/jsp/owners/addOwner.jsp";
        } else if (INSERT_OWNER.equals(actionName)) {
            try {
                Owner owner = new Owner();
                owner.setName(request.getParameter("name"));
                owner.setFirstName(request.getParameter("firstname"));
                Service service = new Service();
                service.insertOwner(owner);
                destinationPage = "/";
            } catch (Exception e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }

        else {
            String messageErreur = "[" + actionName + "] n'est pas une action valide.";
            request.setAttribute(ERROR_KEY, messageErreur);
        }

        if (GET_WORKS_ON_LOAN.equals(actionName)) {
            try {

                Service service = new Service();
                request.setAttribute("worksOnLoan", service.getWorksOnLoan());
                destinationPage = "/WEB-INF/jsp/works/getWorksOnLoan.jsp";
            } catch (Exception e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }

        if (GET_WORKS_FOR_SALE.equals(actionName)) {
            destinationPage = getWorksForSale(request);
        }

        if (ADD_WORk_FOR_SALE.equals(actionName)) {
            try {

                Service service = new Service();
                request.setAttribute("owners", service.getOwners());
                destinationPage = "/WEB-INF/jsp/works/addWorkForSale.jsp";
            } catch (MyException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        } else if (INSERT_WORk_FOR_SALE.equals(actionName)) {
            try {
                Service service = new Service();
                WorkForSale workForSale = new WorkForSale();
                workForSale.setId(Integer.parseInt(request.getParameter("id")));
                workForSale.setTitle(request.getParameter("title"));
                workForSale.setState("L");
                workForSale.setPrice(Float.parseFloat(request.getParameter("price")));
                workForSale.setOwner(service.getOwner(Integer.parseInt(request.getParameter("owner"))));
                service.insertWorkForSale(workForSale);
                destinationPage = getWorksForSale(request);
            } catch (Exception e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }

        else {
            String messageErreur = "[" + actionName + "] n'est pas une action valide.";
            request.setAttribute(ERROR_KEY, messageErreur);
        }

        if (EDIT_WORk_FOR_SALE.equals(actionName)) {
            try {

                Service service = new Service();
                request.setAttribute("owners", service.getOwners());
                WorkForSale workForSale = service.getWorkForSale(Integer.parseInt(request.getParameter("id")));
                request.setAttribute("id", workForSale.getId());
                request.setAttribute("title", workForSale.getTitle());
                request.setAttribute("price", workForSale.getPrice());
                request.setAttribute("owner", workForSale.getOwner().getId());
                request.setAttribute("edit", true);
                destinationPage = "/WEB-INF/jsp/works/addWorkForSale.jsp";
            }catch (Exception e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
                destinationPage = getWorksForSale(request,"Cette oeuvre n'existe pas");
            }
        }else if (DELETE_WORk_FOR_SALE.equals(actionName)) {
            try {

                Service service = new Service();
                WorkForSale workForSale = service.getWorkForSale(Integer.parseInt(request.getParameter("id")));
                service.removeWorkForSale(workForSale);
                destinationPage = getWorksForSale(request);
            } catch (Exception e) {
                destinationPage = getWorksForSale(request,"Cette oeuvre n'existe pas");
                e.printStackTrace();
            }
        }
        else {
            String messageErreur = "[" + actionName + "] n'est pas une action valide.";
            request.setAttribute(ERROR_KEY, messageErreur);
        }


        if (ADD_WORk_ON_LOAN.equals(actionName)) {
            try {

                Service service = new Service();
                request.setAttribute("owners", service.getOwners());
                destinationPage = "/WEB-INF/jsp/works/addWorkOnLoan.jsp";
            } catch (Exception e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        } else if (INSERT_WORk_ON_LOAN.equals(actionName)) {
            try {
                Service service = new Service();
                WorkOnLoan workOnLoan = new WorkOnLoan();
                workOnLoan.setTitle(request.getParameter("title"));
                workOnLoan.setOwner(service.getOwner(Integer.parseInt(request.getParameter("owner"))));
                service.insertWorkOnLoan(workOnLoan);
                destinationPage="/";
            } catch (Exception e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        else {
            String messageErreur = "[" + actionName + "] n'est pas une action valide.";
            request.setAttribute(ERROR_KEY, messageErreur);
        }

        if (BOOK_WORK.equals(actionName)) {
            try {
                Service service = new Service();
                WorkForSale workForSale = service.getWorkForSale(Integer.parseInt(request.getParameter("id")));
                    request.setAttribute("members", service.getMembers());
                    request.setAttribute("work", workForSale);
                    destinationPage = "/WEB-INF/jsp/works/bookWork.jsp";
            } catch (Exception e) {
                destinationPage = getWorksForSale(request,"Cette oeuvre n'existe pas");
                e.printStackTrace();
            }
        } else if (INSERT_BOOKING.equals(actionName)) {
            try {
                Service service = new Service();
                Booking booking = new Booking();
                booking.setDate(java.sql.Date.valueOf(request.getParameter("date")));
                booking.setMember(service.getMember(Integer.parseInt(request.getParameter("member"))));
                WorkForSale workForSale = service.getWorkForSale(Integer.parseInt(request.getParameter("workId")));
                workForSale.setState("R");
                booking.setWorkForSale(workForSale);
                service.insertBooking(booking);
                service.insertWorkForSale(workForSale);
                destinationPage = getWorksForSale(request);
            } catch (Exception e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }

        else {
            String messageErreur = "[" + actionName + "] n'est pas une action valide.";
            request.setAttribute(ERROR_KEY, messageErreur);
        }

        if (BOOKINGS.equals(actionName)) {
            destinationPage = getBookings(request);
        } else if (CONFIRM_BOOKING.equals(actionName)) {
            try {
                Service service = new Service();
                Booking booking = service.getBooking(Integer.parseInt(request.getParameter("idWork")),Integer.parseInt(request.getParameter("idMember")));
                booking.setStatus("confirmee");
                service.updateBooking(booking);
                destinationPage = getWorksForSale(request);
            } catch (Exception e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }

        // Redirection vers la page jsp appropriee
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(destinationPage);
        dispatcher.forward(request, response);

    }

    public String getWorksForSale(HttpServletRequest request, String error){
        if(!error.isEmpty())
            request.setAttribute("error", error);
        return getWorksForSale(request);
    }

    public String getWorksForSale(HttpServletRequest request){
        try {

            Service service = new Service();
            request.setAttribute("worksForSale", service.getWorksForSale());
            return "/WEB-INF/jsp/works/getWorksForSale.jsp";

        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return ERROR_PAGE;
    }

    public String getBookings(HttpServletRequest request){
        try {
            Service service = new Service();
            request.setAttribute("bookings", service.getBookings(false));
            return  "/WEB-INF/jsp/bookings/getBookings.jsp";
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ERROR_PAGE;
    }


}
