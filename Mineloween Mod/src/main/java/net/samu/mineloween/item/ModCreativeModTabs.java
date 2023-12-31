package net.samu.mineloween.item;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;
import net.samu.mineloween.SamuMineloweenMod;
import net.samu.mineloween.block.ModBlocks;

public class ModCreativeModTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, SamuMineloweenMod.MOD_ID);

    public static final RegistryObject<CreativeModeTab> MINELOWEEN_TAB = CREATIVE_MODE_TABS.register("mineloween_tab", () -> CreativeModeTab.builder()
            .icon(() -> new ItemStack(ModItems.WAND.get()))
            .title(Component.translatable("creativetab.mineloween_tab"))
            .displayItems((pParameters, pOutput) -> {
                pOutput.accept(ModBlocks.GEM_ORE.get());
                pOutput.accept(ModBlocks.GEM_BLOCK.get());
                pOutput.accept(ModBlocks.GEMMED_COBBLESTONE.get());
                pOutput.accept(ModBlocks.GEMMED_COBBLESTONE_STAIRS.get());
                pOutput.accept(ModBlocks.GEMMED_COBBLESTONE_SLAB.get());
                pOutput.accept(ModBlocks.GEMMED_COBBLESTONE_BUTTON.get());
                pOutput.accept(ModBlocks.GEMMED_COBBLESTONE_PRESSURE_PLATE.get());
                pOutput.accept(ModBlocks.GEMMED_COBBLESTONE_FENCE.get());
                pOutput.accept(ModBlocks.GEMMED_COBBLESTONE_FENCE_GATE.get());
                pOutput.accept(ModBlocks.GEMMED_COBBLESTONE_WALL.get());
                pOutput.accept(ModBlocks.MOD_BOOKSHELF.get());

                pOutput.accept(ModItems.RAW_GEM.get());
                pOutput.accept(ModItems.GEM.get());
                pOutput.accept(ModItems.GEM_HELMET.get());
                pOutput.accept(ModItems.GEM_CHESTPLATE.get());
                pOutput.accept(ModItems.GEM_LEGGINS.get());
                pOutput.accept(ModItems.GEM_BOOTS.get());
                pOutput.accept(ModItems.GEM_SWORD.get());
                pOutput.accept(ModItems.GEM_PICKAXE.get());
                pOutput.accept(ModItems.GEM_AXE.get());
                pOutput.accept(ModItems.GEM_SHOVEL.get());
                pOutput.accept(ModItems.GEM_HOE.get());
                pOutput.accept(ModItems.WAND.get());
                pOutput.accept(ModItems.SCYTHE.get());
                pOutput.accept(ModItems.CHOCOLATE.get());
                pOutput.accept(ModItems.BELLADONNA_SEEDS.get());
                pOutput.accept(ModItems.LEAF.get());
            })
            .build());

    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }
}
