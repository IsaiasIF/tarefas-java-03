import java.awt.FlowLayout;
import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.ListSelectionModel;

public class ListFrame extends JFrame {
    private JList<String> colorJList; // list to display colors
    private static final String[] colorNames = { 
        "Black", "Blue", "Cyan", "Dark Gray", "Gray", "Green", 
        "Light Gray", "Magenta", "Orange", "Pink", "Red", "White", "Yellow" 
    };
    
    private static final Color[] colors = { 
        Color.BLACK, Color.BLUE, Color.CYAN, Color.DARK_GRAY, Color.GRAY, Color.GREEN, 
        Color.LIGHT_GRAY, Color.MAGENTA, Color.ORANGE, Color.PINK, Color.RED, Color.WHITE, Color.YELLOW 
    };

    public ListFrame() {
        super("List Test");
        setLayout(new FlowLayout());  // configure the frame layout

        colorJList = new JList<>(colorNames); // create JList with color names
        colorJList.setVisibleRowCount(5); // display 5 rows at a time
        colorJList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION); // single selection only

        // Add a JScrollPane containing the JList to the frame
        add(new JScrollPane(colorJList));

        // Add a ListSelectionListener to handle the selection event
        colorJList.addListSelectionListener(new ListSelectionListener() {
            // Handle list selection event
            public void valueChanged(ListSelectionEvent event) {
                getContentPane().setBackground(colors[colorJList.getSelectedIndex()]);
            }
        });
    }

    public static void main(String[] args) {
        ListFrame frame = new ListFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 200);  // set the frame size
        frame.setVisible(true);   // make the frame visible
    }
}
