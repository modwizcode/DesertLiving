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
    @Override
    public ShapelessRecipe getRecipe() {
        return shapeless;
    }
    
}
