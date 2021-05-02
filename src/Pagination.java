import javax.swing.*;
import java.awt.*;

public class Pagination {
    private JFrame mainWindow;
    private Label header;
    public Pagination() {UIInit();}
    public void UIInit(){
        mainWindow = new JFrame("Pagination Window");
        header = new Label("Display Available spots");
//        mainWindow.add(header);
        mainWindow.getContentPane().add(header);
        mainWindow.setSize(400,500);
        mainWindow.setVisible(true);
    }
    public static void main(String [] args){
        Pagination UI = new Pagination();
    }
}
