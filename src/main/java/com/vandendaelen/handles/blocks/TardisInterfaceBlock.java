package com.vandendaelen.handles.blocks;

import com.vandendaelen.handles.blocks.tiles.TardisInterfaceTile;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.state.StateContainer;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.world.IBlockReader;

import javax.annotation.Nullable;

public class TardisInterfaceBlock extends Block {
    public TardisInterfaceBlock() {
        super(Properties.create(Material.IRON)
                .sound(SoundType.METAL)
                .hardnessAndResistance(2.0f)
        );
        setRegistryName("tardisinterface");
    }

    @Override
    public boolean hasTileEntity(BlockState state) {
        return true;
    }

    @Nullable
    @Override
    public TileEntity createTileEntity(BlockState state, IBlockReader world) {
        return new TardisInterfaceTile();
    }

    @Override
    public BlockState getStateForPlacement(BlockItemUseContext context) {
        return super.getStateForPlacement(context)
                .with(BlockStateProperties.HORIZONTAL_FACING, context.getPlayer()
                        .getHorizontalFacing().getOpposite());

    }

    @Override
    protected void fillStateContainer(StateContainer.Builder<Block, BlockState> builder) {
        builder.add(BlockStateProperties.HORIZONTAL_FACING);
    }

    @Override
    public BlockRenderLayer getRenderLayer() {
        return BlockRenderLayer.CUTOUT;
    }
}
