package org.example;

public class Player {
    String name;
    int point;

    public Player(String name, int point) {
        this.name = name;
        this.point = point;
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Player)) return false;
        return name.equals(((Player) obj).name);
    }

    public String getName() {
        return name;
    }

    public boolean is(String otherName) {
        return otherName.equalsIgnoreCase(name);
    }

    public int getPoint() {
        return point;
    }

    public void setName(String name) {
        this.name = name;
    }
}
