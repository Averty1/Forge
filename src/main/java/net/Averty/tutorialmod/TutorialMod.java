package net.Averty.tutorialmod;

import com.mojang.logging.LogUtils;
import net.Averty.tutorialmod.block.ModBlocks;
import net.Averty.tutorialmod.items.ModCreativeModeTabs;
import net.Averty.tutorialmod.items.Moditems;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.CreativeModeTabEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(TutorialMod.MOD_ID)
public class TutorialMod {
    // Define mod id in a common place for everything to reference
    public static final String MOD_ID = "tutorialmod";
    // Directly reference a slf4j logger
    private static final Logger LOGGER = LogUtils.getLogger();
    public TutorialMod() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        Moditems.register(modEventBus);
        ModBlocks.register(modEventBus);

        modEventBus.addListener(this::commonSetup);

        MinecraftForge.EVENT_BUS.register(this);


        modEventBus.addListener(this::addCreative);
    }

    private void commonSetup(final FMLCommonSetupEvent event) {

    }

    private void addCreative(CreativeModeTabEvent.BuildContents event) {
        if(event.getTab() == CreativeModeTabs.INGREDIENTS){
            event.accept(Moditems.Black_Opal);
            event.accept(Moditems.Raw_Black_Opal);
            event.accept(Moditems.Mossy_Sword);
        }

        if (event.getTab() == CreativeModeTabs.BUILDING_BLOCKS){
            event.accept(ModBlocks.Black_Opal_Block);
            event.accept(ModBlocks.Black_Opal_Ore);
            event.accept(ModBlocks.Deepslate_Black_Opal_Ore);
            event.accept(ModBlocks.Netherrack_Black_Opal_Ore);
            event.accept(ModBlocks.Endstone_Black_Opal_Ore);
        }

        if(event.getTab() == ModCreativeModeTabs.TUTORIAL_TAB){
            event.accept(Moditems.Black_Opal);
            event.accept(Moditems.Raw_Black_Opal);
            event.accept(Moditems.Mossy_Sword);

            event.accept(ModBlocks.Black_Opal_Block);
            event.accept(ModBlocks.Black_Opal_Ore);
            event.accept(ModBlocks.Deepslate_Black_Opal_Ore);
            event.accept(ModBlocks.Netherrack_Black_Opal_Ore);
            event.accept(ModBlocks.Endstone_Black_Opal_Ore);
        }
    }

    // You can use EventBusSubscriber to automatically register all static methods in the class annotated with @SubscribeEvent
    @Mod.EventBusSubscriber(modid = MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event) {

        }
    }
}
