import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class MenuTeclado {

    public static void MenuTeclado() throws IOException{
        String pathTeclado = "lib/BBDD_Teclados.csv";
        //String pathReadTeclado = "lib/BDTeclado.csv";
        boolean salir = false;
        Scanner in = new Scanner(System.in);


        while(!salir){
            try {
                ConsolaTeclado.menuOpciones();
                String key2 = in.nextLine();
                ConsolaTeclado.isVacio(key2);
                int key = Integer.parseInt(key2);      
                // "Añadir","Buscar por ID","Buscar Elemento en CSV","Cambiar","Borrar","Leer Info CSV","Eliminar Todo","Volver"};
                switch (key) {
                    case 1:
                        ConsolaTeclado.addTeclados(pathTeclado);
                        break;
                    case 2:
                        ConsolaTeclado.buscaPorID(pathTeclado);
                        break;
                    case 3:
                        ConsolaTeclado.buscaItemCSV(pathTeclado);
                        break;
                    case 4:
                        ConsolaTeclado.funcionActualizar(pathTeclado);
                        break;
                    case 5:
                        ConsolaTeclado.borraRegistro(pathTeclado);
                        break;
                    case 6:
                        ConsolaTeclado.leerCSVOrdenado(pathTeclado);
                        // ConsolaTeclado.leerCSV(pathTeclado);
                        break;
                    case 7:
                        //ConsolaTeclado.borrarCSV(pathTeclado);
                        System.out.println("Esta opcion esta desactivada");
                        break;
                    case 8:
                        Menu.limpiar();
                        App.main(null);
                        salir = true;
                        break;               
                    default:
                        Menu.limpiar();
                        System.out.println("Introduce una opcion valida");
                }
            
            } catch (InputMismatchException e) {
                Menu.limpiar();
                System.out.println("Debes insertar un número.\n");
                in.next();
            }
            catch (Exception e) {
                // System.out.printf("Error en el dato ingresado! Intentelo nuevamente...\n");
                // System.err.printf("Error en el dato ingresado! Intentelo nuevamente...\n");
                // TODO: handle exception
            }
        }       
    }
}    
    

