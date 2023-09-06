package net.samu.mineloween.block.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.phys.BlockHitResult;

public class ModBookshelf extends Block {
    private static final int max_fill_level = 6;
    public static final IntegerProperty FILL_LEVEL = IntegerProperty.create("fill_level", 0, max_fill_level);

    public ModBookshelf(Properties pProperties) {
        super(pProperties);
        this.registerDefaultState(this.defaultBlockState().setValue(FILL_LEVEL, 0));
    }

    @Override
    public InteractionResult use(BlockState pState, Level pLevel, BlockPos pPos, Player pPlayer, InteractionHand pHand, BlockHitResult pHit) {
        if(!pLevel.isClientSide() && pHand == InteractionHand.MAIN_HAND) {
            int current_fill_level = pState.getValue(FILL_LEVEL);
            int new_fill_level = current_fill_level < max_fill_level ? current_fill_level + 1 : 0;
            System.out.println("Current: " + current_fill_level + ", new: " + new_fill_level);
            pLevel.setBlock(pPos, pState.setValue(FILL_LEVEL, new_fill_level), 3);
            System.out.println("Current: " + current_fill_level + ", new: " + new_fill_level);
        }

        return InteractionResult.SUCCESS;
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> pBuilder) {
        pBuilder.add(FILL_LEVEL);
    }
}
