<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ru">
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>Результат</title>
	<style type="text/css">
		body{
			font-family: sans-serif;
			font-size: 17px;
		}
		p {
			margin-bottom: 15px;
		}
	</style>
</head>
<body>
	<h1>Результат</h1>
	<h2>Исходные данные:</h2>
	<p>
		Первая сторона: ${first_side}
	</p>
	<p>
		Вторая сторона: ${second_side}
	</p>
	<p>
		Третья сторона: ${third_side}
	</p>
	<p>
		Четвертая сторона: ${fourth_side}
	</p>
	<h2>Итог:</h2>
	<p>
		Периметр трапеции: ${result}
	</p>

</body>
</html>