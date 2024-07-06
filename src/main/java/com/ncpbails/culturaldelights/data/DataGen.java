package com.ncpbails.culturaldelights.data;

import com.ncpbails.culturaldelights.CulturalDelights;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.minecraftforge.data.event.GatherDataEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, modid = CulturalDelights.MOD_ID)
public class DataGen {

   @SubscribeEvent
   public static void gatherData( final GatherDataEvent event ) {
      DataGenerator gen = event.getGenerator();
      PackOutput output = gen.getPackOutput();

      gen.addProvider(event.includeServer(), new DatapackRegistryProvider(output, event.getLookupProvider()));
   }
}
