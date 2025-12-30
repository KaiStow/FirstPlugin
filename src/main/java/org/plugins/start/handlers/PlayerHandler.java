package org.plugins.start.handlers;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.permissions.PermissionAttachment;
import org.plugins.start.firstPlugin;

public class PlayerHandler implements Listener {
    public PlayerHandler(firstPlugin plugin) {
        Bukkit.getPluginManager().registerEvents(this, plugin);
    }
    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();



//        ItemStack item = new ItemStack(Material.OAK_BUTTON, 10);
//        Inventory inv = player.getInventory();
//
//        inv.addItem(item);
//
//        inv.setItem(8, item);
    }
}
