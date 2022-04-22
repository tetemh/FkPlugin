package eu.tetemh.fkplugin;

import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {

    public String name = "[ FKPlugin ] : ";

    @Override
    public void onEnable() {
        saveDefaultConfig();
        System.out.println(name + "FKPlugin ON");
    }
}
