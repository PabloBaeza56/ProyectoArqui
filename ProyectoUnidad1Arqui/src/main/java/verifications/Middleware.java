package verifications;

public interface Middleware<T> {

    boolean check(T info);
}
