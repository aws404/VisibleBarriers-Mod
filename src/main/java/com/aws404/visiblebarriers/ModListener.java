package com.aws404.visiblebarriers;

import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;

import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.util.text.TextComponentString;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.InputEvent;

@Mod.EventBusSubscriber
public class ModListener {

    public static Block BARRIER_REPLACEMENT = new NewCustomBarrierBlock()
            .setRegistryName("minecraft:barrier")
            .setUnlocalizedName("barrier")
            .setCreativeTab(CreativeTabs.TOOLS);

    @SubscribeEvent
    public void registerBlocks(RegistryEvent.Register<Block> event) {
        //Register the new block that is used as the replacement
        event.getRegistry().register(BARRIER_REPLACEMENT);

        //Add command_block to redstone creative tab
        Blocks.COMMAND_BLOCK.setCreativeTab(CreativeTabs.REDSTONE);
    }

    @SubscribeEvent
    public void toggleKey(InputEvent.KeyInputEvent event) {
        //Barrier visibility toggle
        if (KeyBindings.TOGGLE_KEY.isPressed()) {
            NewCustomBarrierBlock.toggleVisibility();
            Minecraft.getMinecraft().renderGlobal.loadRenderers();
            Minecraft.getMinecraft().player.sendMessage(new TextComponentString("Set barrier visibility to: " + (NewCustomBarrierBlock.IS_SHOWING ? "Visible Barriers" : "Vanilla")));
        }
    }

    @SubscribeEvent
    public static void modelRegister(ModelRegistryEvent event) {
        Item item = Item.getItemFromBlock(BARRIER_REPLACEMENT);
        ModelResourceLocation model = new ModelResourceLocation("minecraft:barrier", "inventory");
        ModelLoader.setCustomModelResourceLocation(item, 0, model);

    }

}
