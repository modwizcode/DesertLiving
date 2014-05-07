/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package github.modwiz.desertLiving;

import org.bukkit.Material;
import org.bukkit.TreeSpecies;
import org.bukkit.entity.Item;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.Recipe;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.inventory.ShapelessRecipe;
import org.bukkit.material.Tree;
import ro.thehunters.digi.recipeUtil.RecipeUtil;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Starbuck Johnson
 */
public class Recipes {
    private DesertLiving mainInstance;

    private List<Recipe> desertBiomeRecipes = new ArrayList<Recipe>();

    public Recipes(DesertLiving plug) {
        mainInstance = plug;
        setupBlocks();
        setupTools();
    }

    public boolean isDesertOnly(Recipe r) {
        for (Recipe recipe : desertBiomeRecipes) {
            if (RecipeUtil.areEqual(recipe, r)) {
                return true;
            }
        }
        return false;
    }

    private void setupBlocks() {

        // Cactus recipe now makes a sapling for more balance
        OneItemRecipe cactusSapling = new OneItemRecipe(new ItemStack(Material.SAPLING,3), Material.CACTUS);
        OneItemRecipe sandDirt = new OneItemRecipe(new ItemStack(Material.DIRT, 4), Material.SAND);

        ShapedRecipe dryWater = new ShapedRecipe(new ItemStack(Material.WATER_BUCKET,2));
        dryWater.shape("TST","TTT");
        dryWater.setIngredient('T',Material.STONE);
        dryWater.setIngredient('S',Material.SAND);

        for (int i = 0; i < TreeSpecies.values().length - 1; i++) {
            ItemStack sapling = new ItemStack(Material.SAPLING);
            sapling.setDurability(TreeSpecies.values()[i+1].getData());
            OneItemRecipe recipe = new OneItemRecipe(sapling, Material.SAPLING, TreeSpecies.values()[i].getData());

            //System.out.println(TreeSpecies.values()[i].name() + "->" + TreeSpecies.values()[i+1].name());
            addRecipe(recipe.getRecipe());
        }

        // Add the loop recipe for back to generic
        ItemStack sapling = new ItemStack(Material.SAPLING);
        sapling.setDurability(TreeSpecies.GENERIC.getData());
        OneItemRecipe saplingReset = new OneItemRecipe(sapling, Material.SAPLING, TreeSpecies.DARK_OAK.getData());

        addRecipe(cactusSapling.getRecipe());
        addRecipe(sandDirt.getRecipe());
        addRecipe(dryWater);
        addRecipe(saplingReset.getRecipe());

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
        desertBiomeRecipes.add(r);
    }
}
