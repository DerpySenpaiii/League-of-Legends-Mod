package com.derpysenpaiii.lolmod.item.custom;

import com.derpysenpaiii.lolmod.misc.ModAttachments;
import com.derpysenpaiii.lolmod.networking.MyData;
import com.mojang.logging.LogUtils;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.neoforged.neoforge.network.PacketDistributor;
import org.slf4j.Logger;
import top.theillusivec4.curios.api.SlotContext;
import top.theillusivec4.curios.api.type.capability.ICurioItem;

public class AmplifyingTome extends Item implements ICurioItem {
    private final double AP_DAMAGE_AMP = 0.5d;
    private static final Logger LOGGER = LogUtils.getLogger();


    public AmplifyingTome() {
        super(new Item.Properties().stacksTo(1));
    }

    @Override
    public void onEquip(SlotContext slotContext, ItemStack prevStack, ItemStack stack) {
        var player = (Player) slotContext.entity();

        if (player.level().isClientSide) ICurioItem.super.onEquip(slotContext, prevStack, stack);

        double abilityPower = player.getData(ModAttachments.ABILITY_POWER) ;
        player.setData(ModAttachments.ABILITY_POWER, abilityPower + AP_DAMAGE_AMP);

        LOGGER.info("Player ability power: " + player.getData(ModAttachments.ABILITY_POWER));
        PacketDistributor.sendToPlayer((ServerPlayer) player, new MyData("AmplifyingTome", player.getData(ModAttachments.ABILITY_POWER)));
        ICurioItem.super.onEquip(slotContext, prevStack, stack);
    }

    @Override
    public void onUnequip(SlotContext slotContext, ItemStack newStack, ItemStack stack) {
        var player = (Player) slotContext.entity();

        if (player.level().isClientSide()) ICurioItem.super.onUnequip(slotContext, newStack, stack);

        double abilityPower = player.getData(ModAttachments.ABILITY_POWER) ;
        player.setData(ModAttachments.ABILITY_POWER, abilityPower - AP_DAMAGE_AMP);

        PacketDistributor.sendToPlayer((ServerPlayer) player, new MyData("AmplifyingTome", player.getData(ModAttachments.ABILITY_POWER)));

        LOGGER.info("Player ability power: " + player.getData(ModAttachments.ABILITY_POWER));

        ICurioItem.super.onUnequip(slotContext, newStack, stack);
    }
}
