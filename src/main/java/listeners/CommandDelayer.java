package listeners;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;
import org.bukkit.plugin.Plugin;

import java.util.ArrayList;

public class CommandDelayer implements Listener
{
    private Plugin plugin;
    private ArrayList<String> whitelist = new ArrayList<>();


    public CommandDelayer (Plugin plugin)
    {
        this.plugin = plugin;
        whitelist.add("r");
        whitelist.add("reply");
        whitelist.add("stats");
        whitelist.add("mctop");
        whitelist.add("partychat");
    }


    @EventHandler
    public void commandDelayer(PlayerCommandPreprocessEvent preprocessEvent)
    {
        Player player = preprocessEvent.getPlayer();
        World.Environment environment = player.getLocation().getWorld().getEnvironment();
        if (environment.equals(World.Environment.THE_END) || environment.equals(World.Environment.NETHER))
        {
            if (!(player.hasPermission("hotfix.override.delay")))
            {
                String msg =  preprocessEvent.getMessage();

                if (whitelist.contains(msg.split(" ")[0].replace("/", "")))
                {
                    return;
                }

                player.sendMessage(ChatColor.RED + "message will send in 3 seconds...");
                preprocessEvent.setCancelled(true);

                Bukkit.getScheduler().scheduleSyncDelayedTask(plugin, new Runnable() {
                    @Override
                    public void run()
                    {
                        String newCommand = msg.substring(1,msg.length());
                        System.out.println(newCommand);
                        Bukkit.getServer().dispatchCommand(player, newCommand);
                    }
                    // 3 seconds
                }, 60L);
            }
        }
    }
}
