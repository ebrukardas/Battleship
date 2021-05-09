package com.company;

/**
 * State Design Pattern for Players
 * https://www.tutorialspoint.com/design_pattern/state_pattern.htm
 */
public interface State {
    /**
     * Does the state its own job
     * @param player which player is in "the" state
     */
    void doAction(Player player);

    /**
     * Get type of the state
     * @return State name
     */
    String getState();
}
