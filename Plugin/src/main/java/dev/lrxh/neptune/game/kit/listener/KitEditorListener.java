package dev.lrxh.neptune.game.kit.listener;

import dev.lrxh.neptune.API;
import dev.lrxh.neptune.game.kit.command.KitEditorCommand;
import dev.lrxh.neptune.profile.data.ProfileState;
import dev.lrxh.neptune.profile.impl.Profile;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryCloseEvent;

public class KitEditorListener implements Listener {

    @EventHandler
    public void onInventoryClose(InventoryCloseEvent event) {
        Player player = (Player) event.getPlayer();
        Profile profile = API.getProfile(player);
        if (profile == null)
            return;
        if (profile.hasState(ProfileState.IN_KIT_EDITOR)) {
            // Richiama la logica che ora sta nel Command
            KitEditorCommand.saveKitAndExit(player, profile);
        }
    }
}
