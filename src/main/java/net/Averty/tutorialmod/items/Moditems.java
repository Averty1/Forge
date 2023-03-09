package net.Averty.tutorialmod.items;

import net.Averty.tutorialmod.TutorialMod;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class Moditems {
    public static final DeferredRegister<Item> Items =
            DeferredRegister.create(ForgeRegistries.ITEMS, TutorialMod.MOD_ID);

    public static final RegistryObject<Item> Black_Opal = Items.register("black_opal",
            () -> new Item(new Item.Properties()));

    public static void register(IEventBus eventBus){
        Items.register(eventBus);
    }

}
