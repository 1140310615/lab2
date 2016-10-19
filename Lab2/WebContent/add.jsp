<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>新建图书</title>
<s:head />
</head>
<body>
	<div id="formbackground"
		style="position: absolute; width: 100%; height: 100%; z-index: -1">
		<img src="image/add.jpg" height="100%" width="100%" />
	</div>
	<br/><br/>
	<p/><div align="right">
	<form action="add" method="post" name="form1">
		&nbsp;<b style="background-color:#800080; font-size:20px; color:#FFFFFF">作者编号：</b>
		<s:textfield name="nauthorid" />
		<br />
		<b style="color:#FF0000; font-size:20px;">
		<s:fielderror>
			<s:param>nauthorid</s:param>
		</s:fielderror>
		</b>
		<br />&nbsp;<b style="background-color:#800080; font-size:20px; color:#FFFFFF">题目：</b>
		<s:textfield name="ntitle" />
		<br />
		<b style="color:#FF0000; font-size:20px;">
		<s:fielderror>
			<s:param>ntitle</s:param>
		</s:fielderror>
		</b>
		<br />&nbsp;<b style="background-color:#800080; font-size:20px; color:#FFFFFF">出版商：</b>
		<s:textfield name="npublisher" />
		<br />
		<b style="color:#FF0000; font-size:20px;">
		<s:fielderror>
			<s:param>npublisher</s:param>
		</s:fielderror>
		</b>		
		<br /> &nbsp;<b style="background-color:#800080; font-size:20px; color:#FFFFFF">出版日期：</b>
		<s:textfield name="npublishdata" />
		<br />
		<b style="color:#FF0000; font-size:20px;">
		<s:fielderror>
			<s:param>npublishdata</s:param>
		</s:fielderror>
		</b>
		<br /> &nbsp;<b style="background-color:#800080; font-size:20px; color:#FFFFFF">价格：</b>
		<s:textfield name="nprice" />
		<br />
		<b style="color:#FF0000; font-size:20px;">
		<s:fielderror>
			<s:param>nprice</s:param>
		</s:fielderror>
		</b>
		<br /> &nbsp;<b style="background-color:#800080; font-size:20px; color:#FFFFFF">ISBN：</b>
		<s:textfield name="nisbn" />
		<br />
		<b style="color:#FF0000; font-size:20px;">
		<s:fielderror>
			<s:param>nisbn</s:param>
		</s:fielderror>
		</b>
		<br />
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<s:submit value="提交" align="right"/>
	</form>
	</div>
	
		<div align="left">
	<a href="queryall.action"><input type=button value="返回主页" 
		style="width: 120px; height:60px; font-size:25px; position:fixed; bottom:0;"></a></div>
</body>
</html>