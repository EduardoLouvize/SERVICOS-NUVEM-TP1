package br.edu.infnet.app.contatos;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;

import br.edu.infnet.domain.contatos.Endereco;
import br.edu.infnet.infra.contatos.EnderecoService;


@WebServlet(name = "EnderecoController", urlPatterns = {"/EnderecoController"})
public class EnderecoController extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        
        String cep = request.getParameter("cep");
        String logradouro = request.getParameter("logradouro");
        String localidade = request.getParameter("localidade");
        String uf = request.getParameter("uf");
        
        String path;
        
        
        if(StringUtils.isNotBlank(cep)) {
            
            
            EnderecoService es = new EnderecoService();
            Endereco end = es.obterPorCep(cep);
            
            request.setAttribute("endereco", end);
            
            path = "enderecoPorCep.jsp";
            
        } else if(StringUtils.isNotBlank(logradouro) && StringUtils.isNotBlank(localidade) && StringUtils.isNotBlank(uf)) {
        	
        	EnderecoService es = new EnderecoService();
        	Endereco[] end = es.obterCepPorEndereco(uf, localidade, logradouro);     	
        	
        	request.setAttribute("enderecos", end);
        	
        	path = "cepPorEndereco.jsp";
        	
        	
        	
        	
        } else {
            
            
            request.setAttribute("erro", "Informação Inválida");
            
            path = "index.jsp";
        }
        
        RequestDispatcher rd = request.getRequestDispatcher(path);
        rd.forward(request, response);
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
