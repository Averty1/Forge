package net.Averty.tutorialmod.event;

import net.Averty.tutorialmod.TutorialMod;
import net.Averty.tutorialmod.entity.ModEntities;
import net.Averty.tutorialmod.entity.custom.TigerEntity;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = TutorialMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModEvents {
    @SubscribeEvent
    public static void entityAttributeEvent(EntityAttributeCreationEvent event) {
        event.put(ModEntities.TIGER.get(), TigerEntity.setAttributes());
    }
}