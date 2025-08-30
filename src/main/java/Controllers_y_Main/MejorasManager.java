package Controllers_y_Main;

import java.io.*;

public class MejorasManager {
    private static final String SAVE_FILE = "src/main/java/Controllers_y_Main/Save.txt";

    public static void guardarMejora(String mejoraId)
    {
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter(SAVE_FILE, true));
            bw.write(mejoraId + "\n");
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static boolean estaComprado(String mejoraId)
    {
        File saveFile = new File(SAVE_FILE);
        if (!saveFile.exists()) {
            return false;
        }

        try {
            BufferedReader br = new BufferedReader(new FileReader(saveFile));
            String linea;
            while ((linea = br.readLine()) != null) {
                if (linea.equals(mejoraId)) {
                    br.close();
                    return true;
                }
            }
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

    public static void inicializarArchivoGuardado()
    {
        File saveFile = new File(SAVE_FILE);
        if (!saveFile.exists()) {
            try {
                saveFile.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}