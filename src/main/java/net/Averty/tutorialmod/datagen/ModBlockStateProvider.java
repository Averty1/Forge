package net.Averty.tutorialmod.datagen;

import net.Averty.tutorialmod.TutorialMod;
import net.Averty.tutorialmod.block.ModBlocks;
import net.minecraft.data.PackOutput;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;

public class ModBlockStateProvider extends BlockStateProvider {
    public ModBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, TutorialMod.MOD_ID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        blockWithItem(ModBlocks.Black_Opal_Block);
        blockWithItem(ModBlocks.Black_Opal_Ore);
        blockWithItem(ModBlocks.Deepslate_Black_Opal_Ore);
        blockWithItem(ModBlocks.Endstone_Black_Opal_Ore);
        blockWithItem(ModBlocks.Netherrack_Black_Opal_Ore);
    }

    private void blockWithItem(RegistryObject<Block> blockRegistryObject) {
        simpleBlockWithItem(blockRegistryObject.get(), cubeAll(blockRegistryObject.get()));
    }
}