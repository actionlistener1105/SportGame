package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class GameTest {

    @Test
    void shouldReturnOneWhenFirstPlayerStronger() {
        Game game = new Game();
        Player first = new Player(1, "Ира", 10);
        Player second = new Player(2, "Маша", 8);
        game.register(first);
        game.register(second);

        int result = game.round("Ира", "Маша");

        Assertions.assertEquals(1, result);
    }

    @Test
    void shouldReturnTwoWhenSecondPlayerStronger() {
        Game game = new Game();
        Player first = new Player(1, "Ира", 8);
        Player second = new Player(2, "Маша", 10);
        game.register(first);
        game.register(second);

        int result = game.round("Ира", "Маша");

        Assertions.assertEquals(2, result);
    }

    @Test
    void shouldReturnZeroWhenStrengthEqual() {
        Game game = new Game();
        Player first = new Player(1, "Ира", 10);
        Player second = new Player(2, "Маша", 10);
        game.register(first);
        game.register(second);

        int result = game.round("Ира", "Маша");

        Assertions.assertEquals(0, result);
    }

    @Test
    void shouldThrowWhenFirstPlayerNotRegistered() {
        Game game = new Game();
        Player second = new Player(2, "Маша", 10);
        game.register(second);

        Assertions.assertThrows(NotRegisteredException.class,
                () -> game.round("Ира", "Маша"));
    }

    @Test
    void shouldThrowWhenSecondPlayerNotRegistered() {
        Game game = new Game();
        Player first = new Player(1, "Ира", 10);
        game.register(first);

        Assertions.assertThrows(NotRegisteredException.class,
                () -> game.round("Ира", "Маша"));
    }

}
