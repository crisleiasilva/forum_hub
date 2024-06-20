package br.com.crislei.forum_hub.dto.response;

public record TopicoListAtivosDto(
        Long id,
        String titulo,
        String mensagem,
        UsuarioIdDto autor,
        CursoIdDto curso
){
    public TopicosListAtivosDto(Long id, String titulo, String mensagem, UsuarioIdDto autor, CursoIdDto curso) {
        this.id = id;
        this.titulo = titulo;
        this.mensagem = mensagem;
        this.autor = autor;
        this.curso = curso;
    }
}
