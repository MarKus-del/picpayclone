package br.com.markusdel.picpayclone.exceptions;

public class NegocioException extends RuntimeException {

    private static final long serialVersionUID = -7507642233804283142L;

    public NegocioException(String msg) {
        super(msg);
    }

    public NegocioException(String msg, Exception exception) {
        super(msg, exception);
    }
}
