package dev.tdmnhat.plugin.setup;

import org.bukkit.Location;
import org.bukkit.entity.Player;

import java.util.HashSet;
import java.util.Set;

public class GameTeam {
    private final String name;
    private final String teamColor;
    private final Set<Player> members = new HashSet<>();
    private final Set<Player> alive = new HashSet<>();
    private Location spawn;
    private Location heartHealthTeamLocation;
    private int heartHealthTeam;

    public GameTeam(String name, String teamColor) {
        this.name = name;
        this.teamColor = teamColor;
    }
}
