package main1;


import java.util.ArrayList;
import proyecto.CSVExtractor;
import proyecto.Region;
import proyecto.CSVCreator;

public class Main1 {
    public static void main(String[] args) {
        String currentDirectory = System.getProperty("user.dir");
        System.out.println(currentDirectory);
        
        CSVExtractor extractor = new CSVExtractor();

        ArrayList<Region> regiones = extractor.extraerDatos("world-happiness-report-2021.csv");

        CSVCreator creadorCSV = new CSVCreator(regiones);

        Thread t1 = new Thread(creadorCSV);
        t1.start();
        
        
    }
}