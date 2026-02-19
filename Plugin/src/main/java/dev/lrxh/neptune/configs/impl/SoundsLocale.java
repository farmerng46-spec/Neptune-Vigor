package dev.lrxh.neptune.configs.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.bukkit.NamespacedKey;
import org.bukkit.Registry;
import org.bukkit.Sound;
import org.jetbrains.annotations.Nullable;

import dev.lrxh.neptune.configs.ConfigService;
import dev.lrxh.neptune.configs.impl.handler.DataType;
import dev.lrxh.neptune.configs.impl.handler.IDataAccessor;
import dev.lrxh.neptune.utils.ConfigFile;
import dev.lrxh.neptune.utils.ServerUtils;
import lombok.Getter;

@Getter
public enum SoundsLocale implements IDataAccessor {
    MATCH_START("match-start", "Plays for all players when the match starts", DataType.STRING, "entity.firework_rocket.blast"),
    MATCH_START_COUNTDOWN("match-start-countdown", "Plays for all players after each second in the match start countdown and new round start countdown", DataType.STRING, "block.note_block.xylophone"),
    MATCH_START2("menu-start2", "Plays for all players when the match starts", DataType.STRING, "block.note_block.bell"),
    PLAYER_KILL("player-kill", "Plays for the player who killed another player", DataType.STRING, "entity.experience_orb.pickup"),
    PLAYER_DEATH("player-death", "Plays for the player who died", DataType.STRING, "block.note_block.ping"),
    PLAYER_RESPAWN("player-respawn", "Plays for the player who respawned", DataType.STRING, "ui.button.click"),
    BED_BROKEN("bed-broken", "Plays for all players when a bed is broken", DataType.STRING, "entity.ender_dragon.growl"),
    MATCH_PARTICIPANT_DIED("match-participant-died", "Plays for all players when someone in the match dies", DataType.STRING, "entity.experience_orb.pickup"),
    MENU_BUTTON_CLICK("menu-button-click", "Plays when a player clicks a button in a menu", DataType.STRING, "ui.button.click"),
    MATCH_VICTORY("match-victory", "Plays when a player clicks a button in a menu", DataType.STRING, "ui.toast.challenge_complete"),
    MATCH_LOSE("match-lose", "Plays when a player clicks a button in a menu", DataType.STRING, "block.beacon.deactivate"),
    MATCH_FOUND("match-found", "Plays for all queued player", DataType.STRING, "block.amethyst_block.hit"),
    PARTY_JOIN("party_join", "Plays when you join in a party", DataType.STRING, "block.amethyst_block.hit"),
    PARTY_CREATE("party_create", "Plays when you create a party", DataType.STRING, "item.goat_horn.sound.1");
    private final String path;
    private final String comment;
    private final List<String> defaultValue = new ArrayList<>();
    private final DataType dataType;
    SoundsLocale(String path, @Nullable String comment, DataType dataType, String... defaultValue) {
        this.path = path;
        this.comment = comment;
        this.defaultValue.addAll(Arrays.asList(defaultValue));
        this.dataType = dataType;
    }

    SoundsLocale(String path, DataType dataType, String... defaultValue) {
        this.path = path;
        this.comment = null;
        this.defaultValue.addAll(Arrays.asList(defaultValue));
        this.dataType = dataType;
    }

    @Override
    public String getHeader() {
        return "";
    }

    @Override
    public ConfigFile getConfigFile() {
        return ConfigService.get().getSoundsConfig();
    }

    public static Sound getSound(SoundsLocale sound) {
        try {
            return Registry.SOUNDS.get(NamespacedKey.fromString(sound.getString()));
        } catch (NullPointerException e) {
            ServerUtils.error("Sound does not exist! path: " + sound.getPath() + ", value: " + sound.getString());
            return null;
        }
    }

    public void update() {}
}
