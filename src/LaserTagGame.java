import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.BorderLayout;

public class LaserTagGame extends JFrame {

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
			Thread.sleep(2500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
  	
  	// Show entry terminal screen
  	setContentPane(new EntryTerminal());
  	setVisible(true);
  	setTitle("Entry Terminal");
  }

}
