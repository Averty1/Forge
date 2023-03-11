package net.Averty.tutorialmod.datagen;

import net.Averty.tutorialmod.block.ModBlocks;
import net.Averty.tutorialmod.items.Moditems;
import net.Averty.tutorialmod.items.Moditems;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.registries.RegistryObject;

import java.util.Set;

public class ModBlockLootTables extends BlockLootSubProvider {
    public ModBlockLootTables() {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags());
    }

    @Override
    protected void generate() {
        dropSelf(ModBlocks.Black_Opal_Block.get());

        add(ModBlocks.Black_Opal_Ore.get(),
                (block) -> createOreDrop(ModBlocks.Black_Opal_Ore.get(), Moditems.Raw_Black_Opal.get()));
        add(ModBlocks.Deepslate_Black_Opal_Ore.get(),
                (block) -> createOreDrop(ModBlocks.Deepslate_Black_Opal_Ore.get(), Moditems.Raw_Black_Opal.get()));
        add(ModBlocks.Netherrack_Black_Opal_Ore.get(),
                (block) -> createOreDrop(ModBlocks.Netherrack_Black_Opal_Ore.get(), Moditems.Raw_Black_Opal.get()));
        add(ModBlocks.Endstone_Black_Opal_Ore.get(),
                (block) -> createOreDrop(ModBlocks.Endstone_Black_Opal_Ore.get(), Moditems.Raw_Black_Opal.get()));
    }

    @Override
    protected Iterable<Block> getKnownBlocks() {
        return ModBlocks.Blocks.getEntries().stream().map(RegistryObject::get)::iterator;
    }
}
