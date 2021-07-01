    package client.Category;

    import client.ClientMain.ClientServerConnector;
import client.resultDetails.CommentPanel;
import server.Server.Model.RequestBody;
import server.Server.Model.ResponseBody;
    import server.Server.Model.SpotCategory;

    import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

    public class CategoryButtons {
        private JFrame window;
        private JPanel panel1;
        private JPanel panel2;

        private JLabel titleView;

        private JButton levelButton;
        private JButton categoryButton;

        private JTable categoriesTable;

        public CategoryButtons() throws Exception {
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

        public void loadCategoryTable() throws Exception{
            /* Get all registered categories */
            RequestBody requestBody = new RequestBody();
            requestBody.setUrl("/sportCategory");
            requestBody.setAction("getAll");
            requestBody.setObject(null);

            ClientServerConnector clientServerConnector = new ClientServerConnector();
            ResponseBody responseBody=  clientServerConnector.ConnectToServer(requestBody);

            panel2 = new JPanel();
            panel2.setBounds(50, 110, 1175, 400);

            categoriesTable = new JTable();
            String[] columns = {"Category id","User id","Category name", "Description"};
            DefaultTableModel model = new DefaultTableModel();
            model.setColumnIdentifiers(columns);
            categoriesTable.setModel(model);

            for (Object response: responseBody.getResponse()){
                SpotCategory spotCategory = (SpotCategory) response;
                ImageIcon delete = createImageIcon("/client/images/delete.png","delete");
                model.addRow(new Object[]{String.valueOf(spotCategory.getCategoryId()),String.valueOf(spotCategory.getUserId()),String.valueOf(spotCategory.getCategoryName()),String.valueOf(spotCategory.getDescription()),delete});
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

        public void CategoriesInit() throws Exception {
            window = new JFrame("Categories buttons");
            window.setSize(1375, 735);
            window.setLayout(null);
            window.setBackground(Color.decode("#F2F6FF"));

            panel1 = new JPanel();
            panel1.setBounds(0, 10, 1375, 100);


            titleView = new JLabel("Spot Categories", JLabel.NORTH_EAST);
            titleView.setFont(new Font("Nunito", Font.BOLD, 20));
            titleView.setForeground(Color.decode("#3674D0"));
            panel1.add(titleView);
            panel1.add(Box.createHorizontalStrut(700));



            categoryButton = new JButton(" + Add Spot Category");
            categoryButton.setBackground(Color.decode("#3674D0"));
            categoryButton.setBorder(null);
            categoryButton.setFont(new Font("Nunito", Font.BOLD, 15));
            categoryButton.setForeground(Color.WHITE);
            categoryButton.setFocusPainted(false);
//            panel1.add(categoryButton);
            loadCategoryTable();
            window.add(panel1, BorderLayout.NORTH);
            window.add(panel2, BorderLayout.NORTH);
            window.setVisible(true);
        }



        public static void main(String[] args) throws Exception {

            new CategoryButtons();
        }
    }
