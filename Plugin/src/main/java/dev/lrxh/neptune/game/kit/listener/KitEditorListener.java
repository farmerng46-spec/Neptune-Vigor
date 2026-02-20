package dev.lrxh.neptune.game.kit.listener;

import dev.lrxh.neptune.API;
import dev.lrxh.neptune.configs.impl.MessagesLocale;
import dev.lrxh.neptune.game.kit.Kit;
import dev.lrxh.neptune.profile.data.ProfileState;
import dev.lrxh.neptune.profile.impl.Profile;
import net.kyori.adventure.text.minimessage.tag.resolver.Placeholder;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.plugin.Plugin;

import java.util.Arrays;

public class KitEditorListener implements Listener {

    private final Plugin plugin;

    public KitEditorListener(Plugin plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onInventoryClose(InventoryCloseEvent event) {
        Player player = (Player) event.getPlayer();
        
        Bukkit.getScheduler().runTask(plugin, () -> {
            if (!player.isOnline()) return;

            Profile profile = API.getProfile(player);
            if (profile == null)
                return;
                
            if (profile.hasState(ProfileState.IN_KIT_EDITOR)) {
                Kit kit = profile.getGameData().getKitEditor();

                profile.getGameData().get(kit)
                        .setKitLoadout(Arrays.asList(player.getInventory().getContents()));

                MessagesLocale.KIT_EDITOR_STOP.send(player.getUniqueId(), Placeholder.parsed("kit", kit.getDisplayName()));

                if (profile.getGameData().getParty() == null) {
                    profile.setState(ProfileState.IN_LOBBY);
                } else {
                    profile.setState(ProfileState.IN_PARTY);
                }
            }
        });
    }
}
