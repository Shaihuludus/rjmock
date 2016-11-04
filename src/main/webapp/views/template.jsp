<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  ~ Copyright (c) 2016. Daniel Madejek
  ~
  ~  Licensed to the Apache Software Foundation (ASF) under one
  ~  or more contributor license agreements.  See the NOTICE file
  ~  distributed with this work for additional information
  ~  regarding copyright ownership.  The ASF licenses this file
  ~  to you under the Apache License, Version 2.0 (the
  ~  "License"); you may not use this file except in compliance
  ~  with the License.  You may obtain a copy of the License at
  ~
  ~    http://www.apache.org/licenses/LICENSE-2.0
  ~
  ~  Unless required by applicable law or agreed to in writing,
  ~  software distributed under the License is distributed on an
  ~  "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
  ~  KIND, either express or implied.  See the License for the
  ~  specific language governing permissions and limitations
  ~  under the License.
  --%>

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
