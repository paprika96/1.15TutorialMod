package com.superg321.tutorialmod;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.superg321.tutorialmod.init.ItemInit;

import net.minecraft.block.Blocks;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.server.FMLServerStartingEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;


// The value here should match an entry in the META-INF/mods.toml file
@Mod("tutorialmod")
public class TutorialMod
{
    // Directly reference a log4j logger.
    private static final Logger LOGGER = LogManager.getLogger();
    public static final String MOD_ID = "tutorialmod"; 
    public static TutorialMod instance; 
    
    public TutorialMod() {
    	
        // Register methods for modloading
    	// final IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
    	final IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
    	
    	modEventBus.addListener(this::setup);
    	modEventBus.addListener(this::doClientStuff);

        instance = this; 
        
        // Register ourselves for server and other game events we are interested in
        MinecraftForge.EVENT_BUS.register(this);
    }

    
    private void setup(final FMLCommonSetupEvent event){
    	
        LOGGER.info("HELLO FROM PREINIT");
        LOGGER.info("DIRT BLOCK >> {}", Blocks.DIRT.getRegistryName());
    }

    private void doClientStuff(final FMLClientSetupEvent event) {
    	
    	
    }

    // You can use SubscribeEvent and let the Event Bus discover methods to call <-- This comment from forge. 
    // A @SubscribeEvent is telling this class (TutorialMod), which is now an event bus subscriber, 
    // (see:MinecraftForge.EVENT_BUS.register(this); above) that this method will be called by the event bus, 
    // in this case when the server starts. <-- This comment from tutorial
    @SubscribeEvent
    public void onServerStarting(FMLServerStartingEvent event) {
        
    	// TODO: Tutorial says delete this logger call. I say find in in the logs first and then delete as appropriate. 
    	// do something when the server starts
        LOGGER.info("HELLO from server starting");
    }
    
    public static class TutorialItemGroup extends ItemGroup{
    	
    	public static final TutorialItemGroup instance = new TutorialItemGroup(ItemGroup.GROUPS.length, "tutorialtab"); 
    	
    	private TutorialItemGroup(int index, String label) { 
    		super(index,label);
    	}
    	
    	@Override
    	public ItemStack createIcon() { 
    		return new ItemStack(ItemInit.rainbow_pill); 
    	}  	
    }

}
