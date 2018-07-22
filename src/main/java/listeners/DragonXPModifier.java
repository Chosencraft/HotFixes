package listeners;

import org.bukkit.entity.EntityType;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;

public class DragonXPModifier implements Listener
{

    @EventHandler
    public void onDragonDeath(EntityDeathEvent deathEvent)
    {
        if (deathEvent.getEntityType().equals(EntityType.ENDER_DRAGON))
        {
            deathEvent.setDroppedExp(2000);
        }
    }

}
