package models;

import Attack.AttackProcess;
import exceptions.CreatureExceptions;
import exceptions.LogicExceptions;

public class Monster implements Creature {
    private final static int DEFENSE_MIN_VALUE = 1;

    private final static int DEFENSE_MAX_VALUE = 30;

    private final static int ATTACK_MIN_VALUE = 1;

    private final static int ATTACK_MAX_VALUE = 30;

    private final static int HEALTH_MIN_VALUE = 0;

    private final AttackProcess attackProcess;

    private final int attack;

    private final int defense;

    private final int damageMinimum;

    private final int damageMaximum;

    private int health;

    private boolean isDead = false;

    public Monster(AttackProcess process, int attack, int defense, int damageMinimum, int damageMaximum, int health) {
        if (attack < ATTACK_MIN_VALUE || attack > ATTACK_MAX_VALUE) {
            throw CreatureExceptions.wrongAttackValuePassedException();
        }

        if (defense < DEFENSE_MIN_VALUE || defense > DEFENSE_MAX_VALUE) {
            throw CreatureExceptions.wrongDefenseValuePassedException();
        }

        if (health < HEALTH_MIN_VALUE) {
            throw CreatureExceptions.wrongHealthValuePassedException();
        }

        if (process == null) {
            throw new IllegalArgumentException("AttackProcess must not be null");
        }

        if (damageMinimum > damageMaximum)
            throw CreatureExceptions.minimumDamageGreaterThanMaximumDamageException();


        this.attackProcess = process;
        this.attack = attack;
        this.defense = defense;
        this.damageMinimum = damageMinimum;
        this.damageMaximum = damageMaximum;
        this.health = health;
    }


    @Override
    public void attack(Creature creature) {
        if (!isDead) {
            if (creature == null)
                throw new IllegalArgumentException("Passed creature to attack can't be null");

            if (creature.isDead())
                throw LogicExceptions.DeadCreatureIsBeingAttackedException();

            creature.decreaseHealthValue(attackProcess.getAttackResult(attack, creature.getDefense(), damageMinimum, damageMaximum));
        } else
            System.out.println("Creature you want to make attack is dead ;(");
    }

    @Override
    public void decreaseHealthValue(int decrease) {
        setHealth(health - decrease);
    }


    @Override
    public int getDefense() {
        return defense;
    }

    @Override
    public boolean isDead() {
        return isDead;
    }

    public int getHealth() {
        return health;
    }

    private void setHealth(int newHealth) {
        if (newHealth <= HEALTH_MIN_VALUE)
            isDead = true;
        health = newHealth;
    }
}
