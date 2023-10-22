/**
 * @autor pingguomc
 * @version 0.0.3
 * 插件主类
 */

package cf.redstart.scpsl;

import cf.redstart.scpsl.command.SCPSLCommand;
import cf.redstart.scpsl.listener.PlayerNumbers;
import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Objects;

public final class SCPSL extends JavaPlugin {
    public static Plugin instance ;
    //相关变量
    public final Plugin SCPSL = this;
    public static Boolean Game_state = false;
    public static Boolean Game_pause = false;
    public static byte player_number = 0;
    public static CommandSender sender1 = Bukkit.getConsoleSender();

    @Override
    public void onEnable() {
        instance = this;
        //加载bstats
        // Metrics metrics = new Metrics(this, 20101);
        // metrics.addCustomChart(new Metrics.SimplePie("chart_id", () -> "SCPSL"));
        //加载配置文件
        saveDefaultConfig();
        this.saveResource("zh_CN.yml",false);
        this.saveResource("help.yml",false);
        //读取配置信息
        getLogger().info("插件当前语言文件为:"+getConfig().getString("lang"));
        //播放加载消息
        getLogger().info("------------------------");
        getLogger().info("|        SCPSL         |");
        getLogger().info("|  作者: pingguomc     |");
        getLogger().info("|      插件正在加载    |");
        getLogger().info("------------------------");
        getLogger().warning("注意！本插件和其他玩法类插件不兼容，且不要将本插件在非小游戏服务器加载");
        //注册指令
        getLogger().info("正在注册指令……");
        Objects.requireNonNull(this.getCommand("scpsl")).setExecutor(this);
        Objects.requireNonNull(Bukkit.getPluginCommand("scpsl")).setExecutor(new SCPSLCommand());
        //注册监听器
        getLogger().info("正在注册监听器……");
        Bukkit.getPluginManager().registerEvents(new PlayerNumbers(),this);
        //加载成功
        Bukkit.getConsoleSender().sendMessage("");
        Bukkit.getConsoleSender().sendMessage("§l§2################### §9SCP:SL插件加载成功！§2###################");
        Bukkit.getConsoleSender().sendMessage("");
    }

    @Override
    public void onDisable() {
        Bukkit.getScheduler().cancelTasks(this);
        getLogger().info("------------------------");
        getLogger().info("|        SCPSL         |");
        getLogger().info("|  作者: pingguomc     |");
        getLogger().info("|      插件已经卸载    |");
        getLogger().info("|         再见！       |");
        getLogger().info("------------------------");
    }
}
