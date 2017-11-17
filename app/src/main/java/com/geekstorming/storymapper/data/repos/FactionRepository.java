package com.geekstorming.storymapper.data.repos;

import com.geekstorming.storymapper.data.pojo.Faction;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Faction repository, faction list
 *
 * @author Elena Guzman Blanco (Beelzenef) - 3d10Mundos
 */

public class FactionRepository {

    // Atts
    ArrayList<Faction> factions;
    private static FactionRepository factionRepository;

    // Constructor
    static {
        factionRepository = new FactionRepository();
    }

    private FactionRepository() {
        factions = new ArrayList<>();
        initializeFactions();
    }

    // Methods

    public void addFaction(Faction f) {
        factions.add(f);
    }

    private void initializeFactions() {
        addFaction(new Faction(1, "La Tabula", "Dominar el mundo", 1));
        addFaction(new Faction(2, "Shadowhunters", "Proteger a la humanidad", 2));
        addFaction(new Faction(3, "La Mascarada", "Mantener a los vampiros tras el Velo", 3));
        addFaction(new Faction(4, "La Tejedora", "Technocracy!", 4));
    }

    public static FactionRepository getInstance() {
        return factionRepository;
    }

    public ArrayList<Faction> getFactions() {

        Collections.sort(factions);
        return factions;
    }
}
