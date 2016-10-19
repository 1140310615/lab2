<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>书籍详情</title>
<link rel="stylesheet" type="text/css" href="mytable.css">
</head>
<body>
	<div id="formbackground"
		style="position: absolute; width: 100%; height: 100%; z-index: -1">
		<img src="image/index.jpg" height="100%" width="100%" />
	</div>
	<br/><br/>
	<p/>
	<table border="1" align="center" bgcolor=#DAA520 bordercolor=##000000 style="font-family:'楷体'; font-size:25px;">
		<tr style="font-family:'黑体'; font-size:25px;">
			<th>Author ID</th>
			<th>Title</th>
			<th>Publisher</th>
			<th>Publish Data</th>
			<th>Price</th>
			<th>ISBN</th>
			<th>Author Name</th>
			<th>Author Age</th>
			<th>Author Country</th>
			<th>操作</th>
		</tr>
		<tr>
			<s:iterator value="books">
				<td><s:property value="authorid" /></td>
				<td><a
					href="<%=request.getContextPath()%>/info.action?qisbn=<s:property value="isbn" />">
						<s:property value="title" />
				</a></td>
				<td><s:property value="publisher" /></td>
				<td><s:property value="publishdata" /></td>
				<td><s:property value="price" /></td>
				<td><s:property value="isbn" /></td>
			</s:iterator>
			<td><s:property value="a_name" /></td>
			<td><s:property value="a_age" /></td>
			<td><s:property value="a_country" /></td>
			<td><a
				href="<%=request.getContextPath()%>/delete.action?qisbn=<s:property value="books.get(0).isbn" />">
<input type=button value="删除" style="width: 60px;"></a>&nbsp;<a
				href="<%=request.getContextPath()%>/modify.action?qisbn=<s:property value="books.get(0).isbn" />"><input type=button value="修改" style="width: 60px;">
</a></td>
		</tr>
				<tr>	<td><a href="add.jsp"><input type=button value="添加"
		style="width: 100px;"></a></td>
		</tr>
	</table>
	<div align="center">
	<a href="queryall.action"><input type=button value="返回主页" 
		style="width: 150px; height:60px; font-size:25px; position:fixed; bottom:0;"></a></div>
</body>
</html>