package me.charon.staffessentials.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.awt.*;
import java.util.Collection;

public class report implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (sender instanceof Player) {
            Player player = (Player) sender;
            String playerName = player.getName();
            Player target = Bukkit.getServer().getPlayer(args[0]);
            String targetName = target.getName();
            String message = "";
            for (int i = 0; i < args.length; i++) {
                message = message + args[i] + " ";
            }
            message = message.trim();
            if(!player.hasPermission("se.sendreport") || player.isOp()) {
                if (command.getName().equalsIgnoreCase("report")) {
                    player.sendMessage(ChatColor.GRAY + "" + ChatColor.STRIKETHROUGH + "----------------------------------------------\n" + ChatColor.GRAY + "[" + ChatColor.DARK_PURPLE + "!" + ChatColor.GRAY + "] " + ChatColor.WHITE + "You have successfully reported player: " + ChatColor.DARK_PURPLE + targetName + ChatColor.DARK_PURPLE + "\nReason: " + ChatColor.WHITE + message + ChatColor.GRAY + "" + ChatColor.STRIKETHROUGH + "\n----------------------------------------------");
                    for (Player online : Bukkit.getOnlinePlayers()) {
                        if (online.hasPermission("se.readreport")) {
                            player.sendMessage(ChatColor.GRAY + "" + ChatColor.STRIKETHROUGH + "----------------------------------------------\n" + ChatColor.GRAY + "[" + ChatColor.DARK_PURPLE + "!" + ChatColor.GRAY + "] " + ChatColor.DARK_PURPLE + player.getName() + ChatColor.WHITE + " has reported " + ChatColor.DARK_PURPLE + target.getName() + ChatColor.DARK_PURPLE + "\nReason: " + ChatColor.WHITE + message + ChatColor.GRAY + "\n" + ChatColor.STRIKETHROUGH + "----------------------------------------------");
                        }
                    }
                }
            } else {
                System.out.println("[*] You have to run this command as player!");
            }
        }
        return false;
    }
}
