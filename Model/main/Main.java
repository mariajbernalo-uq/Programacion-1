import java.sql.Time;
import java.util.Date;

public class Main {
    public static void main(String[] args) {
        Agenda agenda= new Agenda("Enero", 1);

        // ---- CONTACTOS ----
        System.out.println("---- CONTACTOS ----");
        System.out.println(agenda.añadirContacto("Juan", "Ju", "Cali", 1234, "juan@gmail.com"));
        System.out.println(agenda.añadirContacto("Ana", "Anita", "Bogota", 5678, "ana@gmail.com"));
        System.out.println(agenda.añadirContacto("Juan", "Ju", "Cali", 1234, "juan@gmail.com")); // duplicado

        System.out.println(agenda.existeContacto("Juan", 1234));
        System.out.println(agenda.listarContactos());
        System.out.println(agenda.mostrarCliente("Ana"));

        // ---- GRUPOS ----
        System.out.println("\n---- GRUPOS ----");
        System.out.println(agenda.crearGrupo("Amigos", "Social"));
        System.out.println(agenda.crearGrupo("Trabajo", "Laboral"));
        System.out.println(agenda.crearGrupo("Amigos", "Social")); // duplicado

        System.out.println(agenda.anadirContactoGrupo("Juan",1234,"Amigos","Social"));
        System.out.println(agenda.anadirContactoGrupo("Ana",5678,"Amigos","Social"));
        System.out.println(agenda.anadirContactoGrupo("Juan",1234,"Amigos","Social")); // duplicado

        // ---- REUNIONES ----
        System.out.println("\n---- REUNIONES ----");

        Date fecha = new Date();
        Time hora = new Time(System.currentTimeMillis());

        System.out.println(agenda.crearReunion("Reunion Proyecto",fecha,hora,"Trabajo"));
        System.out.println(agenda.crearReunion("Reunion Proyecto",fecha,hora,"Trabajo")); // duplicada

        System.out.println(agenda.agregarContactoReunion("Juan",1234,"Reunion Proyecto",fecha,"Trabajo"));
        System.out.println(agenda.agregarContactoReunion("Ana",5678,"Reunion Proyecto",fecha,"Trabajo"));
        System.out.println(agenda.agregarContactoReunion("Juan",1234,"Reunion Proyecto",fecha,"Trabajo")); //duplicada
        System.out.println(agenda.listarContactos());
    }
}
