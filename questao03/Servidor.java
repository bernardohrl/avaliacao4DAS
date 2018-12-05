import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

/*
* O registro aponta para o serviço remoto que será utilizado, ligando-o ao chat.
* Aqui o skeleton é gerado.
*/

public class Servidor {
    public Servidor(){
        try {
            Registry registry = LocateRegistry.createRegistry(1098);
            ServidorChat server = new ServidorChatImpl();
            Naming.rebind("rmi://localhost:1098/ServidorChat" , server);

        } catch (Exception e){
            System.out.println("Trouble:" + e);
        }

    }

    public static void main(String args[]) {
        new Servidor();
    }

}