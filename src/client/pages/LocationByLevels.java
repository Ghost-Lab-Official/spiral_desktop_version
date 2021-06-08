package client.pages;

import client.resultDetails.CommentPanel;

import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class LocationByLevels {
    private JFrame window;
    private JPanel panel1;
    private JPanel panel2;

    private JLabel titleView;

    private JButton levelButton;
    private JButton categoryButton;

    private JTable categoriesTable;

    public LocationByLevels() {
        CategoriesInit();
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

    public void loadCategoryTable(){
//            ImageIcon delete = createImageIcon("/images/si-delete.png","delete");
//            JLabel deleteIcon = new JLabel(delete);
//            deleteIcon.setBounds(140,10,40,25);
//            JButton deleteButton = new JButton((Action) deleteIcon);
        String[][] locationsData = {
                {"1", "1000", "rwanda coding academy","rwanda coding academy is a school i...","Active"},
                {"2", "1001", "Nyirangarama products","Nyirangarama products","Active"},
                {"3", "1002", "gender balance","gender is the concept that is still not un...","Active"},
                {"4", "1003", "balanced diet ","balanced diet is on a good level in rwanda c..","Active"},
                {"5", "1004", "balanced diet ","balanced diet is on a good level in rwanda c..","Active"},
                {"6", "1005", "Books ","Books that talk abount different subjects","Active"},
                {"7", "1006", "huye waterfall","huye waterfall provides water for huye people","Active"}
        };

        panel2 = new JPanel();
        panel2.setBounds(50, 110, 1175, 400);

        categoriesTable = new JTable();
        String[] columns = {"Category id","User id","Category name", "Description","Action"};
        DefaultTableModel model = new DefaultTableModel();
        model.setColumnIdentifiers(columns);
        categoriesTable.setModel(model);
        for (int i = 0; i < locationsData.length; i++) {
            String[] currentRow = locationsData[i];
            ImageIcon delete = createImageIcon("/client/images/delete.png","delete");
            model.addRow(new Object[]{currentRow[0],currentRow[1],currentRow[2],currentRow[3],delete});
        }

        JScrollPane sp = new JScrollPane(categoriesTable);
        categoriesTable.setRowHeight(50);
        categoriesTable.setBorder(new LineBorder(Color.WHITE));
        categoriesTable.setShowVerticalLines(false);
        categoriesTable.setIntercellSpacing(new Dimension(0,0));
        categoriesTable.getTableHeader().setBackground(Color.WHITE);
        categoriesTable.getTableHeader().setPreferredSize(new Dimension(sp.getWidth(),40));
        categoriesTable.getTableHeader().setFont(new Font("Nunito",Font.BOLD,14));

        for(int i = 0; i < categoriesTable.getColumnCount(); i++) {
            if (i != 2) {
                DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
                centerRenderer.setHorizontalAlignment(JLabel.CENTER);
                categoriesTable.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
            }
        }
        sp.setPreferredSize(new Dimension(1175,400));

        panel2.setBackground(Color.WHITE);
        panel2.add(sp);
    };

    public void CategoriesInit() {
        window = new JFrame("Locations in given location level");
        window.setSize(1375, 735);
        window.setLayout(null);
        window.setBackground(Color.decode("#F2F6FF"));

        panel1 = new JPanel();
        panel1.setBounds(0, 0, 1375, 100);


        titleView = new JLabel("Locations in location levels", JLabel.NORTH_EAST);
        titleView.setFont(new Font("Nunito", Font.BOLD, 20));
        titleView.setForeground(Color.decode("#3674D0"));
        panel1.add(titleView);
        panel1.add(Box.createHorizontalStrut(700));



        categoryButton = new JButton(" + Add Location");
        categoryButton.setBackground(Color.decode("#3674D0"));
        categoryButton.setBorder(null);
        categoryButton.setFont(new Font("Nunito", Font.BOLD, 15));
        categoryButton.setForeground(Color.WHITE);
        categoryButton.setFocusPainted(false);
        panel1.add(categoryButton);
        loadCategoryTable();
        window.add(panel1, BorderLayout.NORTH);
        window.add(panel2, BorderLayout.NORTH);
        window.setVisible(true);
    }



    public static void main(String[] args) {

        new LocationByLevels();
    }
}
