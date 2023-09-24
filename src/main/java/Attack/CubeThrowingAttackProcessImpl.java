package Attack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class CubeThrowingAttackProcessImpl implements AttackProcess {

    private static final int CUBE_MIN_VALUE = 1;

    private static final int CUBE_MAX_VALUE = 6;

    private static final ArrayList<Integer> successfulThrowValues = new ArrayList<>(Arrays.asList(5, 6));


    @Override
    public int getAttackResult(int attack, int defense, int damageMinimum, int damageMaximum) {
        int attackModifier = attack - defense + 1;
        if (attackModifier <= 0) {
            if (isSuccessful(countRandomValue(CUBE_MIN_VALUE, CUBE_MAX_VALUE)))
                return damageMinimum + (int) (Math.random() * damageMaximum);
            else
                return 0;
        }
        for (int i = 0; i < attackModifier; i++) {
            if (isSuccessful(countRandomValue(CUBE_MIN_VALUE, CUBE_MAX_VALUE)))
                return countRandomValue(damageMinimum, damageMaximum);
        }
        return 0;
    }

    public List<Integer> getSuccessfulThrowValues() {
        return Collections.unmodifiableList(successfulThrowValues);
    }

    private boolean isSuccessful(int throwResult) {
        return successfulThrowValues.contains(throwResult);
    }

    private int countRandomValue(int start, int finish) {
        return start + (int) (Math.random() * finish);
    }
}
