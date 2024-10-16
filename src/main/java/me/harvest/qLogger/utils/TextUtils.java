package me.harvest.qLogger.utils;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.TextColor;
import org.bukkit.Bukkit;

public class TextUtils {

    //simple way to send start analytic message to server console. Just for fun n cute style :3
    public static void startupWelcome() {
        Bukkit.getConsoleSender().sendMessage(TextComponentComposer("", 255, 255, 255));
    }

    //Use for simple component compose in prints. Greate (GPT) var.
    public static Component TextComponentComposer(String text, int r, int g, int b) {
        return Component.text(text).color(TextColor.color(r, g, b));
    }

}
