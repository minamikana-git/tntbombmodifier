package org.hotal.tntbombmodifier;

import org.bukkit.Location;
import org.bukkit.entity.TNTPrimed;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.ExplosionPrimeEvent;
import org.bukkit.plugin.java.JavaPlugin;

public class tntbombmodifier extends JavaPlugin implements Listener {

    // TNTの爆発範囲（半径）を変更する
    private double explosionRadius = 5.0;

    @Override
    public void onEnable() {
        getServer().getPluginManager().registerEvents(this, this);
    }

    @Override
    public void onDisable() {
    }

    @EventHandler
    public void onTNTPrime(ExplosionPrimeEvent event) {
        if (event.getEntity() instanceof TNTPrimed) {
            TNTPrimed tnt = (TNTPrimed) event.getEntity();
            Location location = tnt.getLocation();
            // 爆発範囲（半径）を変更する
            event.setRadius((float) explosionRadius);
        }
    }
}
