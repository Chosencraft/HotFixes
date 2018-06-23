package listeners;

import org.bukkit.block.CreatureSpawner;
import org.bukkit.entity.EntityType;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.CreatureSpawnEvent;

public class WitherSpawnDenier implements Listener
{

    @EventHandler(priority = EventPriority.HIGH)
    public void onWitherCreation(CreatureSpawnEvent creatureSpawnEvent)
    {
            if (creatureSpawnEvent.getEntity().getType().equals(EntityType.WITHER))
            {
                creatureSpawnEvent.setCancelled(true);
            }
    }
}
