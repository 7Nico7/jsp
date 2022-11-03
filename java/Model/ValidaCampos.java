package Model;

import org.apache.poi.util.StringUtil;

public class ValidaCampos {

    public String valida(String[] campos, String[] campoNombre) {
        String respuesta = null;

        for (int i = 0; i < campos.length; i++) {
            if (StringUtil.isBlank(campos[i])) {
                respuesta = "<div class=\"alert alert-danger\" role=\"alert\"> " + campoNombre[i] + "! </div>";
                i = campos.length;
            } else {
                respuesta = "correcto";
            }
        }
        return respuesta;
    }
}
