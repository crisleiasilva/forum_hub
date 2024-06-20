package br.com.crislei.forum_hub.dto.request;

import jakarta.validation.constraints.NotBlank;

public record TopicoDto(@NotBlank String titulo,
                        @NotBlank String mensagem,
                        UsuarioIdDto autor,
                        CursoIdDto curso
                        ){
}
