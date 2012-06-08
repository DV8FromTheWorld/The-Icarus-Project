package dv8fromtheworld.icarus;

import org.bukkit.Effect;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;
 

public class IcarusPlayerListener implements Listener{
    private final TheIcarusProject plugin;
    public double height;
    public Player current;
    public Location location;
    public Location movePlayerTo;
    public int newY;
    
    IcarusPlayerListener(TheIcarusProject instance) {
       this.plugin = instance;
       
    }    
    
    @EventHandler
    public void onPlayerMove(PlayerMoveEvent event) {
        current = event.getPlayer();
        location = current.getLocation();
        height = location.getY();
        if(height > plugin.heightLimit){
            if(current.hasPermission("TIP.ignore")){
                
            }
            
            else{
                if(plugin.playSound != true){
                    newY = (plugin.heightLimit - plugin.takeAwayFromHeightLimit);
                    movePlayerTo = location;
                    movePlayerTo.setY(newY);
                    event.setTo(movePlayerTo);
                    current.sendMessage(plugin.message);

                }
                else{
                    newY = (plugin.heightLimit - plugin.takeAwayFromHeightLimit);
                    movePlayerTo = location;
                    movePlayerTo.setY(newY);
                    event.setTo(movePlayerTo);
                    current.sendMessage(plugin.message);
                    current.playEffect(location, Effect.ZOMBIE_CHEW_IRON_DOOR, 1);
                        
                }
            }
        }
          
    }
       
}
