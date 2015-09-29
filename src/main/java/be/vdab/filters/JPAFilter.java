package be.vdab.filters;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;
/**
 * @author guillaume.vandecasteele on 28/09/2015 at 14:28.
 */
@WebFilter(filterName = "JPAFilter", urlPatterns = "*.htm")
public class JPAFilter implements Filter {
	private static final EntityManagerFactory ENTITY_MANAGER_FACTORY = Persistence.createEntityManagerFactory("cultuurhuis");
	private static final ThreadLocal<EntityManager> entityManagers = new ThreadLocal<>();

	public void destroy() {
		ENTITY_MANAGER_FACTORY.close();
	}
	
	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
		entityManagers.set(ENTITY_MANAGER_FACTORY.createEntityManager());
		try {
			req.setCharacterEncoding("utf-8");
			chain.doFilter(req, resp);
		}
		finally {
			EntityManager entityManager = entityManagers.get();
			if (entityManager.getTransaction().isActive()) {
				entityManager.getTransaction().rollback();
			}
			entityManager.close();
			entityManagers.remove();
		}
	}

	public void init(FilterConfig config) throws ServletException {

	}

	public static EntityManager getEntityManager() {
		return entityManagers.get();
	}
}
