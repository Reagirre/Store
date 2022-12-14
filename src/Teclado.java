import java.util.ArrayList;

public class Teclado extends Producto{

    private String color;
    private int teclas;
    private String conector;
    // private ArrayList<Teclado> teclados;

    public Teclado(){
        super();
    }

    public Teclado(String id, String marca, double precio, double dcto, boolean prime, String color, int teclas, String conector){
        super(id, marca, precio, dcto, prime);
        this.color = color;
        this.teclas = teclas;
        this.conector = conector;
        // this.teclados = new ArrayList<>();
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
        System.out.printf("\nCodigo: %s\nMarca: %s\nPrecio: %.2f\nDescuento: %.0f\nPrime: %b\nColor: %s\nTeclas: %d\nConector: %s\nEnvio: %s\n"
        ,getId(),getMarca(),getPrecio(),getDcto(),isPrime(),getColor(),getTeclas(),getConector(),getEnvio());
    }

    @Override
    public String toString() {
         return getId()+ "," + getMarca()+ "," + getPrecio()+ "," + getDcto()+ "," + isPrime()+ "," + getColor()+ "," + getTeclas()+ "," + getConector() + "," + getEnvio() + "," + getPrecioVenta();
        }

    
    public String toStringDatos() {
         return "Id: "+getId()+ "," + "Marca: "+getMarca()+ "," + "Precio: "+getPrecio()+ "," + "Descuento: "+getDcto()+ "," + "Prime: "+isPrime()+ "," + "Color: "+getColor()+ "," + "Teclas: "+getTeclas()+ "," + "Conector: "+getConector() + "," + "Envio: "+getEnvio() + "," + "PVP: "+getPrecioVenta();
        }    

    
    //https://www.youtube.com/watch?v=wCLu4Z5F2dk
    // public void agregarProductos(Teclado t){
    //     this.teclados.add(t);
    // }

    // public int cantTeclados(){
    //     return teclados.size();
    // }
    
    // public Teclado buscarTeclado(String id){
    //     Teclado tecladoEncontrado = null;
    //     int i= 0;
    //     while (i < cantTeclados() && !this.teclados.get(i).getId().equalsIgnoreCase(id)) {
    //         i++;
    //     }
    //     if (i < cantTeclados()) {
    //         tecladoEncontrado = this.teclados.get(i);
    //     }
    //     return tecladoEncontrado;
    // }
    
    // @Override
    // public boolean equals(Object o) {
    //     if (this == o) return true;
    //     if (o == null || getClass() != o.getClass()) return false;
    //     Teclado teclado = (Teclado) o;
    //     return Objects.equals(getId(), teclado.getId());
    //     // && Objects.equals(nombre, producto.nombre);
    // }

    // @Override
    // public int hashCode() {
    //     return Objects.hash(getId()+ "," + getMarca()+ "," + getPrecio()+ "," + getDcto()+ "," + isPrime()+ "," + getColor()+ "," + getTeclas()+ "," + getConector() + "," + getEnvio() + "," + getPrecioVenta());
    // }    
 
}
