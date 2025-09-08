package state;

import state.states.CharacterState;
import state.states.IntermediateState;
import state.states.MasterState;
import state.states.NoviceState;
import state.states.ExpertState;

public class Character {
    private String name;
    private int health;
    private float exp;
    private CharacterState state;

    public Character(String name) {
        this.name = name;
        this.health = 100;
        this.exp = 0;
        this.state = new NoviceState(this);
    }

    public void setState(CharacterState state) {
        this.state = state;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getHealth() {
        return health;
    }

    public float getExperience() {
        return exp;
    }

    public void increaseHealth(int points) {
        this.health = Math.min(100, this.health + points);
        System.out.println("Health restored! Current Health: " + this.health);
    }

    public void decreaseHealth(int points) {
        this.health = Math.max(0, this.health - points);
        System.out.println("Health decreased! Current Health: " + this.health);
    }

    public int gainExperience(int points) {
        this.exp += points;
        if (this.exp >= 150) {
            this.state = new IntermediateState(this);
            System.out.println(name + " leveled up to INTERMEDIATE!");
        } else if (this.exp >= 350) {
            this.state = new ExpertState(this);
            System.out.println(name + " leveled up to EXPERT!");
        } else if (this.exp >= 650) {
            this.state = new MasterState(this);
            System.out.println(name + " leveled up to MASTER!");
        }
        return points;
    }

    public void train() {
        System.out.print("\033\143");
        state.train();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void meditate() {
        System.out.print("\033\143");
        state.meditate();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void fight() {
        System.out.print("\033\143");
        state.fight();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public String getName() {
        return name;
    }

    public void getCharachterStatus() {
        System.out.println("Name: " + name);
        System.out.println("Level: " + state.getLevelName());
        System.out.println("Experience: " + exp);

        String healthBar = "[" + "=".repeat(health / 10) + " ".repeat(10 - health / 10) + "] " + health + "/100";
        System.out.println("Health Bar: " + healthBar);
    }

    public void getAvailableActions() {
        state.displayAvailableActions();
    }
}
