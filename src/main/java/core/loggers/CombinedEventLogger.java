package core.loggers;

import core.beans.Event;

import java.io.IOException;
import java.util.Collection;

/**
 * Created by RDL on 21/04/2017.
 */
public class CombinedEventLogger implements EventLogger {

    private Collection<EventLogger> loggers;

    public CombinedEventLogger(Collection<EventLogger> loggers) {
        this.loggers = loggers;
    }

    @Override
    public void logEvent(Event event) throws IOException {
        for (EventLogger eventLogger : loggers) {
            eventLogger.logEvent(event);
        }
    }
}
