package net.Averty.tutorialmod.datagen;

import net.Averty.tutorialmod.TutorialMod;
import net.Averty.tutorialmod.block.ModBlocks;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.RotatedPillarBlock;
import net.minecraft.world.level.block.SaplingBlock;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.ForgeRegistries;
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

        logBlock(((RotatedPillarBlock) ModBlocks.Ebony_Log.get()));
        axisBlock((RotatedPillarBlock) ModBlocks.Ebony_Wood.get(), blockTexture(ModBlocks.Ebony_Log.get()), blockTexture(ModBlocks.Ebony_Log.get()));
        axisBlock((RotatedPillarBlock) ModBlocks.Stripped_Ebony_Log.get(), new ResourceLocation(TutorialMod.MOD_ID, "block/stripped_ebony_log"),
                new ResourceLocation(TutorialMod.MOD_ID, "block/stripped_ebony_log_top"));
        axisBlock((RotatedPillarBlock) ModBlocks.Stripped_Ebony_Wood.get(), new ResourceLocation(TutorialMod.MOD_ID, "block/stripped_ebony_log"),
                new ResourceLocation(TutorialMod.MOD_ID, "block/stripped_ebony_log"));

        blockWithItem(ModBlocks.Ebony_Planks);
        blockWithItem(ModBlocks.Ebony_Leaves);
        saplingBlock(ModBlocks.Ebony_Sapling);

        simpleBlockItem(ModBlocks.Ebony_Log.get(), models().withExistingParent("tutorialmod:ebony_log", "minecraft:block/cube_column"));
        simpleBlockItem(ModBlocks.Ebony_Wood.get(), models().withExistingParent("tutorialmod:ebony_wood", "minecraft:block/cube_column"));
        simpleBlockItem(ModBlocks.Stripped_Ebony_Log.get(), models().withExistingParent("tutorialmod:stripped_ebony_log", "minecraft:block/cube_column"));
        simpleBlockItem(ModBlocks.Stripped_Ebony_Wood.get(), models().withExistingParent("tutorialmod:stripped_ebony_wood", "minecraft:block/cube_column"));
    }

    private void blockWithItem(RegistryObject<Block> blockRegistryObject) {
        simpleBlockWithItem(blockRegistryObject.get(), cubeAll(blockRegistryObject.get()));
        }

        private void saplingBlock(RegistryObject<Block> blockRegistryObject) {
            simpleBlock(blockRegistryObject.get(),
                    models().cross(ForgeRegistries.BLOCKS.getKey(blockRegistryObject.get()).getPath(), blockTexture(blockRegistryObject.get())).renderType("cutout"));
        }

}