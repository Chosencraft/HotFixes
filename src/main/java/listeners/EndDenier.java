package listeners;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerChangedWorldEvent;

public class EndDenier implements Listener
{

    @EventHandler(priority = EventPriority.LOW)
    public void onWorldChange(PlayerChangedWorldEvent changedWorldEvent)
    {
        Player player = changedWorldEvent.getPlayer();
        if (player.getWorld().getEnvironment().equals(World.Environment.THE_END))
        {
            player.sendMessage(ChatColor.DARK_PURPLE + "Sorry, not today!");
            player.teleport(Bukkit.getWorlds().get(0).getSpawnLocation());
        }
    }


}
