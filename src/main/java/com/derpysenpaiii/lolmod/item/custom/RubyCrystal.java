package com.derpysenpaiii.lolmod.item.custom;

import com.derpysenpaiii.lolmod.LolMod;
import com.mojang.logging.LogUtils;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import org.slf4j.Logger;
import top.theillusivec4.curios.api.SlotContext;
import top.theillusivec4.curios.api.type.capability.ICurioItem;

public class RubyCrystal extends Item implements ICurioItem {
    private static final Logger LOGGER = LogUtils.getLogger();

    public RubyCrystal() {
        super(new Item.Properties().stacksTo(1));
    }

    @Override
    public void onEquip(SlotContext slotContext, ItemStack prevStack, ItemStack stack) {
        var player = (Player) slotContext.entity();
        LOGGER.info(String.valueOf(player.level().isClientSide));
        if (!player.level().isClientSide) {
            var maxHealth = player.getAttribute(Attributes.MAX_HEALTH);
            maxHealth.setBaseValue(maxHealth.getValue() + 2f);
            LOGGER.info("Player health: " + player.getHealth());
        }

        ICurioItem.super.onEquip(slotContext, prevStack, stack);
    }

    @Override
    public void onUnequip(SlotContext slotContext, ItemStack newStack, ItemStack stack) {
        var player = (Player) slotContext.entity();
        if (!player.level().isClientSide) player.getAttribute(Attributes.MAX_HEALTH).setBaseValue(player.getAttribute(Attributes.MAX_HEALTH).getValue() - 2f);
        ICurioItem.super.onUnequip(slotContext, newStack, stack);
    }
}
