import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ImprimirCsv extends BDTeclado{


    public static void ImprimirCsv_Teclado(String pathTeclado) throws IOException{
        try {
                File file = new File(pathTeclado);
                FileWriter fw = new FileWriter(file);
                BufferedWriter bw = new BufferedWriter(fw);

                bw.write("Stock de Teclados");
                bw.newLine();
                for(int i=0;i<teclados.size();i++)
                {
                    bw.write(pathTeclado);
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


    public static void ImprimirCsv_Teclado2(String pathTeclado) throws IOException{
        try {
                File file = new File(pathTeclado);
                FileWriter fw = new FileWriter(file);
                BufferedWriter bw = new BufferedWriter(fw);

                bw.write("Stock de Teclados");
                bw.newLine();
                for(int i=0;i<teclados.size();i++)
                {
                    bw.write(pathTeclado);
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


}