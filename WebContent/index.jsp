<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>iXchange</title>
</head>
<body>
<button onclick="return popitup('http://localhost:9090/iXchange/startIXchange?memberId=B100&name=Baidya&sex=Male')">BNS</button> <br />
<button onclick="return popitup('http://localhost:9090/iXchange/startIXchange?memberId=C110&name=Sunny&sex=Female')">Sunny</button> <br />
<button onclick="return popitup('http://localhost:9090/iXchange/startIXchange?memberId=X22&name=Ravi&sex=Male')">Ravi</button> <br />
<button onclick="return popitup('http://localhost:9090/iXchange/startIXchange?memberId=E222&name=Hari&sex=Male')">Hari</button> <br />
<script language="javascript" type="text/javascript">
function popitup(url) {
	window.open(url, url+'name', 'directories=0,titlebar=0,toolbar=0,location=0,status=0,menubar=0,scrollbars=yes,resizabe=no,copyhistory=no,height=660,width=650').focus();
	return false;
}
</script>

</body>
</html>