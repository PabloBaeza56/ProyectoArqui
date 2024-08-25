package verificaciones;

public abstract class BaseMiddleware<T> implements Middleware<T> {

    private Middleware<T> next;

    public BaseMiddleware<T> linkWith(Middleware<T> next) {
        this.next = next;
        return this;
    }

    public static <T> Middleware<T> link(Middleware<T> first, Middleware<T>... chain) {
        Middleware<T> head = first;
        for (Middleware<T> nextInChain : chain) {
            ((BaseMiddleware<T>) head).next = nextInChain;
            head = nextInChain;
        }
        return first;
    }

    protected boolean checkNext(T info) {
        if (next == null) {
            return true;
        }
        return next.check(info);
    }
}
