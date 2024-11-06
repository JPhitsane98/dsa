package j.com.problems;

import java.util.logging.Level;
import java.util.logging.Logger;

public class LoggerUtil {

    public static void log(Class<?> clazz, String... messages) {
        Logger logger = Logger.getLogger(clazz.getName());
        StringBuilder logMessage = new StringBuilder();

        for (String message : messages) {
            logMessage.append(message).append("\n");
        }

        logger.log(Level.INFO, logMessage.toString().trim());
    }
}