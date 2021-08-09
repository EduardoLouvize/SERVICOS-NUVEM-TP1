<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>CEP Finder</h1>
         <form action="EnderecoController" method="post">
            CEP: <input type="text" name="cep" />
            <input type="submit" value="Buscar" />
        </form>
        <h3 style="color: red">${erro}</h3>
        <h3 style="color: blue">${endereco.cep}</h3>
        <h3 style="color: blue">${endereco.logradouro}</h3>
        <h3 style="color: blue">${endereco.bairro}</h3>
        <h3 style="color: blue">${endereco.uf}</h3>
</body>
</html>