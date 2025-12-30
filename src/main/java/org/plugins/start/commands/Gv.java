package org.plugins.start.commands;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class Gv implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        Player player;
        Material material = Material.matchMaterial(args[1]);
        int amount = 1;
        if (args.length > 3) {
            sender.sendMessage("§6Too many arguments. (3 Max)");
            return true;
        }
        if (args[0].equals("me")) {
            player = Bukkit.getPlayer(sender.getName());
        } else if (Bukkit.getPlayer(args[0]) == null) {
            sender.sendMessage("§6Couldn't find player: "+args[0]+".");
            return true;
        } else {
            player = Bukkit.getPlayer(args[0]);
        }
        if (material == null || !material.isItem()) {
            sender.sendMessage("§6Invalid block/item: " + args[1] + ".");
            return true;
        }
        if (args.length > 2) {
            try {
                amount = Integer.parseInt(args[2]);
            } catch (NumberFormatException e) {
                sender.sendMessage("Invalid amount");
                return true;
            }
        }
        giveItem(player, amount, material);
        return true;
    }

    private void giveItem(Player player, Integer amount, Material material) {
        Inventory inv = player.getInventory();
        ItemStack item = new ItemStack(material, amount);
        inv.addItem(item);
    }
}
