package com.superg321.tutorialmod.init;

import com.superg321.tutorialmod.TutorialMod;
import com.superg321.tutorialmod.TutorialMod.TutorialItemGroup;

import net.minecraft.item.Food;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import net.minecraftforge.registries.ObjectHolder;

// According to Episode 3, this is the class where we initialize all of our items. 
@Mod.EventBusSubscriber(modid = TutorialMod.MOD_ID, bus = Bus.MOD)
@ObjectHolder(TutorialMod.MOD_ID)
public class ItemInit {

	 
	 public static final Item example_item = null;
	 public static final Item test_item = null;
	 
	 @SubscribeEvent
	 public static void registerItems(final RegistryEvent.Register<Item> event)
	 { 
		 
		 event.getRegistry().register(new Item(new Item.Properties().group(ItemGroup.MISC)).setRegistryName("example_item"));
		 event.getRegistry().register(new Item(new Item.Properties().group(ItemGroup.MISC)).setRegistryName("example_item2"));
		 event.getRegistry().register(new Item(new Item.Properties().group(TutorialItemGroup.instance).food(new Food.Builder().hunger(6).saturation(1.2f).effect(new EffectInstance(Effects.ABSORPTION, 6000,5),0.7f).build())).setRegistryName("test_item"));  
	 }

} 
