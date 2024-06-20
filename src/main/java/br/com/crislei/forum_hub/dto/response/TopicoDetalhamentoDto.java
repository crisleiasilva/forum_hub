package br.com.crislei.forum_hub.dto.response;

public record TopicoDetalhamentoDto(
        Long id,
        String titulo,
        String mensagem,
        UsuarioIdDto autor,
        CursoIdDto curso,
        List<RespostaIdDto> resposta,
        boolean status
){
    public TopicoDetalhamentoDto(Long id, String titulo, String mensagem, UsuarioIdDto autor, CursoIdDto curso, List<RespostaIdDto> resposta, boolean status) {
        this.id = id;
        this.titulo = titulo;
        this.mensagem = mensagem;
        this.autor = autor;
        this.curso = curso;
        this.resposta = resposta;
        this.status = status;
    }
}
