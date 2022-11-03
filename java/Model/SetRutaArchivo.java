package Model;

import jakarta.servlet.http.Part;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class SetRutaArchivo {
    private final String pathFiles = "C:\\Users\\Nico\\Documents\\NetBeansProjects\\serviciosgenerales\\web\\pages\\evidencias";
    private final File almacen = new File(pathFiles);
    private final String[] extenciones;
    
    public SetRutaArchivo() {
        this.extenciones = new String[]{".ico", ".png", ".jpg", ".jpeg", ".jfif", "mp4"};
    }

    public Archivo RutaArchivoGuardado(Part evidencia) {
        Archivo archivo = new Archivo();
        Part part = evidencia;
        if (part == null) {
            System.out.println("No ha seleccionado un archivo");
            return null;
        }
        if (isExtension(part.getSubmittedFileName(), extenciones)) {
            //Guarda y Obtiene la ruta
            archivo = GuardarArchivo(part, almacen);
        }

        return archivo;

    }

    private Archivo GuardarArchivo(Part part, File pathUploads) {
        String pathAbsolute = "";
        String name = "";

        try {

            Path path = Paths.get(part.getSubmittedFileName());
            String fileName = path.getFileName().toString();
            InputStream input = part.getInputStream();

            if (input != null) {
                File file = new File(pathUploads, fileName);
                name = file.getName();
                pathAbsolute = file.getAbsolutePath();
                Files.copy(input, file.toPath());
            }

        } catch (IOException e) {
            System.err.println("ERROR GuardarArchivo : " + e);
        }
        Archivo archivo = new Archivo(name, pathAbsolute);

        return archivo;
    }

    //Valida las extenciones de los archivos
    private boolean isExtension(String fileName, String[] extensions) {
        for (String ex : extensions) {
            if (fileName.toLowerCase().endsWith(ex)) {
                return true;
            }
        }
        return false;
    }

}
