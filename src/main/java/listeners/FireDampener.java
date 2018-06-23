package listeners;

import org.bukkit.World;
import org.bukkit.WorldType;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBurnEvent;

public class FireDampener implements Listener
{


    @EventHandler (priority = EventPriority.HIGH)
    public void onBurnEvent (BlockBurnEvent burnEvent)
    {
        if (!(burnEvent.getBlock().getWorld().getEnvironment().equals(World.Environment.NETHER)))
        {
            burnEvent.setCancelled(true);
        }
    }

}
