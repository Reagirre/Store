
import java.io.IOException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class App {

    public static void main(String[] args) throws IOException {

        Scanner in = new Scanner(System.in);
        boolean salir = false;
        Menu.limpiar();
        System.out.println("ONGI ETORRI");
        while (!salir) {
            Menu.MenuInstrumentos();
            try {
                String key2 = in.nextLine();
                ConsolaTeclado.isVacio(key2);
                int key = Integer.parseInt(key2);
                switch (key) {
                    case 1:
                        Menu.limpiar();
                        MenuTeclado.MenuTeclado();
                        salir = true;
                        // ConsolaTeclado.proSer(pathWriteTeclado, pathTemp);
                        break;
                    case 2:
                        // Menu.limpiar();
                        // ConsolaTeclado.buscarTeclados(pathWriteTeclado);
                        System.out.print("Solo esta disponible los productos de TECLADOS\n");
                        // salir = true;
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
            } catch (Exception e) {
                // System.out.printf("Error en el dato ingresado! Intentelo nuevamente...\n");
                // System.err.printf("Error en el dato ingresado! Intentelo nuevamente...\n");
                // TODO: handle exception

            }
        }
    }
}

