package verificaciones;

public class Server<T> {

    private Middleware<T> middleware;

    public void setMiddleware(Middleware<T> middleware) {
        this.middleware = middleware;
    }

    public boolean ejecutar(T tipo) {
        if (middleware.check(tipo)) {
            System.out.println("EXITO");
            return true;
        }
        System.out.println("FRACASO");
        return false;
    }
}
