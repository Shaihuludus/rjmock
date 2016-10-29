<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <link href="<c:url value="/resources/css/bootstrap.min.css"/>" rel="stylesheet"  type="text/css" />
    <link href="<c:url value="/resources/css/rjmock.css"/>" rel="stylesheet"  type="text/css" />
    <script src="<c:url value="/resources/js/jquery-3.1.1.min.js"/>"></script>
    <title>Rest Services Mocks</title>
</head>
<body>
<jsp:include page="include/header.jsp"/>
<jsp:include page="${pageControllerResult}"/>
<jsp:include page="include/footer.jsp"/>
<script src="<c:url value='/resources/js/bootstrap.min.js'/>"></script>
</body>
</html>
