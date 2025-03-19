package net.burrito.tutorialmod.item;

import net.burrito.tutorialmod.TutorialBurritoMod;
import net.burrito.tutorialmod.block.ModBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class ModCreativeModeTabs {
    public static final DeferredRegister<CreativeModeTab>  CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, TutorialBurritoMod.MOD_ID);

    public static final RegistryObject<CreativeModeTab> TUTORIAL_BURRITO_TAB = CREATIVE_MODE_TABS.register("tutorial_burrito_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.SAPPHIRE.get()))
                .title(Component.translatable("creativetab.tutorial_burrito_tab"))
                    // adding to creative tab
                .displayItems((pParameters, pOutput) -> {
                    // adding modded items
                    pOutput.accept(ModItems.SAPPHIRE.get());
                    pOutput.accept(ModItems.RAW_SAPPHIRE.get());

                    // adding vanilla items
                    pOutput.accept(Items.DIAMOND);

                    // adding modded blocks
                    pOutput.accept(ModBlocks.SAPPHIRE_BLOCK.get());
                    pOutput.accept(ModBlocks.RAW_SAPPHIRE_BLOCK.get());

                    pOutput.accept(ModBlocks.SAPPHIRE_ORE.get());
                    pOutput.accept(ModBlocks.DEEPSlATE_SAPPHIRE_ORE.get());
                    pOutput.accept(ModBlocks.NETHER_SAPPHIRE_ORE.get());
                    pOutput.accept(ModBlocks.END_SAPPHIRE_ORE.get());

                })
                .build());

    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }
}
