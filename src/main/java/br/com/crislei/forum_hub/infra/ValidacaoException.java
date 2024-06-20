package br.com.crislei.forum_hub.infra;

public class ValidacaoException extends RuntimeException {
    public ValidacaoException(String mensagem) {
        super (mensagem);
    }
}
