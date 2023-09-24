package models;

public interface Creature {
    void attack(Creature creature);

    void decreaseHealthValue(int decrease);

    int getDefense();

    boolean isDead();

    int getHealth();
}
