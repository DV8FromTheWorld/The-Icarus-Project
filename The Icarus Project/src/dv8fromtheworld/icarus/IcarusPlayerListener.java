package dv8fromtheworld.icarus;

import java.lang.Math;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;
 

public class IcarusPlayerListener implements Listener{

    private final TheIcarusProject plugin;
    public double height;
    public Player current;
    int takeAwayFromHeightLimit = 2;
    public int movePlayerTo;
    
    IcarusPlayerListener(TheIcarusProject instance) {
       this.plugin = instance;
       
    }
    
    
    @EventHandler
    public void onPlayerMove(PlayerMoveEvent event) {
        current = event.getPlayer();
        Location location = current.getLocation();
        height = location.getY();
        if(height > plugin.heightLimit){
            movePlayerTo = plugin.heightLimit - takeAwayFromHeightLimit;
            location.setY(movePlayerTo);
           
           
       }
       
       }     
    
}
