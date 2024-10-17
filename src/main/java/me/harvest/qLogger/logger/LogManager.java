package me.harvest.qLogger.logger;

import me.harvest.qLogger.QLogger;
import me.harvest.qLogger.utils.TextUtils;
import org.bukkit.plugin.Plugin;

public class LogManager {

    public void pullGeneratedMessage(LogType logType, String message, Plugin plugin) {
        try {
            QLogger.getInstance().getTelegram().pullMessage(message);

            int[] rgb = logType.getColorRGBContainer();

            TextUtils.LogSend(logType.getPrefix(), message, rgb[0], rgb[1], rgb[2]);
        }
        catch (Exception e) {
            int[] rgb = LogType.ERROR.getColorRGBContainer();
            TextUtils.LogSend(LogType.ERROR.getPrefix(), message, rgb[0], rgb[1], rgb[2]);
        }

    }

}
