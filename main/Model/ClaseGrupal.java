import java.util.ArrayList;
import java.util.List;

public class ClaseGrupal {
    private int cupoMax;
    private String horario;
    private String tipoClase;

    private Entrenador theEntrenador;
    private List<Socio> listSocios;

    public ClaseGrupal(String horario, String tipoClase, int cupoMax, Entrenador theEntrenador,  List<Socio> listSocios) {
        this.horario = horario;
        this.tipoClase = tipoClase;
        this.cupoMax = cupoMax;
        this.theEntrenador = theEntrenador;
        this.listSocios = listSocios;
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

    public List<Socio> getListSocios() {
        return listSocios;
    }

    public void setListSocios(List<Socio> listSocios) {
        this.listSocios = listSocios;
    }


    /**
     * Método para verificar la cantidad de cupos disponibles
     * @return cantidad de cupos disponibles
     */
    public int cuposDisponibles(){
        int cupos= cupoMax-listSocios.size();
        return cupos;
    }

    /**
     * Método para reservar una clase para un socio
     * @param socio
     * @return respuesta de registro éxitoso o no éxitoso
     */
    public String reservarClase(Socio socio) {

        if (listSocios.contains(socio)) {
            return "El socio ya se registró en la clase";
        }

        // cupo máximo: si ya hay cupoMax socios, no deja inscribir
        if (listSocios.size() >= cupoMax) {
            return "La clase ha alcanzado el cupo máximo y no se puede inscribir. Pruebe con otro curso";
        }else{
            listSocios.add(socio);
            return "El socio " + socio.getNombre() + " se registró en la clase correctamente";
        }


    }

}
