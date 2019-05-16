package me.blast.customenchants;

import me.blast.customenchants.listeners.FrostBite;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.event.Listener;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;

import java.lang.reflect.Field;
import java.util.Iterator;
import java.util.Map;

public class Main extends JavaPlugin implements Listener {

    public static Main PLUGIN;

    public void onEnable(){
        PLUGIN = this;
        ENCHANTMENTS.addEnchantments();
        for(Enchantment ench : ENCHANTMENTS.getCustomEnchantments()){
            registerEnchantment(ench);

        }
        getServer().getPluginManager().registerEvents(new FrostBite(), this);
    }

    Enchantments ENCHANTMENTS = new Enchantments();

    public static void registerEnchantment(Enchantment enchantment) {
        boolean registered = true;
        try {
            Field f = Enchantment.class.getDeclaredField("acceptingNew");
            f.setAccessible(true);
            f.set(null, true);
            Enchantment.registerEnchantment(enchantment);
        } catch (Exception e) {
            registered = false;
            e.printStackTrace();
        }
        if(registered){
            // It's been registered!
        }
    }

    public static boolean hasEnchantment(ItemStack item, Enchantment enchant){
        if(item.getItemMeta() != null && item.getItemMeta().getEnchants() != null && item.getItemMeta().getEnchants().size() > 0){
            for (Iterator<Map.Entry<Enchantment, Integer>> it = item.getItemMeta().getEnchants().entrySet().iterator(); it.hasNext();) {
                java.util.Map.Entry<Enchantment, Integer> e = it.next();
                if(e.getKey().equals(enchant)){
                    return true;
                }
            }
        }
        return false;
    }

    public static int getLevel(ItemStack item, Enchantment enchant){
        if(item.getItemMeta() != null && item.getItemMeta().getEnchants() != null && item.getItemMeta().getEnchants().size() > 0){
            for (Iterator<java.util.Map.Entry<Enchantment, Integer>> it = item.getItemMeta().getEnchants().entrySet().iterator(); it.hasNext();) {
                java.util.Map.Entry<Enchantment, Integer> e = it.next();
                if(e.getKey().equals(enchant)){
                    return e.getValue();
                }
            }
        }
        return 0;
    }

}
