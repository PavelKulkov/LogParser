import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import java.util.List;

/**
 * Created by pavel on 14.05.17.
 */
public class TableModelImpl extends AbstractTableModel{

    private final List <Log> logs;

    public TableModelImpl(final List<Log> logs) {
        this.logs = logs;
    }

    public int getRowCount() {
        return logs.size();
    }

    public int getColumnCount() {
        return 7;
    }

    public Object getValueAt(int i, int i1) {
        switch (i1) {
            case 0:return logs.get(i).date;
            case 1:return logs.get(i).typeOfOperation;
            case 2:return logs.get(i).operationStatus;
            case 3:return logs.get(i).bookingNumber;
            case 4:return logs.get(i).agency;
            case 5:return logs.get(i).gds;
            case 6:return logs.get(i).segments;
            default: return "";
        }
    }

    @Override
    public String getColumnName(int i) {
        switch (i) {
            case 0: return "date";
            case 1: return "typeOfOperation";
            case 2: return "operationStatus";
            case 3: return "bookingNumber";
            case 4: return "agency";
            case 5: return "gds";
            case 6: return "segments";
            default: return  "";
        }
    }
}
