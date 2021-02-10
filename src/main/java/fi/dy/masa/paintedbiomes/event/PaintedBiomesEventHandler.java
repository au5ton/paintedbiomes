package fi.dy.masa.paintedbiomes.event;

import java.io.File;
import java.lang.reflect.Field;

import fi.dy.masa.paintedbiomes.PaintedBiomes;
import net.minecraft.server.MinecraftServer;
import net.minecraft.world.Dimension;
import net.minecraft.world.server.ServerWorld;
import net.minecraft.world.storage.DimensionSavedDataManager;
import net.minecraft.world.storage.FolderName;
import net.minecraftforge.event.TickEvent.ServerTickEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.loading.FMLPaths;
import net.minecraftforge.fml.server.ServerLifecycleHooks;

public class PaintedBiomesEventHandler 
{
  @SubscribeEvent
  public void onServerTick(ServerTickEvent event)
  {
    // do nothing
    MinecraftServer server = ServerLifecycleHooks.getCurrentServer();
    PaintedBiomes.logger.info("Unmapped myster? : {}", server.func_240776_a_(FolderName.DOT).toAbsolutePath());

    // for(ServerWorld w : server.getWorlds())
    // {
    //   w.
    //   try
    //   {
    //     Field privateFolderField = DimensionSavedDataManager.class.getDeclaredField("folder");
    //     privateFolderField.setAccessible(true);
    //     File folder = (File)privateFolderField.get(w.getSavedData());
    //     PaintedBiomes.logger.info("folder? : {}", folder.getAbsolutePath());
    //   }
    //   catch(Exception e)
    //   {
    //     PaintedBiomes.logger.error(e.toString());
    //     // do nothing
    //   }
    // }
    // PaintedBiomes.logger.info("---");

    PaintedBiomes.logger.info("getDataDirectory? : {}", ServerLifecycleHooks.getCurrentServer().getDataDirectory().getAbsolutePath());
    PaintedBiomes.logger.info("getWorldName? : {}", ServerLifecycleHooks.getCurrentServer().getServerConfiguration().getWorldName());
  }  
}
