package dao;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import org.apache.catalina.realm.NestedCredentialHandler;

import model.Client;

public class ClientDao {

	public void addClient(Client client) {
		
		ArrayList<Client> listeClients = (getListeClients() == null) ? new ArrayList<Client>() : getListeClients(); 
		listeClients.add(client);	
		try {
			FileOutputStream fs = new FileOutputStream("C:\\Users\\Yohann\\Desktop\\listeClients.txt");
			ObjectOutputStream os = new ObjectOutputStream(fs);
			os.writeObject(listeClients);
			os.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public Client getClient() {
		try {
			FileInputStream fis = new FileInputStream("C:\\Users\\Yohann\\Desktop\\client.txt");
			ObjectInputStream ois = new ObjectInputStream(fis);
			Client client = (Client) ois.readObject();
			return client;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	

	
	
	
	public ArrayList<Client> getListeClients() {
		try {
			FileInputStream fis = new FileInputStream("C:\\Users\\Yohann\\Desktop\\listeClients.txt");
			ObjectInputStream ois = new ObjectInputStream(fis);
			ArrayList<Client> liste = (ArrayList<Client>) ois.readObject();
			ois.close();
			return liste;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
