package com.ncpbails.culturaldelights;

import com.mojang.logging.LogUtils;
import com.ncpbails.culturaldelights.block.ModBlocks;
import com.ncpbails.culturaldelights.item.ModItems;
import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;
import vectorwing.farmersdelight.common.registry.ModCreativeTabs;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(CulturalDelights.MOD_ID)
public class CulturalDelights {
   // Define mod id in a common place for everything to reference
   public static final String MOD_ID = "culturaldelights";
   // Directly reference a slf4j logger
   private static final Logger LOGGER = LogUtils.getLogger();
   // Create a Deferred Register to hold Blocks which will all be registered under the "examplemod" namespace


   public CulturalDelights() {
      IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
      modEventBus.addListener(this::commonSetup);

      ModItems.register(modEventBus);
      ModBlocks.register(modEventBus);

      MinecraftForge.EVENT_BUS.register(this);
      modEventBus.addListener(this::addCreative);
   }

   private void commonSetup( final FMLCommonSetupEvent event ) {

   }

   // Add the example block item to the building blocks tab
   private void addCreative( BuildCreativeModeTabContentsEvent event ) {
      if ( event.getTabKey() == ModCreativeTabs.TAB_FARMERS_DELIGHT.getKey() ) {
         event.accept(ModItems.CUCUMBER_SEEDS);
         event.accept(ModItems.CORN_KERNELS);
         event.accept(ModItems.EGGPLANT_SEEDS);
         event.accept(ModItems.GINGER);
         event.accept(ModItems.AVOCADO);
         event.accept(ModItems.CUT_AVOCADO);
         event.accept(ModItems.CUCUMBER);
         event.accept(ModItems.PICKLE);
         event.accept(ModItems.CUT_CUCUMBER);
         event.accept(ModItems.CUT_PICKLE);
         event.accept(ModItems.EGGPLANT);
         event.accept(ModItems.CUT_EGGPLANT);
         event.accept(ModItems.SMOKED_EGGPLANT);
         event.accept(ModItems.SMOKED_TOMATO);
         event.accept(ModItems.SMOKED_CUT_EGGPLANT);
         event.accept(ModItems.SMOKED_WHITE_EGGPLANT);
         event.accept(ModItems.WHITE_EGGPLANT);
         event.accept(ModItems.CORN_COB);
         event.accept(ModItems.SQUID);
         event.accept(ModItems.COOKED_SQUID);
         event.accept(ModItems.GLOW_SQUID);
         event.accept(ModItems.RAW_CALAMARI);
         event.accept(ModItems.COOKED_CALAMARI);
         event.accept(ModItems.POPCORN);
         event.accept(ModItems.CORN_DOUGH);
         event.accept(ModItems.TORTILLA);
         event.accept(ModItems.TORTILLA_CHIPS);
         event.accept(ModItems.ELOTE);
         event.accept(ModItems.EMPANADA);
         event.accept(ModItems.HEARTY_SALAD);
         event.accept(ModItems.BEEF_BURRITO);
         event.accept(ModItems.MUTTON_SANDWICH);
         event.accept(ModItems.FRIED_EGGPLANT_PASTA);
         event.accept(ModItems.EGGPLANT_BURGER);
         event.accept(ModItems.AVOCADO_TOAST);
         event.accept(ModItems.CREAMED_CORN);
         event.accept(ModItems.CHICKEN_TACO);
         event.accept(ModItems.SPICY_CURRY);
         event.accept(ModItems.PORK_WRAP);
         event.accept(ModItems.FISH_TACO);
         event.accept(ModItems.MIDORI_ROLL);
         event.accept(ModItems.MIDORI_ROLL_SLICE);
         event.accept(ModItems.EGG_ROLL);
         event.accept(ModItems.CHICKEN_ROLL);
         event.accept(ModItems.CHICKEN_ROLL_SLICE);
         event.accept(ModItems.PUFFERFISH_ROLL);
         event.accept(ModItems.TROPICAL_ROLL);
         event.accept(ModItems.RICE_BALL);
         event.accept(ModItems.CALAMARI_ROLL);
         event.accept(ModBlocks.WILD_CUCUMBERS);
         event.accept(ModBlocks.WILD_CORN);
         event.accept(ModBlocks.WILD_EGGPLANTS);
         event.accept(ModBlocks.AVOCADO_PIT);
         event.accept(ModBlocks.AVOCADO_SAPLING);
         event.accept(ModBlocks.AVOCADO_LOG);
         event.accept(ModBlocks.AVOCADO_WOOD);
         event.accept(ModBlocks.AVOCADO_LEAVES);
         event.accept(ModBlocks.FRUITING_AVOCADO_LEAVES);
//            event.accept(ModBlocks.CUCUMBERS);
//            event.accept(ModBlocks.EGGPLANTS);
//            event.accept(ModBlocks.CORN);
//            event.accept(ModBlocks.CORN_UPPER);
         event.accept(ModBlocks.AVOCADO_CRATE);
         event.accept(ModBlocks.CUCUMBER_CRATE);
         event.accept(ModBlocks.PICKLE_CRATE);
         event.accept(ModBlocks.CORN_COB_CRATE);
         event.accept(ModBlocks.EGGPLANT_CRATE);
         event.accept(ModBlocks.WHITE_EGGPLANT_CRATE);
         event.accept(ModBlocks.EXOTIC_ROLL_MEDLEY);
      }
   }

   // You can use SubscribeEvent and let the Event Bus discover methods to call
   @SubscribeEvent
   public void onServerStarting( ServerStartingEvent event ) {

   }

   // You can use EventBusSubscriber to automatically register all static methods in the class annotated with @SubscribeEvent
   @Mod.EventBusSubscriber(modid = MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
   public static class ClientModEvents {
      @SubscribeEvent
      public static void onClientSetup( FMLClientSetupEvent event ) {
         ItemBlockRenderTypes.setRenderLayer(ModBlocks.WILD_CUCUMBERS.get(), RenderType.cutoutMipped());
         ItemBlockRenderTypes.setRenderLayer(ModBlocks.WILD_CORN.get(), RenderType.cutoutMipped());
         ItemBlockRenderTypes.setRenderLayer(ModBlocks.WILD_EGGPLANTS.get(), RenderType.cutoutMipped());
         ItemBlockRenderTypes.setRenderLayer(ModBlocks.AVOCADO_LEAVES.get(), RenderType.cutoutMipped());
         ItemBlockRenderTypes.setRenderLayer(ModBlocks.AVOCADO_SAPLING.get(), RenderType.cutoutMipped());
         ItemBlockRenderTypes.setRenderLayer(ModBlocks.AVOCADO_PIT.get(), RenderType.cutoutMipped());
         ItemBlockRenderTypes.setRenderLayer(ModBlocks.CUCUMBERS.get(), RenderType.cutoutMipped());
         ItemBlockRenderTypes.setRenderLayer(ModBlocks.EGGPLANTS.get(), RenderType.cutoutMipped());
         ItemBlockRenderTypes.setRenderLayer(ModBlocks.CORN.get(), RenderType.cutoutMipped());
         ItemBlockRenderTypes.setRenderLayer(ModBlocks.CORN_UPPER.get(), RenderType.cutoutMipped());
      }
   }
}
