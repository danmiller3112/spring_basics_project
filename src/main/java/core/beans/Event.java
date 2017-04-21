package core.beans;

import java.text.DateFormat;
import java.util.Date;
import java.util.concurrent.atomic.AtomicInteger;


/**
 * Created by RDL on 21/04/2017.
 */
public class Event {

    private static final AtomicInteger AUTO_ID = new AtomicInteger(0);

    private int id;
    private String msg;
    private Date date;
    private DateFormat df;

    public Event(Date date, DateFormat df) {
        this.id = AUTO_ID.getAndIncrement();
        this.date = date;
        this.df = df;
    }

    public int getId() {
        return id;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Date getDate() {
        return date;
    }

    @Override
    public String toString() {
        return "Event{" +
                "id=" + id +
                ", msg='" + msg + '\'' +
                ", date=" + df.format(date) +
                '}';
    }
}
