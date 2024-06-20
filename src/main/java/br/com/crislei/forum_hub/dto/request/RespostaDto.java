package br.com.crislei.forum_hub.dto.request;


import br.com.crislei.forum_hub.domain.Resposta;
import br.com.crislei.forum_hub.domain.Topico;
import br.com.crislei.forum_hub.domain.Usuario;

import java.time.LocalDateTime;

public record RespostaDto(
        String mensagem,
        boolean solucao,
        Long autorId,
        Long topicoId
){
    public Resposta toEntity(Usuario autor, Topico topico, LocalDateTime dataCriacao) {
        Resposta resposta = new Resposta();
        resposta.setMensagem(this.mensagem());
        resposta.setSolucao(this.solucao());
        resposta.setAutor(autor);
        resposta.setTopico(topico);
        resposta.setData_criacao(dataCriacao);
        return resposta;
    }
}
