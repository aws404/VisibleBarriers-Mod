package com.aws404.visiblebarriers;

import net.minecraft.block.Block;
import net.minecraft.block.BlockBarrier;
import net.minecraft.block.BlockClay;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.EnumBlockRenderType;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class NewCustomBarrierBlock extends BlockBarrier {

    public static boolean IS_SHOWING = true;

    public NewCustomBarrierBlock() {
        super();
    }

    //Custom methods

    @SideOnly(Side.CLIENT)
    public static void toggleVisibility() {
        IS_SHOWING = !IS_SHOWING;
    }

    //Rendering configurations

    @SideOnly(Side.CLIENT)
    public EnumBlockRenderType getRenderType(IBlockState state)
    {
        return EnumBlockRenderType.MODEL;
    }

    @SideOnly(Side.CLIENT)
    public BlockRenderLayer getBlockLayer() {
        return BlockRenderLayer.TRANSLUCENT;
    }

    @SideOnly(Side.CLIENT)
    public boolean shouldSideBeRendered(IBlockState blockState, IBlockAccess blockAccess, BlockPos pos, EnumFacing side) {
        if (!IS_SHOWING)
            return false;

        IBlockState iblockstate = blockAccess.getBlockState(pos.offset(side));
        Block block = iblockstate.getBlock();

        //Don't render the inside faces if touching another barrier
        if (block == this)
            return false;

        return true;
    }

}