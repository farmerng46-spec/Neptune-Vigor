package dev.lrxh.neptune.configs.impl;

import dev.lrxh.neptune.configs.ConfigService;
import dev.lrxh.neptune.configs.impl.handler.DataType;
import dev.lrxh.neptune.configs.impl.handler.IDataAccessor;
import dev.lrxh.neptune.utils.ConfigFile;
import dev.lrxh.neptune.utils.PlayerUtil;
import lombok.Getter;
import net.kyori.adventure.text.minimessage.tag.resolver.TagResolver;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

@Getter
public enum MessagesLocale implements IDataAccessor {
    CANT_DO_THIS_NOW("CANT_DO_THIS_NOW", DataType.STRING_LIST,
                        "&cʏᴏᴜ ᴄᴀɴ’ᴛ ᴅᴏ ᴛʜɪꜱ ʀɪɢʜᴛ ɴᴏᴡ!"),
    CANT_DO_THIS_HERE("CANT_DO_THIS_HERE", DataType.STRING_LIST,
                        "&cʏᴏᴜ ᴄᴀɴ’ᴛ ᴅᴏ ᴛʜɪꜱ ʜᴇʀᴇ!"),
    NO_PERMISSION("NO_PERMISSION", DataType.STRING,
                        "&cʏᴏᴜ ᴅᴏ ɴᴏᴛ ʜᴀᴠᴇ ᴘᴇʀᴍɪꜱꜱɪᴏɴ ᴛᴏ ᴅᴏ ᴛʜɪꜱ."),
    MISSING_ARGUMENT("MISSING_ARGUMENT", DataType.STRING,
                        ""),
    MATCH_YOU("MATCH.YOU", DataType.STRING, "You"),
    MATCH_OPPONENT_TEAM("MATCH.OPPONENT_TEAM", DataType.STRING, "Opponent Team"),
    MATCH_DEATH_DISCONNECT("MATCH.DEATH.DISCONNECT", DataType.STRING_LIST, "<player> &7disconnected"),
    MATCH_DEATH_KILLED("MATCH.DEATH.KILLED", DataType.STRING_LIST, "<player> &7was killed by <killer>"),
    MATCH_DEATH_DIED("MATCH.DEATH.DIED", DataType.STRING_LIST, "<player> &7died"),
    MATCH_DEATH_VOID("MATCH.DEATH.VOID", DataType.STRING_LIST,
                        "<player> &7fell into the void while fighting <killer>"),
    QUEUE_JOIN("QUEUE.JOIN", DataType.STRING_LIST, " ", "&#00A4FC&lᴄᴀꜱᴜᴀʟ <kit>", "&e&l⌚&r &7ꜱᴇᴀʀᴄʜɪɴɢ ꜰᴏʀ ᴍᴀᴛᴄʜ…", ""),
    QUEUE_LEAVE("QUEUE.LEAVE", DataType.STRING_LIST, "&cʏᴏᴜ ʟᴇꜰᴛ ᴛʜᴇ ǫᴜᴇᴜᴇ!"),
    QUEUE_ACTION_BAR("QUEUE.ACTION_BAR", DataType.STRING, ""),
    QUEUE_REPEAT("QUEUE.REPEAT.MESSAGE", DataType.STRING_LIST, "&e&l⌚&r &7ꜱᴇᴀʀᴄʜɪɴɢ ꜰᴏʀ ᴏᴛʜᴇʀ ᴘʟᴀʏᴇʀꜱ ɪɴ ǫᴜᴇᴜᴇ…"),
    QUEUE_REPEAT_TOGGLE("QUEUE.REPEAT.TOGGLE", DataType.BOOLEAN, "true"),
    QUEUE_NO_ARENAS("QUEUE.NO_ARENAS", DataType.STRING_LIST,
                        "&cNo arenas were found!"),
    MATCH_STARTED("MATCH.STARTED", DataType.STRING_LIST, "&aᴍᴀᴛᴄʜ ꜱᴛᴀʀᴛᴇᴅ!"),
    ROUND_STARTED("MATCH.ROUND.STARTED", DataType.STRING_LIST, "&aʀᴏᴜɴᴅ ꜱᴛᴀʀᴛᴇᴅ!"),
    MATCH_FOUND("MATCH.FOUND", DataType.STRING_LIST, " ", "&#00A4FC&lᴄᴀꜱᴜᴀʟ <kit>", " ", " &#00A4FC&l❙&r &fᴀʀᴇɴᴀ: &#00A4FC<arena>",
                        " &#00A4FC&l❙&r &fᴏᴘᴘᴏɴᴇɴᴛ: &c<opponent>", " &#00A4FC&l❙&r &fᴘɪɴɢ: &c<opponent-ping>ᴍꜱ", "",
                        " "),
    MATCH_STARTING("MATCH.START.TIMER", DataType.STRING_LIST, "&e&l⌚&r &7ᴛʜᴇ ɢᴀᴍᴇ ꜱᴛᴀʀᴛꜱ ɪɴ &#00A4FC<timer> &7ꜱᴇᴄᴏɴᴅꜱ!"),
    MATCH_STARTING_TITLE_HEADER("MATCH.STARTING.TITLE-HEADER", DataType.STRING, ""),
    MATCH_OUT_OF_BOUNDS_TITLE_HEADER("MATCH.OUT_OF_BOUNDS.TITLE-HEADER", DataType.STRING,
                        "&c&lʏᴏᴜ ᴀʀᴇ ᴏᴜᴛ ᴏꜰ ʙᴏᴜɴᴅꜱ!"),
    MATCH_OUT_OF_BOUNDS_TITLE_FOOTER("MATCH.OUT_OF_BOUNDS.TITLE-FOOTER", DataType.STRING,
                        "&7ʏᴏᴜ ᴡɪʟʟ ꜱᴛᴀʀᴛ ᴛᴀᴋɪɴɢ ᴅᴀᴍᴀɢᴇ!"),
    RANKUP_TITLE_HEADER("RANKUP.TITLE-HEADER", DataType.STRING, "&#00A4FC&lɴᴇᴡ ᴅɪᴠɪꜱɪᴏɴ"),
    RANKUP_TITLE_FOOTER("RANKUP.TITLE-FOOTER", DataType.STRING, "&7ʏᴏᴜ ᴀʀᴇ ɴᴏᴡ ɪɴ &f<division>&7!"),
    RANKUP_MESSAGE("RANKUP.MESSAGE", DataType.STRING_LIST,
                        "",
                        "&7ʏᴏᴜ’ᴠᴇ ʙᴇᴇɴ ᴘʀᴏᴍᴏᴛᴇᴅ ᴛᴏ &f<division>&7.",
                        ""),
    MATCH_KILL_ACTIONBAR("MATCH.KILL.ACTIONBAR", DataType.STRING, "&#FC0000&l🗡 &f<player> &#FC0000&l🗡"),
    MATCH_STARTING_TITLE_FOOTER("MATCH.STARTING.TITLE-FOOTER", DataType.STRING, ""),
    PARKOUR_CHECKPOINT("MATCH.PARKOUR.CHECKPOINT", DataType.STRING_LIST,
                        "&a<player> finished checkpoint <checkpoint> in <time>!"),
    PARKOUR_END("MATCH.PARKOUR.END", DataType.STRING_LIST, "&#00A4FC<player> &7ꜰɪɴɪꜱʜᴇᴅ ᴛʜᴇ ᴘᴀʀᴋᴏᴜʀ ɪɴ &#00A4FC<time>&7!"),
    ROUND_STARTING("MATCH.ROUND.START.TIMER", DataType.STRING_LIST, "&7ᴛʜᴇ ɢᴀᴍᴇ ꜱᴛᴀʀᴛꜱ ɪɴ &#00A4FC<timer> &7ꜱᴇᴄᴏɴᴅꜱ!"),
    MATCH_START_TITLE_HEADER("MATCH.START.TITLE-HEADER", DataType.STRING, "&#00A4FC&lꜰɪɢʜᴛ!"),
    MATCH_START_TITLE_FOOTER("MATCH.START.TITLE-FOOTER", DataType.STRING, ""),
    MATCH_WINNER_TITLE_HEADER("MATCH.WINNER.TITLE-HEADER", DataType.STRING, "&#FFD700&lᴠɪᴄᴛᴏʀʏ"),
    MATCH_WINNER_TITLE_FOOTER("MATCH.WINNER.TITLE-FOOTER", DataType.STRING, "&#FFD700ʏᴏᴜ ᴡᴏɴ ᴛʜᴇ ɢᴀᴍᴇ!"),

