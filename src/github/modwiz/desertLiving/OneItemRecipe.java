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

/**
 *
 * @author Starbuck Johnson
 */
public class OneItemRecipe implements SimpleRecipe{

    private Recipe recipe;
    OneItemRecipe(ItemStack product, Material reactant) {
        ShapelessRecipe shapeless = new ShapelessRecipe(product);
        shapeless.addIngredient(reactant);
        recipe = shapeless;
    }
    
    public OneItemRecipe(ItemStack product, int damageValue) {
		ShapelessRecipe shapeless = new ShapelessRecipe(product);
		shapeless.addIngredient(Material.CACTUS, damageValue);
		recipe = shapeless;
	}
    
    public OneItemRecipe(Wood product, Wood reactant) {
    	ShapedRecipe shaped = new ShapedRecipe(new ItemStack(Material.LOG, product.toDamage()));
    	shaped.shape("LL");
    	shaped.setIngredient('L',Material.LOG, reactant.toDamage());
    	recipe = shaped;
    }
    
    @Override
    public Recipe getRecipe() {
        return recipe;
    }
    
}
