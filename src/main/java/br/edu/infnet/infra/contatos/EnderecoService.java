package br.edu.infnet.infra.contatos;

import br.edu.infnet.domain.contatos.Endereco;
import jakarta.ws.rs.client.Client;
import jakarta.ws.rs.client.ClientBuilder;
import jakarta.ws.rs.core.MediaType;

public class EnderecoService {

    private final String REST_URI = "https://viacep.com.br/ws/";
    private final Client client = ClientBuilder.newClient();
    
    public Endereco obterPorCep(String cep) {
        
        //CEP do Infnet no Rio de Janeiro
        //https://viacep.com.br/ws/20010020/json/        
        return client
                .target(REST_URI)
                .path(cep)
                .path("json")
                .request(MediaType.APPLICATION_JSON)
                .get(Endereco.class);
    }
    
public Endereco[] obterCepPorEndereco(String uf, String localidade, String logradouro) {
        
	

           
        return client
                .target(REST_URI)
                .path(uf)
                .path(localidade)
                .path(logradouro)
                .path("json")                
                .request(MediaType.APPLICATION_JSON)
                .get(Endereco[].class);
    }
}
