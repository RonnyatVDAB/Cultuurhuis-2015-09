<%@ tag language="java" pageEncoding="ISO-8859-1"%>
<%@taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core'%>
<%@taglib prefix='fmt' uri='http://java.sun.com/jsp/jstl/fmt'%>
<%@taglib prefix='m' uri='http://vdab.be/tags' %>
<nav>
	<ul>
		<c:forEach items='${genres}' var='genre'>
			<li><a href="<c:url value='/genre/${genre.naam}'/>">${genre.naam}</a></li>
		</c:forEach>
	</ul>
</nav>
