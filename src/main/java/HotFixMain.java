import listeners.EndDenier;
import listeners.FireDampener;
import listeners.SpawnFixer;
import listeners.WitherSpawnDenier;
import org.bukkit.Bukkit;
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
        Bukkit.getScheduler().cancelAllTasks();
    }

    private void registerEvents()
    {
        PluginManager manager = Bukkit.getServer().getPluginManager();

        manager.registerEvents(new SpawnFixer(), this);
        manager.registerEvents(new EndDenier(), this);
        manager.registerEvents(new FireDampener(), this);
        manager.registerEvents(new WitherSpawnDenier(), this);

    }

    private void checkOps()
    {
        Bukkit.getScheduler().scheduleSyncRepeatingTask(this, new CheckOps(), 20, 100 );
    }
}