        MATCH_LOSER_TITLE_HEADER("MATCH.LOSER.TITLE-HEADER", DataType.STRING, "&c&lᴅᴇꜰᴇᴀᴛ"),
        MATCH_LOSER_TITLE_FOOTER("MATCH.LOSER.TITLE-FOOTER", DataType.STRING, "&cʏᴏᴜ ʟᴏꜱᴛ ᴛʜᴇ ɢᴀᴍᴇ"),

    MATCH_COMMA("MATCH.COMMA", DataType.STRING, "&7, "),
    MATCH_END_DETAILS_SOLO("MATCH.END_DETAILS_MESSAGE.SOLO", DataType.STRING_LIST,
            " ",
            "&#00A4FC&lᴍᴀᴛᴄʜ ꜱᴜᴍᴍᴀʀʏ",
            " &#00A4FC&l❙&r &fᴡɪɴɴᴇʀ: &#00A4FC<winner>",
            " &#00A4FC&l❙&r &fʟᴏꜱᴇʀ: &#00A4FC<loser>",
            " "),
    MATCH_END_DETAILS_DUEL("MATCH.END_DETAILS_MESSAGE.DUEL", DataType.STRING_LIST,
            " ",
            "&#00A4FC&lᴍᴀᴛᴄʜ ꜱᴜᴍᴍᴀʀʏ",
            " &#00A4FC&l❙&r &fᴡɪɴɴᴇʀ: &#00A4FC<winner>",
            " &#00A4FC&l❙&r &fʟᴏꜱᴇʀ: &#00A4FC<loser>",
            " "),
    MATCH_END_DETAILS_TEAM("MATCH.END_DETAILS_MESSAGE.TEAM", DataType.STRING_LIST,
            " ",
            "&#00A4FC&lᴍᴀᴛᴄʜ ꜱᴜᴍᴍᴀʀʏ",
            " &#00A4FC&l❙&r &fᴡɪɴɴᴇʀꜱ: &#00A4FC<winners>",
            " &#00A4FC&l❙&r &fʟᴏꜱᴇʀꜱ: &#00A4FC<losers>",
            " "),
    MATCH_END_DETAILS_FFA("MATCH.END_DETAILS_MESSAGE.FFA", DataType.STRING_LIST,
            "",
            "&#00A4FC&lꜰꜰᴀ ꜱᴜᴍᴍᴀʀʏ",
            " &#00A4FC&l❙&r &#00A4FC<winner>",
            " "),
    MATCH_RESPAWN_TIMER("MATCH.RESPAWN_TIMER", DataType.STRING_LIST, "&e&l⌚&r &7ʀᴇꜱᴘᴀᴡɴɪɴɢ ɪɴ &#00A4FC<timer>&7..."),
    MATCH_RESPAWNED("MATCH.RESPAWNED", DataType.STRING_LIST, "&aʀᴇꜱᴘᴀᴡɴᴇᴅ!"),
    MATCH_RESPAWN_TITLE_HEADER("MATCH.RESPAWN_TITLE.HEADER", DataType.STRING, "&c&lʏᴏᴜ ᴅɪᴇᴅ!"),
    MATCH_RESPAWN_TITLE_FOOTER("MATCH.RESPAWNED_TITLE_FOOTER", DataType.STRING, "&7ʀᴇꜱᴘᴀᴡɴɪɴɢ ɪɴ &#00A4FC<timer>&7..."),
    MATCH_PLAY_AGAIN_ENABLED("MATCH.PLAY_AGAIN.ENABLED", DataType.BOOLEAN, "false"),
    MATCH_PLAY_AGAIN("MATCH.PLAY_AGAIN.MESSAGE", DataType.STRING, "&bDo you want to play again? <play-again><hover:show_text:'&aClick to play again!'><green>(Click here)</hover></play-again>"),
    MATCH_COMBO_MESSAGE_ENABLE("MATCH.COMBO_MESSAGE.ENABLE", DataType.BOOLEAN, "false"),
    MATCH_COMBO_MESSAGE_5("MATCH.COMBO_MESSAGE.5COMBO", DataType.STRING_LIST, "&a5 COMBO!"),
    MATCH_COMBO_MESSAGE_10("MATCH.COMBO_MESSAGE.10COMBO", DataType.STRING_LIST, "&e10 COMBO!"),
    MATCH_COMBO_MESSAGE_20("MATCH.COMBO_MESSAGE.20COMBO", DataType.STRING_LIST, "&c!!!20 COMBO!!!"),
    MATCH_BED_STATUS_NOT_BROKEN("MATCH.BED_STATUS.NOT_BROKEN", DataType.STRING, "&a✔"),
    MATCH_BED_STATUS_BROKEN("MATCH.BED_STATUS.BROKEN", DataType.STRING, "&c<members-left>"),
    MATCH_BOXING_COMBO_PLACEHOLDER("MATCH.COMBO_PLACEHOLDER", DataType.STRING, "&e(<combo> Combo)"),
    MATCH_BOXING_COMBO_NO_COMBO_PLACEHOLDER("MATCH.COMBO_NO_COMBO_PLACEHOLDER", DataType.STRING, ""),
    MATCH_BOXING_HIT_DIFFERENCE_HIGHER("MATCH.HIT_DIFFERENCE_PLACEHOLDER", DataType.STRING,
                        "&a+<hit-difference>"),
    MATCH_BOXING_HIT_DIFFERENCE_EQUAL("MATCH.HIT_DIFFERENCE_PLACEHOLDER", DataType.STRING,
                        "&a<hit-difference>"),
    MATCH_BOXING_HIT_DIFFERENCE_LOWER("MATCH.HIT_DIFFERENCE_PLACEHOLDER", DataType.STRING,
                        "&c-<hit-difference>"),
    MATCH_BUILD_LIMIT("MATCH.BUILD_LIMIT", DataType.STRING_LIST, "&4&l⚠&r &cʏᴏᴜ ʜᴀᴠᴇ ʀᴇᴀᴄʜᴇᴅ ᴛʜᴇ ʙᴜɪʟᴅ ʟɪᴍɪᴛ!"),
    KIT_EDITOR_START("KIT_EDITOR.START", "This is sent when the player starts editing a kit.", DataType.STRING_LIST,
            "",
            "&7ᴏᴘᴇɴ ʏᴏᴜʀ ɪɴᴠᴇɴᴛᴏʀʏ ᴛᴏ ᴇᴅɪᴛ ʟᴀʏᴏᴜᴛ!",
            "&7ʏᴏᴜ ᴄᴀɴ ᴜꜱᴇ &#00A4FC/ᴋɪᴛᴇᴅɪᴛᴏʀ ʀᴇꜱᴇᴛ <kit> &7ᴛᴏ ʀᴇꜱᴇᴛ ᴛʜᴇ ᴋɪᴛ ʟᴀʏᴏᴜᴛ!",
            ""),
    KIT_EDITOR_STOP("KIT_EDITOR.STOP", "This is sent when the player finishes editing a kit.", DataType.STRING_LIST,
            "&aᴋɪᴛ ʟᴀʏᴏᴜᴛ ʜᴀꜱ ʙᴇᴇɴ ꜱᴀᴠᴇᴅ."),
    KIT_EDITOR_RESET("KIT_EDITOR.RESET", "This is sent when the player resets a kit.", DataType.STRING_LIST,
            "&aᴋɪᴛ ʜᴀꜱ ʙᴇᴇɴ ʀᴇꜱᴇᴛ."),
    DUEL_REQUEST_RECEIVER("DUEL.SENT", DataType.STRING_LIST, " ",
            "",
            "&#00A4FC&lᴅᴜᴇʟ ʀᴇǫᴜᴇꜱᴛ",
            " ",
            " &#00A4FC&l❙&r &fꜰʀᴏᴍ: &#00A4FC<sender>",
            " &#00A4FC&l❙&r &fᴍᴏᴅᴇ: &#00A4FC<kit>",
            " &#00A4FC&l❙&r &fʀᴏᴜɴᴅꜱ: &#00A4FC<rounds>",
            " ",
            "<accept><hover:show_text:'&aClick to accept duel request'>&a&l(ᴄʟɪᴄᴋ ᴛᴏ ᴀᴄᴄᴇᴘᴛ)</hover></accept>"),
    DUEL_REQUEST_SENDER("DUEL.SENDER", DataType.STRING_LIST, " ",
            "",
            "&#00A4FC&lᴅᴜᴇʟ ʀᴇǫᴜᴇꜱᴛ ꜱᴇɴᴛ",
            " ",
            " &#00A4FC&l❙&r &fᴛᴏ: &#00A4FC<receiver>",
            " &#00A4FC&l❙&r &fᴍᴏᴅᴇ: &#00A4FC<kit>",
            " &#00A4FC&l❙&r &fᴍᴀᴘ: &#00A4FC<arena>",
            "& #00A4FC&l❙&r &fRounds: &#00A4FC<rounds>",
            " "),
    DUEL_DENY_SENDER("DUEL.SENDER_DENY", DataType.STRING_LIST, "&cᴅᴜᴇʟ ʀᴇǫᴜᴇꜱᴛ ᴅᴇɴɪᴇᴅ."),
    DUEL_DENY_RECEIVER("DUEL.RECEIVER_DENY", DataType.STRING_LIST, "&4&l⚠&r &cʏᴏᴜʀ ᴅᴜᴇʟ ᴛᴏ &c<player> &cᴡᴀꜱ ᴅᴇɴɪᴇᴅ."),
    DUEL_ALREADY_SENT("DUEL.ALREADY_SENT", DataType.STRING, "&4&l⚠&r &cʏᴏᴜ ʜᴀᴠᴇ ᴀʟʀᴇᴀᴅʏ ꜱᴇɴᴛ <player> ᴀ ᴅᴜᴇʟ ʀᴇǫᴜᴇꜱᴛ."),
    DUEL_EXPIRED("DUEL.EXPIRED", DataType.STRING_LIST, "&4&l⚠&r &cʏᴏᴜʀ ᴅᴜᴇʟ ʀᴇǫᴜᴇꜱᴛ ᴛᴏ <player> ʜᴀꜱ ᴇxᴘɪʀᴇᴅ."),
    DUEL_NOT_ONLINE("DUEL.NOT_ONLINE", DataType.STRING_LIST, "&4&l⚠&r &cᴛʜɪꜱ ᴜꜱᴇʀ ɪꜱ ᴏꜰꜰʟɪɴᴇ ᴏʀ ᴅᴏᴇꜱ ɴᴏᴛ ᴇxɪꜱᴛ."),
    YOU_CANT_SEND_DUEL("DUEL.YOU_CANT_SEND_DUEL", DataType.STRING_LIST, "&4&l⚠&r &cʏᴏᴜ ᴄᴀɴ'ᴛ ꜱᴇɴᴅ ᴅᴜᴇʟ ʀᴇǫᴜᴇꜱᴛꜱ ʀɪɢʜᴛ ɴᴏᴡ!"),
    CANT_DUEL_SELF("DUEL.CANT_DUEL_SELF", DataType.STRING_LIST, "&4&l⚠&r &cʏᴏᴜ ᴄᴀɴ'ᴛ ᴅᴜᴇʟ ʏᴏᴜʀꜱᴇʟꜰ!"),
    PLAYER_CANT_ACCEPT_DUEL("DUEL.PLAYER_CANT_ACCEPT_DUEL", DataType.STRING_LIST,
            "&4&l⚠&r &cᴘʟᴀʏᴇʀ ᴄᴀɴ'ᴛ ᴀᴄᴄᴇᴘᴛ ᴅᴜᴇʟ ʀᴇǫᴜᴇꜱᴛꜱ!"),
    YOU_DONT_HAVE_DUEL_REQUEST("DUEL.YOU_DONT_HAVE_DUEL_REQUEST", DataType.STRING_LIST,
            "&4&l⚠&r &cʏᴏᴜ ᴅᴏɴ'ᴛ ʜᴀᴠᴇ ᴀɴʏ ᴅᴜᴇʟ ʀᴇǫᴜᴇꜱᴛ ꜰʀᴏᴍ ᴛʜɪꜱ ᴘʟᴀʏᴇʀ!"),
    DUEL_REQUEST_COULDNT_BE_ACCEPTED("DUEL.REQUEST_COULDNT_BE_ACCEPTED", DataType.STRING_LIST,
            "&4&l⚠&r &cᴅᴜᴇʟ ʀᴇǫᴜᴇꜱᴛ ᴄᴏᴜʟᴅɴ'ᴛ ʙᴇ ᴀᴄᴄᴇᴘᴛᴇᴅ!"),

