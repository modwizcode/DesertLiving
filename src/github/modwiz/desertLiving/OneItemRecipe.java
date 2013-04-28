/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package github.modwiz.desertLiving;

import github.modwiz.desertLiving.api.SimpleRecipe;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapelessRecipe;

/**
 *
 * @author Starbuck Johnson
 */
public class OneItemRecipe implements SimpleRecipe{

    private ShapelessRecipe shapeless;
    OneItemRecipe(ItemStack product, Material reactant) {
        shapeless = new ShapelessRecipe(product);
        shapeless.addIngredient(reactant);
        
    }
    
    public OneItemRecipe(ItemStack product, int damageValue) {
		shapeless = new ShapelessRecipe(product);
		shapeless.addIngredient(Material.CACTUS, damageValue);
	}
    
    public OneItemRecipe(Wood product, Wood reactant) {
    	shapeless = new ShapelessRecipe(new ItemStack(Material.LOG, product.toDamage()));
    	shapeless.addIngredient(Material.LOG, reactant.toDamage());
    }
    @Override
    public ShapelessRecipe getRecipe() {
        return shapeless;
    }
    
}
