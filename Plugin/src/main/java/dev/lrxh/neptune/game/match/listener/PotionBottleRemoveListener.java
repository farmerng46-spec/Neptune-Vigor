package dev.lrxh.neptune.game.match.listener;

import dev.lrxh.neptune.API;
import dev.lrxh.neptune.game.kit.impl.KitRule;
import dev.lrxh.neptune.profile.data.ProfileState;
import dev.lrxh.neptune.profile.impl.Profile;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerItemConsumeEvent;

public final class PotionBottleRemoveListener implements Listener {

    @EventHandler(priority = EventPriority.HIGHEST, ignoreCancelled = true)
    public void onPotionDrink(PlayerItemConsumeEvent event) {
        if (event.getItem().getType() != Material.POTION) return;

        Player player = event.getPlayer();
        Profile profile = API.getProfile(player);

        if (profile == null
                || profile.getState() != ProfileState.IN_GAME
                || profile.getMatch() == null
                || profile.getState() == ProfileState.IN_CUSTOM) return;

        if (!profile.getMatch().getKit().getRules().getOrDefault(KitRule.BUILD, false)) return;

        if (player.getInventory().getItemInMainHand().getType() == Material.GLASS_BOTTLE) {
            player.getInventory().setItemInMainHand(null);
        }

        if (player.getInventory().getItemInOffHand().getType() == Material.GLASS_BOTTLE) {
            player.getInventory().setItemInOffHand(null);
        }
    }
}