    REMATCH_REQUEST_RECEIVER("REMATCH.SENT", DataType.STRING_LIST, " ",
            "&#00A4FC&lʀᴇᴍᴀᴛᴄʜ ʀᴇǫᴜᴇꜱᴛ",
            "&8&l❙&r &7ʏᴏᴜ ʜᴀᴠᴇ ʀᴇᴄᴇɪᴠᴇᴅ ᴀ ʀᴇᴍᴀᴛᴄʜ ʀᴇǫᴜᴇꜱᴛ ꜰʀᴏᴍ &#00A4FC<sender>&7.",
            " ",
            "<accept><hover:show_text:'&aClick to accept rematch request'>&a&l(ᴄʟɪᴄᴋ ᴛᴏ ᴀᴄᴄᴇᴘᴛ)</hover></accept>"),
    REMATCH_REQUEST_SENDER("REMATCH.SENDER", DataType.STRING_LIST, " ",
            "&#00A4FC&lʀᴇᴍᴀᴛᴄʜ ʀᴇǫᴜᴇꜱᴛ ꜱᴇɴᴛ",
            "&8&l❙&r &7ʏᴏᴜ ʜᴀᴠᴇ ꜱᴇɴᴛ ᴀ ʀᴇᴍᴀᴛᴄʜ ʀᴇǫᴜᴇꜱᴛ ᴛᴏ &#00A4FC<receiver>&7.",
            " "),
    REMATCH_EXPIRED("REMATCH.EXPIRED", DataType.STRING_LIST, "&4&l⚠&r &cʏᴏᴜʀ ʀᴇᴍᴀᴛᴄʜ ʀᴇǫᴜᴇꜱᴛ ᴛᴏ <player> ʜᴀꜱ ᴇxᴘɪʀᴇᴅ."),
    SPECTATE_START("MATCH.SPECTATE.START", DataType.STRING_LIST, "&b&l⚙&r &#00A4FC<player> &7ꜱᴛᴀʀᴛᴇᴅ ꜱᴘᴇᴄᴛᴀᴛɪɴɢ."),
    MATCH_FORFEIT("MATCH.FORFEIT", DataType.STRING_LIST, "&cꜱᴏᴍᴇᴏɴᴇ ʀᴀɢᴇ ǫᴜɪᴛ!"),
    SPECTATE_STOP("MATCH.SPECTATE.STOP", DataType.STRING_LIST, "&b&l⚙&r &#00A4FC<player> &7ꜱᴛᴏᴘᴘᴇᴅ ꜱᴘᴇᴄᴛᴀᴛɪɴɢ."),
    SPECTATE_NOT_ALLOWED("MATCH.SPECTATE.SPECTATE_NOT_ALLOWED", DataType.STRING_LIST,
            "&c<player> ʜᴀꜱ ꜱᴘᴇᴄᴛᴀᴛɪɴɢ ᴅɪꜱᴀʙʟᴇᴅ."),
    SPECTATE_LEAVE_IN_PARTY("MATCH.SPECTATE.SPECTATE_LEAVE_IN_PARTY", DataType.STRING,
            "&cʏᴏᴜ ᴀʀᴇ ɴᴏᴛ ᴀʟʟᴏᴡᴇᴅ ᴛᴏ ʟᴇᴀᴠᴇ ꜱᴘᴇᴄᴛᴀᴛɪɴɢ ᴍᴏᴅᴇ ᴡʜɪʟᴇ ʙᴇɪɴɢ ɪɴ ᴀ ᴘᴀʀᴛʏ!"),
    SPECTATE_PERMISSION_FLAG("MATCH.SPECTATE.NO_PERMISSION_FLAG", DataType.STRING_LIST,
            "&cʏᴏᴜ ᴅᴏɴ’ᴛ ʜᴀᴠᴇ ᴘᴇʀᴍɪꜱꜱɪᴏɴ ᴛᴏ ᴜꜱᴇ ᴛʜɪꜱ ꜰʟᴀɢ!"),
    SPECTATE_SELF("MATCH.SPECTATE.SELF", DataType.STRING_LIST,
            "&cʏᴏᴜ ᴄᴀɴ’ᴛ ꜱᴘᴇᴄᴛᴀᴛᴇ ʏᴏᴜʀꜱᴇʟꜰ!"),
    SPECTATE_IN_MATCH("MATCH.SPECTATE.IN_MATCH", DataType.STRING_LIST,
            "&cʏᴏᴜ ᴄᴀɴ’ᴛ ꜱᴘᴇᴄᴛᴀᴛᴇ ᴡʜɪʟᴇ ɪɴ ᴀ ᴍᴀᴛᴄʜ!"),
    SPECTATE_TARGET_NOT_IN_MATCH("MATCH.SPECTATE.TARGET_NOT_IN_MATCH", DataType.STRING_LIST,
            "&cᴘʟᴀʏᴇʀ ɪꜱɴ’ᴛ ɪɴ ᴀ ᴍᴀᴛᴄʜ!"),
    SPECTATE_STARTED("MATCH.SPECTATE.START", DataType.STRING_LIST,
            "&b&l⚙&r &7ʏᴏᴜ ꜱᴛᴀʀᴛᴇᴅ ꜱᴘᴇᴄᴛᴀᴛɪɴɢ &#00A4FC<player>&7."),
    SPECTATE_STARTED_SILENT("MATCH.SPECTATE.START.SILENT", DataType.STRING_LIST,
            "&b&l⚙&r &7ʏᴏᴜ ꜱɪʟᴇɴᴛʟʏ ꜱᴘᴇᴄᴛᴀᴛɪɴɢ &#00A4FC<player>&7."),
    ERROR_MESSAGE("ERROR_MESSAGE", DataType.STRING, "&c<error>"),
    JOIN_MESSAGE("JOIN_MESSAGE", DataType.STRING, "&8[&a+&8] &a<player>"),
    LEAVE_MESSAGE("LEAVE_MESSAGE", DataType.STRING, "&8[&c-&8] &c<player>"),
    PARTY_CREATE("PARTY.CREATE", DataType.STRING_LIST, "&aCreated party!"),
    PARTY_DISBANDED("PARTY.DISBANDED", DataType.STRING_LIST, "&cParty has been disbanded."),
    PARTY_INVITE_CONFIRM("PARTY.INVITE.CONFIRM", DataType.STRING_LIST,
            "&bRight click &f<player> again to send a party invite."),
    PARTY_INVITED("PARTY.INVITED", DataType.STRING_LIST, "&f<player> &bhas been invited to the party!"),
    PARTY_NOT_IN("PARTY.NOT_IN", DataType.STRING_LIST, "&cYou are not in a party."),
    PARTY_NOT_IN_PARTY("PARTY.NOT_IN_PARTY", DataType.STRING_LIST, "&c<player> isn't in a party."),
    PARTY_NOT_LEADER("PARTY.NOT_LEADER", DataType.STRING_LIST, "&cPlayer <player> isn't a leader of a party."),
    PARTY_PRIVATE("PARTY.PRIVATE", DataType.STRING_LIST, "&cThis party is private."),
    PARTY_NOT_IN_SAME_PARTY("PARTY.NOT_IN_SAME_PARTY", DataType.STRING_LIST, "&c<player> isn't in your party."),
    PARTY_JOINED("PARTY.JOINED", DataType.STRING_LIST, "&f<player> &bjoined the party!"),
    PARTY_JOINED_FROM_ADVERTISEMENT("PARTY.JOINED_FROM_ADVERTISEMENT", DataType.STRING_LIST,
            "&f<player> &bjoined the party from the advertisement!"),
    PARTY_INVITATION("PARTY.INVITATION", DataType.STRING_LIST,
            "&bYou have been invited to &f<leader>&b's party <accept><hover:show_text:'Click to join party'><green>(ACCEPT)</hover></accept>"),
    PARTY_INVITE_OWN("PARTY.INVITE_OWN", DataType.STRING_LIST, "&cYou can't invite yourself to the party."),
    PARTY_TRANSFER_OWN("PARTY.TRANSFER", DataType.STRING_LIST, "&cYou can't transfer a party to yourself."),
    PARTY_NO_PERMISSION("PARTY.NO_PERMISSION", DataType.STRING_LIST, "&cYou do not have permission to do this."),
    PARTY_DISABLED("PARTY.DISABLED", DataType.STRING_LIST, "&c<player> has party requests disabled!"),
    PARTY_ALREADY_IN("PARTY.ALREADY_IN", DataType.STRING_LIST, "&cYou are already in a party."),
    PARTY_ALREADY_SENT("PARTY.ALREADY_SENT", DataType.STRING_LIST, "&cYou have already sent <player> a party request."),
    PARTY_ALREADY_PARTY("PARTY.ALREADY_IN_PARTY", DataType.STRING_LIST, "&c<player> is already in a party."),
    PARTY_TRANSFER("PARTY.TRANSFER.MEMBERS", DataType.STRING_LIST,
            "&f<leader> &btransferred the party to &f<target>&b."),
    PARTY_ADVERTISE_MESSAGE("PARTY.ADVERTISE.MESSAGE", DataType.STRING_LIST,
            "&d&l[AD] &r&f<leader> &6wants you in their party! <join><hover:show_text:'&aClick to join their party'>&a(JOIN)</hover></join>"),
    PARTY_KICK("PARTY.KICK", DataType.STRING_LIST, "&f<player> &bhas been kicked from the party."),
    PARTY_CANNOT_CREATE("PARTY.CANNOT_CREATE", DataType.STRING_LIST, "&cYou can only create a party while in lobby!"),
    PARTY_CANNOT_JOIN("PARTY.CANNOT_JOIN", DataType.STRING_LIST, "&cYou can only join a party while in lobby!"),
    PARTY_LEFT("PARTY.LEFT", DataType.STRING_LIST, "&f<player> &bhas left the party."),
    PARTY_PRIVACY_OPEN("PARTY.PRIVACY.OPEN", DataType.STRING, "Open"),
    PARTY_PRIVACY_CLOSED("PARTY.PRIVACY.OPEN", DataType.STRING, "Closed"),
    PARTY_INFO("PARTY.INFO", DataType.STRING_LIST,
            " ",
            "&7&m------------------------------------------------",
            "&fPrivacy: &b<privacy>",
            "&fLeader: &b<leader>",
            "&fSize: &b<size>/<party-max>",
            "&7&m------------------------------------------------"),
    PARTY_MAX_SIZE("PARTY.MAX_SIZE_REACHED", DataType.STRING_LIST, "&cYou have reached max party size"),
    PARTY_MAX_SIZE_SETTING("PARTY.MAX_SIZE_SETTING_REACHED", DataType.STRING_LIST, "&cThis party can only have a size limit of <max> players!"),
    PARTY_NOT_ENOUGH_MEMBERS("PARTY.NOT_ENOUGH_MEMBERS", DataType.STRING_LIST,
            "&cYou need at least 2 players to start a party event."),
    PARTY_HELP("PARTY.HELP", "Message sent on /party help", DataType.STRING_LIST,
            "",
            "&#00A4FC&lᴘᴀʀᴛʏ ᴄᴏᴍᴍᴀɴᴅꜱ",
            " ",
            "&7/ᴘᴀʀᴛʏ &#00A4FCᴄʀᴇᴀᴛᴇ",
            "&7/ᴘᴀʀᴛʏ &#00A4FCɪɴᴠɪᴛᴇ &7[ᴘʟᴀʏᴇʀ]",
            "&7/ᴘᴀʀᴛʏ &#00A4FCᴅɪꜱʙᴀɴᴅ",
            "&7/ᴘᴀʀᴛʏ &#00A4FCʟᴇᴀᴠᴇ",
            "&7/ᴘᴀʀᴛʏ &#00A4FCᴋɪᴄᴋ &7[ᴘʟᴀʏᴇʀ]",
            "&7/ᴘᴀʀᴛʏ &#00A4FCᴊᴏɪɴ &7[ᴘʟᴀʏᴇʀ]",
            "&7/ᴘᴀʀᴛʏ &#00A4FCᴛʀᴀɴꜱꜰᴇʀ &7[ᴘʟᴀʏᴇʀ]",
            "&7/ᴘᴀʀᴛʏ &#00A4FCᴀɴɴᴏᴜɴᴄᴇ",
            " "),
    PARTY_EXPIRED("PARTY.EXPIRED", DataType.STRING_LIST, "&cYour party request to &c<player> &chas expired."),
    START_FOLLOW("FOLLOW.STARTED", DataType.STRING_LIST, "&bStarted following &f<player>"),
    STOP_FOLLOWING("FOLLOW.STOPPED", DataType.STRING_LIST, "&cStopped following <player>"),
    NOT_ONLINE("NOT_ONLINE", DataType.STRING_LIST, "&c<player> isn't online!"),
    CANT_BREAK_OWN_BED("CANT.BREAK_OWN_BED", DataType.STRING_LIST, "&cYou can't break your own bed!"),
    BED_BREAK_TITLE("BEDWARS.OWN_BREAK.TITLE", DataType.STRING, "&cBED DESTROYED!"),
    BED_BREAK_FOOTER("BEDWARS.OWN_BREAK.FOOTER", DataType.STRING, "&fYou will no longer respawn!"),
    BLUE_BED_BROKEN_MESSAGE("BEDWARS.BLUE_BREAK.MESSAGE", DataType.STRING, "&9Blue Bed &7was broken by <player>"),
    RED_BED_BROKEN_MESSAGE("BEDWARS.RED_BREAK.MESSAGE", DataType.STRING, "&cRed Bed &7was broken by <player>"),
    MATCH_ENDERPEARL_COOLDOWN_ON_GOING("MATCH.ENDERPEARL_COOLDOWN.ON_GOING", DataType.STRING_LIST,
            "&cEnderpearl cooldown&7: &e<time>s"),
    FFA_KILLSTREAK_ANNOUNCE_RULES("FFA.KILLSTREAK_RULES",
            "Rules: 5,10,15 (exact); >5 (above); <5 (below); +5 (every 5 kills). Multiple rules separated by ,",
            DataType.STRING, "+5"),
    FFA_KILL_ANNOUNCE("FFA.KILL_ANNOUNCE", DataType.STRING_LIST,
            "&b⚔ &b<player> &fwas killed by &b<killer>",
            "&b⚔ &b<player> &fwas 360 no-scoped by &b<killer>",
            "&b⚔ &b<player> &fwas diddled by &b<killer>",
            "&b⚔ &b<player> &fwas sent a j*b application by &b<killer>"),
    FFA_KILLSTREAK_ANNOUNCE_ENABLED("FFA.KILLSTREAK_ANNOUNCE.ENABLED", DataType.BOOLEAN, "false"),
    IN_MATCH_BLOCKED_COMMAND_MESSAGE("IN_MATCH_BLOCKED_COMMAND", DataType.STRING_LIST, "&cThis command is blocked while in a match!"),
    FFA_KILLSTREAK_ANNOUNCE_MESSAGE("FFA.KILLSTREAK_ANNOUNCE.MESSAGE", DataType.STRING_LIST,
            " ", "&b<player> &fis now on a &b&l<killstreak> KILLSTREAK!", " ");

