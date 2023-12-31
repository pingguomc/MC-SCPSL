package top.redstarmc.scpsl.command;

import org.bukkit.ChatColor;
import org.bukkit.command.*;
import java.util.ArrayList;
import java.util.List;

import static top.redstarmc.scpsl.SCPSL.*;

/**
 * 注册指令
 */

public class SCPSLCommand implements CommandExecutor, TabExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (args.length == 0) {               //没输入东西
            sender.sendMessage(ChatColor.BLUE+"请输入/scpsl help查看帮助");
            return true;
        }else if (args.length == 1){           //输入一个东西
            String Cmd_1 = args[0];
            if (Cmd_1.equals("help")) {
                sender.sendMessage(ChatColor.BLUE+"1" );
                return true;
            }else if (Cmd_1.equals("start")){
                sender.sendMessage(ChatColor.BLUE+"强制开始游戏");
                Game_state = true;
                Game_pause = false;
                return true;
            }else if (Cmd_1.equals("over")){
                sender.sendMessage(ChatColor.BLUE+"强行停止游戏");
                Game_state = false;
                Game_pause = true;
                return true;
            }else if (Cmd_1.equals("god")){
                sender.sendMessage("你无敌了");
                return true;
            }else if (Cmd_1.equals("give")){
                sender.sendMessage(ChatColor.BLUE+"请输入/scpsl help查看帮助");
                return true;
            }else if (Cmd_1.equals("become")){
                sender.sendMessage(ChatColor.BLUE+"请输入/scpsl help查看帮助");
                return true;
            }else if (Cmd_1.equals("alpha")){
                sender.sendMessage(ChatColor.BLUE+"请输入/scpsl help查看帮助");
                return true;
            }else {
                sender.sendMessage(ChatColor.RED+"未知指令！");
                return true;
            }
        }else if(args.length == 2){                              //输入两个东西
            String Cmd_1 = args[0];
            String Cmd_2 = args[1];
            if (Cmd_1.equals("give")){
                if (Cmd_2.equals("SCP-018")){
                    sender.sendMessage("弹力球");
                    return true;
                }else {
                    sender.sendMessage(ChatColor.RED+"未知指令！");
                    return true;
                }
            }else if (Cmd_1.equals("become")){
                if (Cmd_2.equals("SCP-173")) {
                    sender.sendMessage("你成为了SCP-173");
                    return true;
                }else {
                    sender.sendMessage(ChatColor.RED+"未知指令！");
                    return true;
                }
            }else if(Cmd_1.equals("alpha")){
                if (Cmd_2.equals("open")){
                    sender.sendMessage("开启核弹");
                    return true;
                }else if (Cmd_2.equals("close")){
                    sender.sendMessage("关闭核弹");
                    return true;
                }else if (Cmd_2.equals("boom")){
                    sender.sendMessage("立即引爆核弹");
                    return true;
                }else {
                    sender.sendMessage(ChatColor.RED+"未知指令！");
                }
            }else {
                sender.sendMessage(ChatColor.RED+"未知指令！");
            }
        }else {
            sender.sendMessage(ChatColor.RED+"未知指令！");
            return true;
        }
        return false;
    }

    @Override
    public List<String> onTabComplete(CommandSender sender, Command command, String label, String[] args) {
        if (args.length == 1) {
            List<String> list = new ArrayList<>();
            list.add("help");list.add("start");list.add("over");list.add("god");list.add("give");list.add("become");list.add("alpha");
            return list;
        }else if(args.length == 2) {
            String Cmd_1 = args[0];
            if (Cmd_1.equals("g")){
                List<String> list = new ArrayList<>();
                list.add("give");list.add("god");
                return list;
            }
        }
        return null;
    }
}

