package com.derpysenpaiii.lolmod.datagen;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import top.theillusivec4.curios.api.CuriosDataProvider;
import top.theillusivec4.curios.api.SlotTypePreset;

import java.util.concurrent.CompletableFuture;

public class CurioTestProvider extends CuriosDataProvider {
    public CurioTestProvider(String modId, PackOutput output, ExistingFileHelper fileHelper, CompletableFuture<HolderLookup.Provider> registries) {
        super(modId, output, fileHelper, registries);
    }


    @Override
    public void generate(HolderLookup.Provider registries, ExistingFileHelper fileHelper) {
    }
}
