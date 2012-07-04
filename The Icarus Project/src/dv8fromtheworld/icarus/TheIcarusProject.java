package dv8fromtheworld.icarus;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.java.JavaPlugin;

public class TheIcarusProject extends JavaPlugin{
    public static File configFile;
    private PluginDescriptionFile info;
    private final Logger myLogger = Logger.getLogger("Minecraft");
    private FileConfiguration config;
    private int len;
    public int worldHeightLimit;
    public int takeAwayFromWorldHeightLimit;
    public String worldMessage;
    public boolean playSoundWorld;
    public int netherHeightLimit;
    public int takeAwayFromNetherHeightLimit;
    public String netherMessage;
    public boolean playSoundNether;
    
    public void onDisable() {
       logMessage("has been disabled.");
    }

    public void onEnable() {
        getServer().getPluginManager().registerEvents(new IcarusPlayerListener(this), this);
        info = this.getDescription();
        configFile = new File(getDataFolder(), "config.yml");
        if (!configFile.exists()) {
            configFile.getParentFile().mkdirs();
            copy(getResource("config.yml"), configFile);
        }
        config = this.getConfig();       
        
        loadConfiguration();
        logMessage("has been successfully enabled!");
    }

    private void loadConfiguration() {
        config.options().header("This is the configuration file for the TheIcarusProject plugin.");
        config.addDefault("Height limit for the main world", 255);
        config.addDefault("Amount downwards for the main world", 1);
        config.addDefault("Warning message for main world", "You cannot go any higher, sorry chap!");
        config.addDefault("Play sound at the main world height limit?", false);
        config.addDefault("Height limit for the nether", 255);
        config.addDefault("Amount downwards for the nether", 1);
        config.addDefault("Warning message for nether", "You cannot go any higher, sorry chap!");
        config.addDefault("Play sound at nether height limit?", false);
        
        config.options().copyDefaults(true);
        saveConfig();
        
        worldHeightLimit = config.getInt("Height limit for the main world");
        takeAwayFromWorldHeightLimit = config.getInt("Amount downwards for the main world");
        worldMessage = config.getString("Warning message for main world");
        playSoundWorld = config.getBoolean("Play sound at the main world height limit");
        
        netherHeightLimit = config.getInt("Height limit for the nether");
        takeAwayFromNetherHeightLimit = config.getInt("Amount downwards for the nether");
        netherMessage = config.getString("Warning message for nether");
        playSoundNether = config.getBoolean("Play sound at nether height limit?");
        
    }
    
    
    
    private void logMessage(Level logLevel, String message) {
		myLogger.log(logLevel, "[" + info.getName() + "] " + message);
	}
    
    public void logMessage(String message){
            logMessage(Level.INFO, message);
    }
    
    
    private void copy(InputStream in, File file){
        try {
            OutputStream out = new FileOutputStream(file);
            byte[] buf = new byte[1024];
        while ((len = in.read(buf)) > 0) {
            len = 0;
            out.write(buf, 0, len);
        }
            out.close();
            in.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
