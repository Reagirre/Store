import java.util.ArrayList;
import java.util.Scanner;

public class BDGuitar {

    public static ArrayList<Guitarra> guitarras = new ArrayList<Guitarra>();

    public static void BDGuitar(){

        //Scanner in = new Scanner(System.in);
        Guitarra guitar0 = new Guitarra();
        Guitarra guitar1 = new Guitarra("g002","Fender",650.00,20,true,"Pino",6,"derecha");
        Guitarra guitar2 = new Guitarra("g003","Yamaha",400.00,10,false,"Cedro",6,"derecha");
        Guitarra guitar3 = new Guitarra("g004","Ibanez",800.00,25,false,"Balza",7,"izquierda");

        guitarras.add(guitar0);
        guitarras.add(guitar1);
        guitarras.add(guitar2);
        guitarras.add(guitar3);

        System.out.println("Stock de Guitarras");
        guitar0.mostrarInfo();
        guitar1.mostrarInfo();
        guitar2.mostrarInfo();
        guitar3.mostrarInfo();

        System.out.printf("\nNumero de Guitarras en Stock: %d\n",guitarras.size());
        System.out.println(guitarras);



    }
    
}
