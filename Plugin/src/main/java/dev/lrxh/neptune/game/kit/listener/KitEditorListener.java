package dev.lrxh.neptune.game.kit.listener;

import dev.lrxh.neptune.API;
import dev.lrxh.neptune.configs.impl.MessagesLocale;
import dev.lrxh.neptune.game.kit.Kit;
import dev.lrxh.neptune.profile.data.ProfileState;
import dev.lrxh.neptune.profile.impl.Profile;
import net.kyori.adventure.text.minimessage.tag.resolver.Placeholder;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.jetbrains.annotations.NotNull;

import java.util.Arrays;

public class KitEditorListener implements Listener, CommandExecutor {

    @EventHandler
    public void onInventoryClose(InventoryCloseEvent event) {
        Player player = (Player) event.getPlayer();
        Profile profile = API.getProfile(player);
        
        if (profile != null && profile.hasState(ProfileState.IN_KIT_EDITOR)) {
            saveKitAndExit(player, profile);
        }
    }

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if (!(sender instanceof Player player)) return true;

        if (args.length > 0 && args[0].equalsIgnoreCase("save")) {
            Profile profile = API.getProfile(player);
            if (profile != null && profile.hasState(ProfileState.IN_KIT_EDITOR)) {
                saveKitAndExit(player, profile);
                player.closeInventory();
            }
            return true;
        }
        return false;
    }

    private void saveKitAndExit(Player player, Profile profile) {
        Kit kit = profile.getGameData().getKitEditor();
        if (kit == null) return;

        profile.getGameData().get(kit)
                .setKitLoadout(Arrays.asList(player.getInventory().getContents()));

        MessagesLocale.KIT_EDITOR_STOP.send(player.getUniqueId(), Placeholder.parsed("kit", kit.getDisplayName()));

        if (profile.getGameData().getParty() == null) {
            profile.setState(ProfileState.IN_LOBBY);
        } else {
            profile.setState(ProfileState.IN_PARTY);
        }
    }
}
