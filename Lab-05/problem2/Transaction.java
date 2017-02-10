package problem2;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Transaction {

    private final DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
    private final Calendar cal = Calendar.getInstance();
    private String date = null;
    private String narrtion = null;
    private double ammount = 0;
    private boolean debit = false;

    public Transaction(String narrtion, double ammount, boolean debit) {
        this.narrtion = narrtion;
        this.ammount = ammount;
        this.debit = debit;
        this.date = dateFormat.format(cal.getTime());
    }

    public String getDate() {
        return date;
    }

    public String getNarrtion() {
        return narrtion;
    }

    public double getAmmount() {
        return ammount;
    }

    public boolean isDebit() {
        return debit;
    }
}
