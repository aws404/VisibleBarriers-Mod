package com.aws404.visiblebarriers;

import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.util.text.TextComponentTranslation;
import net.minecraft.world.ChunkCache;
import net.minecraft.world.chunk.Chunk;
import net.minecraft.world.chunk.storage.ChunkLoader;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.InputEvent;

public class ModListener {

    public static Block BARRIER_REPLACEMENT = new NewCustomBarrier();

    //Registers the blocks
    @SubscribeEvent
    public void registerBlocks(RegistryEvent.Register<Block> event) {
        //Register the new block that is used as the replacement
        event.getRegistry().register(BARRIER_REPLACEMENT);

        //Add Command Blocks to redstone creative tab
        Blocks.COMMAND_BLOCK.setCreativeTab(CreativeTabs.REDSTONE);
    }

    @SubscribeEvent
    public void toggleKey(InputEvent.KeyInputEvent event) {
        //Barrier visibility toggle
        if (KeyBindings.TOGGLE_KEY.isPressed()) {
            NewCustomBarrier.toggleVisibility();
            Minecraft.getMinecraft().renderGlobal.loadRenderers();
            Minecraft.getMinecraft().player.sendMessage(new TextComponentString("Toggled barrier visibility!"));
        }
    }

}
