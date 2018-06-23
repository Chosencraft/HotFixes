import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.entity.Player;

import java.util.Collection;
import java.util.List;
import java.util.Stack;

public class CheckOps implements Runnable
{

    @Override
    public void run()
    {
        Collection<? extends Player> players = Bukkit.getOnlinePlayers();
        Stack<Player> priveleged = new Stack<Player>();

        for (Player player : players)
        {
            if (player.isOp() || player.getGameMode().equals(GameMode.CREATIVE))
            {
                if (player.hasPermission("hotfix.game"))
                {
                    player.setOp(false);
                    return;
                }
                else
                {
                    player.setOp(false);
                    player.setGameMode(GameMode.SURVIVAL);
                    return;
                }

            }
        }

    }

}
