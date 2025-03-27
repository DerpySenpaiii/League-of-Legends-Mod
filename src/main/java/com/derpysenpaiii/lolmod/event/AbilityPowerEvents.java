package com.derpysenpaiii.lolmod.event;

import com.derpysenpaiii.lolmod.LolMod;
import com.derpysenpaiii.lolmod.misc.ModAttachments;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.entity.EntityJoinLevelEvent;

@EventBusSubscriber(modid = LolMod.MODID)
public class AbilityPowerEvents {
    @SubscribeEvent
    public static void onProjectileShoot(EntityJoinLevelEvent event) {
        if (event.getEntity() instanceof AbstractArrow arrow && arrow.getOwner() instanceof Player player) {
            double abilityPower = player.getData(ModAttachments.ABILITY_POWER);
            arrow.setBaseDamage(arrow.getBaseDamage() + abilityPower);
        }
    }
}
