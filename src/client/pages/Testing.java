package client.pages;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Arrays;
import java.util.List;

class Tabless extends JFrame {
    JFrame window;
    Box verticalBox;
    JLabel spiralText, otherText;
    JMenu home, about,help;
    JTable table;
    JMenuItem i1, i2, i3, i4, i5;
    JPanel tablePanel, navPanel, footerPanel, buttonPanel;

    Tabless(){
        super("Spiral - Billing");
        InitUI();
    }

    public void MainTable() {
        String empty = "";
        String[] columnNames = {"Billing id","Billing name", "Billing Price","Billing Period","Status","Action"};
        Object[][] data = {
                {"Billing id","Billing name", "Billing Price","Billing Period","Status", empty},
                {"Billing id","Billing name", "Billing Price","Billing Period","Status", empty},
                {"Billing id","Billing name", "Billing Price","Billing Period","Status", empty},
        };
        DefaultTableModel model = new DefaultTableModel(data, columnNames) {
            @Override public Class<?> getColumnClass(int column) {
                return getValueAt(0, column).getClass();
            }
        };
        table = new JTable(model) {
            @Override
            public void updateUI() {
                super.updateUI();
                setRowHeight(36);
                setAutoCreateRowSorter(true);

                TableColumn column = getColumnModel().getColumn(5);
                column.setCellRenderer(new ButtonsRenderer());
                column.setCellEditor(new ButtonsEditor(this));
            }
        };
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
        navPanel.setBackground(Color.green);
        navPanel.setMaximumSize(new Dimension(Integer.MAX_VALUE, navPanel.getMinimumSize().height));
    }
    public void FooterUI(){
      footerPanel = new JPanel();
    }
    public void ButtonUI(){
        buttonPanel = new JPanel();
        otherText = new JLabel("Buttons and text goes here.");
        buttonPanel.add(otherText);
        buttonPanel.setBackground(Color.blue);
        buttonPanel.setMaximumSize(new Dimension(Integer.MAX_VALUE, buttonPanel.getMinimumSize().height));
    }
    public  void  TableUI(){
        tablePanel = new JPanel(new BorderLayout());
        MainTable();
        tablePanel.add(new JScrollPane(table));
        tablePanel.setBackground(Color.white);
        tablePanel.setMaximumSize(new Dimension(Integer.MAX_VALUE, tablePanel.getMinimumSize().height));
    }

    public  void  InitUI(){
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
        window.setSize(900,500);
        window.setVisible(true);
    }

    public static void main(String[] args) {

        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
            ex.printStackTrace();
            Toolkit.getDefaultToolkit().beep();
        }

        new Tabless();
    }
}


class ButtonsPanel extends JPanel {
    private final java.util.List<JButton> buttons = Arrays.asList(new JButton("view"), new JButton("edit"));

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
        super("edit");
        this.table = table;
    }

    @Override public void actionPerformed(ActionEvent e) {
        // Object o = table.getModel().getValueAt(table.getSelectedRow(), 0);
        int row = table.convertRowIndexToModel(table.getEditingRow());
        Object o = table.getModel().getValueAt(row, 0);
        JOptionPane.showMessageDialog(table, "Editing: " + o);
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
