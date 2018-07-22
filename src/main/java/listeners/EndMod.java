package listeners;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.EntityType;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntitySpawnEvent;
import org.bukkit.plugin.Plugin;

import java.util.Random;


public class EndMod implements Listener
{
    Plugin plugin;

    public EndMod(Plugin plugin)
    {
        this.plugin = plugin;
    }

    private int changeChance = 50;
    private int vexChance = 70;
    private int illusionerChance = 100;


    @EventHandler
    public void spawnEvent(EntitySpawnEvent spawnEvent)
    {
        if (spawnEvent.isCancelled())
        {
            return;
        }

        if (spawnEvent.getLocation().getWorld().getEnvironment().equals(World.Environment.THE_END))
        {
            if (! (spawnEvent.getEntity().getType().equals(EntityType.ENDER_DRAGON)))
            {
                if (spawnEvent.getEntity().getType().equals(EntityType.ENDERMAN))
                {
                Random random = new Random();

                int i = random.nextInt(100);
                //System.out.println(i);
                if (i < changeChance)
                {
                    spawnEvent.setCancelled(true);

                    int next = random.nextInt(100);
                    World end = spawnEvent.getLocation().getWorld();
                    Location loc = spawnEvent.getLocation();
                    // System.out.println(next);
                    // System.out.println(end);
                    // System.out.println(loc);


                    int count = random.nextInt(6);
                    if (next < vexChance)
                    {

                        end.spawnEntity(loc.add(1, 0, 1), EntityType.VEX);
                        end.spawnEntity(loc.add(0, 0, 1), EntityType.VEX);
                        end.spawnEntity(loc.add(1, 0, 0), EntityType.VEX);
                        end.spawnEntity(loc, EntityType.VEX);
                        end.spawnEntity(loc.add(- 1, 0, 1), EntityType.VEX);
                        // System.out.println("vex");

                    }
                    else
                    {
                        end.spawnEntity(loc.add(1, 0, 0), EntityType.ILLUSIONER);
                        end.spawnEntity(loc, EntityType.ILLUSIONER);
                        end.spawnEntity(loc.add(0, 0, 1), EntityType.ILLUSIONER);

                    }

                }
                }
            }
        }
    }
}
