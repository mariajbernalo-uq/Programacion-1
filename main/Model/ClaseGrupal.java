import java.util.ArrayList;
import java.util.List;

public class ClaseGrupal {
    private int cupoMax;
    private String horario;
    private String tipoClase;

    private Entrenador theEntrenador;
    private List<Socio> reservas= new ArrayList<>();

    public ClaseGrupal(String horario, String tipoClase, int cupoMax, Entrenador theEntrenador) {
        this.horario = horario;
        this.tipoClase = tipoClase;
        this.cupoMax = cupoMax;
        this.theEntrenador = theEntrenador;
    }
    //-------- Getters y Setters --------//

    public int getCupoMax() {
        return cupoMax;
    }

    public void setCupoMax(int cupoMax) {
        this.cupoMax = cupoMax;
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }

    public String getTipoClase() {
        return tipoClase;
    }

    public void setTipoClase(String tipoClase) {
        this.tipoClase = tipoClase;
    }

    public Entrenador getTheEntrenador() {
        return theEntrenador;
    }

    public void setTheEntrenador(Entrenador theEntrenador) {
        this.theEntrenador = theEntrenador;
    }

    public Socio getTheSocio() {
        return theSocio;
    }

    public void setTheSocio(Socio theSocio) {
        this.theSocio = theSocio;
    }

    /**
     * Método para verificar la cantidad de cupos disponibles
     * @return cantidad de cupos disponibles
     */
    public int cuposDisponibles(){
        return cupoMax-reservas.size();
    }

    /**
     * Método para reservar una clase para un socio
     * @param socio
     * @return respuesta de registro éxitoso o no éxitoso
     */
    public String reservarClase (Socio socio){
        String respuesta= "";
        if(reservas.contains(socio)){
            respuesta= "El socio ya se registró en la clase";
            if(reservas.size()>cuposDisponibles()){
                respuesta= "La clase ha alcanzado el cupo máximo y no se puede inscribir. Pruebe con otro curso";
        }
        }else {
            reservas.add(socio);
            respuesta= "El socio " + socio + "se registró en la clase correctamente";
        }
        return respuesta;
    }

    public List<Socio> getReservas() {
        return reservas;
    }
}
