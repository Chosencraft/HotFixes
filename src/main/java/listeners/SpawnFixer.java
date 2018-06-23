package listeners;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class SpawnFixer implements Listener
{

    @EventHandler (priority = EventPriority.LOW)
    public void onInitialSpawn(PlayerJoinEvent joinEvent)
    {
        Player player = joinEvent.getPlayer();

        if (player.hasPlayedBefore())
        {
            return;
        }
        else
        {
            player.teleport(Bukkit.getWorlds().get(0).getSpawnLocation());
        }
    }
}
