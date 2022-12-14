import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

import com.opencsv.CSVReader;


public class ObjTeclados {
    
   
    public static List<Teclado> teclados = new ArrayList<Teclado>(); 

    
    public static void ObjTeclados(){
        
        
        Teclado teclado0  = new Teclado();
        Teclado teclado1 = new Teclado("t008","Roland",800.00,25,true,"Negro",88,"MIDI");
        Teclado teclado2 = new Teclado("t009","Yamaha",650.00,20,false,"Blanco",61,"MIDI");
        Teclado teclado3 = new Teclado("t0010","Casio",350.00,25,false,"Negro",37,"USB");

        //teclados.add(teclado0);       
        teclados.add(teclado1);       
        teclados.add(teclado2);       
        teclados.add(teclado3);       

        System.out.println("Stock de Teclados");
        // teclado0.mostrarInfo();
        // teclado1.mostrarInfo();
        // teclado2.mostrarInfo();
        // teclado3.mostrarInfo();


        // aqui para mostrar
        // for(int i=0; i<teclados.size();i++){
        //     System.out.printf("\n>> Item Nº: %d\n",i+1);
        //     teclados.get(i).mostrarInfo();
        // }

        // para mostrar en STRING
        for(int i=0; i<teclados.size();i++){
            System.out.printf("\n>> Item Nº: %d\n",i+1);
            System.out.println(teclados.get(i).toString());
        }


    }

    public static void imprimirCSV(String pathTeclado) throws IOException {
        try {
            File file = new File(pathTeclado);
            FileWriter fw = new FileWriter(file);
            BufferedWriter bw = new BufferedWriter(fw);
    
            bw.write("Stock de Teclados");
            bw.newLine();
            for(int i=0;i<teclados.size();i++)
            {
                bw.write(teclados.get(i+1)+", "+teclados.get(i++));
                bw.newLine();
            }
            bw.close();
        
        }catch(IOException e){
            System.out.println(e);
                
        } catch (Exception e) {
        // TODO: handle exception
        } 
    }

        public static void LeerCSV(String pathReadTeclado){
            //FileReader archCSV = null;
            CSVReader csvReader = null;
            try{
            csvReader = new CSVReader(new FileReader(pathReadTeclado));
            String[] fila = null;
            while ((fila = csvReader.readNext()) != null) {
                System.out.println(Arrays.toString(fila));
            // while((fila = csvReader.readNext()) != null) {
                // System.out.println(fila[0]
                //   + " | " + fila[1]
                //   + " |  " + fila[2]);
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
            //     try{
            //         archCSV.close();
            //         csvReader.close();
            //     }
            //     catch(IOException e){
            //         System.out.println(e);
            //     }
            //     catch(Exception e){
            //         System.out.println(e);
            //     }
            }
        }
            

        public static void SearchTeclado(String pathTeclado) { 
            try{
                BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
                BufferedReader reader = new BufferedReader(new FileReader(pathTeclado));
                System.out.printf("Buscando item en archivo: %s ....",pathTeclado);
                System.out.print("Ingrese el dato: ");
                String dato = in.readLine();
                boolean busqueda = false;
                String fila = null;
                while ((fila = reader.readLine()) != null){
                    String[] parts = fila.split(", ");
                    int totalParts = parts.length;
                    for(int i=0;i<totalParts;i++){
                        if(dato.compareTo(parts[i]) == 0){
                            System.out.printf("El dato SI existe en el archivo: %s",pathTeclado);
                            busqueda=true;
                            break;
                        }
                    }
                }
                if(busqueda==false){
                    System.out.print("El dato NO existe");
                }else{
                    System.out.println("Busqueda realizada satisfactoriamente...");
                }
            }catch(IOException e){
                e.printStackTrace();
            }
        }



    }

   
    

