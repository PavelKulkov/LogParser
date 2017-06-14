/**
 * Created by pavel on 11.05.17.
 */
public class Log {

    public final String date;

    public final String typeOfOperation;

    public final String operationStatus;

    public final String bookingNumber;

    public final String agency;

    public final String gds;

    public final String segments;

//    public String departure;
//
//    public String arrival;
//
//    public String vendor;


    public Log(String date, String typeOfOperation, String operationStatus, String bookingNumber,
               String agency, String gds, String segments) {
        this.date = date;
        this.typeOfOperation = typeOfOperation;
        this.operationStatus = operationStatus;
        this.bookingNumber = bookingNumber;
        this.agency = agency;
        this.gds = gds;
//        this.departure = departure;
//        this.arrival = arrival;
//        this.vendor = vendor;
        this.segments = segments;
    }

    @Override
    public String toString() {
        return "Log{" +
                "date='" + date + '\'' +
                ", typeOfOperation='" + typeOfOperation + '\'' +
                ", operationStatus='" + operationStatus + '\'' +
                ", bookingNumber='" + bookingNumber + '\'' +
                ", agency='" + agency + '\'' +
                ", gds='" + gds + '\'' +
                ", segments='" + segments + '\'' +
                '}';
    }
}
