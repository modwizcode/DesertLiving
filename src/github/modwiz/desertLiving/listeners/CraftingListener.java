package github.modwiz.desertLiving.listeners;

import github.modwiz.desertLiving.DesertLiving;
import org.bukkit.Chunk;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Biome;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.PrepareItemCraftEvent;
import org.bukkit.inventory.CraftingInventory;
import org.bukkit.inventory.ItemStack;

/**
 * Created by modwi_000 on 5/6/2014.
 */
public class CraftingListener implements Listener {
    private DesertLiving plugin;

    public CraftingListener(DesertLiving desertLiving) {
        plugin = desertLiving;
    }

    @EventHandler
    public void onPreCraft(PrepareItemCraftEvent event) {
        if (plugin.getRecipeHandler().isDesertOnly(event.getRecipe())) {
            //System.out.println("Desert only recipe");
            Player player = (Player) event.getView().getPlayer();
            World world = player.getWorld();
            Chunk chunk = player.getLocation().getChunk();
            Biome biome = world.getBiome(chunk.getX(), chunk.getZ());
            if (biome == Biome.DESERT || biome == Biome.DESERT_HILLS || biome == Biome.DESERT_MOUNTAINS) {
                // Oops
            } else {
                event.getInventory().setResult(new ItemStack(Material.AIR));
            }
        }
        /* for (ItemStack item : event.getInventory().getMatrix()) {
                if (item != null && item.getType() != Material.AIR) {
                    if (item.getAmount() < 2) {
                        event.getInventory().setResult(new ItemStack(Material.AIR));
                    }
                    plugin.getLogger().info(item.toString() + " " + item.getDurability());
                }
            }
        */
    }

    @EventHandler
    public void onInventoryClick(InventoryClickEvent event) {
        if (event.getInventory() instanceof CraftingInventory) {
          //  plugin.getServer().getPluginManager().callEvent(new PrepareItemCraftEvent((CraftingInventory)event.getInventory(), event.getView(), false));
        }
    }
}
