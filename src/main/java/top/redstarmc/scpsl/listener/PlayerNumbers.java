package top.redstarmc.scpsl.listener;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerKickEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.scheduler.BukkitRunnable;

import static top.redstarmc.scpsl.SCPSL.*;

/**
 * 监听玩家数量，并进行游戏是否开始的判断
 */
public class PlayerNumbers implements Listener {
    @EventHandler(priority = EventPriority.HIGH)
    public void onPlayerJoin(PlayerJoinEvent PlayerJoinEvent){
        Player player = PlayerJoinEvent.getPlayer();
        player_number += 1;
        if (player_number >= 2) {
            if (!Game_pause) {
                Bukkit.getServer().dispatchCommand(sender1,"title @a times 0 199980 0");
                Bukkit.getServer().dispatchCommand(sender1, "title @a title [{\"text\":\"回合将开始\",\"color\":\"light_purple\",\"bold\":false,\"italic\":false,\"underlined\":false,\"strikethrough\":false,\"obfuscated\":false}]");
                new BukkitRunnable(){
                    byte time1 = 30;
                    /**
                     * 倒计时
                     */
                    @Override
                    public void run() {
                        if (time1 > 0) {
                            String time2 = String.valueOf(time1);
                            player.sendMessage(ChatColor.GOLD+time2+" 后开始！");
                            time1 -= 1;
                            if (player_number < 2 ){
                                cancel();
                            }
                        } else if (time1 == 0) {
                            Game_state = true;
                            Bukkit.getServer().dispatchCommand(sender1,"title @a clear");
                            cancel();
                        }
                    }
                }.runTaskTimer(instance,0L,20L);
            }else {
                        Bukkit.getServer().dispatchCommand(sender1,"title @a times 0 199980 0");
                        Bukkit.getServer().dispatchCommand(sender1,"title @a title [{\"text\":\"回合已经暂停\",\"color\":\"light_purple\",\"bold\":false,\"italic\":false,\"underlined\":false,\"strikethrough\":false,\"obfuscated\":false}]");
                    }
        }else {
                    Bukkit.getServer().dispatchCommand(sender1,"title @a times 0 199980 0");
                    Bukkit.getServer().dispatchCommand(sender1,"title @a title [{\"text\":\"回合已经暂停\",\"color\":\"light_purple\",\"bold\":false,\"italic\":false,\"underlined\":false,\"strikethrough\":false,\"obfuscated\":false}]");
                    Bukkit.getServer().dispatchCommand(sender1,"title @a subtitle [{\"text\":\"等待玩家加入\",\"color\":\"light_purple\",\"bold\":false,\"italic\":false,\"underlined\":false,\"strikethrough\":false,\"obfuscated\":false}]");
        }
    }
    @EventHandler(priority = EventPriority.HIGH)
    public void onPlayerQuit(PlayerQuitEvent PlayerQuitEvent){
        player_number -= 1;
    }
    @EventHandler(priority = EventPriority.HIGH)
    public void onPlayerKick(PlayerKickEvent PlayerKickEvent){
        player_number -= 1;
    }


}
