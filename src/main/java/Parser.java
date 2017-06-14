import javax.swing.*;
import java.io.*;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

/**
 * Created by pavel on 11.05.17.
 */
public class Parser {


    public static void main(String[] args) throws IOException {
        JFileChooser jFileChooser = new JFileChooser();
        int ret = jFileChooser.showDialog(null, "Выбрать файл");
        if (ret == JFileChooser.APPROVE_OPTION) {
            BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(jFileChooser.getSelectedFile()), Charset.forName("UTF-8")));
            String tmp = "";
            final List<Log> logs = new ArrayList<Log>();
            Log log = null;
            while ((tmp = reader.readLine()) != null && !tmp.isEmpty()) {
                    log = stringArrayToLogObject(tmp);
                    logs.add(log);
            }

            SwingUtilities.invokeLater(new Runnable() {
                public void run() {
                    new TableExample(logs);
                }
            });
        }

    }

    public static Log stringArrayToLogObject(String line) {
        String[] separateLog = line.split(", ");
        String date = separateLog[0].split(" ")[0];
        String typeOfoperation = line.split(", ")[1].split("=")[1];
        String operationStatus = line.split(", ")[2].split("=")[1];
        String bookingNumber = separateLog[3].split("=").length > 1 ? separateLog[3].split("=")[1] : null;
        String agency = separateLog[7].split("=")[1];
        String gds = separateLog[11].split("=")[1];
        String[] segments = line.split("segments=")[1].replaceAll("WorkflowOperationLogItemSegment", "").replaceAll(Pattern.quote("["), "").replaceAll(Pattern.quote("]"), "").split(",");
        StringBuilder builder = new StringBuilder();
        for (String s : segments) {
            if (!s.contains("departureDate") && !s.contains("flightNumber") && !s.contains("metadata") && !s.contains("session")) {
                builder.append(s);
            }
        }
        return new Log(date, typeOfoperation, operationStatus, bookingNumber, agency, gds, builder.toString());
    }

}
