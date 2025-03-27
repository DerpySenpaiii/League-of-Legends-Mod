package com.derpysenpaiii.lolmod.networking;

import com.derpysenpaiii.lolmod.LolMod;
import com.derpysenpaiii.lolmod.event.AttachmentStatsRenderEvent;
import com.mojang.logging.LogUtils;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerPlayer;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.network.PacketDistributor;
import net.neoforged.neoforge.network.event.RegisterPayloadHandlersEvent;
import net.neoforged.neoforge.network.handling.DirectionalPayloadHandler;
import net.neoforged.neoforge.network.handling.IPayloadContext;
import net.neoforged.neoforge.network.registration.HandlerThread;
import net.neoforged.neoforge.network.registration.PayloadRegistrar;
import org.slf4j.Logger;

public class ModNetwork {
    public static final ResourceLocation ABILITY_POWER_SYNC = ResourceLocation.fromNamespaceAndPath(LolMod.MODID, "ability_power_sync");
    private static Logger LOGGER = LogUtils.getLogger();

    @SubscribeEvent
    public static void register(RegisterPayloadHandlersEvent event) {
        PayloadRegistrar registrar = event.registrar("1").executesOn(HandlerThread.NETWORK);
        registrar.playBidirectional(MyData.TYPE, MyData.STREAM_CODEC, new DirectionalPayloadHandler<>(
                AttachmentStatsRenderEvent::handleAbilityPowerSync,
                ModNetwork::handleDataOnMain
        ));
    }
    public static void handleDataOnMain(final MyData data, final IPayloadContext context) {
        // Do something with the data, on the main thread
        LOGGER.info("HANDLED: " + data.name() + " " + data.age());
    }

}