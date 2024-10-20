package me.harvest.qLogger.utils;

import com.pengrad.telegrambot.TelegramBot;
import com.pengrad.telegrambot.model.Message;
import com.pengrad.telegrambot.model.request.InputMessageContent;
import com.pengrad.telegrambot.model.request.ParseMode;
import com.pengrad.telegrambot.request.SendMessage;
import com.pengrad.telegrambot.response.SendResponse;
import me.harvest.qLogger.QLogger;
import me.harvest.qLogger.logger.LogType;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

// class for logging in telegram bot. You can change private policy in config instr. Default = off
public class TelegramSenderModule {

    private final TelegramBot telegramBot;
    private final List<String> telegramMessagesContainer = new ArrayList<>();
    private final String channelId; // ID канала для отправки сообщений

    public TelegramSenderModule() {
        try {
            telegramBot = new TelegramBot(QLogger.getInstance().getConfig().getString("telegram_key"));
            channelId = QLogger.getInstance().getConfig().getString("telegram_channel_id"); // Получаем ID канала из конфигурации

            new BukkitRunnable() {
                public void run() {
                    if (telegramMessagesContainer.isEmpty()) {
                        return;
                    }
                    sendContainer();
                    telegramMessagesContainer.clear();
                }
            }.runTaskTimerAsynchronously(QLogger.getInstance(), 1200, 1200);

            int[] container = LogType.TELEGRAM.getColorRGBContainer();
            TextUtils.LogSend(LogType.TELEGRAM.getPrefix(), "Success connected to telegram server", container[0], container[1], container[0]);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void pullMessage(String message) {
        if (telegramBot != null) {
            telegramMessagesContainer.add(message);
        }
        // Simple logic: in 30-60 sec (1200 ticks) module pull message to data to share container and send it in time out
    }

    private void sendContainer() {

        StringBuilder stringBuilder = new StringBuilder(String.format("<b>[%s | %s]</b>\n\n", LocalDate.now(), LocalTime.now().withNano(0)));

        for(String log : telegramMessagesContainer){
            stringBuilder.append(log).append("\n");
        }

        SendMessage sendMessage = new SendMessage(channelId, stringBuilder.toString()); // Создаем сообщение для отправки
        sendMessage.parseMode(ParseMode.HTML);
        SendResponse response = telegramBot.execute(sendMessage); // Отправляем сообщение


        if (!response.isOk()) {
            int[] container = LogType.TELEGRAM.getColorRGBContainer();
            TextUtils.LogSend(LogType.TELEGRAM.getPrefix(), "Ошибка при отправке сообщения в канал " + channelId + ": " + response.description(), container[0], container[1], container[0]);
        }

    }
}