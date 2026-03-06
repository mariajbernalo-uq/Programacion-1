import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Gimnasio {
    private String nombre;
    private int nit;
    private String ubicacion;

    private List<Socio> listSocios;
    private List<Entrenador> listEntrenadores;
    private List<Membresia> listMembresias;
    private List<ClaseGrupal> listClasesGrupales;


    public Gimnasio(String nombre, int nit, String ubicacion) {
        this.nombre = nombre;
        this.nit = nit;
        this.ubicacion = ubicacion;
        this.listSocios = new ArrayList<>();
        this.listEntrenadores = new ArrayList<>();
        this.listMembresias = new ArrayList<>();
        this.listClasesGrupales = new ArrayList<>();
    }

    //Getters y Setters
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
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
     * @param cedula
     * @return respuesta
     */

    //Registrarlo si no existe
    public String registrarSocio(String nombre, int cedula){
        String respuesta="";
        Socio socio= buscarSocio(cedula);
        if(socio ==null){
            respuesta="El socio ya está registrado";
        }else{
            Socio nuevoSc = new Socio(nombre, cedula);
            listSocios.add(nuevoSc);
            respuesta= "El socio "+ nuevoSc.getNombre()+" se registró éxitosamente";
        }
        return respuesta;
    }

    //Buscar Socio
    public Socio buscarSocio(int cedula){
        for(Socio sc:listSocios){
            if(sc.getCedula()==cedula){
                return sc;
            }
        }
        return null;
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
                Entrenador nuevoEntrenador= new Entrenador(nombre, clase, cedula);
                listEntrenadores.add(nuevoEntrenador);
                respuesta= "El entrenador "+ nuevoEntrenador.getNombre() + "fue registrado en el gimnasio éxitosamente";
                }
            }
        return respuesta;
    }
    // Buscar entrenador
    public Entrenador buscarEntrenador(int cedula){
        for(Entrenador e:listEntrenadores){
            if(cedula==e.getCedula()){
                return e;
            }
        }
        return null;
    }
    /**
     * Método para registrarClase
     * @param horario
     * @param tipoClase
     * @param cupoMax
     * @param theEntrenador
     * @param sociosAInscribir
     * @return
     */

    public String registrarClase(String horario, String tipoClase, int cupoMax,
                                 Entrenador theEntrenador, List<Socio> sociosAInscribir) {

        // 1) Validar si la clase ya existe
        for (ClaseGrupal cg : listClasesGrupales) {
            if (cg.getTipoClase().equals(tipoClase) && cg.getHorario().equals(horario)) {
                return "La clase ya se encuentra programada";
            }
        }

        // 2) Crear la clase nueva (arranca sin socios)
        ClaseGrupal nuevaClase = new ClaseGrupal(horario, tipoClase, cupoMax, theEntrenador, new ArrayList<>());

        // 3) Asignar socios (inscribirlos a esa clase)
        for (Socio s : sociosAInscribir) {
            String r = nuevaClase.reservarClase(s);
            // opcional: si se llena el cupo, paras
            if (r.contains("cupo máximo"))
                break;
        }

        listClasesGrupales.add(nuevaClase);

        return "La clase " + nuevaClase.getTipoClase()
                + " fue programada correctamente para las " + nuevaClase.getHorario();
    }
        // ---- BUSCAR CLASE ----
            public ClaseGrupal buscarClase(String horario, String tipoClase){
            for(ClaseGrupal cg: listClasesGrupales){
                if(tipoClase.equals(cg.getTipoClase()) && horario.equals(cg.getHorario())){
                    return cg;
                }
            }
            return null;
            }

            //Reservar Clase

            public String reservarCupoClase(int cedula, String horario, String tipoClase){
                String resultado="";
                Socio s = buscarSocio(cedula);

                if(s == null){
                    resultado= "El socio no existe en la base de datos del gimnasio";
                }

                ClaseGrupal c = buscarClase(horario, tipoClase);

                if(c == null){
                    resultado= "No se encuentra esta clase grupal";
                } else {
                    c.reservarClase(s);
                }

                return resultado;
            }

            //Disponibilidad de cupos de una clase

            public String consultarDisponibilidadCupos(String horario, String tipoClase){
            String resultado= "";
            ClaseGrupal cg= buscarClase(horario, tipoClase);
            if(cg==null){
                resultado= "La clase no existe";
            }else{
               int cupos= cg.cuposDisponibles();
                resultado= "La clase de "+ cg.getTipoClase() + " tiene "+ cupos + " disponibles";
            }
            return resultado;
            }
    /**
     * Método para registrar el historial de pago de un socio
     * @param cedula
     * @param fecha
     * @param valor
     * @param metodoPago
     * @return pago realizado
     */
    public HistorialPagos registrarHistorial(int cedula, String fecha, double valor, String metodoPago){
        Socio socio= buscarSocio(cedula);
        if(socio != null){
            HistorialPagos pago= new HistorialPagos(fecha, valor, metodoPago);
            socio.registrarPago(pago);
            return pago;
        }


        return null;
    }

    /**
     * Método para registrar la membresia de un socio
     * @param cedula
     * @param tipo
     * @param fechaInicio
     * @param fechaFin
     * @param precio
     * @return membresia asignada correctamente o fallida
     */
    public String registrarMembresia(int cedula, String tipo, String fechaInicio, String fechaFin, double precio){

        try{
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

            Date inicio = sdf.parse(fechaInicio);
            Date fin = sdf.parse(fechaFin);

            Socio socio = buscarSocio(cedula);

            if(socio == null){
                return "El socio no existe";
            }

            Membresia m = new Membresia(tipo, inicio, fin, precio);

            socio.setThemembresia(m);

            return "Membresía registrada correctamente";

        }catch(Exception e){
            return "Error en el formato de fecha";
        }
    }

    //consultar membresia activa
    public String isMembresiaActiva(int cedula){
        String resultado= "";
        Socio s= buscarSocio(cedula);
        if(s ==null){
           resultado= "El socio no está registrado en el gimnasio";
        }
        if(s.getThemembresia().isMembresiaActiva()){
            resultado= "La membresia del socio"+ s.getNombre() + "está activa";
        }else{
            resultado= "La membresia del socio"+ s.getNombre() + "está vencida";
        }

        return resultado;
    }
    //---CONSULTAR SOCIOS VENCIDOS-----

    public String sociosVencidos(){
        String respuesta="";
        for(Socio s: listSocios){
            if (s.getThemembresia() != null && !s.getThemembresia().isMembresiaActiva()){
                respuesta += s.getNombre() + "-" + s.getCedula() + "\n";
            }
        }

        if(respuesta.isEmpty()){
            respuesta=" No hay socios vencidos";
        }

        return respuesta;
    }


}


