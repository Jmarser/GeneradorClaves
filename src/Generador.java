
import java.security.SecureRandom;
import java.util.Random;
import utils.Constantes;

/**
 *
 * @author Jmarser
 */
public class Generador {

    public Generador() {
    }

    public String getClave(String nivel, int longitud) {
        String password = "";
        String combinaciones;
        switch (nivel.toLowerCase()) {
            case "bajo":
                combinaciones = Constantes.MAYUSCULAS + Constantes.MINUSCULAS;
                password = generator(combinaciones, Constantes.PATRON_LOW, Constantes.LONG_LOW, longitud);
                break;
            case "medio":
                combinaciones = Constantes.MAYUSCULAS + Constantes.MINUSCULAS + Constantes.NUMEROS;
                password = generator(combinaciones, Constantes.PATRON_MEDIUM, Constantes.LONG_MEDIUM, longitud);
                break;
            case "alto":
                combinaciones = Constantes.MAYUSCULAS + Constantes.MINUSCULAS + Constantes.NUMEROS + Constantes.ESPECIALES;
                password = generator(combinaciones, Constantes.PATRON_HIGH, Constantes.LONG_HIGH, longitud);
                break;
            case "pincard":
                password += pinCardLevel(longitud);
                break;
            default:
                password += "";
        }
        return password;

    }

    private String generator(String combinaciones, String patron, int long_min, int longitud) {
        int indice = 0;

        if (longitud < long_min) {
            longitud = long_min;
        }

        String aux = getCombinacion(combinaciones, longitud);

        while (!(aux.substring(indice, (longitud + indice))).matches(patron)) {
            indice++;
            if ((longitud + indice) == combinaciones.length()) {
                indice = 0;
                aux = getCombinacion(combinaciones, longitud);
            }
        }

        return aux.substring(indice, (longitud + indice));
    }

    private String pinCardLevel(int longitud) {
        String aux;

        if (longitud < Constantes.LONG_PIN_CARD) {
            longitud = Constantes.LONG_PIN_CARD;
        }

        aux = getCombinacion(Constantes.NUMEROS, longitud);

        return aux.substring(0, longitud);
    }

    private String getCombinacion(String letras, int longitud) {
        char[] caracteres = letras.toCharArray();
        mezclar(caracteres, longitud);

        return String.valueOf(caracteres);
    }

    private void mezclar(char[] caracteres, int longitud) {
        Random rdn = new SecureRandom();

        int numCambios = caracteres.length + rdn.nextInt(longitud * caracteres.length);
        for (int i = 0; i < numCambios; i++) {
            int pos1 = rdn.nextInt(caracteres.length);
            int pos2 = rdn.nextInt(caracteres.length);
            char aux = caracteres[pos1];
            caracteres[pos1] = caracteres[pos2];
            caracteres[pos2] = aux;
        }
    }

}
