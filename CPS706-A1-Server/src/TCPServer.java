import java.io.*;
import java.net.*;
import java.text.*;
import java.util.*;

/**
 * @authors Jawad Khudadad #500526749 Section 03
 * Farzad Vafaeinezhad #500583434 
 * Evgeny Krupchenko #500567156
 * 
 *TCP Server class that constructs and executes the server in oder to communicate with the Client. 
 */
public class TCPServer {
    
	/**
	 * The main class of the server that creates a new Instance of the TCPServer and calls the method
	 * run on it.
	 * @param args
	 * @throws Exception
	 */
	public static void main(String[] args) throws Exception {
		
		TCPServer server = new TCPServer();
		server.run();

	}
	
	/**
	 * This method constructs the TCPServer in order to communicate with the client
	 * over the network and send either the current date or the current time based on 
	 * the client's choice.
	 */
	public void run() {
		
		try{
			
			ServerSocket s_socket = new ServerSocket(8888); //Create serverSocket at port 8888
			while(true){
			Socket socket = s_socket.accept(); //Wait on welcoming socket for contact by client
			InputStreamReader in = new InputStreamReader(socket.getInputStream()); 
			BufferedReader br = new BufferedReader(in); //Create input stream, attached to socket
			PrintStream out = new PrintStream(socket.getOutputStream());
			Date time = new Date();
			SimpleDateFormat sdf = new SimpleDateFormat("hh:mm:ss"); //Formating the time as hh:mm:ss.
			SimpleDateFormat sdf2 = new SimpleDateFormat("MM/dd/yyyy"); //Formating the date as MM/dd/yyyy.
		
			String msg = br.readLine(); //Read in line from client's Socket
	
			while(msg != null){
	         if(msg.toLowerCase().equals("time")){
				out.println("Current Time: "+sdf.format(time)); //Send to Client's socket current time with specified format.
				}
				else if(msg.toLowerCase().equals("date")){
				out.println("Current Date: "+sdf2.format(time)); //Send to Client's socket current date with specified format.
				}
				else{
					out.println("Invalid Input, Please enter (\"date\" or \"time\")");
				}
			}
		
		
		
		out.close();
		in.close();
		socket.close();
		s_socket.close();
	    }	
		}
		
		//Catching if an exception occurs and displaying the error message.
		catch(Exception exception){
			System.out.println("exception occured in the class TCPServer, in the method run");
			exception.printStackTrace();
		}
	}

}
