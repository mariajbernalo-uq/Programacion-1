import java.util.ArrayList;
import java.util.List;

public class Gimnasio {
    private String nombre;
    private int nit;
    private String ubicacion;

    private List<Socio> listSocios;
    private List<Entrenador> listEntrenadores;
    private List<Membresia> listMembresias;
    private List<ClaseGrupal> listClasesGrupales;
    private List<HistorialPagos> listHistorialPagos;

    public Gimnasio(String nombre, List<HistorialPagos> listHistorialPagos, List<ClaseGrupal> listClasesGrupales, List<Membresia> listMembresias, List<Entrenador> listEntrenadores, List<Socio> listSocios, String ubicacion, int nit) {
        this.nombre = nombre;
        this.listHistorialPagos = listHistorialPagos;
        this.listClasesGrupales = listClasesGrupales;
        this.listMembresias = listMembresias;
        this.listEntrenadores = listEntrenadores;
        this.listSocios = listSocios;
        this.ubicacion = ubicacion;
        this.nit = nit;
    }
    //Getters y Setters
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<HistorialPagos> getListHistorialPagos() {
        return listHistorialPagos;
    }

    public void setListHistorialPagos(List<HistorialPagos> listHistorialPagos) {
        this.listHistorialPagos = listHistorialPagos;
    }

    public List<ClaseGrupal> getListClasesGrupales() {
        return listClasesGrupales;
    }

    public void setListClasesGrupales(List<ClaseGrupal> listClasesGrupales) {
        this.listClasesGrupales = listClasesGrupales;
    }

    public List<Membresia> getListMembresias() {
        return listMembresias;
    }

    public void setListMembresias(List<Membresia> listMembresias) {
        this.listMembresias = listMembresias;
    }

    public List<Entrenador> getListEntrenadores() {
        return listEntrenadores;
    }

    public void setListEntrenadores(List<Entrenador> listEntrenadores) {
        this.listEntrenadores = listEntrenadores;
    }

    public List<Socio> getListSocios() {
        return listSocios;
    }

    public void setListSocios(List<Socio> listSocios) {
        this.listSocios = listSocios;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public int getNit() {
        return nit;
    }

    public void setNit(int nit) {
        this.nit = nit;
    }

    /**
     * Método para registrar Socios
     * @param nombre
     * @param cedula
     * @return respuesta
     */

    public String registrarSocios (String nombre, int cedula){
        String respuesta="";
        boolean existeSocio=false;
        for(Socio sc:listSocios){
            if(sc.getCedula()==cedula){
                existeSocio=true;
                break;
            }
        }
        if(existeSocio){
            respuesta="El socio ya está registrado";
        }else{
            Socio nuevoSc= new Socio(nombre, cedula);
            respuesta= "El socio "+ nuevoSc.getNombre()+" se registró éxitosamente";
        }
        return respuesta;
    }

    /**
     * Método para registrarEntrenadores
     * @param nombre
     * @param clase
     * @param cedula
     * @return respuesta
     */

    public String registrarEntrenadores (String nombre, String clase, int cedula){
        String respuesta= "";
        boolean existeEntrenador= false;
        for(Entrenador et: listEntrenadores){
            if(et.getCedula()==cedula){
               existeEntrenador=true;
            }
            if(existeEntrenador){
                respuesta= "El entrenador ya se encuentra en la base de datos";
            }else{
                Entrenador nuevoEntrenador= new Entrenador(nombre, clase, cedula, listClasesGrupales);
                respuesta= "El entrenador "+ nuevoEntrenador.getNombre() + "fue registrado en el gimnasio éxitosamente";
                }
            }
        return respuesta;
        }

    public String registrarClases (int cupoMax, String horario, String tipoClase, Entrenador entrenador){
        String respuesta= "";
        boolean existeClase= false;
        for(ClaseGrupal cg: listClasesGrupales){
            if(cg.getTipoClase().equals(tipoClase) && cg.getHorario().equals(horario)){
                existeClase=true;
            }
            if(existeClase){
                respuesta= "La clase ya se encuentra programada";
            }else{
                ClaseGrupal nuevaClase= new ClaseGrupal(cupoMax, horario, tipoClase, entrenador);
                respuesta= "La clase "+ nuevaClase.getTipoClase() + "fue programada correctamente para las "+ nuevaClase.getHorario();
            }
        }
        return respuesta;
    }



    }


