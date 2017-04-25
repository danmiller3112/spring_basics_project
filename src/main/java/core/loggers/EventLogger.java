package core.loggers;

import core.beans.Event;
import core.beans.EventType;

import java.io.IOException;

/**
 * Created by RDL on 19/04/2017.
 */
public interface EventLogger {

    void logEvent(Event event) throws IOException;
}
