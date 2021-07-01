package client.pages;
import client.ClientMain.ClientServerConnector;
import server.Server.Model.Billing;
import server.Server.Model.RequestBody;
import server.Server.Model.ResponseBody;
import javax.swing.*;
import javax.swing.table.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Arrays;
import java.util.List;
class BillingTable extends JFrame {
    private static final Color themeColor = Color.decode("#3674D0");
    JFrame window;
    Box verticalBox;
    JLabel spiralText, otherText;
    JMenu home, about,help;
    JTable table;
    JMenuItem i1, i2, i3, i4, i5;
    JPanel tablePanel, navPanel, footerPanel, buttonPanel;
    private JButton btn;
    BillingTable() throws Exception {
        super("Spiral - Billing");
        InitUI();
    }
    public void MainTable() throws Exception {
        String empty = "";
        String[] columnNames = {"Billing id","Billing name", "Billing Price","Billing Period","Status","Action"};
        RequestBody requestBody = new RequestBody();
        requestBody.setUrl("/billing");
        requestBody.setAction("selectAllBillingPlans");
        requestBody.setObject(null);
        ClientServerConnector clientServerConnector = new ClientServerConnector();
        ResponseBody responseBody = clientServerConnector.ConnectToServer(requestBody);
        Integer index = 0, Size=0;
        for(Object response : responseBody.getResponse()){
            Size++;
        }
        String data[][] = new String[Size][6];
        for(Object response : responseBody.getResponse()){
            Billing response1 = (Billing) response;
            data[index][0] = String.valueOf(response1.getBilling_id());
            data[index][1] = response1.getBilling_name();
            data[index][2] = String.valueOf(response1.getPrice());
            data[index][3] = String.valueOf(response1.getBilling_period());
            data[index][4] = response1.getBilling_status();
            data[index][5] = empty;
            index++;
        }
        DefaultTableModel model = new DefaultTableModel(data, columnNames) {
            @Override public Class<?> getColumnClass(int column) {
                return getValueAt(0, column).getClass();
            }
        };
        table = new JTable();
        table = new JTable(model) {
            @Override
            public void updateUI() {
                super.updateUI();
                setRowHeight(40);
                setAutoCreateRowSorter(true);
                TableColumn column = getColumnModel().getColumn(5);
                column.setCellRenderer(new ButtonsRenderer());
                column.setCellEditor(new ButtonsEditor(this));
            }
        };
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment( JLabel.CENTER );
        table.setDefaultRenderer(String.class, centerRenderer);
    }
    public void NavUI(){
        navPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 0, 0));
        JMenuBar mb=new JMenuBar();
        home=new JMenu("Home");
        about=new JMenu("About");
        help=new JMenu("Help");
        mb.add(home);
        mb.add(about);
        mb.add(help);
        navPanel.setBorder(BorderFactory.createEmptyBorder(10, 5, 10,5));
        navPanel.add(mb);
        navPanel.setBackground(themeColor);
        navPanel.setMaximumSize(new Dimension(Integer.MAX_VALUE, navPanel.getMinimumSize().height));
    }
    public void FooterUI(){
        footerPanel = new JPanel();
        otherText = new JLabel("Footer Buttons and text goes here.");
        footerPanel.add(otherText);
        footerPanel.setBackground(Color.white);
        tablePanel.setMaximumSize(new Dimension(Integer.MAX_VALUE, tablePanel.getMinimumSize().height));
    }
    public void ButtonUI(){
        buttonPanel = new JPanel();
        btn = new JButton("+ New Billing Plan");
        btn.setBounds(510,600,90,40);
        btn.setBackground(themeColor);
        btn.setForeground(Color.WHITE);
        btn.setFont(new Font("verdana", Font.PLAIN, 15));
        btn.addActionListener(
                e -> {
                    window.setVisible(false);
                    try {
                        new RegisterBill();
                    } catch (Exception exception) {
                        window.setVisible(true);
                        exception.printStackTrace();
                    }
                }
        );
        otherText = new JLabel("View Billing Plans.");
        buttonPanel.add(otherText);
        buttonPanel.add(btn);
        buttonPanel.setBackground(Color.white);
        buttonPanel.setMaximumSize(new Dimension(Integer.MAX_VALUE, buttonPanel.getMinimumSize().height));
    }
    public  void  TableUI() throws Exception {
        tablePanel = new JPanel(new BorderLayout());
        MainTable();
        tablePanel.add(new JScrollPane(table));
        tablePanel.setBackground(Color.white);
        tablePanel.setMaximumSize(new Dimension(Integer.MAX_VALUE, tablePanel.getMinimumSize().height));
    }
    public  void  InitUI() throws Exception {
        verticalBox = Box.createVerticalBox();
        TableUI();
        ButtonUI();
        FooterUI();
        NavUI();
        verticalBox.add(navPanel);
        verticalBox.add(buttonPanel);
        verticalBox.add(tablePanel);
        verticalBox.add(footerPanel);
        verticalBox.add(Box.createHorizontalGlue());
        window = new JFrame();
        window.setLayout(null);
        window.setContentPane(verticalBox);
        window.setSize(1000,500);
        window.setVisible(true);
    }
    public static void main(String[] args) throws Exception {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
            ex.printStackTrace();
            Toolkit.getDefaultToolkit().beep();
        }
        new BillingTable();
    }
}
class ButtonsPanel extends JPanel {
    private final java.util.List<JButton> buttons = Arrays.asList(new JButton("view"), new JButton("Delete"));
    protected ButtonsPanel() {
        super();
        setOpaque(true);
        for (JButton b : buttons) {
            b.setFocusable(false);
            b.setRolloverEnabled(false);
            add(b);
        }
    }
    protected java.util.List<JButton> getButtons() {
        return buttons;
    }
}
class ButtonsRenderer implements TableCellRenderer {
    private final ButtonsPanel panel = new ButtonsPanel() {
        @Override public void updateUI() {
            super.updateUI();
            setName("Table.cellRenderer");
        }
    };
    @Override public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        panel.setBackground(isSelected ? table.getSelectionBackground() : table.getBackground());
        return panel;
    }
}
class ViewAction extends AbstractAction {
    private final JTable table;
    protected ViewAction(JTable table) {
        super("view");
        this.table = table;
    }
    @Override public void actionPerformed(ActionEvent e) {
        JOptionPane.showMessageDialog(table, "Viewing");
    }
}
class EditAction extends AbstractAction {
    private final JTable table;
    protected EditAction(JTable table) {
        super("Delete");
        this.table = table;
    }
    @Override public void actionPerformed(ActionEvent e) {
        // Object o = table.getModel().getValueAt(table.getSelectedRow(), 0);
        int row = table.convertRowIndexToModel(table.getEditingRow());
        Object id = table.getModel().getValueAt(row, 0);
        JOptionPane.showMessageDialog(table, "Are you sure you want to delete this.");
    }
}
// delegation pattern
class ButtonsEditor extends AbstractCellEditor implements TableCellEditor {
    protected final ButtonsPanel panel = new ButtonsPanel();
    protected final JTable table;
    private class EditingStopHandler extends MouseAdapter implements ActionListener {
        @Override public void mousePressed(MouseEvent e) {
            Object o = e.getSource();
            if (o instanceof TableCellEditor) {
                actionPerformed(new ActionEvent(o, ActionEvent.ACTION_PERFORMED, ""));
            } else if (o instanceof JButton) {
                // DEBUG: view button click -> control key down + edit button(same cell) press -> remain selection color
                ButtonModel m = ((JButton) e.getComponent()).getModel();
                if (m.isPressed() && table.isRowSelected(table.getEditingRow()) && e.isControlDown()) {
                    panel.setBackground(table.getBackground());
                }
            }
        }
        @Override public void actionPerformed(ActionEvent e) {
            EventQueue.invokeLater(ButtonsEditor.this::fireEditingStopped);
        }
    }
    protected ButtonsEditor(JTable table) {
        super();
        this.table = table;
        List<JButton> list = panel.getButtons();
        list.get(0).setAction(new ViewAction(table));
        list.get(1).setAction(new EditAction(table));
        EditingStopHandler handler = new EditingStopHandler();
        for (JButton b : list) {
            b.addMouseListener(handler);
            b.addActionListener(handler);
        }
        panel.addMouseListener(handler);
    }
    @Override public Component getTableCellEditorComponent(JTable tbl, Object value, boolean isSelected, int row, int column) {
        panel.setBackground(tbl.getSelectionBackground());
        return panel;
    }
    @Override public Object getCellEditorValue() {
        return "";
    }
}