package verificaciones;

public interface Middleware<T> {

    boolean check(T info);
}