        private final String path;
        private final String comment;
        private final List<String> defaultValue = new ArrayList<>();
        private final DataType dataType;

        MessagesLocale(String path, @Nullable String comment, DataType dataType, String... defaultValue) {
                this.path = path;
                this.comment = comment;
                this.defaultValue.addAll(Arrays.asList(defaultValue));
                this.dataType = dataType;
        }

        MessagesLocale(String path, DataType dataType, String... defaultValue) {
                this.path = path;
                this.comment = null;
                this.defaultValue.addAll(Arrays.asList(defaultValue));
                this.dataType = dataType;
        }

        @Override
        public ConfigFile getConfigFile() {
                return ConfigService.get().getMessagesConfig();
        }

    @Override
    public String getHeader() {
        return "Replace with NONE to disable";
    }
    public void send(Player player, TagResolver resolver) {
        if (player == null) return;
        final UUID playerUUID = player.getUniqueId();
        if (dataType.equals(DataType.STRING_LIST)) {
            for (String message : getStringList()) {
                if (message.equals("NONE"))
                    continue;
            PlayerUtil.sendMessage(playerUUID, message, resolver);
            }
        } else if (dataType.equals(DataType.STRING)) {
            if (getString().equals("NONE"))
                return;
            PlayerUtil.sendMessage(playerUUID, getString(), resolver);
        }
    }
    public void send(Player player) {
        send(player, TagResolver.empty());
    }
    public void send(UUID playerUUID) {
        Player player = Bukkit.getPlayer(playerUUID);
        send(player, TagResolver.empty());
    }
    public void send(UUID playerUUID, TagResolver resolver) {
        Player player = Bukkit.getPlayer(playerUUID);
        send(player, resolver);
    }

