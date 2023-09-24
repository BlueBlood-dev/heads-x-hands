package org.application;

import attack.CubeThrowingAttackProcessImpl;
import models.Monster;
import models.Player;

public class Main {
    public static void main(String[] args) {
        System.out.println("simple fighting sample");
        Player player = new Player(23, 20, 100, new CubeThrowingAttackProcessImpl(), 3, 8);
        Monster firstMonster = new Monster(new CubeThrowingAttackProcessImpl(), 5, 25, 1, 7, 25);

        System.out.println("Killing first monster...");
        while (!firstMonster.isDead()) {
            player.attack(firstMonster);
            System.out.println("Monster's health is " + firstMonster.getHealth());
        }

        if (firstMonster.isDead())
            System.out.println("the monster died as it was expected");

        System.out.println("now we'll make sure that healing works");
        player.decreaseHealthValue(33);
        System.out.println("current player health value is " + player.getHealth());
        player.heal();
        System.out.println("player's health after healing is " + player.getHealth());


    }
}