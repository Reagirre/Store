import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

import com.opencsv.CSVReader;

public class ObjGuitarras {

    public static ArrayList<Guitarra> guitarras = new ArrayList<Guitarra>();

    public static void ObjGuitarras(){

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
        for(int i=0; i<guitarras.size();i++){
            System.out.printf("\n>> Item Nº: %d\n",i+1);
            guitarras.get(i).mostrarInfo();
        }

        System.out.printf("\nNumero de Guitarras en Stock: %d\n",guitarras.size());
        System.out.println(guitarras);
    }


    public static void imprimirCSV(String pathGuitarra) throws IOException {
        try {
            File file = new File(pathGuitarra);
            FileWriter fw = new FileWriter(file);
            BufferedWriter bw = new BufferedWriter(fw);
    
            bw.write("Stock de Teclados");
            bw.newLine();
            for(int i=0;i<guitarras.size();i++)
            {
                bw.write(guitarras.get(i+1)+", "+guitarras.get(i++));
                //bw.write(teclado.get(i).mostrarInfo());
                bw.newLine();
            }
            bw.close();
        
        }catch(IOException e){
            System.out.println(e);
                
        } catch (Exception e) {
        // TODO: handle exception
        } 
    }


    public static void LeerCSV(String pathReadGuitarra){
        CSVReader csvReader = null;
        try{
        csvReader = new CSVReader(new FileReader(pathReadGuitarra));
        String[] fila = null;
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
    
}
