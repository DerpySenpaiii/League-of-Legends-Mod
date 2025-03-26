package com.derpysenpaiii.lolmod.datagen;

import com.derpysenpaiii.lolmod.LolMod;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.client.model.generators.BlockStateProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.registries.DeferredBlock;

public class ModBlockStateProvider extends BlockStateProvider {
    public ModBlockStateProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, LolMod.MODID, existingFileHelper);
    }
    @Override
    protected void registerStatesAndModels() {
        //blockWithItem(ModBlocks.HIEREINMOD);
    }

    private void blockWithItem(DeferredBlock<?> deferredBlock) {
        simpleBlockItem(deferredBlock.get(), cubeAll(deferredBlock.get()));
    }
}
