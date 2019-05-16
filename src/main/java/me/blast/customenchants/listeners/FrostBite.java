package me.blast.customenchants.listeners;

import me.blast.customenchants.Enchantments;
import me.blast.customenchants.Main;
import org.bukkit.Particle;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import java.util.Random;

public class FrostBite extends EnchantmentsListener {

    @EventHandler
    public void onHit(EntityDamageByEntityEvent event){
        if(!(event.getDamager() instanceof Player)){return;}
        if(!(event.getEntity() instanceof LivingEntity)){return;}
        Player player = (Player) event.getEntity();
        LivingEntity entity = (LivingEntity) event.getEntity();
        if(Main.hasEnchantment(player.getInventory().getItemInMainHand(), Enchantments.FROSTBITE)) {
            int chance = getRandom(10);
            switch (Main.getLevel(player.getInventory().getItemInMainHand(), Enchantments.FROSTBITE)) {
                case 1:
                    if (chance < 1) {
                        entity.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 3, 1), true);
                        snowballParticle(entity);
                    }
                    break;
                case 2:
                    if (chance < 2) {
                        entity.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 5, 1), true);
                        snowballParticle(entity);
                    }
                    break;
                case 3:
                    if (chance < 2) {
                        entity.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 4, 2), true);
                        snowballParticle(entity);
                    }
                    break;
                case 4:
                    if (chance < 3) {
                        entity.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 10, 1), true);
                        snowballParticle(entity);
                    }
                    break;
                default:
                    return;
            }
        }
    }

    public void snowballParticle(LivingEntity entity){
        entity.getWorld().spawnParticle(Particle.SNOWBALL, entity.getLocation(), 1);
    }

    public int getRandom(int num){
        Random rand = new Random();
        int value = rand.nextInt(num);
        return value;
    }

}
