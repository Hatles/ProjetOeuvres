package projetoeuvres.controle;

import projetoeuvres.dao.Service;
import projetoeuvres.meserreurs.MyException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by kifkif on 11/02/2017.
 */
@WebServlet(name = "home", urlPatterns = "")
public class HomeController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    private void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Service service = new Service();
        try {
            request.setAttribute("members", service.getMembers().size());
            request.setAttribute("owners", service.getOwners().size());
            request.setAttribute("workForSale", service.getWorksForSale().size());
            request.setAttribute("workOnLoan", service.getWorksOnLoan().size());
            request.setAttribute("waitingBooking", service.getBookings(true).size());

        } catch (MyException e) {
            e.printStackTrace();
        }
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/WEB-INF/jsp/index.jsp");
        dispatcher.forward(request, response);
    }
}
