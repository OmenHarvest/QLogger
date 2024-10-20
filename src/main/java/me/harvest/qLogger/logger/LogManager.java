package me.harvest.qLogger.logger;

import jdk.jfr.Description;
import me.harvest.qLogger.QLogger;
import me.harvest.qLogger.utils.TextUtils;
import org.bukkit.plugin.Plugin;

import java.util.HashMap;
import java.util.Map;

public class LogManager {

    Map<LogType, String> configMap = Map.of(
            LogType.DEATH, "death_log.telegram_log",
            LogType.CHANGEWORLD, "changed_world_log.telegram_log",
            LogType.CHAT, "chat_log.telegram_log",
            LogType.DAMAGE, "damage_log.telegram_log",
            LogType.JOINLEAVE, "join_leave_log.telegram_log"
    );

    public void pullGeneratedMessage(LogType logType, String message, Plugin plugin) {
        if(QLogger.getInstance().getConfig().getBoolean("telegram_module")){
            int[] rgb = logType.getColorRGBContainer();

            TextUtils.LogSend(logType.getPrefix(), message, rgb[0], rgb[1], rgb[2]);

            if(QLogger.getInstance().getConfig().getBoolean(configMap.get(logType))) {
                QLogger.getInstance().getTelegram().pullMessage(String.format("%s %s", logType.getPrefix(), message));
            }
        }
        else{
            int[] rgb = logType.getColorRGBContainer();
            TextUtils.LogSend(logType.getPrefix(), message, rgb[0], rgb[1], rgb[2]);
        }

    }

    @Description("For future api!!!")
    public void pullGeneratedMessageAPI(LogType logType, String message, boolean sendToTelegram, Plugin plugin) {
        try {

            int[] rgb = logType.getColorRGBContainer();

            TextUtils.LogSend(logType.getPrefix(), message, rgb[0], rgb[1], rgb[2]);
            if(QLogger.getInstance().getConfig().getBoolean("telegram_module") && sendToTelegram){
                QLogger.getInstance().getTelegram().pullMessage(String.format("%s %s", logType.getPrefix(), message));
            }
        }
        catch (Exception e) {
            int[] rgb = LogType.ERROR.getColorRGBContainer();
            TextUtils.LogSend(LogType.ERROR.getPrefix(), message, rgb[0], rgb[1], rgb[2]);
        }

    }

}
