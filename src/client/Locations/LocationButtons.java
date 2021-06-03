    package client.Locations;
    import client.resultDetails.resultDetails.CommentPanel;
    import resultDetails.CommentPanel;

    import javax.swing.*;
    import javax.swing.border.LineBorder;
    import javax.swing.table.DefaultTableCellRenderer;
    import javax.swing.table.DefaultTableModel;
    import java.awt.*;
    import java.util.ArrayList;

    public class LocationButtons {
        private JFrame window;
        private JPanel panel1;
        private JPanel panel2;

        private JLabel titleView;
        private JButton levelButton;
        private JButton locationButton;

        private JTable locationsTable;

        public LocationButtons() {
            LocationsInit();
        }
        public ImageIcon createImageIconResizeable(String path,
                                                   String description, int w, int h) {
            java.net.URL imgURL = CommentPanel.class.getResource(path);

            if (imgURL != null) {
                ImageIcon imageIcon = new ImageIcon(imgURL, description);
                Image image=imageIcon.getImage();
                Image newimg = image.getScaledInstance(w, h,  Image.SCALE_SMOOTH);
                imageIcon=new ImageIcon(newimg);
                return imageIcon;
            } else {
                System.err.println("Couldn't find file: " + path);
                return null;
            }
        }
        public ImageIcon createImageIcon(String path,
                                         String description) {
            java.net.URL imgURL = CommentPanel.class.getResource(path);

            if (imgURL != null) {
                ImageIcon imageIcon = new ImageIcon(imgURL, description);
                Image image=imageIcon.getImage();
                Image newimg = image.getScaledInstance(20, 20,  Image.SCALE_SMOOTH);
                imageIcon=new ImageIcon(newimg);
                return imageIcon;
            } else {
                System.err.println("Couldn't find file: " + path);
                return null;
            }
        }

        public void loadLocationTable(){
            ImageIcon delete = createImageIcon("/images/si-delete.png","delete");
            JLabel deleteIcon = new JLabel(delete);
            deleteIcon.setBounds(140,10,40,25);
//            JButton deleteButton = new JButton((Action) deleteIcon);
            String[][] locationsData = {
                    {"Nyabihu", "2.5547° S, 29.6035° E", "rwanda coding academy is a school i...","Active"},
                    {"Nyabihu", "2.5547° S, 29.6035° E", "Nyirangarama products","Active"},
                    {"Nyabihu", "2.5547° S, 29.6035° E", "gender is the concept that is still not un...","Active"},
                    {"Nyabihu", "2.5547° S, 29.6035° E", "balanced diet is on a good level in rwanda c..","Active"},
                    {"Nyabihu", "2.5547° S, 29.6035° E", "balanced diet is on a good level in rwanda c..","Active"},
                    {"Nyabihu", "2.5547° S, 29.6035° E", "Books that talk abount different subjects","Active"},
                    {"Nyabihu", "2.5547° S, 29.6035° E", "huye waterfall provides water for huye people","Active"}
            };

            panel2 = new JPanel();
            panel2.setBounds(50, 110, 1175, 400);

            locationsTable = new JTable();
            String[] columns = {"Location","GPS","Description", "Status","Action"};
            DefaultTableModel model = new DefaultTableModel();
            model.setColumnIdentifiers(columns);
            locationsTable.setModel(model);
            for (int i = 0; i < locationsData.length; i++) {
                String[] currentRow = locationsData[i];
                model.addRow(new Object[]{currentRow[0],currentRow[1],currentRow[2],currentRow[3]});
            }

            JScrollPane sp = new JScrollPane(locationsTable);
            locationsTable.setRowHeight(50);
            locationsTable.setBorder(new LineBorder(Color.WHITE));
            locationsTable.setShowVerticalLines(false);
            locationsTable.setIntercellSpacing(new Dimension(0,0));
            locationsTable.getTableHeader().setBackground(Color.WHITE);
            locationsTable.getTableHeader().setPreferredSize(new Dimension(sp.getWidth(),40));
            locationsTable.getTableHeader().setFont(new Font("Nunito",Font.BOLD,14));

            for(int i=0; i < locationsTable.getColumnCount(); i++) {
                if (i != 2) {
                    DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
                    centerRenderer.setHorizontalAlignment(JLabel.CENTER);
                    locationsTable.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
                }
            }
            sp.setPreferredSize(new Dimension(1175,400));

            panel2.setBackground(Color.WHITE);
            panel2.add(sp);
        };

        public void LocationsInit() {
            window = new JFrame("Location buttons");
            window.setSize(1375, 735);
            window.setLayout(null);
            window.setBackground(Color.decode("#F2F6FF"));

            panel1 = new JPanel();
            panel1.setBounds(0, 10, 1375, 100);
    //      panel1.setBackground(Color.blue);


            titleView = new JLabel("View Locations", JLabel.NORTH_EAST);
            titleView.setFont(new Font("Nunito", Font.BOLD, 20));
            titleView.setForeground(Color.decode("#3674D0"));
            panel1.add(titleView);
            panel1.add(Box.createHorizontalStrut(700));

            levelButton = new JButton(" + Add Level ");
            levelButton.setBackground(Color.decode("#CCCCCD"));
            levelButton.setBorder(null);
            levelButton.setFont(new Font("Nunito", Font.BOLD, 15));
            levelButton.setForeground(Color.decode("#323232"));
//            levelButton.setBorder(new RoundedBorder(10));
            levelButton.setFocusPainted(false);
            panel1.add(levelButton);
            panel1.add(Box.createHorizontalStrut(7));


            locationButton = new JButton(" + Add Location ");
            locationButton.setBackground(Color.decode("#3674D0"));
            locationButton.setBorder(null);
            locationButton.setFont(new Font("Nunito", Font.BOLD, 15));
            locationButton.setForeground(Color.WHITE);
//            locationButton.setBorder(new RoundedBorder(10));
            locationButton.setFocusPainted(false);
            panel1.add(locationButton);
            loadLocationTable();
            window.add(panel1, BorderLayout.NORTH);
            window.add(panel2, BorderLayout.NORTH);
            window.setVisible(true);
        }

 

        public static void main(String[] args) {

            new LocationButtons();
        }
    }
