package lectores;

public class PDFInvalidoException extends Exception {

    public PDFInvalidoException() {
        super("El documento es inválido.");
    }

    public PDFInvalidoException(String mensaje) {
        super(mensaje);
    }

    public PDFInvalidoException(String mensaje, Throwable causa) {
        super(mensaje, causa);
    }

    public PDFInvalidoException(Throwable causa) {
        super(causa);
    }
}
