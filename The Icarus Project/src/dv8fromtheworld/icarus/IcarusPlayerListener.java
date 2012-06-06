package dv8fromtheworld.icarus;

import java.lang.Math;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.permissions.*;
 

public class IcarusPlayerListener implements Listener{
    private final TheIcarusProject plugin;
    public double height;
    public Player current;
    public Location location;
    public Location movePlayerTo;
    public int newY;
    private Location test;
    
    IcarusPlayerListener(TheIcarusProject instance) {
       this.plugin = instance;
       
    }    
    
    @EventHandler
    public void onPlayerMove(PlayerMoveEvent event) {
        current = event.getPlayer();
        location = current.getLocation();
        height = location.getY();
        if(current.hasPermission("TIP.Ignore.height.limit")){
            
        }
        if(height > plugin.heightLimit){
            if(current.hasPermission("TIP.Ignore.height.limit")){
                
            }
            else{
            newY = (plugin.heightLimit - plugin.takeAwayFromHeightLimit);
            movePlayerTo = location;
            movePlayerTo.setY(newY);
            event.setTo(movePlayerTo);
            current.sendMessage(plugin.message);
            }
           
           
       }
       
    }     
    
}
