package com.derpysenpaiii.lolmod.misc;

import com.derpysenpaiii.lolmod.LolMod;
import com.mojang.serialization.Codec;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.attachment.AttachmentType;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.NeoForgeRegistries;

import java.util.function.Supplier;

public class ModAttachments {
    private static final DeferredRegister<AttachmentType<?>> ATTACHMENT_TYPES = DeferredRegister.create(NeoForgeRegistries.Keys.ATTACHMENT_TYPES, LolMod.MODID);

    public static final Supplier<AttachmentType<Double>> ABILITY_POWER = ATTACHMENT_TYPES.register("ability_power", () -> AttachmentType.builder(() -> 0d).serialize(Codec.DOUBLE).build());

    public static void register(IEventBus eventBus) {
        ATTACHMENT_TYPES.register(eventBus);
    }
}
