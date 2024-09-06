package verificaciones;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import lombok.Getter;
import lombok.Setter;

public class TXTContainsTags extends BaseMiddleware<ArrayList<String>> {

    @Getter @Setter ArrayList<String> tags;
    public TXTContainsTags(ArrayList<String> tags) {
        this.tags = tags;
    }

    @Override
    public boolean check(ArrayList<String> info) {
        String cadenaBonita = ponerTodoElTXTEnUnaSolaLinea(info);
        Integer contador_chido = 0;
        for (String tag : tags) {
            String contenidoDinamico = tag;  // Este es el contenido variable
            String patron = String.format("<\\s*%s\\s*>", contenidoDinamico);

            String texto = cadenaBonita;

            Pattern pattern = Pattern.compile(patron);
            System.out.println(patron);
            Matcher matcher = pattern.matcher(texto);
            System.out.println(texto);

            if (matcher.matches()) {
                contador_chido++;
            } 
        }
        if (contador_chido != tags.size()){
            return false;
        }

        System.out.println("PDF_NoVacio");
        return checkNext(info);
    }

    public String ponerTodoElTXTEnUnaSolaLinea(ArrayList<String> info){
        String resultado = String.join("/n", info);
        return resultado;
    }
}
