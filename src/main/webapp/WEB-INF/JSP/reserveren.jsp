<%@page contentType='text/html' pageEncoding='UTF-8' session='false'%>
<%@taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core' %>
<%@taglib prefix="v" uri='http://vdab.be/tags'%>

<!doctype html>
<html>
    <head>
        <title>Het Cultuurhuis:reserveren</title>
    </head>
    <body>
        <v:header />
        <h1>Het Cultuurhuis: reserveren.</h1>
        <img src="<c:url value='/images/reserveren.png'/>" alt="afbeelding reserveren">
        <a href="">Voorstellingen</a>
        <dl>
            <dt>Voorstelling:</dt><dd>${opvoering.voorstelling.titel}</dd>
            <dt>Uitvoerders:</dt><dd>${opvoering.voorstelling.uitvoerder}</dd>
            <dt>Datum:</dt><dd>${opvoering.datum}</dd>
            <dt>Prijs:</dt><dd>${opvoering.prijs}</dd>
            <dt>Vrije plaatsen:</dt><dd>${opvoering.vrijeplaatsen}</dd>
        </dl>
        <form method='post'>
            <input type="hidden" name="opvoeringid" value=${opvoering.id}>
            <input type="number" name="aantalreserveren" min="1" required>
            <input type="submit" value='Reserveren'>
        </form>
        <c:if test='${not empty foutmelding}'>
            <div class='foutmelding'>${foutmelding}</div>
        </c:if>
        <v:footer />
    </body>
</html>