import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

/*
* Esta classe possui a implementação dos métodos que serão acessados
* remotamente pelos clientes.
*/

public class ServidorChatImpl extends java.rmi.server.UnicastRemoteObject implements ServidorChat {

    ArrayList<String> mensagens;
    int nMensagens;

    public ServidorChatImpl() throws RemoteException {
        super();
        this.mensagens = new ArrayList<String>();
    }

    public void enviarMensagemTodos(String mensagem) throws RemoteException {
        mensagens.add(mensagem);
    }

    public ArrayList<String> lerMensagem() throws RemoteException {
        return mensagens;
    }

}
