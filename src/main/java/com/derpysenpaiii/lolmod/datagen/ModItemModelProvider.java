package com.derpysenpaiii.lolmod.datagen;

import com.derpysenpaiii.lolmod.LolMod;
import com.derpysenpaiii.lolmod.item.ModItems;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.client.model.generators.ItemModelProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;

public class ModItemModelProvider extends ItemModelProvider {
    public ModItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, LolMod.MODID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        basicItem(ModItems.RUBY_CRISTAL.get());
        basicItem(ModItems.HAUNTING_GUISE.get());
        basicItem(ModItems.AMPLIFYING_TOME.get());
        basicItem(ModItems.FATED_ASHES.get());
    }

}
