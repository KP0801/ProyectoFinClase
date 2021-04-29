package proyecto;

//import Proyecto.Region;
import java.util.ArrayList;
//import Proyecto.FileManager;
import java.util.Arrays;

public class CSVExtractor {
    private ArrayList<Region> regiones;

    public CSVExtractor(){
        this.regiones = new ArrayList<Region>();
    }

    private Region buscarRegion(String nombreRegion){
        Region resultado = null;

        for(Region region: this.regiones){
            if(region.getNombreRegion().equals(nombreRegion)){
                resultado = region;
                break;
            }
        }

        return resultado;
    }

    private int obtenerPosicion(String[] lista, String nombreColumna){
        int posicion = 0;

        for(String elemento: lista){
            
            if(elemento.equals(nombreColumna)){
                break;
            }
            posicion++;
        }

        return posicion;
    }

    public ArrayList<Region> extraerDatos(String nombreArchivo){
        FileManager fm = new FileManager();

        String contenido = fm.read(nombreArchivo);

        if(contenido.equals("")){
            System.out.println("SE RETORNA UNA LISTA VACIA.");
        }else{
            String[] filas = contenido.split("\n");
            String[] cabeceras = filas[0].split(",");

            filas = Arrays.copyOfRange( filas , 1, filas.length);

            for(String fila: filas){
                String[] columnas = fila.split(",");

                if(buscarRegion(columnas[1]) == null){
                    this.regiones.add(new Region(columnas[1]));
                }

                Region regionActual = buscarRegion(columnas[1]);

                regionActual.crearPais(
                    columnas[0],
                    Float.parseFloat(columnas[ obtenerPosicion(cabeceras, "Social support") ]),
                    Float.parseFloat(columnas[ obtenerPosicion(cabeceras, "Healthy life expectancy") ]),
                    Float.parseFloat(columnas[ obtenerPosicion(cabeceras, "Freedom to make life choices") ]),
                    Float.parseFloat(columnas[ obtenerPosicion(cabeceras, "Generosity") ]),
                    Float.parseFloat(columnas[ obtenerPosicion(cabeceras, "Perceptions of corruption") ])
                );
            }
        }


        return this.regiones;
    }

}
