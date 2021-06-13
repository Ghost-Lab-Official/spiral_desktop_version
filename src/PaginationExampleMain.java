/*
Author: Cyebukayire Peace
Description:
.Creating frame
. Generating and inserting data into the table
* */
import javax.swing.*;
import javax.swing.table.TableModel;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class PaginationExampleMain {
    public static void main(String[] args) {
        JFrame frame = createFrame();
        JTable table = new JTable(createObjectDataModel());
        table.setAutoCreateRowSorter(true);
        PaginationDataProvider<Employee> dataProvider = createDataProvider();
        PaginatedTableDecorator<Employee> paginatedDecorator = PaginatedTableDecorator.decorate(table,
                dataProvider, new int[]{5, 10, 20, 50, 75, 100}, 10);
        frame.add(paginatedDecorator.getContentPanel());
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    private static TableModel createObjectDataModel() {
        return new ObjectTableModel<Employee>() {
            @Override
            public Object getValueAt(Employee employee, int columnIndex) {
                switch (columnIndex) {
                    case 0:
                        return employee.getId();
                    case 1:
                        return employee.getName();
                    case 2:
                        return employee.getPhoneNumber();
                    case 3:
                        return employee.getAddress();
                }
                return null;
            }

            @Override
            public int getColumnCount() {
                return 4;
            }
            @Override
            public String getColumnName(int column) {
                switch (column) {
                    case 0:
                        return "Id";
                    case 1:
                        return "Name";
                    case 2:
                        return "Phone";
                    case 3:
                        return "Address";
                }
                return null;
            }
        };
    }

    //Inserting data into the table
    private static PaginationDataProvider<Employee> createDataProvider() {

        final List<Employee> list = new ArrayList<>();
        for (int i = 1; i <= 500; i++) {
            Employee e = new Employee();
            e.setId(i);
            e.setName("name" + i);
            e.setPhoneNumber("phone" + i);
            e.setAddress("address " + i);
            list.add(e);
        }

        return new PaginationDataProvider<Employee>() {
            @Override
            public int getTotalRowCount() {
                return list.size();
            }

            @Override
            public List<Employee> getRows(int startIndex, int endIndex) {
                return list.subList(startIndex, endIndex);
            }
        };
    }

    private static JFrame createFrame() {
        JFrame frame = new JFrame("JTable Pagination");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(new Dimension(600, 300));
        return frame;
    }
}