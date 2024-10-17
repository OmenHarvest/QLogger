package me.harvest.qLogger.logger;

import me.harvest.qLogger.utils.TelegramSenderModule;
import me.harvest.qLogger.utils.TextUtils;
import org.bukkit.plugin.Plugin;

public class LogManager {

    public boolean pullGeneratedMessage(LogType logType, String message, Plugin plugin) {
        try{
            TelegramSenderModule.pullMessage(message);

            int[] rgb = logType.getColorRGBContainer();

            TextUtils.LogSend(logType.getPrefix(), message, rgb[0], rgb[1], rgb[2]);
            return true;
        }
        catch(Exception e){
            return false;
        }
    }

}
