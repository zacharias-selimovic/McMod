package com.zacharias.zacmod;

import com.mojang.logging.LogUtils;
import com.zacharias.zacmod.block.ModBlock;
import com.zacharias.zacmod.item.ModItems;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.CreativeModeTabEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(ZacMod.MOD_ID)
public class ZacMod
{
    // Define mod id in a common place for everything to reference
    public static final String MOD_ID = "zacmod";
    // Directly reference a slf4j logger
    private static final Logger LOGGER = LogUtils.getLogger();
    public ZacMod() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        ModItems.register(modEventBus);
        ModBlock.register(modEventBus);

        modEventBus.addListener(this::commonSetup);

        MinecraftForge.EVENT_BUS.register(this);

        // Register the item to a creative tab
        modEventBus.addListener(this::addCreative);
    }

    private void commonSetup(final FMLCommonSetupEvent event) {

    }

    private void addCreative(CreativeModeTabEvent.BuildContents event) {

        if(event.getTab() == CreativeModeTabs.BUILDING_BLOCKS){
            event.accept(ModBlock.RUBY_BLOCK);
        }

        if(event.getTab() == CreativeModeTabs.NATURAL_BLOCKS){
            event.accept(ModBlock.RUBY_ORE);
            event.accept(ModBlock.DEEPSLATE_RUBY_ORE);
        }

        if(event.getTab() == CreativeModeTabs.INGREDIENTS) {
            event.accept(ModItems.RUBY);
            event.accept(ModItems.ROUGH_RUBY);
        }
    }



    // You can use EventBusSubscriber to automatically register all static methods in the class annotated with @SubscribeEvent
    @Mod.EventBusSubscriber(modid = MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents
    {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event) {

        }
    }
}
