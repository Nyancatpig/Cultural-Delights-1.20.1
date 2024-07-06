package com.ncpbails.culturaldelights.worldgen;

import com.ncpbails.culturaldelights.CulturalDelights;
import net.minecraft.core.HolderSet;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BiomeTags;
import net.minecraft.world.level.biome.Biomes;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.world.BiomeModifier;
import net.minecraftforge.common.world.ForgeBiomeModifiers;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.holdersets.OrHolderSet;

import java.util.List;

import static net.minecraft.world.level.levelgen.GenerationStep.Decoration.VEGETAL_DECORATION;

public class ModBiomeModifiers {

   public static final ResourceKey<BiomeModifier> AVOCADO_TREES = createKey("trees_avocado");

   public static final ResourceKey<BiomeModifier> WILD_CUCUMBERS = createKey("wild_cucumbers");
   public static final ResourceKey<BiomeModifier> WILD_EGGPLANTS = createKey("wild_eggplants");
   public static final ResourceKey<BiomeModifier> WILD_CORN = createKey("wild_corn");

   public static void init( BootstapContext<BiomeModifier> context ) {

      var isBambooJungle = HolderSet.direct(context.lookup(Registries.BIOME).getOrThrow(Biomes.BAMBOO_JUNGLE));
      var isSparseJungle = HolderSet.direct(context.lookup(Registries.BIOME).getOrThrow(Biomes.SPARSE_JUNGLE));
      var isJungle = HolderSet.direct(context.lookup(Registries.BIOME).getOrThrow(Biomes.JUNGLE));

      var isPlains = HolderSet.direct(context.lookup(Registries.BIOME).getOrThrow(Biomes.PLAINS));
      var isSwamp = HolderSet.direct(context.lookup(Registries.BIOME).getOrThrow(Biomes.SWAMP));
      var isMangroveSwamp = HolderSet.direct(context.lookup(Registries.BIOME).getOrThrow(Biomes.MANGROVE_SWAMP));

      var avocadoTreeBiomes = new OrHolderSet<>(List.of(isBambooJungle, isSparseJungle, isJungle));
      var wildCornBiomes = new OrHolderSet<>(List.of(isPlains));
      var wildCucumbersBiomes = new OrHolderSet<>(List.of(isSwamp, isMangroveSwamp));


      var avocadoTrees = HolderSet.direct(context.lookup(Registries.PLACED_FEATURE).getOrThrow(ModFeatures.Placed.TREES_AVOCADO_PLACED));
      var wildCorn = HolderSet.direct(context.lookup(Registries.PLACED_FEATURE).getOrThrow(ModFeatures.Placed.WILD_CORN));
      var wildEggplant = HolderSet.direct(context.lookup(Registries.PLACED_FEATURE).getOrThrow(ModFeatures.Placed.WILD_EGGPLANTS));
      var wildCucumbers = HolderSet.direct(context.lookup(Registries.PLACED_FEATURE).getOrThrow(ModFeatures.Placed.WILD_CUCUMBERS));


      context.register(AVOCADO_TREES, new ForgeBiomeModifiers.AddFeaturesBiomeModifier(avocadoTreeBiomes, avocadoTrees, VEGETAL_DECORATION));
      context.register(WILD_CORN, new ForgeBiomeModifiers.AddFeaturesBiomeModifier(wildCornBiomes, wildCorn, VEGETAL_DECORATION)); // plains
      context.register(WILD_CUCUMBERS, new ForgeBiomeModifiers.AddFeaturesBiomeModifier(wildCucumbersBiomes, wildCucumbers, VEGETAL_DECORATION)); // swamp
      context.register(WILD_EGGPLANTS, new ForgeBiomeModifiers.AddFeaturesBiomeModifier(avocadoTreeBiomes, wildEggplant, VEGETAL_DECORATION)); // jungle

   }


   // region HELPERS
   private static ResourceKey<BiomeModifier> createKey( String name ) {

      return ResourceKey.create(ForgeRegistries.Keys.BIOME_MODIFIERS, new ResourceLocation(CulturalDelights.MOD_ID, name));
   }
}
