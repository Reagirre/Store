import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
import com.opencsv.exceptions.CsvException;


public class ConsolaTeclado{


    public static void menuOpciones() {
        String[] opciones = {"Añadir","Buscar por ID","Buscar Elemento en CSV","Cambiar","Borrar","Leer Info CSV","Eliminar Todo","Volver"};
            System.out.print("\n***Menu de Opciones***\n");
            for (int i =0;i<opciones.length;i++){
                System.out.printf("%d - %s:\n",i+1,opciones[i]);
            }
            System.out.print("Seleccione opción: ");
        }

    public static void mostrarTeclados() {

        System.out.printf("\nNumero de Teclados en Stock: %d\n",baseTeclados().size());
        for(int i=0; i<baseTeclados().size();i++){
            System.out.printf("\n>> Item Nº: %d\n",i+1);
            System.out.println(baseTeclados().get(i).toString());
        }
        // for(int i=0; i<baseTeclados().size();i++){
        //     System.out.printf("\n>> Item Nº: %d\n",i+1);
        //     baseTeclados().get(i).mostrarInfo();
        // }
    }

    public static List<Teclado> baseTeclados(){
 
    //Teclado teclado0  = new Teclado();
    Teclado teclado1 = new Teclado("t008","Roland",800.00,25,true,"Negro",88,"MIDI");
    Teclado teclado2 = new Teclado("t009","Yamaha",650.00,20,false,"Blanco",61,"MIDI");
    Teclado teclado3 = new Teclado("t0010","Casio",350.00,25,false,"Negro",37,"USB");

    List<Teclado> teclados = new ArrayList<Teclado>();

    //teclados.add(teclado0);       
    teclados.add(teclado1);       
    teclados.add(teclado2);       
    teclados.add(teclado3); 

    return teclados;
    
}

    public static void addTeclados(String pathTeclado) throws IOException{

        try {
            String id, marca, color, conector, loop;
            double precio, dcto;
            int teclas;
            boolean prime;
        
            List<Teclado> arrTeclado = new ArrayList<Teclado>();
            Teclado teclado  = new Teclado();
            Scanner in = new Scanner(System.in);
            String[] opc = {"Numero de id","Marca","Precio","Descuento","Prime","Color","Teclas","Conector"};
            
        
            System.out.printf("Ingrese %s: t", opc[0]);
            id = "t"+in.next();
            teclado.setId(id);	
        
            System.out.printf("Ingrese %s: ", opc[1]);
            marca = in.next();
            teclado.setMarca(marca);
        
            System.out.printf("Ingrese %s: ", opc[2]);
            precio = in.nextDouble();
            teclado.setPrecio(precio);
        
            System.out.printf("Ingrese %s: ", opc[3]);
            dcto = in.nextDouble();
            teclado.setDcto(dcto);
        
            System.out.printf("Ingrese %s (true/false): ", opc[4]);
            prime = in.nextBoolean();
            teclado.setPrime(prime);
            
            System.out.printf("Ingrese %s: ", opc[5]);
            color = in.next();
            teclado.setColor(color);
        
            System.out.printf("Ingrese %s: ", opc[6]);
            teclas = in.nextInt();
            teclado.setTeclas(teclas);
        
            System.out.printf("Ingrese %s: ", opc[7]);
            conector = in.next();
            teclado.setConector(conector);
        
            System.out.println("\nDatos del Producto ingresado:");
            //teclado.mostrarInfo();
            System.out.println(teclado.toStringDatos());
            
            arrTeclado.add(teclado);
            //System.out.println("\n"+arrTeclado.toString());
        
            System.out.print("\nDesea grabar la informacion en el Fichero CSV?:\nPresione S para grabar o pulse otra tecla para ingresar los valores nuevamente: ");
            loop = in.next();
            if(loop.equals("S") || loop.equals("s")){
            //if(loop == "S" || loop == "s"){
                try {
                    File file = new File(pathTeclado);
                    FileWriter fw = new FileWriter(file.getAbsoluteFile(),true);
                    BufferedWriter bw = new BufferedWriter(fw);
                    //bw.write("Stock de Teclados");
                    //bw.newLine();
                    bw.write("\n"+teclado.toString());
                    //bw.newLine();       
                    bw.close();
                    Menu.limpiar();
                    System.out.printf("\nArchivo Guardado en: %s\n",pathTeclado);
                
                }catch(IOException e){
                    System.out.println(e);
                        
                } catch (Exception e) {
                // TODO: handle exception
                } 
            }else{
                Menu.limpiar();
                addTeclados(pathTeclado);
            }
            
        } catch (Exception e) {
            System.out.printf("Error en el dato ingresado! Intentelo nuevamente...\n");
            addTeclados(pathTeclado);
            // TODO: handle exception
        }

    
    }

