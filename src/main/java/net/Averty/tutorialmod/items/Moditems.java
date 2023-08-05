package net.Averty.tutorialmod.items;

import net.Averty.tutorialmod.TutorialMod;
import net.Averty.tutorialmod.entity.ModEntities;
import net.minecraft.util.datafix.fixes.WeaponSmithChestLootTableFix;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ProjectileWeaponItem;
import net.minecraftforge.common.ForgeSpawnEggItem;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class Moditems {
    public static final DeferredRegister<Item> Items =
            DeferredRegister.create(ForgeRegistries.ITEMS, TutorialMod.MOD_ID);

    public static final RegistryObject<Item> Black_Opal = Items.register("black_opal",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> Raw_Black_Opal = Items.register("raw_black_opal",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> Mossy_Sword = Items.register("mossy_sword",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> Tiger_Spawn_Egg = Items.register("tiger_spawn_egg",
            () -> new ForgeSpawnEggItem(ModEntities.TIGER, 0xD57E36, 0x1D0D00,
                    new Item.Properties()));

    public static void register(IEventBus eventBus){
        Items.register(eventBus);
    }

}
