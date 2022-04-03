package me.charon.staffessentials;

import me.charon.staffessentials.commands.*;
import org.bukkit.plugin.java.JavaPlugin;

public final class StaffEssentials extends JavaPlugin {

    @Override
    public void onEnable() {
        System.out.println("[*] Starting Staff Essentials...");
        System.out.println("[*] Successfully started Staff Essentials...");

        getCommand("feed").setExecutor(new feed());
        getCommand("heal").setExecutor(new heal());
        getCommand("kick").setExecutor(new kick());
        getCommand("ban").setExecutor(new ban());
        getCommand("banip").setExecutor(new banip());
        getCommand("unban").setExecutor(new unban());
        getCommand("tempban").setExecutor(new tempban());
        getCommand("report").setExecutor(new report());
        getCommand("staff").setExecutor(new staff());
    }

    @Override
    public void onDisable() {
        System.out.println("[*] Stopping Staff Essentials...");
        System.out.println("[*] Successfully stopped Staff Essentials...");
    }
}
