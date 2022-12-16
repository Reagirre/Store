import java.util.ArrayList;

public class Teclado extends Producto{

    private String color;
    private int teclas;
    private String conector;

    public Teclado(){
        super();
    }

    public Teclado(String id, String marca, double precio, double dcto, boolean prime, String color, int teclas, String conector){
        super(id, marca, precio, dcto, prime);
        this.color = color;
        this.teclas = teclas;
        this.conector = conector;
    }

    public String getColor() {
        return this.color.toUpperCase();
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getTeclas() {
        return this.teclas;
    }

    public void setTeclas(int teclas) {
        this.teclas = teclas;
    }

    public String getConector() {
        return this.conector.toUpperCase();
    }

    public void setConector(String conector) {
        this.conector = conector;
    }
    
    public void mostrarInfo(){
        System.out.printf("\nCodigo: %s\nMarca: %s\nPrecio: %.2f\nDescuento: %.0f\nPrime: %b\nColor: %s\nTeclas: %d\nConector: %s\nEnvio: %s\nPVP: %.2f\n"
        ,getId(),getMarca(),getPrecio(),getDcto(),isPrime(),getColor(),getTeclas(),getConector(),getEnvio(),getPrecioVenta());
    }

    @Override
    public String toString() {
         return getId()+ "," + getMarca()+ "," + getPrecio()+ "," + getDcto()+ "," + isPrime()+ "," + getColor()+ "," + getTeclas()+ "," + getConector() + "," + getEnvio() + "," + getPrecioVenta();
        }

    public String toStringDatos() {
         return "Id: "+getId()+ "\n" + "Marca: "+getMarca()+ "\n" + "Precio: "+getPrecio()+ "\n" + "Descuento: "+getDcto()+ "\n" + "Prime: "+isPrime()+ "\n" + "Color: "+getColor()+ "\n" + "Teclas: "+getTeclas()+ "\n" + "Conector: "+getConector() + "\n" + "Envio: "+getEnvio() + "\n" + "PVP: "+getPrecioVenta();
        }    

 
}
