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
    
    
    public void onDisable() {
       logMessage("has been disabled.");
    }

    public void onEnable() {
        getServer().getPluginManager().registerEvents(new IcarusPlayerListener(this), this);

        loadConfiguration();
        logMessage("has been successfully enabled!");
    }

    private void loadConfiguration() {
        config.options().header("This is the configuration file for the TheIcarusProject plugin.");
        config.addDefault("height limit", 75);
        config.options().copyDefaults(true);
        saveConfig();
        heightLimit = config.getInt("height limit");
        
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
