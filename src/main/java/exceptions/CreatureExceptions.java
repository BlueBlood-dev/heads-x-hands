package exceptions;

public class CreatureExceptions extends RuntimeException {
    private CreatureExceptions(String message) {
        super(message);
    }

    public static CreatureExceptions wrongDefenseValuePassedException() {
        return new CreatureExceptions("Passed defense value is invalid");
    }

    public static CreatureExceptions wrongAttackValuePassedException() {
        return new CreatureExceptions("Passed attack value is invalid");
    }

    public static CreatureExceptions wrongHealthValuePassedException() {
        return new CreatureExceptions("Passed health value is invalid");
    }


    public static CreatureExceptions minimumDamageGreaterThanMaximumDamageException() {
        return new CreatureExceptions("Minimal damage must be less than maximal");
    }


}
