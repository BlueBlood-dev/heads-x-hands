package exceptions;

public class LogicExceptions extends RuntimeException{
    private LogicExceptions(String message){
        super(message);
    }

    public static LogicExceptions DeadCreatureIsBeingAttackedException(){
        return new LogicExceptions("Can't attack already dead creature!");
    }
}
