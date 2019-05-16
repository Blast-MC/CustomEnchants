package me.blast.customenchants.wrappers;

import me.blast.customenchants.Main;
import org.bukkit.NamespacedKey;
import org.bukkit.enchantments.Enchantment;

public abstract class CustomEnchantmentWrapper extends Enchantment{

    public CustomEnchantmentWrapper(String namespace) {
        super(new NamespacedKey(Main.PLUGIN, namespace));
    }

}
