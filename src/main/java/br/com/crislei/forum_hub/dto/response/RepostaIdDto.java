package br.com.crislei.forum_hub.dto.response;

import java.time.LocalDateTime;

public record RepostaIdDto(
        Long id,
        String mensagem,
        LocalDateTime data_criacao,
        boolean solucao,
        Long autorId,
        Long topicId
){
}
