package cf.redstart.scpsl;

import org.bukkit.plugin.java.JavaPlugin;

import java.util.Objects;

public final class SCPSL extends JavaPlugin {

    @Override
    public void onEnable() {
        saveDefaultConfig();
        getLogger().info("插件当前语言文件为:"+getConfig().getString("lang"));
        this.saveResource("zh_CN.yml",false);
        getLogger().info("------------------------");
        getLogger().info("|        SCPSL         |");
        getLogger().info("|  作者: pingguomc     |");
        getLogger().info("|      插件正在加载    |");
        getLogger().info("------------------------");
        getLogger().warning("注意！本插件和其他玩法类插件不兼容，且不要将本插件在非小游戏服务器加载");
        Objects.requireNonNull(this.getCommand("scpsl")).setExecutor(this);
    }

    @Override
    public void onDisable() {
        getLogger().info("------------------------");
        getLogger().info("|        SCPSL         |");
        getLogger().info("|  作者: pingguomc     |");
        getLogger().info("|      插件已经卸载    |");
        getLogger().info("|         再见！       |");
        getLogger().info("------------------------");

    }
}
