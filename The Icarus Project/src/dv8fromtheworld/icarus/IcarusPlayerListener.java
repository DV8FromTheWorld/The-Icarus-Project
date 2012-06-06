package dv8fromtheworld.icarus;

import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;
 

public class IcarusPlayerListener implements Listener{

    private final TheIcarusProject plugin;
    public double height;
    public Player current;
    
    IcarusPlayerListener(TheIcarusProject instance) {
       this.plugin = instance;
    }

    
    @EventHandler
      public void onPlayerMove(PlayerMoveEvent event) {
       current = event.getPlayer();
       Location location = current.getLocation();
       height = location.getY();
       if(height > 75){
           current.sendMessage("Get down from there!");
       }
       
       }
       
    
    
            
    

    
}
