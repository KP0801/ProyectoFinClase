package proyecto;

import java.util.ArrayList;

public class CSVCreator implements Runnable{
    private ArrayList<Region> regiones;
    FileManager fileManager;

    public CSVCreator(ArrayList<Region> regiones){
        this.regiones = regiones;
        this.fileManager = new FileManager();
    }

    public void run(){
        for(Region region: this.regiones){
            String filename = region.getNombreRegion() + ".csv";
            this.fileManager.write(filename, region.getPrintable());
        }
    }
}
