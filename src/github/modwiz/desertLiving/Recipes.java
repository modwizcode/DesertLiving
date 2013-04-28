/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package github.modwiz.desertLiving;

import org.bukkit.Material;
import org.bukkit.entity.Item;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.Recipe;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.inventory.ShapelessRecipe;

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
        OneItemRecipe oakToSpruce = new OneItemRecipe(Wood.SPRUCE, Wood.OAK);
        OneItemRecipe spruceToBirch = new OneItemRecipe(Wood.BIRCH, Wood.SPRUCE);
        OneItemRecipe birchToJungle = new OneItemRecipe(Wood.BIRCH, Wood.JUNGLE);
        OneItemRecipe jungleToOak = new OneItemRecipe(Wood.JUNGLE, Wood.OAK);
        addRecipe(woodRecipe.getRecipe());
        addRecipe(oakToSpruce.getRecipe());
        addRecipe(spruceToBirch.getRecipe());
        addRecipe(birchToJungle.getRecipe());
        addRecipe(jungleToOak.getRecipe());
        
        DesertLiving.log.info("[DesertLiving] Block Recipes Loaded.");
    }
    
    private void setupTools() {
        ShapedRecipe pickaxeRecipe = new ShapedRecipe(new ItemStack(Material.STONE_PICKAXE,1)).shape(new String[] {"xxx","asa","asa"}).setIngredient('a', Material.AIR).setIngredient('s', Material.STICK).setIngredient('x', Material.SANDSTONE);
        mainInstance.getServer().addRecipe(pickaxeRecipe);
        DesertLiving.log.info("[DesertLiving] Tool Recipes Loaded.");

    }
    
    private void addRecipe(Recipe r) {
    	if (r == null) {
    		throw new IllegalArgumentException("Recipe was null");
    	} else if (mainInstance == null) {
    		throw new IllegalArgumentException("Plugin instance was null");
    	}
    	
    	mainInstance.getServer().addRecipe(r);
    }
}
