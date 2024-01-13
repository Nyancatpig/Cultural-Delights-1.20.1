package com.ncpbails.culturaldelights.event;

import com.ncpbails.culturaldelights.CulturalDelights;
import com.ncpbails.culturaldelights.item.ModItems;
import it.unimi.dsi.fastutil.ints.Int2ObjectMap;
import net.minecraft.world.entity.npc.VillagerProfession;
import net.minecraft.world.entity.npc.VillagerTrades;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.trading.MerchantOffer;
import net.minecraftforge.event.village.VillagerTradesEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.List;

@Mod.EventBusSubscriber(modid = CulturalDelights.MOD_ID)
public class ModEvents {

    @SubscribeEvent
    public static void addCustomTrades(VillagerTradesEvent event) {

        if(event.getType() == VillagerProfession.FARMER) {
            Int2ObjectMap<List<VillagerTrades.ItemListing>> trades = event.getTrades();
            ItemStack stack = new ItemStack(Items.EMERALD, 1);
            int villagerLevel = 1;

            trades.get(villagerLevel).add((trader, rand) -> new MerchantOffer(
                    new ItemStack(ModItems.CUCUMBER.get(), 22),
                    stack,10,2,0.02F));
                    //max uses       pXp       price multiplier

            trades.get(villagerLevel).add((trader, rand) -> new MerchantOffer(
                    new ItemStack(ModItems.EGGPLANT.get(), 15),
                    stack,10,2,0.02F));
            //max uses       pXp       price multiplier

            trades.get(villagerLevel).add((trader, rand) -> new MerchantOffer(
                    new ItemStack(ModItems.WHITE_EGGPLANT.get(), 20),
                    stack,10,2,0.02F));
            //max uses       pXp       price multiplier

            trades.get(villagerLevel).add((trader, rand) -> new MerchantOffer(
                    new ItemStack(ModItems.CORN_COB.get(), 15),
                    stack,10,2,0.02F));
            //max uses       pXp       price multiplier

            trades.get(villagerLevel).add((trader, rand) -> new MerchantOffer(
                    new ItemStack(ModItems.AVOCADO.get(), 20),
                    stack,10,2,0.02F));
            //max uses       pXp       price multiplier
        }

    }
}