    public static void borrarCSV(String pathTeclado) throws IOException {
        try {
            Scanner in = new Scanner(System.in);
            System.out.println("****ATENCION****\nEsta seguro que desea eliminar el contenido del archivo? (s/n)");
            String key = in.next();
            if(key.equals("S") || key.equals("s")){

                File file = new File(pathTeclado);
                FileWriter fw = new FileWriter(file);
                BufferedWriter bw = new BufferedWriter(fw);   
                // bw.write("Stock de Teclados");
                // bw.newLine();
                // bw.write("Id,Marca,Precio,Descuento,Prime,Color,Teclas,Conector,Envio,PrecioVenta");
                //bw.newLine();
                bw.close();
                System.out.printf("\nArchivo Borrado: %s\n",pathTeclado);
            }
        }catch(IOException e){
            System.out.println(e);
        } catch (Exception e) {
        // TODO: handle exception
        } 
    }

    public static void leerCSV(String pathTeclado){
        CSVReader csvReader = null;
        try{
        csvReader = new CSVReader(new FileReader(pathTeclado));
        String[] fila = null;
        System.out.printf("\n>>Informacion del archivo: %s\n",pathTeclado);

        while ((fila = csvReader.readNext()) != null) {
            System.out.println(Arrays.toString(fila));
            }

        }
        catch(IOException e){
            System.out.println(e);
        }
        catch(Exception e){
            System.out.println(e);
        }
        finally{
            if (null != csvReader) {
                try {
                    csvReader.close();
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        }
    }

    //---------------ENCUENTRA ELEMENTOS EN EL CSV--------------------------
    public static void buscaItemCSV(String pathTeclado) {
         
        try{
            BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
            BufferedReader reader = new BufferedReader(new FileReader(pathTeclado));
            System.out.printf("\nArchivo de busqueda: %s",pathTeclado);
            System.out.print("\nIngrese el dato: ");
            String dato = in.readLine();
            boolean busqueda = false;
            String fila = null;
            long numFila = 0;
            long itemFinds = 0;
            while ((fila = reader.readLine()) != null){
                numFila++;
                String[] parts = fila.split(",");
                int totalParts = parts.length;
                for(int i=0;i<totalParts;i++){
                    if(dato.compareTo(parts[i]) == 0){
                        itemFinds++;
                        System.out.printf("\nItem encontrado en la Fila: %d - Posicion [%d]\nObjeto >> %s",numFila,i,fila);
                        busqueda=true;
                        break;
                    }
                    
                }
            }
            System.out.printf("\n\nTotal items encontrados segun el dato [%s]: %d\n",dato,itemFinds);
            if(busqueda==false){
                System.out.println("El dato NO existe");
            }else{
                System.out.println("\nBusqueda realizada satisfactoriamente...");
            }
        }catch(IOException e){
            e.printStackTrace();
        }
    }
    
    public static long contarFilasCSV(String pathTeclado){

        try{
        FileReader fr = new FileReader(pathTeclado);
        BufferedReader bf = new BufferedReader(fr);
        long numFilas = 0;
        String fila = null;

        while ((fila = bf.readLine()) != null) {
            numFilas++;
            }
            System.out.println(numFilas);
            return numFilas;

        }
     catch (FileNotFoundException fnfe){
        fnfe.printStackTrace();
      } catch (IOException ioe){
        ioe.printStackTrace();
      }
        return 0;
    }

    public static void proSer(String pathTeclado) throws FileNotFoundException{

        // long n = leerFilasCSV(pathTeclado);

        File file = new File(pathTeclado);
        Scanner inputFile = new Scanner(file);
        String str;
        String[] tokens;

        ArrayList<Teclado> arrTeclados = new ArrayList<Teclado>();
        Teclado tecladoFind  = new Teclado();
        // List<Teclado> arrTeclados = new ArrayList<Teclado>();
        try {
            while (inputFile.hasNext()) {
            // for (int i =0;i<n;i++) {
                str = inputFile.nextLine();        
                tokens = str.split(",");
                Teclado teclado = new Teclado();

                teclado.setId(tokens[0]); 
                teclado.setMarca(tokens[1]); 
                teclado.setPrecio(Double.parseDouble(tokens[2]));
                teclado.setDcto(Double.parseDouble(tokens[3]));
                String primeString = tokens[4];
                Boolean prime;

                    if(primeString.equals("PRIME")){
                        prime = true;
                    }else{
                        prime = false;
                    } 

                teclado.setPrime(prime); 
                teclado.setColor(tokens[5]); 
                teclado.setTeclas(Integer.parseInt(tokens[6])); 
                teclado.setConector(tokens[7]); 
                String envio = tokens[8];
                Double pvp = Double.parseDouble(tokens[9]);
                arrTeclados.add(teclado);
                //teclado.mostrarInfo();
                // return teclado;
            }

            for(int i=0; i<arrTeclados.size();i++){
                //System.out.printf("\n>> Item Nº: %d\n",i+1);
                System.out.println(arrTeclados.get(i).toString());
            }

                Scanner in = new Scanner(System.in);
                System.out.print("\nIngrese codigo para buscar: ");
                String key = in.nextLine();

                int i = 0;
            
                while (i < arrTeclados.size() && !arrTeclados.get(i).getId().equalsIgnoreCase(key)){
                    i++;
                }
                if(i<arrTeclados.size()){
                    tecladoFind = arrTeclados.get(i);
                }

                //tecladoFind.mostrarInfo();
                System.out.println(tecladoFind.toStringDatos());
                //borrar linea del csv

                CSVReader reader2 = new CSVReader(new FileReader(pathTeclado));
                List<String[]> allElements = reader2.readAll();
                allElements.remove(i);
                FileWriter sw = new FileWriter(pathTeclado);
                CSVWriter writer = new CSVWriter(sw);
                writer.writeAll(allElements,false);
                writer.close();
                

                //deleteLine(pathTeclado, pathTemp, tecladoFind);

                System.out.println("\nMenu de Cambio de Valores");
                String[] cambios = {"Marca","Precio","Descuento","Prime","Color","Teclas","Conector"};
                for (int j =0;j<cambios.length;j++){
                    System.out.printf("%d - %s:\n",j+1,cambios[j]);
                }
                System.out.print("\nQue valor desea cambiar? ");
                int op = in.nextInt();
                String keychange;
                double keydouble;
                int keyInt;
                boolean keyboolean;

                switch (op) {
                    case 1: //MARCA
                        System.out.printf("\nValor anterior: %s",tecladoFind.getMarca());
                        System.out.print("\nIngrese nuevo valor: ");
                        keychange = in.next();
                        tecladoFind.setMarca(keychange);
                        System.out.printf("\nValor Nuevo: %s",tecladoFind.getMarca());
                        tecladoFind.mostrarInfo();
                        break;
                    case 2: //PRECIO
                        System.out.printf("\nValor anterior: %s",tecladoFind.getPrecio());
                        System.out.print("\nIngrese nuevo valor: ");
                        keydouble = in.nextDouble();
                        tecladoFind.setPrecio(keydouble);
                        System.out.printf("\nValor Nuevo: %s",tecladoFind.getPrecio());
                        tecladoFind.mostrarInfo();
                        break;
                    case 3: //DESCUENTO
                        System.out.printf("\nValor anterior: %s",tecladoFind.getDcto());
                        System.out.print("\nIngrese nuevo valor: ");
                        keydouble = in.nextDouble();
                        tecladoFind.setDcto(keydouble);
                        System.out.printf("\nValor Nuevo: %s",tecladoFind.getDcto());
                        tecladoFind.mostrarInfo();
                        break;
                    case 4: //PRIME
                        System.out.printf("\nValor anterior: %s",tecladoFind.isPrime());
                        System.out.print("\nIngrese nuevo valor (true/false): ");
                        keyboolean = in.nextBoolean();
                        tecladoFind.setPrime(keyboolean);
                        System.out.printf("\nValor Nuevo: %s",tecladoFind.isPrime());
                        tecladoFind.mostrarInfo();
                        break;
                    case 5: //COLOR
                        System.out.printf("\nValor anterior: %s",tecladoFind.getColor());
                        System.out.print("\nIngrese nuevo valor: ");
                        keychange = in.next();
                        tecladoFind.setColor(keychange);
                        System.out.printf("\nValor Nuevo: %s",tecladoFind.getColor());
                        tecladoFind.mostrarInfo();
                        break;
                    case 6: //TECLAS
                        System.out.printf("\nValor anterior: %s",tecladoFind.getTeclas());
                        System.out.print("\nIngrese nuevo valor: ");
                        keyInt = in.nextInt();
                        tecladoFind.setTeclas(keyInt);
                        System.out.printf("\nValor Nuevo: %s",tecladoFind.getTeclas());
                        tecladoFind.mostrarInfo();
                        break;
                    case 7: //CONECTOR
                        System.out.printf("\nValor anterior: %s",tecladoFind.getConector());
                        System.out.print("\nIngrese nuevo valor: ");
                        keychange = in.next();
                        tecladoFind.setConector(keychange);
                        System.out.printf("\nValor Nuevo: %s",tecladoFind.getConector());
                        tecladoFind.mostrarInfo();
                        break;
                
                    default:
                        break;
                }


                try {
                    FileWriter fw = new FileWriter(file.getAbsoluteFile(),true);
                    BufferedWriter bw = new BufferedWriter(fw);
                    bw.write(tecladoFind.toString());
                    //bw.newLine();       
                    bw.close();
                    System.out.printf("Archivo Guardado en: %s\n",pathTeclado);
                
                }catch(IOException e){
                    System.out.println(e);
                        
                } catch (Exception e) {
                // TODO: handle exception
                } 

    
        } catch (Exception e) {
            // TODO: handle exception

        }

        
    }

    //Teclado tecladoFind  = new Teclado();
    public static void funcionActualizar(String pathTeclado) throws FileNotFoundException{

        File file = new File(pathTeclado);
        Scanner inputFile = new Scanner(file);
        ArrayList<Teclado> arrTeclados = new ArrayList<Teclado>();
        
        try {
                pasarObjectosCSV(pathTeclado, arrTeclados, file, inputFile);
                buscaCambiaActualiza(arrTeclados, pathTeclado, file);
                // buscarGuardar(arrTeclados, tecladoFind, pathTeclado);
                // cambiarValores(tecladoFind);
                // imprimirALGO(pathTeclado, tecladoFind, file);
        } catch (Exception e) {
            // TODO: handle exception
        }
    }

    public static void borraRegistro(String pathTeclado) throws FileNotFoundException{

        File file = new File(pathTeclado);
        Scanner inputFile = new Scanner(file);
        ArrayList<Teclado> arrTeclados = new ArrayList<Teclado>();
        
        try {
                pasarObjectosCSV(pathTeclado, arrTeclados, file, inputFile);
                eliminaRegistro(arrTeclados, pathTeclado);
        } catch (Exception e) {
            // TODO: handle exception
        }
    }

    public static void buscaPorID(String pathTeclado) throws FileNotFoundException{

        File file = new File(pathTeclado);
        Scanner inputFile = new Scanner(file);
        ArrayList<Teclado> arrTeclados = new ArrayList<Teclado>();
        
        try {
                pasarObjectosCSV(pathTeclado, arrTeclados, file, inputFile);
                buscaID(arrTeclados,pathTeclado);
        } catch (Exception e) {
            // System.out.printf("\nEste codigo no existe....\n");
        }
    }

    private static void buscaCambiaActualiza(ArrayList arrTeclados, String pathTeclado, File file){
        
        //BUSCA, Cambia Y Actualiza
        try {
            Teclado tecladoFind  = new Teclado();

            Scanner in = new Scanner(System.in);
            int i = 0;
            System.out.print("\nIngrese codigo: ");
            String key = in.nextLine();
    
            while (i < arrTeclados.size() && !((Producto) arrTeclados.get(i)).getId().equalsIgnoreCase(key)){
                i++;
            }
            if(i<arrTeclados.size()){
                tecladoFind = (Teclado) arrTeclados.get(i);
            }
            //tecladoFind.mostrarInfo();
            System.out.println(tecladoFind.toStringDatos());
            
            CSVReader reader2 = new CSVReader(new FileReader(pathTeclado));
            List<String[]> allElements = reader2.readAll();
            allElements.remove(i);
            FileWriter sw = new FileWriter(pathTeclado);
            CSVWriter writer = new CSVWriter(sw);
            writer.writeAll(allElements,false);
            writer.close();

   
            // CAMBIA VALORES****************************

            System.out.println("\nMenu de Cambio de Valores");
            String[] cambios = {"Marca","Precio","Descuento","Prime","Color","Teclas","Conector"};
            for (int j =0;j<cambios.length;j++){
                System.out.printf("%d - %s:\n",j+1,cambios[j]);
            }
            System.out.print("\nQue valor desea cambiar? ");
            int op = in.nextInt();
            String keychange;
            double keydouble;
            int keyInt;
            boolean keyboolean;

            switch (op) {
                case 1: //MARCA
                    System.out.printf("\nValor anterior: %s",tecladoFind.getMarca());
                    System.out.print("\nIngrese nuevo valor: ");
                    keychange = in.next();
                    tecladoFind.setMarca(keychange);
                    System.out.printf("\nValor Nuevo: %s",tecladoFind.getMarca());
                    tecladoFind.mostrarInfo();
                    break;
                case 2: //PRECIO
                    System.out.printf("\nValor anterior: %s",tecladoFind.getPrecio());
                    System.out.print("\nIngrese nuevo valor: ");
                    keydouble = in.nextDouble();
                    tecladoFind.setPrecio(keydouble);
                    System.out.printf("\nValor Nuevo: %s",tecladoFind.getPrecio());
                    tecladoFind.mostrarInfo();
                    break;
                case 3: //DESCUENTO
                    System.out.printf("\nValor anterior: %s",tecladoFind.getDcto());
                    System.out.print("\nIngrese nuevo valor: ");
                    keydouble = in.nextDouble();
                    tecladoFind.setDcto(keydouble);
                    System.out.printf("\nValor Nuevo: %s",tecladoFind.getDcto());
                    tecladoFind.mostrarInfo();
                    break;
                case 4: //PRIME
                    System.out.printf("\nValor anterior: %s",tecladoFind.isPrime());
                    System.out.print("\nIngrese nuevo valor (true/false): ");
                    keyboolean = in.nextBoolean();
                    tecladoFind.setPrime(keyboolean);
                    System.out.printf("\nValor Nuevo: %s",tecladoFind.isPrime());
                    tecladoFind.mostrarInfo();
                    break;
                case 5: //COLOR
                    System.out.printf("\nValor anterior: %s",tecladoFind.getColor());
                    System.out.print("\nIngrese nuevo valor: ");
                    keychange = in.next();
                    tecladoFind.setColor(keychange);
                    System.out.printf("\nValor Nuevo: %s",tecladoFind.getColor());
                    tecladoFind.mostrarInfo();
                    break;
                case 6: //TECLAS
                    System.out.printf("\nValor anterior: %s",tecladoFind.getTeclas());
                    System.out.print("\nIngrese nuevo valor: ");
                    keyInt = in.nextInt();
                    tecladoFind.setTeclas(keyInt);
                    System.out.printf("\nValor Nuevo: %s",tecladoFind.getTeclas());
                    tecladoFind.mostrarInfo();
                    break;
                case 7: //CONECTOR
                    System.out.printf("\nValor anterior: %s",tecladoFind.getConector());
                    System.out.print("\nIngrese nuevo valor: ");
                    keychange = in.next();
                    tecladoFind.setConector(keychange);
                    System.out.printf("\nValor Nuevo: %s",tecladoFind.getConector());
                    tecladoFind.mostrarInfo();
                    break;
            
                default:
                    break;
            }

                FileWriter fw = new FileWriter(file.getAbsoluteFile(),true);
                BufferedWriter bw = new BufferedWriter(fw);
                bw.write(tecladoFind.toString());
                //bw.newLine();       
                bw.close();
                System.out.printf("\nArchivo Guardado Satisfactoriamente en: %s\n",pathTeclado);
            
            }catch(IOException e){
                System.out.println(e);
                    
            } catch (Exception e) {
                Menu.limpiar();
                System.out.printf("\nDato erroneo....\n");
            } 

    }

    //FUNCION PARA BUSCAR ID
    private static void buscaID(ArrayList arrTeclados, String pathTeclado){
        
        try {
            Teclado tecladoFind  = new Teclado();
            Scanner in = new Scanner(System.in);
            int i = 0;
            System.out.print("\nIngrese el codigo que busca: ");
            String key = in.nextLine();
    
            while (i < arrTeclados.size() && !((Producto) arrTeclados.get(i)).getId().equalsIgnoreCase(key)){
                i++;
            }
            if(i<arrTeclados.size()){
                tecladoFind = (Teclado) arrTeclados.get(i);
            }
            //tecladoFind.mostrarInfo();
            System.out.println(tecladoFind.toStringDatos());

        } catch (Exception e) {
            System.out.printf("\nEste codigo no existe....\n");
        }
    }

    //////// FUNCIONES PARA QUE FUNCIONEN INDEPENDIENTEMENTE
    private static void pasarObjectosCSV(String pathTeclado, ArrayList arrTeclados, File file, Scanner inputFile) throws FileNotFoundException{

        try {

            String str;
            String[] tokens;
            System.out.printf("\n>>Informacion del archivo: %s\n",pathTeclado);
           
                while (inputFile.hasNext()) {
                // for (int i =0;i<n;i++) {
                    str = inputFile.nextLine();        
                    tokens = str.split(",");
                    Teclado teclado = new Teclado();
    
                    teclado.setId(tokens[0]); 
                    teclado.setMarca(tokens[1]); 
                    teclado.setPrecio(Double.parseDouble(tokens[2]));
                    teclado.setDcto(Double.parseDouble(tokens[3]));
                    String primeString = tokens[4];
                    Boolean prime;
                        if(primeString.equals("PRIME")){
                            prime = true;
                        }else{
                            prime = false;
                        } 
                    teclado.setPrime(prime); 
                    teclado.setColor(tokens[5]); 
                    teclado.setTeclas(Integer.parseInt(tokens[6])); 
                    teclado.setConector(tokens[7]); 
                    String envio = tokens[8];
                    Double pvp = Double.parseDouble(tokens[9]);
                    arrTeclados.add(teclado);
                    //teclado.mostrarInfo();
                    // return teclado;
                }
    
                for(int i=0; i<arrTeclados.size();i++){
                    //System.out.printf("\n>> Item Nº: %d\n",i+1);
                    System.out.println(arrTeclados.get(i).toString());
                }
            
        } catch (Exception e) {
            // TODO: handle exception
        }

 
    }

    private static void eliminaRegistro(ArrayList arrTeclados, String pathTeclado){
        
        try {
            Teclado tecladoFind  = new Teclado();
            Scanner in = new Scanner(System.in);
            int i = 0;
            System.out.print("\nIngrese codigo para eliminar: ");
            String key = in.nextLine();
    
            while (i < arrTeclados.size() && !((Producto) arrTeclados.get(i)).getId().equalsIgnoreCase(key)){
                i++;
            }
            if(i<arrTeclados.size()){
                tecladoFind = (Teclado) arrTeclados.get(i);
            }
            //tecladoFind.mostrarInfo();
            System.out.print("\nEl elemento es:\n");
            System.out.println(tecladoFind.toStringDatos());

            System.out.print("\nEsta seguro que desea eliminar el registro? (s/n): ");
            key = in.next();

            if(key.contentEquals("S")||key.contentEquals("s")){
                CSVReader reader2 = new CSVReader(new FileReader(pathTeclado));
                List<String[]> allElements = reader2.readAll();
                allElements.remove(i);
                FileWriter sw = new FileWriter(pathTeclado);
                CSVWriter writer = new CSVWriter(sw);
                writer.writeAll(allElements,false);
                writer.close();
            }
            


        } catch (Exception e) {
            // TODO: handle exception
        }
    }

    private static void buscarGuardar(ArrayList arrTeclados, String pathTeclado){
        //BUSCA - ELIMINA - Y ACTUALIZA
        try {
            Teclado tecladoFind  = new Teclado();
            Scanner in = new Scanner(System.in);
            int i = 0;
            System.out.print("\nIngrese codigo para eliminar: ");
            String key = in.nextLine();
    
            while (i < arrTeclados.size() && !((Producto) arrTeclados.get(i)).getId().equalsIgnoreCase(key)){
                i++;
            }
            if(i<arrTeclados.size()){
                tecladoFind = (Teclado) arrTeclados.get(i);
            }
            //tecladoFind.mostrarInfo();
            System.out.println(tecladoFind.toStringDatos());
            //ELIMINA Y ACTUALIZA
            CSVReader reader2 = new CSVReader(new FileReader(pathTeclado));
            List<String[]> allElements = reader2.readAll();
            allElements.remove(i);
            FileWriter sw = new FileWriter(pathTeclado);
            CSVWriter writer = new CSVWriter(sw);
            writer.writeAll(allElements,false);
            writer.close();

        } catch (Exception e) {
            // TODO: handle exception
        }
    }

    private static void cambiarValores(Teclado tecladoFind){

        try {
            Scanner in = new Scanner(System.in);

            System.out.println("\nMenu de Cambio de Valores");
        String[] cambios = {"Marca","Precio","Descuento","Prime","Color","Teclas","Conector"};
        for (int j =0;j<cambios.length;j++){
            System.out.printf("%d - %s:\n",j+1,cambios[j]);
        }
        System.out.print("\nQue valor desea cambiar? ");
        int op = in.nextInt();
        String keychange;
        double keydouble;
        int keyInt;
        boolean keyboolean;

        switch (op) {
            case 1: //MARCA
                System.out.printf("\nValor anterior: %s",tecladoFind.getMarca());
                System.out.print("\nIngrese nuevo valor: ");
                keychange = in.next();
                tecladoFind.setMarca(keychange);
                System.out.printf("\nValor Nuevo: %s",tecladoFind.getMarca());
                tecladoFind.mostrarInfo();
                break;
            case 2: //PRECIO
                System.out.printf("\nValor anterior: %s",tecladoFind.getPrecio());
                System.out.print("\nIngrese nuevo valor: ");
                keydouble = in.nextDouble();
                tecladoFind.setPrecio(keydouble);
                System.out.printf("\nValor Nuevo: %s",tecladoFind.getPrecio());
                tecladoFind.mostrarInfo();
                break;
            case 3: //DESCUENTO
                System.out.printf("\nValor anterior: %s",tecladoFind.getDcto());
                System.out.print("\nIngrese nuevo valor: ");
                keydouble = in.nextDouble();
                tecladoFind.setDcto(keydouble);
                System.out.printf("\nValor Nuevo: %s",tecladoFind.getDcto());
                tecladoFind.mostrarInfo();
                break;
            case 4: //PRIME
                System.out.printf("\nValor anterior: %s",tecladoFind.isPrime());
                System.out.print("\nIngrese nuevo valor (true/false): ");
                keyboolean = in.nextBoolean();
                tecladoFind.setPrime(keyboolean);
                System.out.printf("\nValor Nuevo: %s",tecladoFind.isPrime());
                tecladoFind.mostrarInfo();
                break;
            case 5: //COLOR
                System.out.printf("\nValor anterior: %s",tecladoFind.getColor());
                System.out.print("\nIngrese nuevo valor: ");
                keychange = in.next();
                tecladoFind.setColor(keychange);
                System.out.printf("\nValor Nuevo: %s",tecladoFind.getColor());
                tecladoFind.mostrarInfo();
                break;
            case 6: //TECLAS
                System.out.printf("\nValor anterior: %s",tecladoFind.getTeclas());
                System.out.print("\nIngrese nuevo valor: ");
                keyInt = in.nextInt();
                tecladoFind.setTeclas(keyInt);
                System.out.printf("\nValor Nuevo: %s",tecladoFind.getTeclas());
                tecladoFind.mostrarInfo();
                break;
            case 7: //CONECTOR
                System.out.printf("\nValor anterior: %s",tecladoFind.getConector());
                System.out.print("\nIngrese nuevo valor: ");
                keychange = in.next();
                tecladoFind.setConector(keychange);
                System.out.printf("\nValor Nuevo: %s",tecladoFind.getConector());
                tecladoFind.mostrarInfo();
                break;
        
            default:
                break;
        }
            
        } catch (Exception e) {
            // TODO: handle exception
        }
        
    }

    private static void imprimirALGO(String pathTeclado,Teclado tecladoFind, File file){
        try {
            FileWriter fw = new FileWriter(file.getAbsoluteFile(),true);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(tecladoFind.toString());
            //bw.newLine();       
            bw.close();
            System.out.printf("Archivo Guardado en: %s\n",pathTeclado);
        
        }catch(IOException e){
            System.out.println(e);
                
        } catch (Exception e) {
        // TODO: handle exception
        } 

    }

    private static void borrarLinea(String pathTeclado, int i) throws IOException, CsvException{

        try {
            CSVReader reader2 = new CSVReader(new FileReader(pathTeclado));
            List<String[]> allElements = reader2.readAll();
            allElements.remove(i);
            FileWriter sw = new FileWriter(pathTeclado);
            CSVWriter writer = new CSVWriter(sw);
            writer.writeAll(allElements,false);
            writer.close();
        } catch (Exception e) {
            // TODO: handle exception
        }

    }

    private static void imprimeUnaLinea(String pathTeclado){

        File outputFile = new File("lib/BBDD_Teclados copy.csv");

        try{
            BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
            FileWriter fw = new FileWriter(outputFile,false);
            BufferedReader reader = new BufferedReader(new FileReader(pathTeclado));
            BufferedWriter writer = new BufferedWriter(fw);

            System.out.printf("Archivo de busqueda: %s",pathTeclado);
            System.out.print("\nIngrese el dato: ");
            String dato = in.readLine();
            boolean busqueda = false;
            String fila = null;
            while ((fila = reader.readLine()) != null){
                String[] parts = fila.split(",");
                int totalParts = parts.length;
                for(int i=0;i<totalParts;i++){
                    if(dato.compareTo(parts[i]) == 0){
                        if(fila.trim().equals(dato)){
                            continue;
                        }
                        writer.write(fila + System.getProperty("line.separator"));
                        //System.out.printf(fila);
                        busqueda=true;
                        break;
                    }
                }
            }
            writer.close();
            reader.close();
        }catch(IOException e){
            e.printStackTrace();
        }
    }

    private static void deleteLine(String pathTeclado, String pathTemp, String lineaBorrar) throws IOException{

        File inputFile = new File(pathTeclado);
        File tempFile = new File(pathTemp);

        BufferedReader reader = new BufferedReader(new FileReader(inputFile));
        BufferedWriter writer = new BufferedWriter(new FileWriter(pathTemp));
        String currentLine;

        while((currentLine = reader.readLine())!=null){
            String trimmedLine = currentLine.trim();
            if(trimmedLine.equals(lineaBorrar)) continue;
            writer.write(currentLine + System.getProperty("line.separator"));
        }
        writer.close();
        reader.close();
        boolean succesful = tempFile.renameTo(inputFile);
        
    }
    
    private static void buscarTeclados(String pathReadTeclado) throws FileNotFoundException{
           
        Teclado tecladoFind  = null;
        Teclado teclado1 = new Teclado("t008","Roland",800.00,25,true,"Negro",88,"MIDI");
        Teclado teclado2 = new Teclado("t009","Yamaha",650.00,20,false,"Blanco",61,"MIDI");
        Teclado teclado3 = new Teclado("t0010","Casio",350.00,25,false,"Negro",37,"USB");
    
        List<Teclado> teclados = new ArrayList<Teclado>();
    
        //teclados.add(teclado0);       
        teclados.add(teclado1);       
        teclados.add(teclado2);       
        teclados.add(teclado3);

        System.out.print(teclados.toString());

        // Scanner in = new Scanner(System.in);
        // System.out.print("Ingrese codigo para buscar");
        // String key = in.nextLine();

        int i = 0;
    
        while (i < teclados.size() && !teclados.get(i).getId().equalsIgnoreCase("t008")){
            i++;
        }
        if(i<teclados.size()){
            tecladoFind = teclados.get(i);
        }
        System.out.println("\n"+tecladoFind.toString());
              
    }
}
