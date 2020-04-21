package com.superg321.tutorialmod;


import net.minecraft.block.Blocks;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.server.FMLServerStartingEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


// The value here should match an entry in the META-INF/mods.toml file
@Mod("tutorialmod")
public class TutorialMod
{
    // Directly reference a log4j logger.
    private static final Logger LOGGER = LogManager.getLogger();
    public static final String MOD_ID = "tutorialmod"; 
    public static TutorialMod instance; 
    

    public TutorialMod() {
        // Register methodsfor modloading
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::doClientStuff);

        instance = this; 
        
        // Register ourselves for server and other game events we are interested in
        MinecraftForge.EVENT_BUS.register(this);
    }

    private void setup(final FMLCommonSetupEvent event){
    	
    	// TOOD: Tutorial suggests removing the logger code in this method (so method is empty) but I want to try and find the logs and comments first. f
    	// 	1. Find the logs?  
    	//  2. Find these entries in the logs. 
    	//  3. Remove this todo list and the next 3 lines, immediately below.  
        // some preinit code
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
}
