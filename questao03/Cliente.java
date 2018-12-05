import java.rmi.*;
import javax.swing.*;
import java.util.Scanner;
import java.lang.Thread.*;
import java.util.ArrayList;
import java.rmi.RemoteException;

/*
* O cliente acessa os serviços do servidor
*/

public class Cliente {

    public static void main( String args[] ) {


        try {
            /* 
            * O stub é criado, permitindo o acesso dos cliente ao servidor remoto
            * e a utilização dos seus métodos
            */
            final ServidorChat chat = (ServidorChat) Naming.lookup("rmi://localhost:1098/ServidorChat");

            
            String nome;
            String msg = "";
            Scanner scanner = new Scanner(System.in);

            System.out.println("Registre seu nome de usuário:");
            nome = scanner.nextLine();

            Thread thread = new Thread(new Runnable() {
                int cont = chat.lerMensagem().size();
                @Override
                public void run() {
                    try {
                        while(true){
                            if (chat.lerMensagem().size() > cont){
                                System.out.println(chat.lerMensagem().get(chat.lerMensagem().size()-1));
                                cont++;
                            }
                        }
                    } catch (RemoteException e) {
                        e.printStackTrace();
                    }
                }
            });
            thread.start();

            System.out.println("\n\nDigite mensagens a todos os usuários:");


            while(msg != "sair"){

                msg = scanner.nextLine();


                /*
                * Utilização do método remoto
                */
                chat.enviarMensagemTodos(nome + ": " + msg + "\n");

            }

        }
        catch( Exception e ) {
            e.printStackTrace();
        }

    }
}