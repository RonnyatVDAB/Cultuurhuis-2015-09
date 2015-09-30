package be.vdab.servlets;
import be.vdab.dao.OpvoeringDAO;
import be.vdab.entities.Opvoering;
import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/reserveren.htm")
public class ReserverenServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private static final String VIEW = "/WEB-INF/JSP/reserveren.jsp";
    private static final String SUCCESS_VIEW = "/WEB-INF/JSP/reservatiemandje.jsp";
    private final transient OpvoeringDAO opvoeringDAO = new OpvoeringDAO();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        if (request.getQueryString() != null) {
            request.setAttribute("opvoering",
                    opvoeringDAO.read(Long.parseLong(request.getParameter("id"))));
        }
        HttpSession session = request.getSession(false);
        if (session.getAttribute("mandje") != null) {
            request.setAttribute("heeftMandje", true);
        }
        request.getRequestDispatcher(VIEW).forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        if (request.getParameter("aantalreserveren") != null) {
            HttpSession session = request.getSession();
            @SuppressWarnings("unchecked")
			Map<Long, Integer> mandje = (TreeMap<Long, Integer>) session.getAttribute("mandje");
            Integer aantalTeReserveren = Integer.parseInt(request.getParameter("aantalreserveren"));
            Long idTeReserveren = Long.valueOf(request.getParameter("opvoeringid"));
            // Validatie: int 0-?, id moet bestaan
            String foutmelding = null;
            Opvoering opvoering = opvoeringDAO.read(idTeReserveren);
            if (opvoering == null) {
                foutmelding="Deze opvoering bestaat niet. ";
            }
            if (aantalTeReserveren < 0) {
                foutmelding.concat("Je moet minstens een plaats reserveren. ");
            }
            if (aantalTeReserveren > opvoering.getVrijeplaatsen()) {
                foutmelding.concat("Er zijn niet genoeg vrije plaatsen. ");
            }
            if (foutmelding == null) {
                if (mandje == null) {
                    mandje = new TreeMap<Long, Integer>();
                    mandje.put(idTeReserveren, aantalTeReserveren);
                } else {
                    if (mandje.containsKey(idTeReserveren)) {
                        mandje.put(idTeReserveren, mandje.get(idTeReserveren) + aantalTeReserveren);
                    }
                }
                session.setAttribute("mandje", mandje);
                
                // are we done? redirect to reservatiemandje page
                response.sendRedirect(String.format(SUCCESS_VIEW, request.getContextPath()));
            } else {
                request.setAttribute("foutmelding", foutmelding);
                request.getRequestDispatcher(VIEW).forward(request, response);
            }
        }
        response.sendRedirect(response.encodeRedirectURL(request.getRequestURI()));
    }
}
