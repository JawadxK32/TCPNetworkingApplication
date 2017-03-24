import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.net.*;
import javax.swing.*;
/**
 * GetListener class that responds to the client input according.
 */
public class GetListener implements ActionListener {

  TextField tf;

  public GetListener(TextField tf) {
    this.tf = tf;
  }

  /**
   * this method will be called when the user presses the button and
   * it constructs a TCPClient to communicate with the TCPServer. 
   * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
   **/
  public void actionPerformed(ActionEvent e) {
	 //Start of the try block
	 try{
		
		 Socket socket = new Socket("localhost",8888);//create client socket that connects to server
		 String textField = tf.getText(); //gets the text in TextField and stores a in String Variable 
		 BufferedReader inFromUser = new BufferedReader(new InputStreamReader(socket.getInputStream())); // create inputStream
		 PrintStream out = new PrintStream(socket.getOutputStream()); //create output stream attached to socket
		 out.println(textField); //send to server whatever the client types in the gui's TextField.
	        
		 InputStreamReader in = new InputStreamReader(socket.getInputStream());
		 BufferedReader inFromServer = new BufferedReader(in); 
		 String serverMsg = inFromServer.readLine(); //Read in a line from server
		 JOptionPane.showMessageDialog(null, serverMsg,"Server's Response",JOptionPane.PLAIN_MESSAGE);// display the server's response as a showMessageDialog on the gui. 
		 
		 
		 out.close();	
		 inFromUser.close();
		 inFromServer.close();
		 socket.close();
		 
	 }
	 //Catching if an exception occurs and simply displaying the error.
	 catch(Exception exception){
			System.out.println("exception occured in the class GetListener, in the method actionPerformed");
			exception.printStackTrace();
		}
  }
}