import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class MenuTeclado {

    public static void MenuTeclado() throws IOException{
        String pathWriteTeclado = "lib/BBDD_Teclados.csv";
        String pathReadTeclado = "lib/BDTeclado.csv";
        boolean salir = false;
        Scanner in = new Scanner(System.in);

        while(!salir){
            try {
                ConsolaTeclado.MenuOpciones();
                int key = in.nextInt();
//"Añadir","Buscar","Cambiar (No disponible)","Leer CSV","Borrar Linea (No Funciona)","Eliminar Todo","Ver objetos añadidos","AÑADIR ObjetoCSV","Volver"};

                switch (key) {
                    case 1:
                        ConsolaTeclado.addTeclados(pathWriteTeclado);
                        break;
                    case 2:
                        ConsolaTeclado.SearchTeclado(pathWriteTeclado);
                        break;
                    case 3:
                        ConsolaTeclado.proSer(pathWriteTeclado);
                        break;
                    case 4:
                        ConsolaTeclado.LeerCSV(pathWriteTeclado);
                        break;
                    case 5:
                        ConsolaTeclado.imprimeUnaLinea(pathWriteTeclado);
                        break;
                    case 6:
                        ConsolaTeclado.borrarCSV(pathWriteTeclado);
                        break;
                    case 7:
                        
                        break;
                    case 8:
                        ConsolaTeclado.crearObjetos(pathWriteTeclado);
                        break;
                    case 9:
                        Menu.limpiar();
                        App.main(null);
                        break;               
                    default:
                        System.out.println("Introduce una opcion valida\n");
                }
            
            } catch (InputMismatchException e) {
                System.out.println("Debes insertar un número.\n");
                in.next();
            }
        }       
    }
}    
    

