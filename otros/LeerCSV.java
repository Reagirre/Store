
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

import com.opencsv.*;


public class LeerCSV {

    public static void LeerCSV(String pathReadTeclado){

        //FileReader archCSV = null;
        CSVReader csvReader = null;
        try{
        csvReader = new CSVReader(new FileReader("lib/BDTeclado.csv"));
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
    
}
