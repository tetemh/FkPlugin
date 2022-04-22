package eu.tetemh.fkplugin.commands;

import eu.tetemh.fkplugin.Main;
import eu.tetemh.fkplugin.Runnable;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;

public class FkGamerules implements CommandExecutor {

    private FileConfiguration config =  Main.getInstance().getConfig();

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String aliases, String[] args) {
        if(sender instanceof Player){
            Player player = (Player) sender;
            if(args.length != 0){
                switch(args[0]){




                    case "NetherDay" :
                        if(args.length == 2){
                            config.set("Rules.NetherDay", Integer.valueOf(args[1]));
                            Main.getInstance().saveConfig();
                            Main.getInstance().reloadConfig();
                            player.sendMessage("Nether Day are setup to " + args[1]);
                        }else{
                            player.sendMessage("Nether Day : " + config.getInt("Rules.NetherDay"));
                        }
                        break;






                    case "PvpDay" :
                        if(args.length == 2){
                            config.set("Rules.PvpDay", Integer.valueOf(args[1]));
                            Main.getInstance().saveConfig();
                            Main.getInstance().reloadConfig();
                            player.sendMessage("Pvp Day are setup to " + args[1]);
                        }else{
                            player.sendMessage("Pvp Day : " + config.getInt("Rules.PvpDay"));
                        }
                        break;

                    case "EndDay" :
                        if(args.length == 2){
                            config.set("Rules.EndDay", Integer.valueOf(args[1]));
                            Main.getInstance().saveConfig();
                            Main.getInstance().reloadConfig();
                            player.sendMessage("End Day are setup to " + args[1]);
                        }else{
                            player.sendMessage("End Day : " + config.getInt("Rules.EndDay"));
                        }
                        break;

                    case "WarDay":
                        if(args.length == 2){
                            config.set("Rules.WarDay", Integer.valueOf(args[1]));
                            Main.getInstance().saveConfig();
                            Main.getInstance().reloadConfig();
                            player.sendMessage("War Day are setup to " + args[1]);
                        }else{
                            player.sendMessage("War Day : " + config.getInt("Rules.WarDay"));
                        }
                        break;
                }
            }
        }
        return false;
    }


}
