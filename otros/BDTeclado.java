import java.util.ArrayList;



public class BDTeclado {
    
    public static ArrayList<Teclado> teclados = new ArrayList<Teclado>(); 
    
    public static void BDTeclado(){
     

        //Scanner in = new Scanner(System.in);
        Teclado teclado0  = new Teclado();
        Teclado teclado1 = new Teclado("t008","Roland",800.00,25,true,"Negro",88,"MIDI");
        Teclado teclado2 = new Teclado("t009","Yamaha",650.00,20,false,"Blanco",61,"MIDI");
        Teclado teclado3 = new Teclado("t0010","Casio",350.00,25,false,"Negro",37,"USB");

        //teclados.add(teclado0);       
        //teclados.add(teclado1);       
        teclados.add(teclado2);       
        teclados.add(teclado3);
        
        System.out.println("Stock de Teclados");

        for(int i=0; i<teclados.size();i++){
            System.out.printf("\n>> Item Nº: %d\n",i+1);
            teclados.get(i).mostrarInfo();
        }
        // teclado0.mostrarInfo();

        System.out.printf("\nNumero de Teclados en Stock: %d\n",teclados.size());
        System.out.println(teclados);



    }


    
    
}
