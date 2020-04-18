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
	
	@SubscribeEvent
	public static void registerBlocks(final RegistryEvent.Register<Block> event)
	{ 
		event.getRegistry().register(new Block(Block.Properties.create(Material.IRON).hardnessAndResistance(0.5f, 15.0f).sound(SoundType.SAND)).setRegistryName("example_block"));	 
	}
	
	@SubscribeEvent
	public static void registerBlockItems(final RegistryEvent.Register<Item> event)
	{ 
		// TODO: look in Turty's github repo and see the additional properties (see SpecialBlock) in particular, see 
		//       .hardnessAndResistance(2.0f, 10.0f).harvestLevel(2).harvestTool(ToolType.PICKAXE). In episode 4, as he was testing 
		//       this new block he realized that he hadn't set these properties and so his in-game expectations were not met, but 
		//       but he said how to fix it anyway.  I looked at his github repo and he hadn't fixed this example_block, but he 
		//       had added a SpecialBlock that had these properties.  No Drops or something like that was another property he mentioned
		//       but apparently no drops are applicable in the survival mode only (need to confirm this). 
		event.getRegistry().register(new BlockItem(example_block, new Item.Properties().maxStackSize(16).group(ItemGroup.BREWING)).setRegistryName("example_block"));  
	}	

}
