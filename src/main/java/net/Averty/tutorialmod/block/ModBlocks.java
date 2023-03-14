package net.Averty.tutorialmod.block;

import com.mojang.blaze3d.shaders.Uniform;
import net.Averty.tutorialmod.TutorialMod;
import net.Averty.tutorialmod.block.custom.ModFlammableRotatedPillarBlock;
import net.Averty.tutorialmod.items.Moditems;
import net.Averty.tutorialmod.worldgen.tree.EbonyTreeGrower;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister<Block> Blocks =
            DeferredRegister.create(ForgeRegistries.BLOCKS, TutorialMod.MOD_ID);

    public static final RegistryObject<Block> Black_Opal_Block = registerBlock("black_opal_block",
            () -> new Block(BlockBehaviour.Properties.of(Material.METAL)
                    .strength(6f).requiresCorrectToolForDrops()));

    public static final RegistryObject<Block> Black_Opal_Ore = registerBlock("black_opal_ore",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.of(Material.STONE)
                    .strength(5f).requiresCorrectToolForDrops(), UniformInt.of(2, 6)));
    public static final RegistryObject<Block> Deepslate_Black_Opal_Ore = registerBlock("deepslate_black_opal_ore",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.of(Material.STONE)
                    .strength(8f).requiresCorrectToolForDrops(), UniformInt.of(2, 6)));
    public static final RegistryObject<Block> Netherrack_Black_Opal_Ore = registerBlock("netherrack_black_opal_ore",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.of(Material.STONE)
                    .strength(4f).requiresCorrectToolForDrops(), UniformInt.of(2, 6)));
    public static final RegistryObject<Block> Endstone_Black_Opal_Ore = registerBlock("endstone_black_opal_ore",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.of(Material.STONE)
                    .strength(9f).requiresCorrectToolForDrops(), UniformInt.of(2, 6)));


    public static final RegistryObject<Block> Ebony_Log = registerBlock("ebony_log",
            () -> new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.copy(net.minecraft.world.level.block.Blocks.OAK_LOG)
                    .strength(5f).requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> Ebony_Wood = registerBlock("ebony_wood",
            () -> new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.copy(net.minecraft.world.level.block.Blocks.OAK_WOOD)
                    .strength(5f).requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> Stripped_Ebony_Log = registerBlock("stripped_ebony_log",
            () -> new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.copy(net.minecraft.world.level.block.Blocks.STRIPPED_OAK_LOG)
                    .strength(5f).requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> Stripped_Ebony_Wood = registerBlock("stripped_ebony_wood",
            () -> new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.copy(net.minecraft.world.level.block.Blocks.STRIPPED_OAK_WOOD)
                    .strength(5f).requiresCorrectToolForDrops()));

    public static final RegistryObject<Block> Ebony_Planks = registerBlock("ebony_planks",
            () -> new Block(BlockBehaviour.Properties.copy(net.minecraft.world.level.block.Blocks.OAK_PLANKS)
                    .strength(5f)) {
                @Override
                public boolean isFlammable(BlockState state, BlockGetter world, BlockPos pos, Direction face) {
                    return true;
                }

                @Override
                public int getFlammability(BlockState state, BlockGetter world, BlockPos pos, Direction face) {
                    return 5;
                }

                @Override
                public int getFireSpreadSpeed(BlockState state, BlockGetter world, BlockPos pos, Direction face) {
                    return 20;
                }
            });
    public static final RegistryObject<Block> Ebony_Leaves = registerBlock("ebony_leaves",
            () -> new LeavesBlock(BlockBehaviour.Properties.copy(net.minecraft.world.level.block.Blocks.OAK_LEAVES)) {
                @Override
                public boolean isFlammable(BlockState state, BlockGetter world, BlockPos pos, Direction face) {
                    return true;
                }

                @Override
                public int getFlammability(BlockState state, BlockGetter world, BlockPos pos, Direction face) {
                    return 30;
                }

                @Override
                public int getFireSpreadSpeed(BlockState state, BlockGetter world, BlockPos pos, Direction face) {
                    return 60;
                }
            });

    public static final RegistryObject<Block> Ebony_Sapling = registerBlock("ebony_sapling",
            () -> new SaplingBlock(new EbonyTreeGrower(),BlockBehaviour.Properties.copy(net.minecraft.world.level.block.Blocks.OAK_SAPLING)));


    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block){
        RegistryObject<T> toReturn = Blocks.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    private static <T extends Block> RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> Block){
        return Moditems.Items.register(name, () -> new BlockItem(Block.get(),
                new Item.Properties()));
    }

    public static void register(IEventBus eventBus){
        Blocks.register(eventBus);
    }
}
