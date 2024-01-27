<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
  <title>Edit Material</title>
</head>
<body>
  <h1>Edit Material</h1>
  <form action="${pageContext.request.contextPath}/materials/update" method="post">
    <input type="hidden" name="id" value="${material.id}" />
    <label for="title">Title:</label>
    <input type="text" name="title" id="title" value="${material.title}" required />
    <br/>
    <label for="content">Content:</label>
    <textarea name="content" id="content" rows="5" required>${material.content}</textarea>
    <br/>
    <button type="submit">Save</button>
  </form>
  <c:if test="${not empty errorMessage}">
    <p class="error-message">${errorMessage}</p>
  </c:if>
</body>
</html>