    public void update() {
            DUEL_REQUEST_RECEIVER.set(
                    DUEL_REQUEST_RECEIVER.getStringList().stream().map(
                            str -> str.replaceAll("<hover:show_text:'&aClick to accept duel request'><click:run_command:'/duel accept-uuid <uuid>'>&a&l(ACCEPT)</click></hover>", "<accept><hover:show_text:'&aClick to accept duel request'>&a&l(ACCEPT)</hover></accept>")
                                    .replaceAll("<hover:show_text:'&cClick to deny duel request'><click:run_command:'/duel deny-uuid <uuid>'>&a&l(DENY)</click></hover>", "<deny><hover:show_text:'&cClick to deny duel request'>&a&l(DENY)</hover></deny>")
                    ).toList()
            );
            REMATCH_REQUEST_RECEIVER.set(
                    DUEL_REQUEST_RECEIVER.getStringList().stream().map(
                            str -> str.replaceAll("<hover:show_text:'&aClick to accept rematch request'><click:run_command:'/duel accept-uuid <uuid>'>&a&l(ACCEPT)</click></hover>", "<accept><hover:show_text:'&aClick to accept rematch request'>&a&l(ACCEPT)</hover></accept>")
                                    .replaceAll("<hover:show_text:'&cClick to deny rematch request'><click:run_command:'/duel deny-uuid <uuid>'>&a&l(DENY)</click></hover>", "<deny><hover:show_text:'&cClick to deny rematch request'>&a&l(DENY)</hover></deny>")
                    ).toList()
            );
            getConfigFile().save();
    }
}