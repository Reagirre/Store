
import java.io.IOException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class App {

    public static void main(String[] args) throws IOException{
        String pathWriteTeclado = "lib/BBDD_Teclados.csv";
        String pathTemp = "lib/BBDD_Temp.csv";
        Teclado teclado = new Teclado();
        List<Teclado> arrTeclados = new ArrayList<Teclado>();
        
        Scanner in = new Scanner(System.in);
        boolean salir = false;
        Menu.limpiar();
        System.out.println("ONGI ETORRI");
        while(!salir){
            Menu.MenuInstrumentos();
            try {
                int key = in.nextInt();
                
                switch (key) {
                    case 1:
                        Menu.limpiar();
                        salir = true;
                        MenuTeclado.MenuTeclado();
                        // ConsolaTeclado.addTeclados(pathWriteTeclado);
                        //ConsolaTeclado.proSer(pathWriteTeclado, pathTemp);
                        break;
                    case 2:
                        //Menu.limpiar();
                        //ConsolaTeclado.buscarTeclados(pathWriteTeclado);

                        // ConsolaTeclado.prueba(pathWriteTeclado, arrTeclados);
                        break;
                    case 3:
                        salir = true;
                        break;
                    default:
                        System.out.println("Seleccione una opcion valida!\n");
               }
                } catch (InputMismatchException e) {
                System.out.println("Debes insertar un número");
                in.next();
            }
        }
    }
}


