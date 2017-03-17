package com.ainslie.PigRace;

import java.io.File;
import java.io.IOException;

import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.command.*;

public class PigRace extends JavaPlugin {

    //members
    protected YamlConfiguration config;
    protected File configFile;

    public void onEnable() {
        getLogger().info("Welcome to the Pig Race plugin");

        configFile = new File(getDataFolder(), "config.yml");
        if (!configFile.exists()) {
            //This will create the folder '/plugins/exampleconfig/' if it doesn't exist.
            getDataFolder().mkdirs();

            //Create a blank yaml config
            config = new YamlConfiguration();

            /* Give it a header
             * Use \n for line breaks.
             * Every line of the header WILL have '# ' added to the beginning of it.
            */
            config.options().header("This is a header.\n" + "This is more header.");

            //Set up some settings.
            config.set("blah", false);

            //Attempt to save the config.
            //This should not fail but you never know.
            try {
                config.save(configFile);
            } catch (IOException e) {
                // It blew up. Print a Strack trace.
                e.printStackTrace();
            }
        }
    }

    public void onDisable() {

    }

    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args)
    {
        if(cmd.getName().equalsIgnoreCase("PigRace")||cmd.getName().equalsIgnoreCase("PR")){
                sender.sendMessage("Welcome to PigRace! Type \"/pr help\" for help");
        }
        return true;
    }

}