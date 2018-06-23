package listeners;

import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;

public class CommandDenier implements Listener
{
    String[] bannedCommands = {"?"};

    @EventHandler (priority = EventPriority.HIGH)
    public void onCommand(PlayerCommandPreprocessEvent preprocessEvent)
    {
        // retrieves only the primary command
        String command = preprocessEvent.getMessage().split(" ")[0].replace("/", "");
        //System.out.println(command);
        //System.out.println(preprocessEvent.getMessage());
        for (String bannedCommand : bannedCommands)
        {
            if (bannedCommand.equalsIgnoreCase(command))
            {
               // System.out.println("canceled");
                preprocessEvent.setCancelled(true);
            }
        }
    }
}
