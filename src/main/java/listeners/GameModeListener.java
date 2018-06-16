package listeners;

import org.bukkit.GameMode;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerGameModeChangeEvent;

public class GameModeListener implements Listener
{

    @EventHandler
    public void onGameModeChanger(PlayerGameModeChangeEvent gameModeChangeEvent)
    {
        Player player = gameModeChangeEvent.getPlayer();

        if (!(player.hasPermission("hotfix.gamemode")))
        {
            player.setGameMode(GameMode.SURVIVAL);
            return;
        }
    }
}
