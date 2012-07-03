package dv8fromtheworld.icarus;

import java.util.Locale;
import org.bukkit.Effect;
import org.bukkit.Location;
import org.bukkit.World.*;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.entity.*;
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
    public Environment world;

    
    IcarusPlayerListener(TheIcarusProject instance) {
       this.plugin = instance;
       
    }    
    
    @EventHandler
    public void onPlayerMove(PlayerMoveEvent event) {
        current = event.getPlayer();
        world = current.getWorld().getEnvironment();
        location = current.getLocation();
        height = location.getY();
       
        if(world == Environment.NORMAL){
            if(height > plugin.worldHeightLimit){
                if(current.hasPermission("TIP.ignore.world")){

                } 
                else{
                    newY = (plugin.worldHeightLimit - plugin.takeAwayFromWorldHeightLimit);
                    movePlayerTo = location;
                    movePlayerTo.setY(newY);
                    event.setTo(movePlayerTo);
                    current.sendMessage(plugin.worldMessage);
                    if(plugin.playSoundWorld == true){
                        current.playEffect(location, Effect.ZOMBIE_CHEW_IRON_DOOR, 1);
                    }
                }
            }
        }    
        if(world == Environment.NETHER){
            if(height > plugin.worldHeightLimit){
                if(current.hasPermission("TIP.ignore.nether")){

                } 
                else{
                    newY = (plugin.netherHeightLimit - plugin.takeAwayFromNetherHeightLimit);
                    movePlayerTo = location;
                    movePlayerTo.setY(newY);
                    event.setTo(movePlayerTo);
                    current.sendMessage(plugin.netherMessage);
                    if(plugin.playSoundNether == true){
                        current.playEffect(location, Effect.ZOMBIE_CHEW_IRON_DOOR, 1);
                    }
                }
            }      
        }
    }    
}