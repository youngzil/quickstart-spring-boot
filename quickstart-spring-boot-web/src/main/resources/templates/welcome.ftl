<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>welcome to spring boot</title>
</head>
<body>
<h4>亲爱的${toUserName}，你好！</h4>

<p style="color:blue;">this is welcome.ftl</p> 
<p style="color:blue;">&emsp;${message}请不要告诉其他人，切记！</p> 

祝：开心！
</br>
${fromUserName}
</br>
${time?date}
<!--${time?date}表示time是日期类型的变量，只取date部分。“?date”还可以使用“?datetime”或“?time”。-->
</body>
</html>