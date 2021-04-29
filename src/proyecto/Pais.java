package proyecto;

public class Pais{
    private String nombre;
    private float socialSupport, healthyLifeExpectancy, freedomToMakeChoices, generosity, perceptionOfCorruption;

    public Pais(
        String nombre,
        float socialSupport,
        float healthyLifeExpectancy,
        float freedomToMakeChoices,
        float generosity,
        float perceptionOfCorruption
    ){
        this.nombre = nombre;
        this.socialSupport = socialSupport; 
        this.healthyLifeExpectancy = healthyLifeExpectancy;
        this.freedomToMakeChoices = freedomToMakeChoices;
        this.generosity = generosity;
        this.perceptionOfCorruption = perceptionOfCorruption;
    }

    public String getNombre(){
        return this.nombre;
    }

    public float getSocialSupport(){
        return this.socialSupport;
    }

    public float getLifeExpectancy(){
        return this.healthyLifeExpectancy;
    }

    public float getFreedomOfChoice(){
        return this.freedomToMakeChoices;
    }

    public float getGenerosity(){
        return this.generosity;
    }

    public float getCorruption(){
        return this.perceptionOfCorruption;
    }
}