package laserTag.GUI;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class LaserTagGame extends JFrame {
  
  private Socket clientSocket;
  private PrintWriter out;
  private BufferedReader in;

  public void startConnection(String ip, int port) throws IOException {
    clientSocket = new Socket(ip, port);
    out = new PrintWriter(clientSocket.getOutputStream(), true);
    in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
  }
  
  public String sendPlayerData(String msg) throws IOException {
    out.println(msg);
    String resp = in.readLine();
    return resp;
  } 

  public static void main(String[] args) {
  	new LaserTagGame();
  }
  
  public LaserTagGame() {
  	// Show Splash Screen
  	JPanel SplashScreen = new JPanel(new BorderLayout());
  	SplashScreen.add(new JLabel(new ImageIcon("logo.jpg")), BorderLayout.CENTER);
  	setContentPane(SplashScreen);
  	setBounds(50, 50, 643, 410);
  	setVisible(true);
  	setTitle("Splash Screen");
  	
  	// Sleep while showing splash screen
  	try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
  	
  	// Establish TCP connection to player data receiver
  	try {
      startConnection("localhost", 8686);
    } catch (IOException e) {
      System.out.print("Unable to establish connection to player data receiver");
      e.printStackTrace();
    }
  	
  	// Show entry terminal screen
  	setContentPane(new EntryTerminal(this));
  	setVisible(true);
  	setTitle("Entry Terminal");
  }

}
