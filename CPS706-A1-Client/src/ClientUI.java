import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 * Client Class that construct the required GUI for the client. 
 */
public class ClientUI {
	
	/**
	 * Main Class of the client that creates a new instance of ClientUI and executes it.  
	 * @param args
	 * @throws Exception
	 */
	public static void main(String[] args) throws Exception {
		
		new ClientUI();
	
	}
	  Frame frame; 
	  TextField textField; 
	  JLabel jl; 
	  Button button; 
	  
	  /**
	   * Default constructor for ClientUI that constructs the 
	   * GUI window and Initialize the proper needed Variables.
	   */
	  public ClientUI() { 
		  
	    frame = new Frame(); 
	    frame.setTitle("Client GUI");
	    frame.setBackground(Color.CYAN);
	    frame.setLayout(new FlowLayout());
	    jl = new JLabel("ENTER \"date\" FOR THE CURRENT DATE OR \"time\" FOR THE CURRENT TIME.");
	    jl.setForeground(Color.black);
	    jl.setFont(new Font("Arial",Font.BOLD,15));
	    textField = new TextField(30); 
	    textField.setFont(new Font("Arial",Font.BOLD,15));
	    button = new Button("ENTER"); 
	    button.addActionListener(new GetListener(textField));
	    frame.add(jl);
	    frame.add(textField); 
	    frame.add(button); 
	    frame.setSize(640, 300);
	    frame.show(); 
	    
	    //add the windowlistener that will exit the program when the user closes the window
	    frame.addWindowListener(new WindowAdapter() {
	        
	    /*
	     * This method is called after a window is closed
	     * @see java.awt.event.WindowAdapter#windowClosing(java.awt.event.WindowEvent)
	     */
	        public void windowClosing(WindowEvent evt) {
	            System.exit(0);
	        }
	    });
	    
	  }
	  
}