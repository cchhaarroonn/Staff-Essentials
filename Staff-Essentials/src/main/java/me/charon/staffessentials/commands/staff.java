package me.charon.staffessentials.commands;

import org.apache.commons.lang.ArrayUtils;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class staff implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (sender instanceof Player) {
            Player player = (Player) sender;
                if (!player.hasPermission("se.seestaff") || player.isOp()) {
                    if (command.getName().equalsIgnoreCase("staff")) {
                        List<String> onlineStaff = new ArrayList<String>();
                        for (Player p : Bukkit.getOnlinePlayers()) {
                            if (p.hasPermission("se.staff")) ;
                            String pName = p.getName();
                            onlineStaff.add(pName + "\n");
                            String output = onlineStaff.toString().replaceAll("(^\\[|\\]$)", "");
                            player.sendMessage(ChatColor.GRAY + "" + ChatColor.STRIKETHROUGH + "--------------" + ChatColor.RESET + ChatColor.GRAY + "(" + ChatColor.DARK_PURPLE + onlineStaff.size() + ChatColor.GRAY + ")" + ChatColor.STRIKETHROUGH + "--------------\n" + ChatColor.WHITE + output + ChatColor.GRAY + "\n" + ChatColor.GRAY + "" + ChatColor.GRAY + "" + ChatColor.STRIKETHROUGH + "--------------" + ChatColor.RESET + ChatColor.GRAY + "(" + ChatColor.DARK_PURPLE + onlineStaff.size() + ChatColor.GRAY + ")" + ChatColor.STRIKETHROUGH + "--------------\n");
                        }
                    }
                }
        } else {
            System.out.println("[*] You have to run this command as player!");
        }

        return false;
    }
}
