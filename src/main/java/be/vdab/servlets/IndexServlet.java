package be.vdab.servlets;

import be.vdab.entities.Genre;
import be.vdab.services.GenreService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Servlet implementation class IndexServlet
 */
@WebServlet(name="indexservlet", urlPatterns="/index.htm")
public class IndexServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	private static final String VIEW = "/WEB-INF/JSP/index.jsp";
	private final transient GenreService genreservice = new GenreService();
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Iterable<Genre> genres = genreservice.findAllGenres();
		request.setAttribute("genres", genres);
		request.getRequestDispatcher(VIEW).forward(request, response); 
	}

}