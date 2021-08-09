<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="br.edu.infnet.domain.contatos.Endereco"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>CEP Finder</h1>        
        <form action="EnderecoController" method="post">
            Logradouro: <input type="text" name="logradouro" />
            Cidade: <input type="text" name="localidade" />
            UF: <input type="text" name="uf" />
            <input type="submit" value="Buscar" />        
        </form>
        
               
       
        
        <h3 style="color: red">${erro}</h3>
        <h3 style="color: blue">${endereco.cep}</h3>
        <h3 style="color: blue">Retirar no final</h3>
        <h3 style="color: blue">${endereco.logradouro}</h3>
        <h3 style="color: blue">${endereco.bairro}</h3>
        <h3 style="color: blue">${endereco.uf}</h3>
        <h3 style="color: blue">${endereco.length}</h3>
        
        
</body>
</html>