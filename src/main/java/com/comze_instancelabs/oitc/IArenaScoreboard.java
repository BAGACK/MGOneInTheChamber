package com.comze_instancelabs.oitc;

import java.util.HashMap;
import java.util.logging.Level;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.OfflinePlayer;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.ScoreboardManager;

import com.comze_instancelabs.minigamesapi.Arena;
import com.comze_instancelabs.minigamesapi.MinigamesAPI;
import com.comze_instancelabs.minigamesapi.util.ArenaScoreboard;

public class IArenaScoreboard extends ArenaScoreboard {

	HashMap<String, Scoreboard> ascore = new HashMap<String, Scoreboard>();
	HashMap<String, Objective> aobjective = new HashMap<String, Objective>();

	JavaPlugin plugin = null;

	public IArenaScoreboard(JavaPlugin plugin) {
		this.plugin = plugin;
	}

	public void updateScoreboard(final IArena arena) {
		for (String p_ : arena.getAllPlayers()) {
			Player p = Bukkit.getPlayer(p_);
			if (!ascore.containsKey(arena.getInternalName())) {
				ascore.put(arena.getInternalName(), Bukkit.getScoreboardManager().getNewScoreboard());
			}
			if (!aobjective.containsKey(arena.getInternalName())) {
				aobjective.put(arena.getInternalName(), ascore.get(arena.getInternalName()).registerNewObjective(arena.getInternalName(), "dummy"));
				aobjective.get(arena.getInternalName()).setDisplaySlot(DisplaySlot.SIDEBAR);
				aobjective.get(arena.getInternalName()).setDisplayName(MinigamesAPI.getAPI().pinstances.get(plugin).getMessagesConfig().scoreboard_title.replaceAll("<arena>", arena.getDisplayName()));
			}

			if (!arena.kills.containsKey(p_)) {
				arena.kills.put(p_, 0);
			}
			int i = arena.kills.get(p_);

			// ascore.get(arena.getInternalName()).resetScores(p_);
			// ascore.get(arena.getInternalName()).resetScores(Bukkit.getOfflinePlayer(Integer.toString(arena.kills.get(p_) + " "));

			get(aobjective.get(arena.getInternalName()), p_).setScore(i);
		}

		for (String p_ : arena.getAllPlayers()) {
			Player p = Bukkit.getPlayer(p_);
			if (ascore.containsKey(arena.getInternalName())) {
				p.setScoreboard(ascore.get(arena.getInternalName()));
			}
		}

	}

	@Override
	public void updateScoreboard(JavaPlugin plugin, final Arena arena) {
		IArena a = (IArena) MinigamesAPI.getAPI().pinstances.get(plugin).getArenaByName(arena.getInternalName());
		this.updateScoreboard(a);
	}

	@Override
	public void removeScoreboard(String arena, Player p) {
		if (ascore.containsKey(arena)) {
			try {
				Scoreboard sc = ascore.get(arena);
				for (OfflinePlayer player : sc.getPlayers()) {
					sc.resetScores(player);
				}
			} catch (Exception e) {
				if (MinigamesAPI.debug) {
					MinigamesAPI.getAPI().getLogger().log(Level.WARNING, "exception", e);
				}
			}
			ascore.remove(arena);
			if(aobjective.containsKey(arena)){
				aobjective.remove(arena);
			}
		}
		ScoreboardManager manager = Bukkit.getScoreboardManager();
		Scoreboard sc = manager.getNewScoreboard();
		sc.clearSlot(DisplaySlot.SIDEBAR);
		p.setScoreboard(sc);
	}

}
