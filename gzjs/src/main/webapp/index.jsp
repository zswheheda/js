<%@ page language="java" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML>
<html>
<head>
  <title></title>
<script type="text/javascript">
function showDetail(id, name, age) {
	document.getElementById('sid').value = id;
	document.getElementById('sname').value = name;
	document.getElementById('sage').value = age;
}
</script>
</head>

<body >
  <form action="add.action" method="post">
    <input type="text" name="name" />
    <input type="text" name="age" />
    <input type="submit" value="提交" />
  </form>
  <table>
    <tr>
      <td>操作</td>
      <td>姓名</td>
      <td>年龄</td>
    </tr>
    <c:forEach items="${students}" var="student">
	<tr>
	  <td>
	    <a href="del.action?id=${student.id}">删除</a>
	    &nbsp;
	    <button onclick="showDetail('${student.id}', '${student.name}', '${student.age}')">更新</button>
	  </td>
	  <td>${student.name}</td>
	  <td>${student.age}</td>
	</tr>	
	</c:forEach>
  </table>
  
  <form action="update.action" method="post">
    <input id="sid" type="text" name="id" />   
    <input id="sname" type="text" name="name" />
    <input id="sage" type="text" name="age" />
    <input type="submit" value="提交" />
  </form>
</body>
</html>
