package dv8fromtheworld.icarus;

import org.bukkit.plugin.java.JavaPlugin;

public class TheIcarusProject extends JavaPlugin{
    public void onDisable() {
       System.out.println("[Icarus] The Icarus Project has been disabled.");
    }

    public void onEnable() {
        getServer().getPluginManager().registerEvents(new IcarusPlayerListener(this), this);
        System.out.println("[Icarus] The Icarus Project has been successfully enabled!");
    }

    

}

