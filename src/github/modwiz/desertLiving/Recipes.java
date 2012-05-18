/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package github.modwiz.desertLiving;

import org.bukkit.Material;
import org.bukkit.entity.Item;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;

/**
 *
 * @author Starbuck Johnson
 */
public class Recipes {
    private DesertLiving mainInstance;
    
    public void Load(DesertLiving plug) {
        mainInstance = plug;
        setupBlocks();
        setupTools();
    }
    
    private void setupBlocks() {
        OneItemRecipe woodRecipe = new OneItemRecipe(new ItemStack(Material.LOG,8), Material.CACTUS);
        mainInstance.getServer().addRecipe(woodRecipe.getRecipe());
        DesertLiving.log.info("[DesertLiving] Block Recipes Loaded.");
    }
    
    private void setupTools() {
        ShapedRecipe pickaxeRecipe = new ShapedRecipe(new ItemStack(Material.STONE_PICKAXE,1)).shape(new String[] {"xxx","asa","asa"}).setIngredient('a', Material.AIR).setIngredient('s', Material.STICK).setIngredient('x', Material.SANDSTONE);
        mainInstance.getServer().addRecipe(pickaxeRecipe);
        DesertLiving.log.info("[DesertLiving] Tool Recipes Loaded.");

    }
}
