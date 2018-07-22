import listeners.*;
import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public class HotFixMain extends JavaPlugin
{

    public void onEnable()
    {
        registerEvents();
        checkOps();

    }

    public void onDisable()
    {
        Bukkit.getScheduler().cancelTasks(this);
    }

    private void registerEvents()
    {
        PluginManager manager = Bukkit.getServer().getPluginManager();


        for (World world : Bukkit.getWorlds())
        {
            if (world.getEnvironment().equals(World.Environment.THE_END))
            {
                world.setMonsterSpawnLimit(world.getMonsterSpawnLimit() * 2);
            }
        }

        manager.registerEvents(new SpawnFixer(), this);
        manager.registerEvents(new EndDenier(), this);
        manager.registerEvents(new FireDampener(), this);
        manager.registerEvents(new WitherSpawnDenier(), this);
        manager.registerEvents(new CommandDenier(), this);
        manager.registerEvents(new DragonXPModifier(), this);
        manager.registerEvents(new EndMod(this), this);
        manager.registerEvents(new CommandDelayer(this), this);

    }

    private void checkOps()
    {
        Bukkit.getScheduler().scheduleSyncRepeatingTask(this, new CheckOps(), 20, 100 );
    }
}
