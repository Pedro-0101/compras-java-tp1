package Core.Log;

import java.util.ArrayList;
import java.util.List;

public class CompositeLogger implements ILogger {
    private List<ILogger> loggers = new ArrayList<>();

    public void addLogger(ILogger logger) {
        loggers.add(logger);
    }

    @Override
    public void log(String message) {
        for (ILogger logger : loggers) {
            logger.log(message);
        }
    }
}
