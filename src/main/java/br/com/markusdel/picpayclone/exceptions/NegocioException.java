package br.com.markusdel.picpayclone.exceptions;

public class NegocioException extends RuntimeException {

    public NegocioException(String msg) {
        super(msg);
    }

    public NegocioException(String msg, Exception exception) {
        super(msg, exception);
    }
}
