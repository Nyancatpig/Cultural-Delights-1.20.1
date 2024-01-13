package com.ncpbails.culturaldelights.worldgen;

import com.ncpbails.culturaldelights.CulturalDelights;
import com.ncpbails.culturaldelights.block.ModBlocks;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.data.worldgen.placement.VegetationPlacements;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.placement.*;
import net.minecraftforge.registries.RegistryObject;

import java.util.List;

public class ModPlacedFeatures {
    public static final ResourceKey<PlacedFeature> AVOCADO_PLACED_KEY = registerKey("avocado_placed");

    public static void bootstrap(BootstapContext<PlacedFeature> context) {
        HolderGetter<ConfiguredFeature<?, ?>> configuredFeatures = context.lookup(Registries.CONFIGURED_FEATURE);

        register(context, AVOCADO_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.AVOCADO_KEY),
                VegetationPlacements.treePlacement(PlacementUtils.countExtra(3, 0.1f, 2),
                        ModBlocks.AVOCADO_SAPLING.get()));
    }


    public static final RegistryObject<PlacedFeature> WILD_CORN_PLACED = PLACED_FEATURES.register("wild_corn_placed",
            () -> new PlacedFeature(ModConfiguredFeatures.WILD_CORN.getHolder().get(), List.of(RarityFilter.onAverageOnceEvery(25),
                    InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP, BiomeFilter.biome())));

    public static final RegistryObject<PlacedFeature> WILD_EGGPLANTS_PLACED = PLACED_FEATURES.register("wild_eggplants_placed",
            () -> new PlacedFeature(ModConfiguredFeatures.WILD_EGGPLANTS.getHolder().get(), List.of(RarityFilter.onAverageOnceEvery(25),
                    InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP, BiomeFilter.biome())));

    public static final RegistryObject<PlacedFeature> WILD_CUCUMBERS_PLACED = PLACED_FEATURES.register("wild_cucumbers_placed",
            () -> new PlacedFeature(ModConfiguredFeatures.WILD_CUCUMBERS.getHolder().get(), List.of(RarityFilter.onAverageOnceEvery(25),
                    InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP, BiomeFilter.biome())));

    private static ResourceKey<PlacedFeature> registerKey(String name) {
        return ResourceKey.create(Registries.PLACED_FEATURE, new ResourceLocation(CulturalDelights.MOD_ID, name));
    }

    private static void register(BootstapContext<PlacedFeature> context, ResourceKey<PlacedFeature> key, Holder<ConfiguredFeature<?, ?>> configuration,
                                 List<PlacementModifier> modifiers) {
        context.register(key, new PlacedFeature(configuration, List.copyOf(modifiers)));
    }
}