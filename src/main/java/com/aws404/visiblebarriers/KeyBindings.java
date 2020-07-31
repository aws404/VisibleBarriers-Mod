package com.aws404.visiblebarriers;

import net.minecraft.client.settings.KeyBinding;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import org.lwjgl.input.Keyboard;

public class KeyBindings {
   public static KeyBinding TOGGLE_KEY = new KeyBinding("Toggle Barrier Visibility", Keyboard.KEY_B, "key.categories.creative");

   public static void registerBindings() {
       ClientRegistry.registerKeyBinding(TOGGLE_KEY);
   }
}
