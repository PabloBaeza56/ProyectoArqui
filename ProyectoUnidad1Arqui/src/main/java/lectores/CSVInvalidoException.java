package lectores;

public class CSVInvalidoException extends Exception {

    public CSVInvalidoException() {
        super("El documento es inválido.");
    }

    public CSVInvalidoException(String mensaje) {
        super(mensaje);
    }

    public CSVInvalidoException(String mensaje, Throwable causa) {
        super(mensaje, causa);
    }

    public CSVInvalidoException(Throwable causa) {
        super(causa);
    }
}
