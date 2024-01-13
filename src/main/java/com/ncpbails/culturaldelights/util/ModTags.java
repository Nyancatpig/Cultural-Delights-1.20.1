package com.ncpbails.culturaldelights.util;

import com.ncpbails.culturaldelights.CulturalDelights;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.Tags;

public class ModTags {

    public static class Items {
        public static final TagKey<Item> BOWL_FOODS = forgeTag("rollmatout/bowl_foods");
        public static final TagKey<Item> BOTTLE_FOODS = forgeTag("rollmatout/bottle_foods");
        public static final TagKey<Item> BUCKET_FOODS = forgeTag("rollmatout/bucket_foods");

        private static TagKey<Item> tag(String name) {
            return ItemTags.create(new ResourceLocation(CulturalDelights.MOD_ID, name));
        }

        private static TagKey<Item> forgeTag(String name) {
            return ItemTags.create(new ResourceLocation("forge", name));
        }
    }
}
