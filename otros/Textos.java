package otros;
import java.util.Scanner;

public class Textos extends Usuario{

    public static void main(String[] args) {
        
        String user;
        String pass;
        Scanner in = new Scanner(System.in);
        Usuario usuario = new Usuario();


        System.out.print("Ingrese Usuario: ");
        user = in.nextLine();
        usuario.setUser(user);

        System.out.print("Ingrese Password: ");
        pass = in.nextLine();
        usuario.setPass(pass);
    
        

    }
    
}
