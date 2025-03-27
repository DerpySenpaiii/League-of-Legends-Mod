package com.derpysenpaiii.lolmod.event;

import com.derpysenpaiii.lolmod.LolMod;
import com.derpysenpaiii.lolmod.misc.ModAttachments;
import com.derpysenpaiii.lolmod.networking.MyData;
import com.mojang.logging.LogUtils;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.screens.inventory.InventoryScreen;
import net.minecraft.network.chat.Component;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.ScreenEvent;
import net.neoforged.neoforge.network.handling.IPayloadContext;
import net.neoforged.neoforge.network.registration.NetworkRegistry;
import net.neoforged.neoforge.network.registration.PayloadRegistrar;
import org.slf4j.Logger;

@EventBusSubscriber(modid = LolMod.MODID)
public class AttachmentStatsRenderEvent {

    private static double abilityPower = 0;

    private static Logger LOGGER = LogUtils.getLogger();
    @SubscribeEvent
    public static void onScreenRender(ScreenEvent.Render.Post event) {
        if (event.getScreen() instanceof InventoryScreen) {
            var minecraft = Minecraft.getInstance();

            var text = "Ability Power: " + abilityPower;
            LOGGER.info(text);
            event.getGuiGraphics().drawString(
                    minecraft.font,
                    Component.literal(text),
                    event.getScreen().width / 2 - 80,
                    event.getScreen().height / 2 - 80,
                    0x675DE9
            );

        }
    }

    public static void handleAbilityPowerSync(final MyData data, final IPayloadContext context) {
        abilityPower = data.age();
    }

}
