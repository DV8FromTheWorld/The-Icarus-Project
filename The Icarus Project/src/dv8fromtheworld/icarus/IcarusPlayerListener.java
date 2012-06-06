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
    public Location location;
    public Location movePlayerTo;
    public int takeAwayFromHeightLimit = 2;
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
        if(height > plugin.heightLimit){
           // newY = plugin.heightLimit - takeAwayFromHeightLimit;
           // movePlayerTo = location;
           // movePlayerTo.setY(newY);
           // event.setTo(movePlayerTo);
            test = event.getFrom();
            event.setTo(test);
            current.sendMessage("you cant go higher than this, sorry chap!");
           
           
       }
       
    }     
    
}
