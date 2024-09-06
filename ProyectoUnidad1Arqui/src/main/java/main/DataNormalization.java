package main;

import java.util.ArrayList;
import java.util.Arrays;

public class DataNormalization {
    
    public ArrayList<String> tagNormalization (ArrayList<String> dataPDF, ArrayList<String> tags){
        String onlyString = arrayToString(dataPDF);
        String repairedString = repairTags(onlyString, tags);
        String[] arrayLines = repairedString.split("\n");
        ArrayList<String> arrayRepaired = new ArrayList<>(Arrays.asList(arrayLines));
        return arrayRepaired;
    }
    
    private String arrayToString(ArrayList<String> info) {
        return String.join("\n", info);
    }
    
    private String repairTags(String chain, ArrayList<String> etiquetas) {
        for (String etiqueta : etiquetas) {
            // Corregir cualquier etiqueta malformada que tenga espacios o saltos de línea dentro de "<etiqueta>"
            String malformedRegex = "<\\s*\n?" + etiqueta + "\n?\\s*>";
            chain = chain.replaceAll(malformedRegex, "<" + etiqueta + ">");

            // Solo agregar salto de línea si la etiqueta está malformada o necesita corrección
            // Este paso asegura que si hay una etiqueta mal formada, la corregimos con un salto de línea, pero no tocamos las etiquetas bien formadas.
            String regexSaltoLinea = "(<" + etiqueta + ">)(?!\\n)(?=\\S)";
            chain = chain.replaceAll(regexSaltoLinea, "$1\n");  // Solo agregar "\n" si no hay ya un salto de línea justo después y hay contenido
        }
        return chain;
    }
    
}
