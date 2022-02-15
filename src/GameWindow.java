import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import javax.swing.JTable;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;
import javax.swing.Box;
import javax.swing.JTextField;

public class GameWindow {

  private JFrame frmEntryTerminal;
  private Box horizontalBox;
  private Box verticalBox;
  private Box verticalBox_1;
  private JScrollPane scrollPane;
  private JScrollPane scrollPane_1;
  private JTextField txtRedTeam;
  private JTextField txtGreenTeam;
  private JTable table;
  private JTable table_1;

  /**
   * Launch the application.
   */
  public static void main(String[] args) {
    EventQueue.invokeLater(new Runnable() {
      public void run() {
        try {
          GameWindow window = new GameWindow();
          window.frmEntryTerminal.setVisible(true);
        } catch (Exception e) {
          e.printStackTrace();
        }
      }
    });
  }

  /**
   * Create the application.
   */
  public GameWindow() {
    initialize();
  }

  /**
   * Initialize the contents of the frame.
   */
  private void initialize() {
    frmEntryTerminal = new JFrame();
    frmEntryTerminal.setTitle("Entry Terminal");
    frmEntryTerminal.setBounds(100, 100, 450, 300);
    frmEntryTerminal.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    
    String[] colNames = {"First Name", "Last Name", "Code Name"};
    Object[][] tableData = {
    		{"test1", "test2", "test3"},
    		{"test4", "test5", "test6"},
    		{"", "", ""},
    		{"", "", ""},
    		{"", "", ""},
    		{"", "", ""},
    		{"", "", ""},
    		{"", "", ""},
    		{"", "", ""},
    		{"", "", ""},
    		{"", "", ""},
    		{"", "", ""},
    		{"", "", ""},
    		{"", "", ""} };
    
    JLabel screenLabel = new JLabel("Edit Current Game");
    screenLabel.setHorizontalAlignment(SwingConstants.CENTER);
    frmEntryTerminal.getContentPane().add(screenLabel, BorderLayout.NORTH);
    
    horizontalBox = Box.createHorizontalBox();
    frmEntryTerminal.getContentPane().add(horizontalBox, BorderLayout.CENTER);
    
    verticalBox = Box.createVerticalBox();
    horizontalBox.add(verticalBox);
    
    txtRedTeam = new JTextField();
    txtRedTeam.setForeground(new Color(255, 255, 255));
    txtRedTeam.setBackground(new Color(128, 0, 0));
    txtRedTeam.setToolTipText("Enter team name for red team.");
    txtRedTeam.setMaximumSize(new Dimension(2147483647, 14));
    txtRedTeam.setText("Red Team");
    verticalBox.add(txtRedTeam);
    txtRedTeam.setColumns(10);
    
    scrollPane = new JScrollPane();
    verticalBox.add(scrollPane);
    
    table = new JTable(tableData, colNames);
    scrollPane.setViewportView(table);
    
    verticalBox_1 = Box.createVerticalBox();
    horizontalBox.add(verticalBox_1);
    
    txtGreenTeam = new JTextField();
    txtGreenTeam.setBackground(new Color(0, 128, 0));
    txtGreenTeam.setForeground(new Color(255, 255, 255));
    txtGreenTeam.setToolTipText("Enter name for green team");
    txtGreenTeam.setMaximumSize(new Dimension(2147483647, 14));
    txtGreenTeam.setText("Green Team");
    verticalBox_1.add(txtGreenTeam);
    txtGreenTeam.setColumns(10);
    
    scrollPane_1 = new JScrollPane();
    verticalBox_1.add(scrollPane_1);
    
    table_1 = new JTable(tableData, colNames);
    scrollPane_1.setViewportView(table_1);
  }

}
