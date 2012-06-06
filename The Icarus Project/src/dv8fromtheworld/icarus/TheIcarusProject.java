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
     public int heightLimit;
     public int takeAwayFromHeightLimit;
     public String message;
    
    
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
        config.addDefault("height limit", 255);
        config.addDefault("Amount downwards", 1);
        config.addDefault("Warning message", "You cannot go any higher, sorry chap!");
        config.options().copyDefaults(true);
        saveConfig();
        heightLimit = config.getInt("height limit");
        takeAwayFromHeightLimit = config.getInt("Amount downwards");
        message = config.getString("Warning message");
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
