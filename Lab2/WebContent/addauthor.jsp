<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>新建作者</title>
<s:head />
</head>
<body>
	<div id="formbackground"
		style="position: absolute; width: 100%; height: 100%; z-index: -1">
		<img src="image/author.gif" height="100%" width="100%" />
	</div>
	<br/><br/>
	<p/>
	<div align="left" style="font-family:'楷体'; font-size:25px;">
	<form action="addauthor" method="post" name="form2">
		作者编号：
		<s:textfield name="nauthorid" />
		<br />
		<br /> 姓名：
		<s:textfield name="nname" />
		<br />
		<b style="color:#FF0000; font-size:20px;">
		<s:fielderror>
			<s:param>nname</s:param>
		</s:fielderror>
		</b>
		<br /> 年龄：
		<s:textfield name="nage" />
		<br />
		<b style="color:#FF0000; font-size:20px;">
		<s:fielderror>
			<s:param>nage</s:param>
		</s:fielderror>
		</b>
		<br /> 国家：
		<s:textfield name="ncountry" />
		<br />
		<b style="color:#FF0000; font-size:20px;">
		<s:fielderror>
			<s:param>ncountry</s:param>
		</s:fielderror>
		</b>
		<br />
		<s:submit value="提交" align="left" style="width: 80px;height : 30px"/>
	</form>
	</div>
</body>
</html>