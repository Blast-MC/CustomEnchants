package me.blast.customenchants;

import me.blast.customenchants.wrappers.FrostBite;
import org.bukkit.enchantments.Enchantment;

import java.util.ArrayList;
import java.util.List;

public class Enchantments {

    public static final Enchantment FROSTBITE = new FrostBite();

    public final List<Enchantment> customEnchantments = new ArrayList<>();

    public void addEnchantments(){
        customEnchantments.add(FROSTBITE);
    }

    public List<Enchantment> getCustomEnchantments(){
        return customEnchantments;
    }

}
