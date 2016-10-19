<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>作者查询</title>
</head>
<body>
	<div id="formbackground"
		style="position: absolute; width: 100%; height: 100%; z-index: -1">
		<img src="image/index.jpg" height="100%" width="100%" />
	</div>
	<br/><br/>
	<p/>
	<table border="1" align="center" bgcolor=#DAA520 bordercolor=##000000 width=500px style="font-family:'楷体'; font-size:20px; height:400px;">
		<tr style="font-family:'黑体'; font-size:30px;">
			<th>标题</th>
			<th>作者</th>
			<th>操作</th>
		</tr>
		<s:iterator value="books">
			<tr>
				<td><a
					href="<%=request.getContextPath()%>/info.action?qisbn=<s:property value="isbn" />">
						<s:property value="title" />
				</a></td>
				<td><s:property value="qaname" /></td>
				<td><a
					href="<%=request.getContextPath()%>/delete.action?qisbn=<s:property value="isbn" />"><input type=button value="删除" style="width: 60px;"></a>&nbsp;<a
href="<%=request.getContextPath()%>/modify.action?qisbn=<s:property value="isbn" />"><input type=button value="修改" style="width: 60px;">
				</a></td>
			</tr>
		</s:iterator>
		<tr>	<td><a href="add.jsp"><input type=button value="添加"
		style="width: 100px;"></a></td>
		</tr>
	</table>
	
<!--  	<s:iterator value="titles" status="statusVar">
  <tr> 
      <td><s:property/></td>
  </tr>
	</s:iterator>
-->
</body>
</html>