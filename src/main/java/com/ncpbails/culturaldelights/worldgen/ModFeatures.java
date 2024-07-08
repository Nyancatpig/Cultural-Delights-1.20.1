package com.ncpbails.culturaldelights.worldgen;

import com.ncpbails.culturaldelights.CulturalDelights;
import com.ncpbails.culturaldelights.block.ModBlocks;
import com.ncpbails.culturaldelights.block.custom.FruitingLeaves;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.data.worldgen.features.FeatureUtils;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.data.worldgen.placement.VegetationPlacements;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.random.SimpleWeightedRandomList;
import net.minecraft.util.valueproviders.ConstantInt;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.WeightedPlacedFeature;
import net.minecraft.world.level.levelgen.feature.configurations.RandomFeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.RandomPatchConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.SimpleBlockConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.TreeConfiguration;
import net.minecraft.world.level.levelgen.feature.featuresize.TwoLayersFeatureSize;
import net.minecraft.world.level.levelgen.feature.foliageplacers.AcaciaFoliagePlacer;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.minecraft.world.level.levelgen.feature.stateproviders.WeightedStateProvider;
import net.minecraft.world.level.levelgen.feature.trunkplacers.StraightTrunkPlacer;
import net.minecraft.world.level.levelgen.placement.*;

import java.util.List;

import static com.ncpbails.culturaldelights.block.ModBlocks.*;

public class ModFeatures {


   public static class Configured {

      public static final ResourceKey<ConfiguredFeature<?, ?>> WILD_CORN = createKey("wild_corn");
      public static final ResourceKey<ConfiguredFeature<?, ?>> WILD_EGGPLANTS = createKey("wild_eggplant");
      public static final ResourceKey<ConfiguredFeature<?, ?>> WILD_CUCUMBERS = createKey("wild_cucumber");

      public static final ResourceKey<ConfiguredFeature<?, ?>> AVOCADO_TREE = createKey("avocado_tree");
      public static final ResourceKey<ConfiguredFeature<?, ?>> AVOCADO_SPAWN = createKey("avocado_spawn");
      public static final ResourceKey<ConfiguredFeature<?, ?>> AVOCADO_PIT = createKey("avocado_pit");


      public static void init( BootstapContext<ConfiguredFeature<?, ?>> context ) {

         HolderGetter<PlacedFeature> features = context.lookup(Registries.PLACED_FEATURE);


         FeatureUtils.register(context, AVOCADO_TREE, Feature.TREE, new TreeConfiguration.TreeConfigurationBuilder(
                 BlockStateProvider.simple(ModBlocks.AVOCADO_LOG.get()),
                 new StraightTrunkPlacer(3, 2, 0),
                 new WeightedStateProvider(SimpleWeightedRandomList.<BlockState> builder().add(ModBlocks.AVOCADO_LEAVES.get().defaultBlockState(),
                         4).add(ModBlocks.FRUITING_AVOCADO_LEAVES.get().defaultBlockState().setValue(FruitingLeaves.AGE, 4), 1)),
                 new AcaciaFoliagePlacer(ConstantInt.of(3), ConstantInt.of(0)),
                 new TwoLayersFeatureSize(1, 0, 1)).ignoreVines().build());

         FeatureUtils.register(context, AVOCADO_SPAWN, Feature.RANDOM_SELECTOR, new RandomFeatureConfiguration(List.of(new WeightedPlacedFeature(
                 features.getOrThrow(ModFeatures.Placed.AVOCADO_TREE_CHECKED),
                 0.2F)), features.getOrThrow(ModFeatures.Placed.AVOCADO_TREE_CHECKED)));

         FeatureUtils.register(context, AVOCADO_PIT, Feature.TREE, new TreeConfiguration.TreeConfigurationBuilder(
                 BlockStateProvider.simple(ModBlocks.AVOCADO_SAPLING.get()),
                 new StraightTrunkPlacer(3, 2, 0),
                 BlockStateProvider.simple(ModBlocks.AVOCADO_SAPLING.get()),
                 new AcaciaFoliagePlacer(ConstantInt.of(0), ConstantInt.of(0)),
                 new TwoLayersFeatureSize(1, 0, 1)).ignoreVines().build());

         FeatureUtils.register(context, WILD_CORN, Feature.FLOWER,
                 new RandomPatchConfiguration(32, 6, 2, PlacementUtils.onlyWhenEmpty(Feature.SIMPLE_BLOCK,
                         new SimpleBlockConfiguration(BlockStateProvider.simple(ModBlocks.WILD_CORN.get())))));

         FeatureUtils.register(context, WILD_EGGPLANTS, Feature.FLOWER,
                 new RandomPatchConfiguration(32, 6, 2, PlacementUtils.onlyWhenEmpty(Feature.SIMPLE_BLOCK,
                         new SimpleBlockConfiguration(BlockStateProvider.simple(ModBlocks.WILD_EGGPLANTS.get())))));


         FeatureUtils.register(context, WILD_CUCUMBERS, Feature.FLOWER,
                 new RandomPatchConfiguration(32, 6, 2, PlacementUtils.onlyWhenEmpty(Feature.SIMPLE_BLOCK,
                         new SimpleBlockConfiguration(BlockStateProvider.simple(ModBlocks.WILD_CUCUMBERS.get())))));

      }

