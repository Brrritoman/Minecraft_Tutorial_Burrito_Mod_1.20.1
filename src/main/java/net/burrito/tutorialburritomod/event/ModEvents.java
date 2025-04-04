package net.burrito.tutorialburritomod.event;

import it.unimi.dsi.fastutil.ints.Int2ObjectMap;
import net.burrito.tutorialburritomod.TutorialBurritoMod;
import net.burrito.tutorialburritomod.block.ModBlocks;
import net.burrito.tutorialburritomod.item.ModItems;
import net.burrito.tutorialburritomod.villager.ModVillagers;
import net.minecraft.world.entity.npc.VillagerProfession;
import net.minecraft.world.entity.npc.VillagerTrades;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.trading.MerchantOffer;
import net.minecraftforge.event.village.VillagerTradesEvent;
import net.minecraftforge.event.village.WandererTradesEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.List;

@Mod.EventBusSubscriber(modid = TutorialBurritoMod.MOD_ID)
public class ModEvents {
    @SubscribeEvent
    public static void addCustomTrades(VillagerTradesEvent event) {
        if(event.getType() == VillagerProfession.FARMER) {
            Int2ObjectMap<List<VillagerTrades.ItemListing>> trades = event.getTrades();

            trades.get(1).add((pTrader, pRandom) -> new MerchantOffer(
                    new ItemStack(Items.EMERALD, 2),
                    new ItemStack(ModItems.STRAWBERRY.get(), 12),
                    12, 8,0.02f)
            );
            trades.get(2).add((pTrader, pRandom) -> new MerchantOffer(
                    new ItemStack(Items.EMERALD, 5),
                    new ItemStack(ModItems.CORN.get(), 8),
                    8, 8,0.02f)
            );
        }

        if(event.getType() == ModVillagers.SOUND_MASTER.get()) {
            Int2ObjectMap<List<VillagerTrades.ItemListing>> trades = event.getTrades();

            trades.get(1).add((pTrader, pRandom) -> new MerchantOffer(
                    new ItemStack(Items.EMERALD, 4),
                    new ItemStack(ModBlocks.SOUND_BLOCK.get(), 2),
                    8, 4,0.02f)
            );
            trades.get(1).add((pTrader, pRandom) -> new MerchantOffer(
                    new ItemStack(Items.EMERALD, 32),
                    new ItemStack(ModItems.METAL_DETECTOR.get(), 1),
                    2, 16,0.75f)
            );
            trades.get(2).add((pTrader, pRandom) -> new MerchantOffer(
                    new ItemStack(Items.EMERALD, 36),
                    new ItemStack(ModBlocks.SAPPHIRE_BLOCK.get(), 2),
                    4, 8,0.05f)
            );
        }

    }
    @SubscribeEvent
    public static void addCustomWanderingTrades(WandererTradesEvent event) {
        List<VillagerTrades.ItemListing> genericTrades = event.getGenericTrades();
        List<VillagerTrades.ItemListing> rareTrades = event.getRareTrades();

        genericTrades.add((pTrader, pRandom) -> new MerchantOffer(
                new ItemStack(Items.EMERALD, 12),
                new ItemStack(ModItems.METAL_DETECTOR.get(), 1),
                3, 2, 0.2f
        ));
        rareTrades.add((pTrader, pRandom) -> new MerchantOffer(
                new ItemStack(Items.EMERALD, 3),
                new ItemStack(ModItems.SAPPHIRE.get(), 1),
                8, 6, 0.2f
        ));

    }

}
