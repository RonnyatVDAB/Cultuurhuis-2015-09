<%@ tag language="java" pageEncoding="UTF-8"%>
<%@taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core'%>

<h2>Genres</h2>
<nav>
	<ul>
		<c:forEach items='${genres}' var='genre'>
		<c:url value="" var="genreURL">
			<c:param name="genreid" value="${genre.id}"/>
		</c:url>
			<li><a href="${genreURL}">${genre.naam}</a></li>
		</c:forEach>
	</ul>
</nav>
