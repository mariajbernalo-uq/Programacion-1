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

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public void setMetodoPago(String metodoPago) {
        this.metodoPago = metodoPago;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }
}
