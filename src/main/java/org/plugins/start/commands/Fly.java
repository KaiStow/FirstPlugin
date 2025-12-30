package org.plugins.start.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Fly implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (!(sender.hasPermission("start.commands.fly"))) {
            sender.sendMessage("No permission.");
            return true;
        }

        if (args.length == 0) {
            Player player = (Player) sender;
            toggleFly(player);
            return true;
        } else if (args.length == 1) {
            Player player = Bukkit.getPlayer(args[0]);
            if (player == null) {
                sender.sendMessage("§6Could not find player: " + args[0] + ".");
                return true;
            }
            toggleFly(player);
            player.sendMessage(sender.getName()+" toggled your flight.");
            sender.sendMessage("Toggled flight for: "+player.getName());
            return true;
        }

        return true;
    }
    private void toggleFly(Player player) {

        if (player.getAllowFlight()) {
            player.setAllowFlight(false);
            player.sendMessage("§4Disabled flight.");
        } else {
            player.setAllowFlight(true);
            player.sendMessage("§4Enabled flight.");
        }
    }
}
