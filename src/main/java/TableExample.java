import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

/**
 * Created by pavel on 14.05.17.
 */
public class TableExample {

    JTable table;

    TableExample(final List<Log> logs) {
        JFrame jFrame = new JFrame();
        jFrame.setTitle("Мой любимый парсер, чтоб я без него делала");
        try {
            jFrame.setIconImage(new ImageIcon(new URL("http://interesting-information.ru/wp-content/uploads/2015/06/%D0%A4%D0%BE%D1%82%D0%BE1-%D0%9B%D0%B8%D1%81%D0%B8%D1%86%D0%B0-%D0%BE%D0%B1%D1%8B%D0%BA%D0%BD%D0%BE%D0%B2%D0%B5%D0%BD%D0%BD%D0%B0%D1%8F.jpg")).getImage());
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        jFrame.getContentPane().setLayout(new FlowLayout());
        jFrame.setSize(jFrame.getMaximumSize());
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.setSize((new Dimension(1280,540)));
        TableModelImpl tableModel = new TableModelImpl(logs);
        table = new JTable(tableModel){
            @Override
            public String getToolTipText(MouseEvent mouseEvent) {
                String tip = null;
                java.awt.Point p = mouseEvent.getPoint();
                int rowIndex = rowAtPoint(p);
                int colIndex = columnAtPoint(p);

                try {
                    //comment row, exclude heading
                    if(rowIndex >= 0){
                        tip = getValueAt(rowIndex, colIndex).toString();
                    }
                } catch (RuntimeException e1) {
                    //catch null pointer exception if mouse is over an empty line
                }

                return tip;
            }
        };
        JScrollPane pane = new JScrollPane(table);
        table.setPreferredScrollableViewportSize(new Dimension(1250,500));
        jFrame.getContentPane().add(pane);
        jFrame.setVisible(true);
        table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        table.getColumnModel().getColumn(0).setPreferredWidth(95);
        table.getColumnModel().getColumn(1).setPreferredWidth(200);
        table.getColumnModel().getColumn(2).setPreferredWidth(50);
        table.getColumnModel().getColumn(5).setPreferredWidth(100);
        table.getColumnModel().getColumn(6).setPreferredWidth(800);
    }
}
