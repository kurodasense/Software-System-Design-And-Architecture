<%@ page language="java" import="java.util.*" pageEncoding="utf-8" contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>欢迎登录MyMVC</title>
</head>
<body>
	<h1>欢迎登录MyMVC</h1>
	<h2>用户名：aa, 密码：123</h2>
		<form action="${ pageContext.request.contextPath }/user/login" method="POST">			
			<table>
				<tr>	
					<td class="tdx">用户名：</td>
					<td><input type="text" name="username" value="${ user.username }"/></td>
				</tr>
				<tr>
					<td class="tdx">密&nbsp;&nbsp; 码：</td>
					<td><input type="password" name="password" value=""/></td>
				</tr>
				
				<tr>
					<td colspan="2" style="text-align:center">
						<input type="submit" value="登录"/>
					</td>	
				</tr>
				<tr>
					<td colspan="2" style="color:red;text-align:center;font-height:bold;">
						${message}
					</td>
				</tr>
			</table>
		</form>
</body>
</html>