      // region HELPERS
      private static ResourceKey<ConfiguredFeature<?, ?>> createKey( String name ) {

         return ResourceKey.create(Registries.CONFIGURED_FEATURE, new ResourceLocation(CulturalDelights.MOD_ID, name));
      }
      // endregion
   }


   public static class Placed {
      public static final ResourceKey<PlacedFeature> AVOCADO_TREE_CHECKED = createKey("avocado_tree");
      public static final ResourceKey<PlacedFeature> TREES_AVOCADO_PLACED = createKey("trees_avocado");
      public static final ResourceKey<PlacedFeature> WILD_CORN = createKey("wild_corn");
      public static final ResourceKey<PlacedFeature> WILD_CUCUMBERS = createKey("wild_cucumbers");
      public static final ResourceKey<PlacedFeature> WILD_EGGPLANTS = createKey("wild_eggplants");


      public static void init( BootstapContext<PlacedFeature> context ) {

         HolderGetter<ConfiguredFeature<?, ?>> features = context.lookup(Registries.CONFIGURED_FEATURE);

         context.register(AVOCADO_TREE_CHECKED,
                 new PlacedFeature(features.getOrThrow(Configured.AVOCADO_TREE),
                         List.of(PlacementUtils.filteredByBlockSurvival(ModBlocks.AVOCADO_SAPLING.get()))));

         context.register(TREES_AVOCADO_PLACED,
                 new PlacedFeature(features.getOrThrow(Configured.AVOCADO_SPAWN),
                         VegetationPlacements.treePlacement(
                                 PlacementUtils.countExtra(0, 0.1f, 1))));

         context.register(WILD_CORN,
                 new PlacedFeature(features.getOrThrow(Configured.WILD_CORN), List.of(RarityFilter.onAverageOnceEvery(25),
                         InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP, BiomeFilter.biome()))
         );

         context.register(WILD_CUCUMBERS,
                 new PlacedFeature(features.getOrThrow(Configured.WILD_CUCUMBERS), List.of(RarityFilter.onAverageOnceEvery(25),
                         InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP, BiomeFilter.biome()))
         );
         context.register(WILD_EGGPLANTS,
                 new PlacedFeature(features.getOrThrow(Configured.WILD_EGGPLANTS), List.of(RarityFilter.onAverageOnceEvery(25),
                         InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP, BiomeFilter.biome()))
         );
      }

      // region HELPERS
      private static ResourceKey<PlacedFeature> createKey( String name ) {

         return ResourceKey.create(Registries.PLACED_FEATURE, new ResourceLocation(CulturalDelights.MOD_ID, name));
      }
   }
}
