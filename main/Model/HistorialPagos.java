public class HistorialPagos {
    private String fecha;
    private double valor;
    private String metodoPago;

    public HistorialPagos(String fecha, double valor, String metodoPago) {
        this.fecha = fecha;
        this.valor = valor;
        this.metodoPago = metodoPago;
    }

    public String getFecha() {
        return fecha;
    }

    public double getValor() {
        return valor;
    }

    public String getMetodoPago() {
        return metodoPago;
    }
}
