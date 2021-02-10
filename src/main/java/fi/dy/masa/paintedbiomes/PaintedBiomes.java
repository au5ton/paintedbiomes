package fi.dy.masa.paintedbiomes;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.server.FMLServerAboutToStartEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.fml.loading.FMLPaths;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import fi.dy.masa.paintedbiomes.event.PaintedBiomesEventHandler;
import fi.dy.masa.paintedbiomes.reference.Reference;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(Reference.MOD_ID)
public class PaintedBiomes
{
    public static PaintedBiomes instance;

    // Directly reference a log4j logger.
    private static final Logger LOGGER = LogManager.getLogger();

    public PaintedBiomes()
    {
        instance = this;
        // Register the setup method for modloading
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);

        // Register ourselves for server and other game events we are interested in
        PaintedBiomesEventHandler handler = new PaintedBiomesEventHandler();
        MinecraftForge.EVENT_BUS.register(handler);
        MinecraftForge.EVENT_BUS.register(this);
    }

    public void setup(FMLCommonSetupEvent event)
    {
        // TODO: create "Configs" class
        // Configs.setConfigDir(FMLPaths.CONFIGDIR.get());

        // Mimics FMLPostInitializationEvent
        event.enqueueWork(this::loadLater);
    }

    private void loadLater()
    {
        // Loads configs, so that the file and the options exist without loading into a world once first
        // TODO: create "Configs" class
        // Configs.reload();
    }

    @SubscribeEvent
    private void serverAboutToStart(FMLServerAboutToStartEvent event)
    {
        // (Re-)Load the config when the server is about to start.
        // This means that in single player you can just save and exit to main menu,
        // make changes to the config and then load a world and have the new configs be used.

        // TODO: create "Configs" class
        // Configs.reload();
    }
}
