/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package github.modwiz.desertLiving;

import java.util.logging.Logger;
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
        log.info("[DesertLiving] Plugin has been enabled.");
        recipes = new Recipes();
        recipes.Load(this);
    }
    
    @Override
    public void onDisable() {
        log.info("[DesertLiving] Plugin has been disabled.");
    }
}
