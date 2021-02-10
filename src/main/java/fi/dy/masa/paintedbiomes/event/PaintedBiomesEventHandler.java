package fi.dy.masa.paintedbiomes.event;

import fi.dy.masa.paintedbiomes.PaintedBiomes;
import net.minecraftforge.event.TickEvent.ServerTickEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

public class PaintedBiomesEventHandler 
{
  @SubscribeEvent
  public void onServerTick(ServerTickEvent event)
  {
    // do nothing
    PaintedBiomes.logger.info("ServerTickEvent");
  }  
}
