package com.ibochello;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.event.entity.player.PlayerSleepInBedEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;

import java.util.HashSet;
import java.util.Set;

@Mod(TimedistortMod.MODID)
@EventBusSubscriber(modid = TimedistortMod.MODID, value = Dist.DEDICATED_SERVER)
public class TimedistortMod {
    public static final String MODID = "timedistort";

    // Uyuyan oyuncuları tutan set
    private static final Set<Player> sleepingPlayers = new HashSet<>();

    // Zaman donma durumu
    private static boolean timeFrozen = false;
    private static long frozenTime = 0L;

    public TimedistortMod() {
        // Mod başlatma kodu buraya
    }

    @SubscribeEvent
    public static void onPlayerSleep(PlayerSleepInBedEvent event) {
        Player player = event.getPlayer();
        Level level = (Level) player.level;

        if (!level.isClientSide()) {
            sleepingPlayers.add(player);

            // Eğer 1. oyuncu uyuduysa ve diğerleri uyumuyorsa zamanı dondur
            if (sleepingPlayers.size() == 1) {
                timeFrozen = true;
                frozenTime = level.getDayTime();
            }
        }
    }

    @SubscribeEvent
    public static void onPlayerWakeUp(TickEvent.PlayerTickEvent event) {
        Player player = event.player;
        Level level = (Level) player.level;

        if (!level.isClientSide()) {
            if (sleepingPlayers.contains(player)) {
                // Oyuncu uyuyor, zamanı dondur
                level.setDayTime(frozenTime);
            } else {
                // Uyuyan yoksa zamanı normal devam ettir
                timeFrozen = false;
            }
        }
    }

    @SubscribeEvent
    public static void onPlayerWake(PlayerSleepInBedEvent event) {
        Player player = event.getPlayer();
        Level level = (Level) player.level;

        if (!level.isClientSide()) {
            sleepingPlayers.remove(player);

            if (sleepingPlayers.isEmpty()) {
                // Uyuyan oyuncu kalmadı, zamanı normal devam ettir
                timeFrozen = false;
            }
        }
    }
}
