package fi.dy.masa.paintedbiomes.event;

import net.minecraftforge.event.world.WorldEvent;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.TickEvent;
import cpw.mods.fml.common.gameevent.TickEvent.ServerTickEvent;
import fi.dy.masa.paintedbiomes.image.ImageHandler;

public class PaintedBiomesEventHandler
{
    @SubscribeEvent
    public void onServerTick(ServerTickEvent event)
    {
        if (event.phase == TickEvent.Phase.START)
        {
            ImageHandler.tickTimeouts();
        }
    }

    @SubscribeEvent
    public void onWorldLoad(WorldEvent.Load event)
    {
        ImageHandler.setTemplateBasePath();

        // Re-initialize the ImageHandler after a world loads, to update the possibly changed configs and template images
        ImageHandler.getImageHandler(event.world.provider.dimensionId).init();
    }

    @SubscribeEvent
    public void onWorldUnload(WorldEvent.Unload event)
    {
        ImageHandler.removeImageHandler(event.world.provider.dimensionId);
    }
}