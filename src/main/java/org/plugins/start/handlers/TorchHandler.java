package org.plugins.start.handlers;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;
import org.plugins.start.firstPlugin;

public class TorchHandler implements Listener {
    public TorchHandler(firstPlugin plugin) {
        Bukkit.getPluginManager().registerEvents(this, plugin);
    }

    @EventHandler(priority = EventPriority.LOW)
    public void onTorchPlace_Low(BlockPlaceEvent event) {
        if (event.getBlock().getType() != Material.TORCH) {
            return;
        }

        // Permission node
        // start.torch.diamond

        if (!event.getPlayer().hasPermission("start.torch.diamond")) {
            return;
        }

        event.getBlock().setType(Material.DIAMOND_BLOCK);
    }
}
