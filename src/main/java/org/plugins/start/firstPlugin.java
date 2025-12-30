package org.plugins.start;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;
import org.plugins.start.handlers.PlayerHandler;
import org.plugins.start.handlers.TorchHandler;
import org.plugins.start.commands.*;

public final class firstPlugin extends JavaPlugin {

    @Override
    public void onEnable() {
        Bukkit.getLogger().info("Hello world");

        getCommand("fly").setExecutor(new Fly());
        getCommand("gv").setExecutor(new Gv());
        getCommand("gv").setTabCompleter(new GvTabCompleter());

        new TorchHandler(this);
        new PlayerHandler(this);

    }

    @Override
    public void onDisable() {
        Bukkit.getLogger().info("Shutting down");
    }
}
