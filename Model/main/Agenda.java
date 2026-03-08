import java.sql.Time;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Agenda {
    private String nombre;
    private int id;

    private List<Contacto> listContactos;
    private List<Grupo> listGrupos;
    private List<Reunion> listReuniones;

    // Constructor
    public Agenda(String nombre, int id){
        this.nombre= nombre;
        this.id= id;
        this.listContactos= new ArrayList<>();
        this.listGrupos= new ArrayList<>();
        this.listReuniones= new ArrayList<>();
    }

    //------CONTACTO------
    //Buscar Contacto
    public Contacto buscarContacto(String nombre, int telefono){
        for(Contacto c:listContactos){
            if(nombre.equals(c.getNombre()) && telefono==c.getTelefono())
                return c;
        }
        return null;
    }
    // Registrar Contacto
    public String añadirContacto (String nombre, String alias, String direccion, int telefono, String email) {
        String respuesta = "";
        Contacto c = buscarContacto(nombre, telefono);
        if (c != null) {
            respuesta = "El contacto ya está agregado";
        } else {
            Contacto ct=new Contacto(nombre, alias, direccion, telefono, email);
            listContactos.add(ct);
            respuesta = "El contacto " + ct.getNombre() + " ha sido añadido exítosamente";
        }
        return respuesta;
    }
    //Verificar Existencia Contacto
    public String existeContacto(String nombre, int telefono){
        String respuesta="";
        if(buscarContacto(nombre, telefono)==null){
            respuesta= "El contacto no está registrado en la agenda";
        }else{
            respuesta= "El contacto buscado está creado con el nombre " + buscarContacto(nombre, telefono).getNombre() + "y telefono" + buscarContacto(nombre, telefono).getTelefono();

        }
        return respuesta;
    }
    //Listar Contactos de una Agenda
    public String listarContactos(){
        String respuestaLista= "";
        for(Contacto c:listContactos){
            respuestaLista += c.getNombre() + "\n";
        }
        if(respuestaLista.isEmpty()){
            respuestaLista= "No hay contactos agregados aún";
        }
        return respuestaLista;
    }
    //MostrarCliente
    public String mostrarCliente(String nombre){
        String respuesta="";
        for(Contacto c: listContactos){
            if(nombre.equals(c.getNombre())){
                respuesta= "El contacto buscado tiene el telefono " + c.getTelefono();
            }
        }
        return respuesta;
    }

    //---- GRUPO ----
    //Buscar Grupo
    public Grupo buscarGrupo(String nombre, String categoria){
        for(Grupo g:listGrupos){
            if(nombre.equals(g.getNombre()) && categoria.equals(g.getCategoria())){
                return g;
            }
        }
        return null;
    }
    //Crear Grupo
    public String crearGrupo(String nombre, String categoria){
        String respuesta="";
        Grupo g= buscarGrupo(nombre, categoria);
        if(g != null){
            respuesta= "El grupo ya existe";
        }else{
            Grupo gr= new Grupo(nombre, categoria);
            listGrupos.add(gr);
        }
        return respuesta;
    }
    //Añadir Contacto A un Grupo
    public String anadirContactoGrupo(String nombreContacto, int telefonoContacto, String nombreGrupo, String categoriaGrupo){
        String respuesta="";
        Contacto c=buscarContacto(nombreContacto, telefonoContacto);
        Grupo g= buscarGrupo(nombreGrupo, categoriaGrupo);
        if(c == null){
            respuesta= "El contacto no está registrado en la agenda";
        }else if(g == null) {
            respuesta = "El grupo no está creado";
        }else if(g.getListContactosGrupo().size() >=10) {
            respuesta = "El grupo ha superado el límite de participantes";
        } else if(g.estaContactoEnGrupo(c)){
            respuesta= "El contacto ya está en el grupo";
        }else{
            c.agregarContacto(g);
            g.anadirContactoGrupo(c);
            respuesta= "Contacto agregado al grupo correctamente";
        }
        return respuesta;
    }

//----- REUNION-----
    //Buscar reunion
    public Reunion buscarReunion(String descripcion, Date fecha, String categoria){
        for(Reunion c:listReuniones){
            if(c.getDescripcion().equals(descripcion) && c.getCategoria().equals(categoria) && c.getFecha().equals(fecha)){
                return c;
            }
        } return null;
    }
    //Crear reunion
    public String crearReunion(String descripcion, Date fecha, Time hora, String categoria){
        String resultado="";
        Reunion r= buscarReunion(descripcion, fecha, categoria);
        if(r!=null){
            resultado= "La reunión ya está creada";
        } else{
            Reunion rn= new Reunion(descripcion, fecha, hora, categoria);
            listReuniones.add(rn);
            resultado= "La reunión " + rn.getDescripcion() + " de la categoria " + rn.getCategoria() + " fue creada éxitosamente";
        }
        return resultado;
    }
    //Agregar contacto a una reunión
    public String agregarContactoReunion(String nombreContacto, int telefonoContacto, String descripcionReunion, Date fechaReunion, String categoriaReunion){
        String respuesta= "";
        Contacto c=buscarContacto(nombreContacto, telefonoContacto);
        Reunion r=buscarReunion(descripcionReunion, fechaReunion, categoriaReunion);
        if(c==null){
            respuesta="Este contacto no está en la agenda";
        } else if(r==null){
            respuesta= "Esta reunión no está en la agenda";
        }else if(r.verificarDuplicadoContactoReunion(c)){
            respuesta= "El contacto ya está agregado a la reunión";
        }else{
            r.anadirContactosReunion(c);
            respuesta= "El contacto " + c.getNombre() + " fue añadido correctamente a la reunión " + r.getDescripcion() + " a las " + r.getHora();
        }

        return respuesta;
    }





    // Getters y Setters


    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Contacto> getListContactos() {
        return listContactos;
    }

    public void setListContactos(List<Contacto> listContactos) {
        this.listContactos = listContactos;
    }

    public List<Grupo> getListGrupos() {
        return listGrupos;
    }

    public void setListGrupos(List<Grupo> listGrupos) {
        this.listGrupos = listGrupos;
    }

    public List<Reunion> getListReuniones() {
        return listReuniones;
    }

    public void setListReuniones(List<Reunion> listReuniones) {
        this.listReuniones = listReuniones;
    }
}