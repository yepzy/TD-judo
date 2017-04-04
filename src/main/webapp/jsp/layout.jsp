<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page isELIgnored="false"%>
<div class="container-fluid">
	<div class="row">
		<div class="col-12">
			<%@include file="../WEB-INF/jspf/header.jspf"%>
		</div>

		<div class="col-4">
			<%@include file="../WEB-INF/jspf/menu.jspf"%>
		</div>

		<div class="col-8 jumbotron">
			<c:if test="${slug == 'coordonnee'}">
				<%@ include file="../WEB-INF/jspf/coordonnee.jspf"%>
			</c:if>
			<c:if test="${slug == 'competition'}">
				<%@ include file="../WEB-INF/jspf/competition.jspf"%>
			</c:if>
			<c:if test="${slug == 'profil'}">
				<%@ include file="../WEB-INF/jspf/profil.jspf"%>
			</c:if>
		</div>
		
			<%@include file="../WEB-INF/jspf/footer.jspf"%>
	</div>
</div>