package com.superg321.tutorialmod;

import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.InterModComms;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.lifecycle.InterModEnqueueEvent;
import net.minecraftforge.fml.event.lifecycle.InterModProcessEvent;
import net.minecraftforge.fml.event.server.FMLServerStartingEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.stream.Collectors;

// The value here should match an entry in the META-INF/mods.toml file
@Mod("tutorialmod")
public class TutorialMod
{
    // Directly reference a log4j logger.
    private static final Logger LOGGER = LogManager.getLogger();

    public TutorialMod() {
        // Register the setup method for modloading
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);

// Commented out this to method calls because the tutorial deleted them. See more notes at the method definitions below.         
//        // Register the enqueueIMC method for modloading
//        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::enqueueIMC);
//        // Register the processIMC method for modloading
//        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::processIMC);
        
        // Register the doClientStuff method for modloading
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::doClientStuff);

        // Register ourselves for server and other game events we are interested in
        MinecraftForge.EVENT_BUS.register(this);
    }

    private void setup(final FMLCommonSetupEvent event)
    {
    	// TOOD: Tutorial suggests removing the logger code in this method (so method is empty) but I want to try and find the logs and comments first. f
    	// 	1. Find the logs?  
    	//  2. Find these entries in the logs. 
    	//  3. Remove this todo list and the next 3 lines, immediately below.  
        // some preinit code
        LOGGER.info("HELLO FROM PREINIT");
        LOGGER.info("DIRT BLOCK >> {}", Blocks.DIRT.getRegistryName());
    }

    private void doClientStuff(final FMLClientSetupEvent event) {
    	
    	// TODO: Tutorial suggests removing this logger call; I want to find it in the logs first. 
    	// 1. Find the logs. 
    	// 2. Find the entry corresponding to this logging call in the logs. 
    	// 3. Remove this todo list and the next 2 lines immediately below. 
        // do something that can only be done on the client
        LOGGER.info("Got game settings {}", event.getMinecraftSupplier().get().gameSettings);
    }

    
// Tutorial says that these two methods are for facilitating other mod compatibility, but this tutorial won't cover them.  
// In tutorial, both of these methods are deleted. Keeping them here until I can evaluate there value, or lack thereof. 
// Tutorial suggests there may be info about these in forge docs or maybe the forge discord. 
//    private void enqueueIMC(final InterModEnqueueEvent event)
//    {
//        // some example code to dispatch IMC to another mod
//        InterModComms.sendTo("examplemod", "helloworld", () -> { LOGGER.info("Hello world from the MDK"); return "Hello world";});
//    }
//
//    private void processIMC(final InterModProcessEvent event)
//    {
//        // some example code to receive and process InterModComms from other mods
//        LOGGER.info("Got IMC {}", event.getIMCStream().
//                map(m->m.getMessageSupplier().get()).
//                collect(Collectors.toList()));
//    }
    
    
    // You can use SubscribeEvent and let the Event Bus discover methods to call <-- This comment from forge. 
    // A @SubscribeEvent is telling this class (TutorialMod), which is now an event bus subscriber, 
    // (see appx line 42: MinecraftForge.EVENT_BUS.register(this);) that this method will be called by the event bus, 
    // in this case when the server starts. <-- This comment from tutorial
    
    @SubscribeEvent
    public void onServerStarting(FMLServerStartingEvent event) {
        
    	// TODO: Tutorial says delete this logger call. I say find in in the logs first and then delete as appropriate. 
    	// do something when the server starts
        LOGGER.info("HELLO from server starting");
    }

    // You can use EventBusSubscriber to automatically subscribe events on the contained class (this is subscribing to the MOD
    // Event bus for receiving Registry Events) <-- This is the original forge comment. 
    // This comment is from the tutorial. This is a @Mod.EventBusSubscriber. Note that this is actually a different class: RegistryEvents. 
    // As implemented this is for registering blocks and items.
    // TODO: Tutorial says to delete this class and its method because it's not the best way to register blocks and items.  Tutorial promises
    // to show us a better way. For now, I'm commenting this out.  Clean up as appropriate when deemed appropriate. 
//    @Mod.EventBusSubscriber(bus=Mod.EventBusSubscriber.Bus.MOD)
//    public static class RegistryEvents {
//        @SubscribeEvent
//        public static void onBlocksRegistry(final RegistryEvent.Register<Block> blockRegistryEvent) {
//            // register a new block here
//            LOGGER.info("HELLO from Register Block");
//        }
//    }
}
