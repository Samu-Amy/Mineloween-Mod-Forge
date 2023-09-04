package net.samu.mineloween.block;

import net.minecraft.sounds.SoundEvents;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.samu.mineloween.SamuMineloweenMod;
import net.samu.mineloween.item.ModItems;

import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, SamuMineloweenMod.MOD_ID);

    public static final RegistryObject<Block> GEM_ORE = registerBlock("gem_ore",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.copy(Blocks.DIAMOND_ORE).requiresCorrectToolForDrops(), UniformInt.of(3, 7)));

    public static final RegistryObject<Block> GEM_BLOCK = registerBlock("gem_block",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.COBBLESTONE).sound(SoundType.AMETHYST)));

    public static final RegistryObject<Block> GEMMED_COBBLESTONE = registerBlock("gemmed_cobblestone",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.COBBLESTONE)));

    public static final RegistryObject<Block> GEMMED_COBBLESTONE_STAIRS = registerBlock("gemmed_cobblestone_stairs",
            () -> new StairBlock(() -> ModBlocks.GEMMED_COBBLESTONE.get().defaultBlockState(),
                    BlockBehaviour.Properties.copy(Blocks.COBBLESTONE)));

    public static final RegistryObject<Block> GEMMED_COBBLESTONE_SLAB = registerBlock("gemmed_cobblestone_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.copy(Blocks.COBBLESTONE)));

    public static final RegistryObject<Block> GEMMED_COBBLESTONE_BUTTON = registerBlock("gemmed_cobblestone_button",
            () -> new ButtonBlock(BlockBehaviour.Properties.copy(Blocks.STONE_BUTTON), BlockSetType.STONE, 10, true));

    public static final RegistryObject<Block> GEMMED_COBBLESTONE_PRESSURE_PLATE = registerBlock("gemmed_cobblestone_pressure_plate",
            () -> new PressurePlateBlock(PressurePlateBlock.Sensitivity.MOBS, BlockBehaviour.Properties.copy(Blocks.COBBLESTONE), BlockSetType.STONE));

    public static final RegistryObject<Block> GEMMED_COBBLESTONE_FENCE = registerBlock("gemmed_cobblestone_fence",
            () -> new FenceBlock(BlockBehaviour.Properties.copy(Blocks.COBBLESTONE)));

    public static final RegistryObject<Block> GEMMED_COBBLESTONE_FENCE_GATE = registerBlock("gemmed_cobblestone_fence_gate",
            () -> new FenceGateBlock(BlockBehaviour.Properties.copy(Blocks.COBBLESTONE), SoundEvents.FENCE_GATE_OPEN, SoundEvents.FENCE_GATE_CLOSE));

    public static final RegistryObject<Block> GEMMED_COBBLESTONE_WALL = registerBlock("gemmed_cobblestone_wall",
            () -> new WallBlock(BlockBehaviour.Properties.copy(Blocks.COBBLESTONE)));

//    public static final RegistryObject<Block> GEMMED_COBBLESTONE_DOOR = registerBlock("gemmed_cobblestone_door",
//            () -> new DoorBlock(BlockBehaviour.Properties.copy(Blocks.COBBLESTONE), BlockSetType.STONE));

//    public static final RegistryObject<Block> GEMMED_COBBLESTONE_TRAPDOOR = registerBlock("gemmed_cobblestone_trapdoor",
//            () -> new TrapDoorBlock(BlockBehaviour.Properties.copy(Blocks.COBBLESTONE), BlockSetType.STONE));

    public static final RegistryObject<Block> EMPTY_BOOKSHELF = registerBlock("empty_bookshelf",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.BOOKSHELF)));


    private static <T extends Block> RegistryObject<T>  registerBlock(String name, Supplier<T> block) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    private static <T extends Block> RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block) {
        return ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}
