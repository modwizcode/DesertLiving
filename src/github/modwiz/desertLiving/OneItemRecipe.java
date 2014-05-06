/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package github.modwiz.desertLiving;

import github.modwiz.desertLiving.api.SimpleRecipe;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.Recipe;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.inventory.ShapelessRecipe;
import org.bukkit.material.MaterialData;

/**
 * Helps single item conversion code to work smoothly
 * @author Starbuck Johnson
 */
public class OneItemRecipe implements SimpleRecipe{

    private Recipe recipe;

    OneItemRecipe(ItemStack product, Material reactant) {
        ShapelessRecipe shapeless = new ShapelessRecipe(product);
        shapeless.addIngredient(reactant);
        recipe = shapeless;
    }
    
    public OneItemRecipe(ItemStack product, MaterialData materialData) {
		ShapelessRecipe shapeless = new ShapelessRecipe(product);
		shapeless.addIngredient(materialData);
		recipe = shapeless;
	}
    
    @Override
    public Recipe getRecipe() {
        return recipe;
    }
    
}
