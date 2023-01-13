
public class Menu {

    public static void MenuInstrumentos(){
        System.out.println("\n***Instrumentos Musicales en Stock***\n");
        String[] instrumentos = {"Teclados","Guitarras","Salir"};
        for (int i =0;i<instrumentos.length;i++){
            System.out.printf("%d - %s:\n",i+1,instrumentos[i]);
        }
        System.out.print("Seleccione opción: ");
    }
    
    public static void MenuOpciones() {
        String[] opciones = {"Añadir Producto","Buscar por codigo ID","Buscar item en archivo.CSV","Cambiar Información","Borrar Producto","Leer Info CSV","Eliminar Todo (No disponible)","Volver"};
        //String[] opciones = {"Añadir","Buscar","Cambiar","Eliminar"};
        System.out.print("\n***Menu de Opciones***\n");
            for (int i =0;i<opciones.length;i++){
                System.out.printf("%d - %s:\n",i+1,opciones[i]);
            }
            System.out.print("Seleccione opción: ");
        }

    public static void limpiar() {  
        System.out.print("\033[H\033[2J");  
        System.out.flush();  
    } 

}
    

