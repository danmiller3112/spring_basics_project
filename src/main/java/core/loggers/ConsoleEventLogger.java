package core.loggers;

import core.beans.Event;

/**
 * Created by RDL on 19/04/2017.
 */
public class ConsoleEventLogger implements EventLogger {

    public void logEvent(Event event) {
        System.out.println(event);
    }
}
