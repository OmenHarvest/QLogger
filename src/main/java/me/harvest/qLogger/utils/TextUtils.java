package me.harvest.qLogger.utils;

import me.harvest.qLogger.QLogger;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.TextColor;
import org.bukkit.Bukkit;
import org.bukkit.scheduler.BukkitRunnable;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class TextUtils {

    //simple way to send start analytic message to server console. Just for fun n cute style :3
    public static void startupWelcome() {
        Bukkit.getConsoleSender().sendMessage(TextComponentComposer("\n⣿⡟⠙⠛⠋⠩⠭⣉⡛⢛⠫⠭⠄⠒⠄⠄⠄⠈⠉⠛⢿⣿⣿⣿⣿⣿⣿⣿⣿⣿\n" +
                "⣿⡇⠄⠄⠄⠄⣠⠖⠋⣀⡤⠄⠒⠄⠄⠄⠄⠄⠄⠄⠄⠄⣈⡭⠭⠄⠄⠄⠉⠙\n" +
                "⣿⡇⠄⠄⢀⣞⣡⠴⠚⠁⠄⠄⢀⠠⠄⠄⠄⠄⠄⠄⠄⠉⠄⠄⠄⠄⠄⠄⠄⠄\n" +
                "⣿⡇⠄⡴⠁⡜⣵⢗⢀⠄⢠⡔⠁⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄\n" +
                "⣿⡇⡜⠄⡜⠄⠄⠄⠉⣠⠋⠠⠄⢀⡄⠄⠄⣠⣆⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⢸\n" +
                "⣿⠸⠄⡼⠄⠄⠄⠄⢰⠁⠄⠄⠄⠈⣀⣠⣬⣭⣛⠄⠁⠄⡄⠄⠄⠄⠄⠄⢀⣿ ",122, 122, 122).append(TextComponentComposer("Minecraft ver. > ", 46, 204, 113).append(TextComponentComposer(Bukkit.getMinecraftVersion() + "\n", 255, 255, 255)))
                .append(TextComponentComposer("⣏⠄⢀⠁⠄⠄⠄⠄⠇⢀⣠⣴⣶⣿⣿⣿⣿⣿⣿⡇⠄⠄⡇⠄⠄⠄⠄⢀⣾⣿ ", 122, 122, 122).append(TextComponentComposer("Bukkit ver. > ", 255, 121,121)).append(TextComponentComposer(Bukkit.getBukkitVersion() + "\n", 255, 255, 255)))
                .append(TextComponentComposer("⣿⣸⠈⠄⠄⠰⠾⠴⢾⣻⣿⣿⣿⣿⣿⣿⣿⣿⣿⢁⣾⢀⠁⠄⠄⠄⢠⢸⣿⣿ ", 122, 122, 122)).append(TextComponentComposer("OS > ", 104, 109, 224)).append(TextComponentComposer(System.getProperty("os.name") + "\n", 255, 255, 255))
                .append(TextComponentComposer("⣿⣿⣆⠄⠆⠄⣦⣶⣦⣌⣿⣿⣿⣿⣷⣋⣀⣈⠙⠛⡛⠌⠄⠄⠄⠄⢸⢸⣿⣿ ", 122, 122, 122).append(TextComponentComposer("Ip/Port info > ", 255, 190, 118)).append(TextComponentComposer(Bukkit.getIp() + Bukkit.getPort() + "\n", 255, 255,255)))
                .append(TextComponentComposer("⣿⣿⣿⠄⠄⠄⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⠇⠈⠄⠄⠄⠄⠄⠈⢸⣿⣿ ", 122, 122, 122).append(TextComponentComposer("Java ver. > ", 230, 126, 34)).append(TextComponentComposer(System.getProperty("java.version") + "\n", 255, 255, 255)))
                .append(TextComponentComposer("⣿⣿⣿⠄⠄⠄⠘⣿⣿⣿⡆⢀⣈⣉⢉⣿⣿⣯⣄⡄⠄⠄⠄⠄⠄⠄⠄⠈⣿⣿\n" +
                        "⣿⣿⡟⡜⠄⠄⠄⠄⠙⠿⣿⣧⣽⣍⣾⣿⠿⠛⠁⠄⠄⠄⠄⠄⠄⠄⠄⠃⢿⣿\n" +
                        "⣿⡿⠰⠄⠄⠄⠄⠄⠄⠄⠄⠈⠉⠩⠔⠒⠉⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠐⠘⣿\n" +
                        "⣿⠃⠃⠄⠄⠄⠄⠄⠄⣀⢀⠄⠄⡀⡀⢀⣤⣴⣤⣤⣀⣀⠄⠄⠄⠄⠄⠄⠁⢹", 122, 122, 122))
        );
    }

    //Use for simple component compose in prints. Greate (GPT) var.
    public static Component TextComponentComposer(String text, int r, int g, int b) {
        return Component.text(text).color(TextColor.color(r, g, b));
    }

    public static void LogSend(String prefix, String message, int r, int g, int b) {
        Bukkit.getConsoleSender().sendMessage(TextComponentComposer(prefix + " ", r, g, b).append(TextComponentComposer(message, 255, 255, 255)));
    }

    public static void TimerControl(){
        new BukkitRunnable() {
            @Override
            public void run() {
                Bukkit.getConsoleSender().sendMessage(TextComponentComposer(String.format("---------------[%s | %s]---------------", LocalDate.now(), LocalTime.now().withNano(0)),217, 128, 250));
            }
        }.runTaskTimer(QLogger.getInstance(), 20, 3600);
    }

}
