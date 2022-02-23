import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JTable;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.Box;
import javax.swing.JTextField;

public class EntryTerminal extends JPanel implements TableModelListener {

  private Box horizontalBox;
  private Box verticalBoxRed;
  private Box verticalBoxGreen;
  private JScrollPane scrollPaneRed;
  private JScrollPane scrollPaneGreen;
  private JTextField txtRedTeam;
  private JTextField txtGreenTeam;
  private JTable tableRed;
  private JTable tableGreen;
  DefaultTableModel greenModel;
  DefaultTableModel redModel;

  /**
   * A JPanel containing player entry screen components
   */
  public EntryTerminal() {
    // Add UI components
    initialize();
    
    // Add table listeners
    tableRed.getModel().addTableModelListener(this);
    tableGreen.getModel().addTableModelListener(this);
  }

  /**
   * Initialize the contents of the panel.
   */
  private void initialize() {
    
  	// name of columns for both player tables
    String[] columnHeaders = { "Player ID", "Codename" };
    
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
    txtRedTeam.setMaximumSize(new Dimension(2147483647, 14));
    txtRedTeam.setText("Red Team");
    verticalBoxRed.add(txtRedTeam);
    txtRedTeam.setColumns(10);
    
    // Scrollpane that red team table is contained in
    scrollPaneRed = new JScrollPane();
    verticalBoxRed.add(scrollPaneRed);
    
    // Red team table model
    redModel = new DefaultTableModel(20, 2);
    redModel.setColumnIdentifiers(columnHeaders);
    
    // Red team table
    tableRed = new JTable(redModel);
    scrollPaneRed.setViewportView(tableRed);
    
    // Vertical box containing green team contents
    verticalBoxGreen = Box.createVerticalBox();
    horizontalBox.add(verticalBoxGreen);
    
    // Textbox labeling green team label
    txtGreenTeam = new JTextField();
    txtGreenTeam.setBackground(new Color(0, 128, 0));
    txtGreenTeam.setForeground(new Color(255, 255, 255));
    txtGreenTeam.setMaximumSize(new Dimension(2147483647, 14));
    txtGreenTeam.setText("Green Team");
    verticalBoxGreen.add(txtGreenTeam);
    txtGreenTeam.setColumns(10);
    
    // Scrollpane that green team table is contained in
    scrollPaneGreen = new JScrollPane();
    verticalBoxGreen.add(scrollPaneGreen);
    
    // Green team table model
    greenModel = new DefaultTableModel(20, 2);
    greenModel.setColumnIdentifiers(columnHeaders);
    
    // Green team table
    tableGreen = new JTable(greenModel);
    scrollPaneGreen.setViewportView(tableGreen);
  }
  
  @Override
  public void tableChanged(TableModelEvent e) {
    int row = e.getFirstRow();
    int column = e.getColumn();
    TableModel model = (TableModel)e.getSource();
    Boolean redTeam = (model == redModel);
    String input = (String)model.getValueAt(row, column);
    
    // Ignore changes to header row
    if (row < 0) {
      return;
    }
    
    /*
     * TODO link data to database
     * When a table is changed, this method is called with information about the change that occurred.
     * Store the information in the database.
     * The information is set up in the following way:
     * 
     * row: (int) The row of the cell that was changed
     * column: (int) The column of the cell that was changed
     * redTeam: (boolean) True if the table that was changed is the red team's (false would presumably be the green team)
     * input: (String) The string that was entered to cause the change
     */
    
    // For testing purposes
    System.out.println("Table change detected!\n" +
        "Cell changed: (" + row + ", " + column +
        ")\nRed Team: " + redTeam +
        "\nString changed: \"" + input + "\"");
  }
}
