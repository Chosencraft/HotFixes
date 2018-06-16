import listeners.GameModeListener;
import listeners.SpawnFixer;
import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public class HotFixMain extends JavaPlugin
{

    public void onEnable()
    {

    }

    public void onDisable()
    {

    }

    private void registerEvents()
    {
        PluginManager manager = Bukkit.getServer().getPluginManager();

        manager.registerEvents(new SpawnFixer(), this);
        manager.registerEvents(new GameModeListener(), this);

    }

}
