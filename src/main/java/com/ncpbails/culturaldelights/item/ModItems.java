package com.ncpbails.culturaldelights.item;

import com.ncpbails.culturaldelights.CulturalDelights;
import com.ncpbails.culturaldelights.block.ModBlocks;
import net.minecraft.world.item.*;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import vectorwing.farmersdelight.FarmersDelight;
import vectorwing.farmersdelight.common.item.KelpRollItem;
import vectorwing.farmersdelight.common.registry.ModCreativeTabs;

public class ModItems {

    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, CulturalDelights.MOD_ID);

    //Items                                                                  item id

    public static final RegistryObject<Item> CUCUMBER_SEEDS = ITEMS.register("cucumber_seeds",
            () -> new ItemNameBlockItem(ModBlocks.CUCUMBERS.get(),
                    new Item.Properties()));

    public static final RegistryObject<Item> CORN_KERNELS = ITEMS.register("corn_kernels",
            () -> new ItemNameBlockItem(ModBlocks.CORN.get(),
                    new Item.Properties()));

    public static final RegistryObject<Item> EGGPLANT_SEEDS = ITEMS.register("eggplant_seeds",
            () -> new ItemNameBlockItem(ModBlocks.EGGPLANTS.get(),
                    new Item.Properties()));


    //Ingredients
    public static final RegistryObject<Item> AVOCADO = ITEMS.register("avocado",
            () -> new Item(new Item.Properties().food(ModFoods.AVOCADO)));

    public static final RegistryObject<Item> CUT_AVOCADO = ITEMS.register("cut_avocado",
            () -> new Item(new Item.Properties().food(ModFoods.CUT_AVOCADO)));

    public static final RegistryObject<Item> CUCUMBER = ITEMS.register("cucumber",
            () -> new Item(new Item.Properties().food(ModFoods.CUCUMBER)));

    public static final RegistryObject<Item> PICKLE = ITEMS.register("pickle",
            () -> new Item(new Item.Properties().food(ModFoods.PICKLE)));

    public static final RegistryObject<Item> CUT_CUCUMBER = ITEMS.register("cut_cucumber",
            () -> new Item(new Item.Properties().food(ModFoods.CUT_CUCUMBER)));

    public static final RegistryObject<Item> CUT_PICKLE = ITEMS.register("cut_pickle",
            () -> new Item(new Item.Properties().food(ModFoods.CUT_PICKLE)));

    public static final RegistryObject<Item> EGGPLANT = ITEMS.register("eggplant",
            () -> new Item(new Item.Properties().food(ModFoods.EGGPLANT)));

    public static final RegistryObject<Item> CUT_EGGPLANT = ITEMS.register("cut_eggplant",
            () -> new Item(new Item.Properties().food(ModFoods.CUT_EGGPLANT)));

    public static final RegistryObject<Item> SMOKED_EGGPLANT = ITEMS.register("smoked_eggplant",
            () -> new Item(new Item.Properties().food(ModFoods.SMOKED_EGGPLANT)));

    public static final RegistryObject<Item> SMOKED_TOMATO = ITEMS.register("smoked_tomato",
            () -> new Item(new Item.Properties().food(ModFoods.SMOKED_TOMATO)));

    public static final RegistryObject<Item> SMOKED_CUT_EGGPLANT = ITEMS.register("smoked_cut_eggplant",
            () -> new Item(new Item.Properties().food(ModFoods.SMOKED_CUT_EGGPLANT)));

    public static final RegistryObject<Item> SMOKED_WHITE_EGGPLANT = ITEMS.register("smoked_white_eggplant",
            () -> new Item(new Item.Properties().food(ModFoods.SMOKED_WHITE_EGGPLANT)));
    public static final RegistryObject<Item> SMOKED_CORN = ITEMS.register("smoked_corn",
            () -> new Item(new Item.Properties().food(ModFoods.SMOKED_CORN)));
    public static final RegistryObject<Item> WHITE_EGGPLANT = ITEMS.register("white_eggplant",
            () -> new Item(new Item.Properties().food(ModFoods.WHITE_EGGPLANT)));
    public static final RegistryObject<Item> CORN_COB = ITEMS.register("corn_cob",
            () -> new Item(new Item.Properties().food(ModFoods.CORN_COB)));
    public static final RegistryObject<Item> GINGER = ITEMS.register("ginger",
            () -> new Item(new Item.Properties().food(ModFoods.GINGER)));

    public static final RegistryObject<Item> SQUID = ITEMS.register("squid",
            () -> new Item(new Item.Properties().food(ModFoods.SQUID)));

    public static final RegistryObject<Item> COOKED_SQUID = ITEMS.register("cooked_squid",
            () -> new Item(new Item.Properties().food(ModFoods.COOKED_SQUID)));

    public static final RegistryObject<Item> GLOW_SQUID = ITEMS.register("glow_squid",
            () -> new Item(new Item.Properties().food(ModFoods.GLOW_SQUID)));

    public static final RegistryObject<Item> RAW_CALAMARI = ITEMS.register("raw_calamari",
            () -> new Item(new Item.Properties().food(ModFoods.RAW_CALAMARI)));

    public static final RegistryObject<Item> COOKED_CALAMARI = ITEMS.register("cooked_calamari",
            () -> new Item(new Item.Properties().food(ModFoods.COOKED_CALAMARI)));


    //Meals
    public static final RegistryObject<Item> POPCORN = ITEMS.register("popcorn",
            () -> new Item(new Item.Properties().food(ModFoods.POPCORN)));

    public static final RegistryObject<Item> CORN_DOUGH = ITEMS.register("corn_dough",
            () -> new Item(new Item.Properties().food(ModFoods.CORN_DOUGH)));

    public static final RegistryObject<Item> TORTILLA = ITEMS.register("tortilla",
            () -> new Item(new Item.Properties().food(ModFoods.TORTILLA)));

    public static final RegistryObject<Item> TORTILLA_CHIPS = ITEMS.register("tortilla_chips",
            () -> new Item(new Item.Properties().food(ModFoods.TORTILLA_CHIPS)));

    public static final RegistryObject<Item> ELOTE = ITEMS.register("elote",
            () -> new Item(new Item.Properties().food(ModFoods.ELOTE)));

    public static final RegistryObject<Item> EMPANADA = ITEMS.register("empanada",
            () -> new Item(new Item.Properties().food(ModFoods.EMPANADA)));

    public static final RegistryObject<Item> HEARTY_SALAD = ITEMS.register("hearty_salad",
            () -> new BowlFoodItem(new Item.Properties().stacksTo(16).food(ModFoods.HEARTY_SALAD)));

    public static final RegistryObject<Item> BEEF_BURRITO = ITEMS.register("beef_burrito",
            () -> new Item(new Item.Properties().food(ModFoods.BEEF_BURRITO)));

    public static final RegistryObject<Item> MUTTON_SANDWICH = ITEMS.register("mutton_sandwich",
            () -> new Item(new Item.Properties().food(ModFoods.MUTTON_SANDWICH)));

    public static final RegistryObject<Item> FRIED_EGGPLANT_PASTA = ITEMS.register("fried_eggplant_pasta",
            () -> new BowlFoodItem(new Item.Properties().stacksTo(16).food(ModFoods.FRIED_EGGPLANT_PASTA)));

    public static final RegistryObject<Item> EGGPLANT_BURGER = ITEMS.register("eggplant_burger",
            () -> new Item(new Item.Properties().food(ModFoods.EGGPLANT_BURGER)));

    public static final RegistryObject<Item> AVOCADO_TOAST = ITEMS.register("avocado_toast",
            () -> new Item(new Item.Properties().food(ModFoods.AVOCADO_TOAST)));

    public static final RegistryObject<Item> CREAMED_CORN = ITEMS.register("creamed_corn",
            () -> new BowlFoodItem(new Item.Properties().stacksTo(16).food(ModFoods.CREAMED_CORN)));

    public static final RegistryObject<Item> CHICKEN_TACO = ITEMS.register("chicken_taco",
            () -> new Item(new Item.Properties().food(ModFoods.CHICKEN_TACO)));

    public static final RegistryObject<Item> SPICY_CURRY = ITEMS.register("spicy_curry",
            () -> new BowlFoodItem(new Item.Properties().stacksTo(16).food(ModFoods.SPICY_CURRY)));

    public static final RegistryObject<Item> PORK_WRAP = ITEMS.register("pork_wrap",
            () -> new Item(new Item.Properties().food(ModFoods.PORK_WRAP)));

    public static final RegistryObject<Item> FISH_TACO = ITEMS.register("fish_taco",
            () -> new Item(new Item.Properties().food(ModFoods.FISH_TACO)));

    public static final RegistryObject<Item> MIDORI_ROLL = ITEMS.register("midori_roll",
            () -> new Item(new Item.Properties().food(ModFoods.MIDORI_ROLL)));

    public static final RegistryObject<Item> MIDORI_ROLL_SLICE = ITEMS.register("midori_roll_slice",
            () -> new Item(new Item.Properties().food(ModFoods.MIDORI_ROLL_SLICE)));

    public static final RegistryObject<Item> EGG_ROLL = ITEMS.register("egg_roll",
            () -> new Item(new Item.Properties().food(ModFoods.EGG_ROLL)));

    public static final RegistryObject<Item> CHICKEN_ROLL = ITEMS.register("chicken_roll",
            () -> new KelpRollItem(new Item.Properties().food(ModFoods.CHICKEN_ROLL)));

    public static final RegistryObject<Item> CHICKEN_ROLL_SLICE = ITEMS.register("chicken_roll_slice",
            () -> new KelpRollItem(new Item.Properties().food(ModFoods.CHICKEN_ROLL_SLICE)));

    public static final RegistryObject<Item> PUFFERFISH_ROLL = ITEMS.register("pufferfish_roll",
            () -> new Item(new Item.Properties().food(ModFoods.PUFFERFISH_ROLL)));

    public static final RegistryObject<Item> TROPICAL_ROLL = ITEMS.register("tropical_roll",
            () -> new Item(new Item.Properties().food(ModFoods.TROPICAL_ROLL)));

    public static final RegistryObject<Item> RICE_BALL = ITEMS.register("rice_ball",
            () -> new Item(new Item.Properties().food(ModFoods.RICE_BALL)));

    public static final RegistryObject<Item> CALAMARI_ROLL = ITEMS.register("calamari_roll",
            () -> new Item(new Item.Properties().food(ModFoods.CALAMARI_ROLL)));


    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
