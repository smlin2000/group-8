import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JTable;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;
import javax.swing.Box;
import javax.swing.JTextField;

public class EntryTerminal extends JPanel {

  private Box horizontalBox;
  private Box verticalBoxRed;
  private Box verticalBoxGreen;
  private JScrollPane scrollPaneRed;
  private JScrollPane scrollPaneGreen;
  private JTextField txtRedTeam;
  private JTextField txtGreenTeam;
  private JTable tableRed;
  private JTable tableGreen;

  /**
   * A JPanel containing player entry screen components
   */
  public EntryTerminal() {
    initialize();
  }

  /**
   * Initialize the contents of the panel.
   */
  private void initialize() {
    
  	// Initial data for tables
    String[] colNames = {"Player ID", "Code Name"};
    Object[][] tableData = {
    		{"test1", "test2"},
    		{"test4", "test5"},
    		{"", ""},
    		{"", ""},
    		{"", ""},
    		{"", ""},
    		{"", ""},
    		{"", ""},
    		{"", ""},
    		{"", ""} };
    
    setLayout(new BorderLayout(0, 0));
    
    // Label at top of screen
    JLabel screenLabel = new JLabel("Edit Current Game");
    screenLabel.setHorizontalAlignment(SwingConstants.CENTER);
    add(screenLabel);
    
    // Box horizontally arranging left and right halves of the screen
    horizontalBox = Box.createHorizontalBox();
    add(horizontalBox);
    
    // Vertical box containing red team contents
    verticalBoxRed = Box.createVerticalBox();
    horizontalBox.add(verticalBoxRed);
    
    // Textbox labeling red team table
    txtRedTeam = new JTextField();
    txtRedTeam.setForeground(new Color(255, 255, 255));
    txtRedTeam.setBackground(new Color(128, 0, 0));
    txtRedTeam.setToolTipText("Enter team name for red team.");
    txtRedTeam.setMaximumSize(new Dimension(2147483647, 14));
    txtRedTeam.setText("Red Team");
    verticalBoxRed.add(txtRedTeam);
    txtRedTeam.setColumns(10);
    
    // Scrollpane that red team table is contained in
    scrollPaneRed = new JScrollPane();
    verticalBoxRed.add(scrollPaneRed);
    
    // Red team table
    tableRed = new JTable(tableData, colNames);
    scrollPaneRed.setViewportView(tableRed);
    
    // Vertical box containing green team contents
    verticalBoxGreen = Box.createVerticalBox();
    horizontalBox.add(verticalBoxGreen);
    
    // Textbox labeling green team label
    txtGreenTeam = new JTextField();
    txtGreenTeam.setBackground(new Color(0, 128, 0));
    txtGreenTeam.setForeground(new Color(255, 255, 255));
    txtGreenTeam.setToolTipText("Enter name for green team");
    txtGreenTeam.setMaximumSize(new Dimension(2147483647, 14));
    txtGreenTeam.setText("Green Team");
    verticalBoxGreen.add(txtGreenTeam);
    txtGreenTeam.setColumns(10);
    
    // Scrollpane that green team table is contained in
    scrollPaneGreen = new JScrollPane();
    verticalBoxGreen.add(scrollPaneGreen);
    
    // Green team table
    tableGreen = new JTable(tableData, colNames);
    scrollPaneGreen.setViewportView(tableGreen);
  }

}
