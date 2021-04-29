package proyecto;

import java.util.ArrayList;
//import Proyecto.Pais;

public class Region {
    private String nombreRegion;
    private ArrayList<Pais> paises = null;
    private float promSocialSupport;
    private float promLifeExpect;
    private float promFreedomOfChoice;
    private float promGenerosity;
    private float promPercepCorruption;
    private String mostCorruptCountry;
    private String mostGenerousCountry;

    public Region(String nombreRegion){
        this.nombreRegion = nombreRegion;
        this.paises = new ArrayList<Pais>();
    }

    public String getNombreRegion(){
        return this.nombreRegion;
    }

    public void crearPais(
        String nombre,
        float socialSupport,
        float healthyLifeExpectancy,
        float freedomToMakeChoices,
        float generosity,
        float perceptionOfCorruption
    ){
        this.paises.add(new Pais(
            nombre,
            socialSupport,
            healthyLifeExpectancy,
            freedomToMakeChoices,
            generosity,
            perceptionOfCorruption
            ));
    }

    public boolean buscarPais(String nombrePais){
        for(Pais pais: paises){
            if(pais.getNombre().equals(nombrePais)){
                return true;
            }
        }
        return false;
    }

    public void setPromSocSupport(){
        float promedio = 0;

        for(Pais pais: this.paises){
            promedio += pais.getSocialSupport();
        }

        this.promSocialSupport = (promedio/this.paises.size());
    }

    public void setPromLifeExpect(){
        float promedio = 0;

        for(Pais pais: this.paises){
            promedio += pais.getLifeExpectancy();
        }

        this.promLifeExpect = (promedio/this.paises.size());
    }

    public void setPromFreedomChoice(){
        float promedio = 0;

        for(Pais pais: this.paises){
            promedio += pais.getFreedomOfChoice();
        }

        this.promFreedomOfChoice = (promedio/this.paises.size());
    }

    public void setPromGenerosity(){
        float promedio = 0;

        for(Pais pais: this.paises){
            promedio += pais.getGenerosity();
        }

        this.promGenerosity = (promedio/this.paises.size());
    }

    public void setPromCorruption(){
        float promedio = 0;

        for(Pais pais: this.paises){
            promedio += pais.getCorruption();
        }

        this.promPercepCorruption = (promedio/this.paises.size());
    }

    public void setMostGenerousCountry(){
        Pais paisActual = this.paises.get(0);

        for(Pais pais: this.paises){
            if(paisActual.getGenerosity() < pais.getGenerosity()){
                paisActual = pais;
            }
        }

        this.mostGenerousCountry = paisActual.getNombre();
    }

    public void setMostCorruptCountry(){
        Pais paisActual = this.paises.get(0);

        for(Pais pais: this.paises){
            if(paisActual.getCorruption() < pais.getCorruption()){
                paisActual = pais;
            }
        }

        this.mostCorruptCountry = paisActual.getNombre();
    }

    public void analizarDatos(){
        setPromSocSupport();
        setPromLifeExpect();
        setPromFreedomChoice();
        setPromGenerosity();
        setPromCorruption();
        setMostGenerousCountry();
        setMostCorruptCountry();
    }

    private String getPrintableCountry(Pais pais){
        return (
            pais.getNombre() + "," +
            this.nombreRegion + "," + 
            (Math.round((pais.getSocialSupport() - this.promSocialSupport)*1000.00)/1000.00) + "," + 
            (Math.round((pais.getLifeExpectancy() - this.promLifeExpect)*1000.00)/1000.00) + "," + 
            (Math.round((pais.getFreedomOfChoice() - this.promFreedomOfChoice )*1000.00)/1000.00)+ "," + 
            (Math.round((pais.getGenerosity() - this.promGenerosity)*1000.00)/1000.00) + "," +
            (Math.round((pais.getCorruption()  - this.promPercepCorruption)*1000.00)/1000.00)
            );
    }

    public String getPrintable(){
        String printable = "Country name,Regional Indicator,Social support,Healthy life expectancy,Freedom to make life choices,Generosity,Perceptions of corruption\n";

        for(Pais pais: this.paises){
            printable += getPrintableCountry(pais) + "\n";
        }

        return printable;
    }
}
