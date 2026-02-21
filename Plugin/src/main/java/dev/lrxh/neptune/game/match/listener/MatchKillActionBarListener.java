package dev.lrxh.neptune.game.match.listener;

import dev.lrxh.api.events.MatchParticipantDeathEvent;
import dev.lrxh.neptune.configs.impl.MessagesLocale;
import dev.lrxh.neptune.game.match.Match;
import dev.lrxh.neptune.game.match.impl.participant.Participant;
import dev.lrxh.neptune.profile.impl.Profile;
import dev.lrxh.neptune.API;

import net.kyori.adventure.text.minimessage.tag.resolver.Placeholder;
import net.kyori.adventure.text.minimessage.tag.resolver.TagResolver;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

public class MatchKillActionBarListener implements Listener {

    @EventHandler
    public void onMatchDeath(MatchParticipantDeathEvent event) {

        Match match = event.getMatch();
        Participant victim = event.getParticipant();

        if (victim == null)
            return;

        Participant killer = victim.getLastAttacker();

        if (killer == null)
            return;

        Player killerPlayer = Bukkit.getPlayer(killer.getUuid());

        if (killerPlayer == null)
            return;

        // Invia ActionBar usando il tuo MessagesLocale
        MessagesLocale.MATCH_KILL_ACTIONBAR.sendActionBar(killerPlayer,
                TagResolver.resolver(
                        Placeholder.unparsed("player", victim.getName())
                )
        );
    }
}