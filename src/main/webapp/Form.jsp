<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ru">
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>Расчет периметра</title>
	<style type="text/css">
		body{
			font-family: sans-serif;
			font-size: 17px;
		}
		.input {
			width: 300px;
			border: 1px solid #bfb8d1;
			font-size: 15px;
			font-family: sans-serif;
			height: 20px;
			padding-left: 15px;
			margin-bottom: 15px;
		}
		.btn {
			border: 1px solid #bfb8d1;
			cursor: pointer;
			margin-left: 130px;
			width: 150px;
			height: 30px;
		}
	</style>
</head>
<body>
	<h1>Калькулятор для расчета периметра трапеции</h1>
	<form action="${pageContext.request.contextPath}/JavaCalc" method="post">
		<label for="first_side">Сторона a:</label>
		<input class="input" type="text" name="first_side" id="first_side" value="${first_side}"><br>
		
		<label for="second_side">Сторона b:</label>
		<input class="input" type="text" name="second_side" id="second_side" value="${second_side}"><br>

		<label for="third_side">Сторона c:</label>
		<input class="input" type="text" name="third_side" id="third_side" value="${third_side}"><br>

		<label for="fourth_side">Сторона d:</label>
		<input class="input" type="text" name="fourth_side" id="fourth_side" value="${fourth_side}"><br>

		<input class="btn" type="submit" name="sign" value="Perimetr">
	</form>
</body>
</html>