
<%@page import="br.edu.infnet.app.contatos.EnderecoController"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="br.edu.infnet.domain.contatos.Endereco,javax.servlet.http.HttpServletRequest,javax.servlet.http.HttpServlet"%>
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
        
        
        <%
        Endereco[] ends = (Endereco[])request.getAttribute("enderecos");
        if (request.getContentLength() > 0){
        	for (Endereco end : ends){
        		
        		out.println("<h4 style='color: blue'> CEP: " + end.getCep() + "</h4>");
            	out.println("<h4 style='color: blue'>" + end.getLogradouro() + "</h4>");
            	out.println("<h4 style='color: blue'>" + end.getBairro() + "</h4>");
            	out.println("<h4 style='color: blue'>" + end.getUf() + "</h4>");    
            	out.println("------------------------------------------------");
            }
        }
        
        %>        
        
        
        
        
</body>
</html>