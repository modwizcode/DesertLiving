/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package github.modwiz.desertLiving;

import java.util.logging.Logger;

import github.modwiz.desertLiving.listeners.CraftingListener;
import org.bukkit.plugin.java.JavaPlugin;

/**
 *
 * @author Starbuck Johnson
 */
public class DesertLiving extends JavaPlugin{
    
    static final Logger log = Logger.getLogger("Minecraft");
    
    private Recipes recipes;
    
    @Override
    public void onEnable() {
        recipes = new Recipes(this);
        getServer().getPluginManager().registerEvents(new CraftingListener(this), this);
    }

    public Recipes getRecipeHandler() {
        return recipes;
    }
}
