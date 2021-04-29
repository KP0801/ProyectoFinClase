package proyecto;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;

public class FileManager {

    public String read(String fileName) {
        String content = "";

        try {
            File f = new File(fileName);
            FileInputStream fis = new FileInputStream(f);
            InputStreamReader isr = new InputStreamReader(fis);
            BufferedReader br = new BufferedReader(isr);

            try {
                String line;

                while ((line = br.readLine()) != null) {
                    content += line;
                    content += "\n";
                }

            } finally {
                br.close();

            }
        } catch (Exception e) {
            System.out.println("Surgio un error durante la lectura del archivo o el archivo no existe por lo que se devuelve una cadena en blanco.");
            return "";
        }

        return content;
    }

    public boolean write(String fileName, String content) {
        try {
            File newFile = new File(fileName);

            FileOutputStream fos = new FileOutputStream(newFile);

            try {
                byte[] strToBytes = content.getBytes();

                fos.write(strToBytes);

            } finally {
                fos.close();
            }

        } catch (Exception e) {
            return false;
        }

        return true;
    }
}
