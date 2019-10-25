<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"
    import="java.util.List,com.kuaisuji.po.Type"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
<h2>类别表</h2>
	<table border="1">
		<tr>
			<th>类型类别编号</th>
			<th>类别编号</th>
			<th>类别名称</th>
			<th>类别图标存放路径</th>
		</tr>
	<%
		List<Type> typeList = (List<Type>)request.getAttribute("typeList");
		for(Type type : typeList){
	%>
		<tr>
			<td><%=type.getAccount_type() %></td>
			<td><%=type.getAccount_item() %></td>
			<td><%=type.getAccount_item_name() %></td>
			<td><%=type.getItem_img_src() %></td>
		</tr>
	<%
		}
	%>
	</table>
</body>
</html>