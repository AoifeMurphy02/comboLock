package org.example;

public class ComboLock {
    private int s1;
    private int s2;
    private int s3;

    private ComboLockState comboLockState;

    /**
     * Constructor for the ComboLock class takes in the combo for the lock and sets the initial state of the lock to NONE_CORRECT
     * @param s1 the first value in the combo for the lock
     * @param s2 the second value in the combo for the lock
     * @param s3 the third value in the combo for the lock
     */
    public ComboLock(int s1, int s2, int s3)
    {
        this.s1 = s1;
        this.s2 = s2;
        this.s3 = s3;
        this.comboLockState = ComboLockState.NONE_CORRECT;
    }

    /**
     * sets the state to none correct
     */
    public void reset() {
        this.comboLockState = ComboLockState.NONE_CORRECT;
    }

    /**
     * turns the combo lock to the right by the number entered
     * @param number the number to turn the lock to the right to.
     */
    public void turnRight(int number) {
        //if the lock state is NONE_CORRECT and the number is the same s1
        if (comboLockState == ComboLockState.NONE_CORRECT
                && s1 == number)
            //set the state to FIRST_CORRECT
            comboLockState = ComboLockState.FIRST_CORRECT;
        else {
            //if the lock state is SECOND_CORRECT and number is the same as s3
            if (comboLockState == ComboLockState.SECOND_CORRECT && s3 == number)
                //set state to ALL_CORRECT
                comboLockState = ComboLockState.ALL_CORRECT;
            else
                // if neither of above then, reset() lock to NONE_CORRECT state
                reset();
        }
    }

    /**
     * Turns the lock to the left using the number entered
     * @param number the number to turn the lock to
     */
    public void turnLeft(int number) {
        //see if the lock is in state FIRST_CORRECT ans number is the same as s2
        if (comboLockState == ComboLockState.FIRST_CORRECT && s2 == number)
            //set the state to SECOND_CORRECT
            comboLockState = ComboLockState.SECOND_CORRECT;
        else
            // if not then, reset() lock to NONE_CORRECT state
            reset();
    }

    /**
     * if all combo are correct
     * @return true if all correct false is not all correct
     */
    public boolean open() {

        if (comboLockState == ComboLockState.ALL_CORRECT)
            return true;
        else
            return false;
    }
}


