public class ClaseGrupal {
    private int cupoMax;
    private String horario;
    private String tipoClase;

    private Entrenador theEntrenador;
    private Socio theSocio;

    public ClaseGrupal(String horario, String tipoClase, int cupoMax, Entrenador theEntrenador, Socio theSocio) {
        this.horario = horario;
        this.tipoClase = tipoClase;
        this.cupoMax = cupoMax;
        this.theEntrenador = theEntrenador;
        this.theSocio = theSocio;
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

    public String reservarCupo(int cupoMax){
        int cupoActual= cupoMax;
        if(ClaseGrupal ){

        }
    }
}
