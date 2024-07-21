package com.extra.chapter2.converter.domain;

public class TaskClass {


    private String characterName;

    private String universe;

    private String powerLevel;
    private String tournamentResult;

    public TaskClass(String characterName, String universe, String powerLevel, String tournamentResult) {
        this.characterName = characterName;
        this.universe = universe;
        this.powerLevel = powerLevel;
        this.tournamentResult = tournamentResult;
    }

    public String getCharacterName() {
        return characterName;
    }

    public String getUniverse() {
        return universe;
    }

    public String getPowerLevel() {
        return powerLevel;
    }

    public String getTournamentResult() {
        return tournamentResult;
    }
}
