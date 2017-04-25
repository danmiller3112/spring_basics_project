package core;

import core.beans.Client;
import core.beans.Event;
import core.beans.EventType;
import core.loggers.EventLogger;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;
import java.util.Map;

/**
 * Created by RDL on 19/04/2017.
 */
public class App {

    private Client client;
    private EventLogger defaultLogger;
    private Map<EventType, EventLogger> loggers;

    public App(Client client, EventLogger eventLogger, Map<EventType, EventLogger> loggers) {
        this.client = client;
        this.defaultLogger = eventLogger;
        this.loggers = loggers;
    }

    public static void main(String[] args) throws IOException {
        ConfigurableApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
        App app = (App) context.getBean("app");

        Event event = context.getBean(Event.class);
        app.logEvent(EventType.INFO, event, "Some event 1");

        event = context.getBean(Event.class);
        app.logEvent(EventType.ERROR, event, "Some event 2");

        event = context.getBean(Event.class);
        app.logEvent(null, event, "Some event 3");

        context.close();
    }

    private void logEvent(EventType eventType, Event event, String msg) throws IOException {
        String message = msg.replaceAll(client.getId(), client.getFullName());
        event.setMsg(message);

        EventLogger logger = loggers.get(eventType);
        if (logger == null) {
            defaultLogger.logEvent(event);
        } else {
            logger.logEvent(event);
        }

    }

}
