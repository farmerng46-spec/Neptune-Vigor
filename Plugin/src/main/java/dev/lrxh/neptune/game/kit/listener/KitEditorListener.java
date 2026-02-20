package dev.lrxh.neptune.game.kit.listener;

import dev.lrxh.neptune.API;
import dev.lrxh.neptune.configs.impl.MessagesLocale;
import dev.lrxh.neptune.game.kit.Kit;
import dev.lrxh.neptune.profile.data.ProfileState;
import dev.lrxh.neptune.profile.impl.Profile;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.minimessage.tag.resolver.Placeholder;
import net.kyori.adventure.text.serializer.legacy.LegacyComponentSerializer;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.Plugin;

import java.util.Arrays;
import java.util.Collections;

public class KitEditorListener implements Listener {

    private final Plugin plugin;
    private final String title = LegacyComponentSerializer.legacyAmpersand().deserialize("&8ᴋɪᴛ ᴇᴅɪᴛᴏʀ").content();

    public KitEditorListener(Plugin plugin) {
        this.plugin = plugin;
    }

    public void openEditorMenu(Player player) {
        Inventory inv = Bukkit.createInventory(null, 27, LegacyComponentSerializer.legacyAmpersand().deserialize("&8ᴋɪᴛ ᴇᴅɪᴛᴏʀ"));
        
        ItemStack filler = createItem(Material.CYAN_STAINED_GLASS_PANE, " ");
        for (int i = 0; i < 27; i++) inv.setItem(i, filler);

        inv.setItem(11, createItem(Material.GREEN_WOOL, "&a&lꜱᴀᴠᴇ ᴋɪᴛ", "", "&7ᴄʟɪᴄᴋ ᴛᴏ ꜱᴀᴠᴇ"));
        inv.setItem(13, createItem(Material.YELLOW_WOOL, "&e&lʀᴇꜱᴇᴛ ᴋɪᴛ", "", "&7ᴄʟɪᴄᴋ ᴛᴏ ʀᴇꜱᴇᴛ"));
        inv.setItem(15, createItem(Material.RED_WOOL, "&c&lʟᴇᴀᴠᴇ ᴇᴅɪᴛᴏʀ", "", "&7ᴄʟɪᴄᴋ ᴛᴏ ʟᴇᴀᴠᴇ"));

        player.openInventory(inv);
    }

    @EventHandler
    public void onInventoryClick(InventoryClickEvent event) {
        if (!event.getView().getTitle().equals(title)) return;
        event.setCancelled(true);

        Player player = (Player) event.getWhoClicked();
        Profile profile = API.getProfile(player);
        if (profile == null || !profile.hasState(ProfileState.IN_KIT_EDITOR)) return;

        int slot = event.getRawSlot();
        if (slot == 11) { // Save
            saveAndClose(player, profile);
        } else if (slot == 13) { // Reset
            Kit kit = profile.getGameData().getKitEditor();
            player.getInventory().setContents(kit.getContents()); // Assuming getContents() exists in Kit
        } else if (slot == 15) { // Leave
            player.closeInventory();
        }
    }

    @EventHandler
    public void onInventoryClose(InventoryCloseEvent event) {
        if (!event.getView().getTitle().equals(title)) return;
        
        Player player = (Player) event.getPlayer();
        Bukkit.getScheduler().runTask(plugin, () -> {
            Profile profile = API.getProfile(player);
            if (profile != null && profile.hasState(ProfileState.IN_KIT_EDITOR)) {
                saveAndClose(player, profile);
            }
        });
    }

    private void saveAndClose(Player player, Profile profile) {
        Kit kit = profile.getGameData().getKitEditor();
        profile.getGameData().get(kit).setKitLoadout(Arrays.asList(player.getInventory().getContents()));
        
        MessagesLocale.KIT_EDITOR_STOP.send(player.getUniqueId(), Placeholder.parsed("kit", kit.getDisplayName()));
        
        profile.setState(profile.getGameData().getParty() == null ? ProfileState.IN_LOBBY : ProfileState.IN_PARTY);
        player.closeInventory();
    }

    private ItemStack createItem(Material material, String name, String... lore) {
        ItemStack item = new ItemStack(material);
        ItemMeta meta = item.getItemMeta();
        if (meta != null) {
            meta.displayName(LegacyComponentSerializer.legacyAmpersand().deserialize(name));
            meta.lore(Arrays.stream(lore).map(line -> LegacyComponentSerializer.legacyAmpersand().deserialize(line)).toList());
            item.setItemMeta(meta);
        }
        return item;
    }
}
