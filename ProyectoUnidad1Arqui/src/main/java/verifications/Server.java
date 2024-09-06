package verifications;

public class Server<T> {

    public Middleware<T> middleware;

    public void setMiddleware(Middleware<T> middleware) {
        this.middleware = middleware;
    }

    public boolean executeChain(T tipo) {
        if (middleware.check(tipo)) {
            System.out.println("ALL CORRECT");
            return true;
        }
        System.out.println("ERROR IN VALIDATIONS");
        return false;
    }
}
