package com.superg321.tutorialmod.init;

import com.superg321.tutorialmod.TutorialMod;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import net.minecraftforge.registries.ObjectHolder;

@ObjectHolder(TutorialMod.MOD_ID)
@Mod.EventBusSubscriber(modid = TutorialMod.MOD_ID, bus = Bus.MOD)
public class BlockInit {

	public static final Block example_block = null;
	public static final Block example_block2 = null; 
	
	@SubscribeEvent
	public static void registerBlocks(final RegistryEvent.Register<Block> event)
	{ 
		event.getRegistry().register(new Block(Block.Properties.create(Material.IRON).hardnessAndResistance(0.5f, 15.0f).sound(SoundType.SAND)).setRegistryName("example_block"));
		event.getRegistry().register(new Block(Block.Properties.create(Material.GLASS).hardnessAndResistance(0.5f, 15.0f).lightValue(15).sound(SoundType.GLASS)).setRegistryName("example_block2"));
	}
	
	@SubscribeEvent
	public static void registerBlockItems(final RegistryEvent.Register<Item> event)
	{ 
		event.getRegistry().register(new BlockItem(example_block, new Item.Properties().maxStackSize(16).group(ItemGroup.BREWING)).setRegistryName("example_block"));  
		event.getRegistry().register(new BlockItem(example_block2, new Item.Properties().maxStackSize(16).group(ItemGroup.BUILDING_BLOCKS)).setRegistryName("example_block2"));
	}	

}
