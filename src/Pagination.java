import javax.swing.*;
import java.awt.*;

public class Pagination extends JPanel {
    public Pagination(){dataTable(); paginationBtn();}
    public void dataTable() {

        String[] columnNames = {"First Name",
                "Last Name",
                "Sport",
                "# of Years",
                "Vegetarian"};

        Object[][] data = {
                {"Kathy", "Smith",
                        "Snowboarding", new Integer(5), new Boolean(false)},
                {"John", "Doe",
                        "Rowing", new Integer(3), new Boolean(true)},
                {"Sue", "Black",
                        "Knitting", new Integer(2), new Boolean(false)},
                {"Jane", "White",
                        "Speed reading", new Integer(20), new Boolean(true)},
                {"Kathy", "Smith",
                        "Snowboarding", new Integer(5), new Boolean(false)},
                {"John", "Doe",
                        "Rowing", new Integer(3), new Boolean(true)},
                {"Sue", "Black",
                        "Knitting", new Integer(2), new Boolean(false)},
                {"Jane", "White",
                        "Speed reading", new Integer(20), new Boolean(true)},
                {"Kathy", "Smith",
                        "Snowboarding", new Integer(5), new Boolean(false)},
                {"John", "Doe",
                        "Rowing", new Integer(3), new Boolean(true)},
                {"Sue", "Black",
                        "Knitting", new Integer(2), new Boolean(false)},
                {"Jane", "White",
                        "Speed reading", new Integer(20), new Boolean(true)},
                {"Kathy", "Smith",
                        "Snowboarding", new Integer(5), new Boolean(false)},
                {"John", "Doe",
                        "Rowing", new Integer(3), new Boolean(true)},
                {"Sue", "Black",
                        "Knitting", new Integer(2), new Boolean(false)},
                {"Jane", "White",
                        "Speed reading", new Integer(20), new Boolean(true)},{"Kathy", "Smith",
                "Snowboarding", new Integer(5), new Boolean(false)},
                {"John", "Doe",
                        "Rowing", new Integer(3), new Boolean(true)},
                {"Sue", "Black",
                        "Knitting", new Integer(2), new Boolean(false)},
                {"Jane", "White",
                        "Speed reading", new Integer(20), new Boolean(true)},

                {"Joe", "Brown",
                        "Pool", new Integer(10), new Boolean(false)}
        };

        final JTable table = new JTable(data, columnNames);
        table.setPreferredScrollableViewportSize(new Dimension(700, 150));
        table.setFillsViewportHeight(false);

        //Create the scroll pane and add the table to it.
        JScrollPane scrollPane = new JScrollPane(table);

        //Add the scroll pane to this panel.
        add(scrollPane);
    }

    public void paginationBtn(){

        JButton first = new JButton("First");
        JButton previous = new JButton("Previous");
        JButton page1 = new JButton("1");
        JButton page2 = new JButton("2");
        JButton page3 = new JButton("3");
        JButton page4 = new JButton("4");
        JButton next = new JButton("Next");
        JButton last = new JButton("Last");
        first.setContentAreaFilled(false);
        previous.setContentAreaFilled(false);
        page1.setContentAreaFilled(false);
        page2.setContentAreaFilled(false);
        page3.setContentAreaFilled(false);
        page4.setContentAreaFilled(false);
        next.setContentAreaFilled(false);
        last.setContentAreaFilled(false);

        add(first);
        add(previous);
        add(page1);
        add(page2);
        add(page3);
        add(page4);
        add(next);
        add(last);
    }

    private static void ShowGUI() {
        //Create and set up the window.
        JFrame frame = new JFrame("PaginationTesting");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Create and set up the content pane.
        Pagination newContentPane = new Pagination();
        newContentPane.setOpaque(true); //content panes must be opaque
        frame.setContentPane(newContentPane);

        //Display the window.
        frame.pack();
        frame.setSize(800,500);
        frame.setVisible(true);
    }



    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                ShowGUI();
            }
        });
    }
}