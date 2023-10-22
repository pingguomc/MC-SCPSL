package cf.redstart.scpsl;

import cf.redstart.scpsl.command.SCPSLCommand;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;
import cf.redstart.scpsl.Metrics.Metrics;
import java.util.Objects;

public final class SCPSL extends JavaPlugin {
    //相关变量
    public static Boolean Game_state = false;

    @Override
    public void onEnable() {
        //加载bstats
        Metrics metrics = new Metrics(this, 20101);
        metrics.addCustomChart(new Metrics.SimplePie("chart_id", () -> "SCPSL"));
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
        Bukkit.getPluginCommand("scpsl").setExecutor(new SCPSLCommand());
        //注册监听器
        getLogger().info("正在注册监听器……");
        System.out.println("&l&9 SCP:SL插件加载成功！");
    }

    @Override
    public void onDisable() {
        getLogger().info("------------------------");
        getLogger().info("|        SCPSL         |");
        getLogger().info("|  作者: pingguomc     |");
        getLogger().info("|      插件已经卸载    |");
        getLogger().info("|         再见！       |");
        getLogger().info("------------------------");
        System.out.println("&l&9 See You ！");
    }
}
