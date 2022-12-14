import java.util.ArrayList;

// import javax.print.DocFlavor.STRING;

public abstract class Producto {

    // protected String id;
    // protected String marca;
    // protected double precio;
    // protected double dcto;
    // protected boolean prime;

    private String id;
    private String marca;
    private double precio;
    private double dcto;
    private boolean prime;
    //private double preciotemp;
    // private ArrayList<Teclado> teclados;

    

    public Producto(){
    }

    public Producto(String id, String marca, double precio, double dcto, boolean prime){
        this.id     = id;
        this.marca  = marca;
        this.precio = precio;
        this.dcto   = dcto;
        this.prime  = prime;
        //this.preciotemp = precio;
        // this.teclados = new ArrayList<>();
    }
 
    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMarca() {
        return this.marca.toUpperCase();
        //return this.marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public double getPrecio() {
        return this.precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
        //this.preciotemp = precio;
    }

    public double getDcto() {
        return this.dcto;
    }

    public void setDcto(double dcto) {
        this.dcto = dcto;
    }

    // public boolean isPrime() {
    //     return this.prime;
    // }

    public String isPrime() {
        String p = "PRIME";
        String r = "Regular";
        if(this.prime==true){
            return p;
        }else{
        return r;}
    }

    public void setPrime(boolean prime) {
        this.prime = prime;
    }

    public double getPrecioVenta(){
        if(this.prime==true){
            return this.precio = precio - Math.round(precio*dcto)/100;
        }else{
            return this.precio = precio - Math.round(precio*dcto)/100 + 15;
    }

    }

    public String getEnvio(){
        String euro = "\u20AC";
        String g = "GRATIS";
        String e = "+15"+euro;
        if(this.prime==true){
            return g;
        }else{
        return e;}
    }



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
    

}
