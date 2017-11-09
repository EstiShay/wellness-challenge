package com.epicodus.wellnesschallenge.models;

import org.parceler.Parcel;

@Parcel
public class TeamMember {
    String name;
    String team;

    public TeamMember(){}

    public TeamMember(String name, String team){
        this.name = name;
        this.team = team;
    }

    public String getName() {
        return name;
    }

    public String getTeam() {
        return team;
    }
}
