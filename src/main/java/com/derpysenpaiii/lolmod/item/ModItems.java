package com.derpysenpaiii.lolmod.item;

import com.derpysenpaiii.lolmod.LolMod;
import com.derpysenpaiii.lolmod.item.custom.AmplifyingTome;
import com.derpysenpaiii.lolmod.item.custom.RubyCrystal;
import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;
import top.theillusivec4.curios.api.type.capability.ICurioItem;

public class ModItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(LolMod.MODID);

    public static final DeferredItem<RubyCrystal> RUBY_CRISTAL = ITEMS.register("ruby_crystal", RubyCrystal::new);
    public static final DeferredItem<Item> HAUNTING_GUISE = ITEMS.register("haunting_guise", () -> new Item(new Item.Properties()));
    public static final DeferredItem<AmplifyingTome> AMPLIFYING_TOME = ITEMS.register("amplifying_tome", AmplifyingTome::new);
    public static final DeferredItem<Item> FATED_ASHES = ITEMS.register("fated_ashes", () -> new Item(new Item.Properties()));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }


}



