package ga.test.main;

import ga.test.imp.*;

public class CallBackTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        Server server = new Server(); 
        Client client = new Client(server); 
        client.sendMsg("Server,Hello~"); 

	}

}
