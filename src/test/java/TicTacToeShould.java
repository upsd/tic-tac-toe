import org.junit.Before;
import org.junit.Test;
import upsd.game.*;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class TicTacToeShould {

    private TicTacToeGame game;

    @Before
    public void setup() {
        game = new TicTacToeGame();
    }

    @Test
    public void place_X_first() {
        game.play(Position.TOP_LEFT);

        assertThat(game.atPosition(Position.TOP_LEFT), is(Value.X));
    }

    @Test
    public void place_O_second() {
        game.play(Position.TOP_LEFT);
        game.play(Position.TOP_RIGHT);

        assertThat(game.atPosition(Position.TOP_RIGHT), is(Value.O));
    }

    @Test(expected = PositionAlreadyTakenException.class)
    public void not_allow_a_play_on_a_taken_position() {
        game.play(Position.TOP_LEFT);
        game.play(Position.TOP_LEFT);
    }

    @Test
    public void report_if_game_is_a_draw() {
        game.play(Position.TOP_LEFT);
        game.play(Position.MIDDLE_MIDDLE);
        game.play(Position.MIDDLE_RIGHT);
        game.play(Position.BOTTOM_LEFT);
        game.play(Position.TOP_RIGHT);
        game.play(Position.TOP_MIDDLE);
        game.play(Position.MIDDLE_LEFT);
        game.play(Position.BOTTOM_RIGHT);
        game.play(Position.BOTTOM_MIDDLE);

        assertThat(game.summary(), is(Summary.DRAW));
    }

    @Test
    public void report_if_game_has_not_finished() {
        game.play(Position.TOP_LEFT);

        assertThat(game.summary(), is(Summary.PLAYING));
    }

    @Test
    public void report_if_game_is_won_vertically_down_left_row_for_X() {
        game.play(Position.TOP_LEFT);
        game.play(Position.TOP_RIGHT);
        game.play(Position.MIDDLE_LEFT);
        game.play(Position.MIDDLE_MIDDLE);
        game.play(Position.BOTTOM_LEFT);

        assertThat(game.summary(), is(Summary.WIN_FOR_X));
    }

    @Test
    public void report_if_game_is_won_vertically_down_middle_row_for_X() {
        game.play(Position.TOP_MIDDLE);
        game.play(Position.BOTTOM_RIGHT);
        game.play(Position.MIDDLE_MIDDLE);
        game.play(Position.BOTTOM_LEFT);
        game.play(Position.BOTTOM_MIDDLE);

        assertThat(game.summary(), is(Summary.WIN_FOR_X));
    }

    @Test
    public void report_if_game_is_won_vertically_down_right_row_for_X() {
        game.play(Position.TOP_RIGHT);
        game.play(Position.BOTTOM_LEFT);
        game.play(Position.MIDDLE_RIGHT);
        game.play(Position.TOP_LEFT);
        game.play(Position.BOTTOM_RIGHT);

        assertThat(game.summary(), is(Summary.WIN_FOR_X));
    }

    @Test
    public void report_if_game_is_won_vertically_down_left_row_for_O() {
        game.play(Position.TOP_RIGHT);
        game.play(Position.TOP_LEFT);
        game.play(Position.BOTTOM_MIDDLE);
        game.play(Position.MIDDLE_LEFT);
        game.play(Position.TOP_MIDDLE);
        game.play(Position.BOTTOM_LEFT);

        assertThat(game.summary(), is(Summary.WIN_FOR_O));
    }

    @Test
    public void report_if_game_is_won_vertically_down_middle_row_for_O() {
        game.play(Position.BOTTOM_RIGHT);
        game.play(Position.TOP_MIDDLE);
        game.play(Position.BOTTOM_LEFT);
        game.play(Position.MIDDLE_MIDDLE);
        game.play(Position.TOP_RIGHT);
        game.play(Position.BOTTOM_MIDDLE);

        assertThat(game.summary(), is(Summary.WIN_FOR_O));
    }

    @Test
    public void report_if_game_is_won_vertically_down_right_row_for_O() {
        game.play(Position.BOTTOM_LEFT);
        game.play(Position.TOP_RIGHT);
        game.play(Position.TOP_LEFT);
        game.play(Position.MIDDLE_RIGHT);
        game.play(Position.MIDDLE_MIDDLE);
        game.play(Position.BOTTOM_RIGHT);

        assertThat(game.summary(), is(Summary.WIN_FOR_O));
    }

    @Test
    public void report_if_is_won_horizontally_across_top_row_for_X() {
        game.play(Position.TOP_LEFT);
        game.play(Position.MIDDLE_MIDDLE);
        game.play(Position.TOP_MIDDLE);
        game.play(Position.BOTTOM_LEFT);
        game.play(Position.TOP_RIGHT);

        assertThat(game.summary(), is(Summary.WIN_FOR_X));
    }

    @Test
    public void report_if_is_won_horizontally_across_middle_row_for_X() {
        game.play(Position.MIDDLE_LEFT);
        game.play(Position.BOTTOM_RIGHT);
        game.play(Position.MIDDLE_MIDDLE);
        game.play(Position.TOP_LEFT);
        game.play(Position.MIDDLE_RIGHT);

        assertThat(game.summary(), is(Summary.WIN_FOR_X));
    }

    @Test
    public void report_if_is_won_horizontally_across_bottom_row_for_X() {
        game.play(Position.BOTTOM_LEFT);
        game.play(Position.TOP_LEFT);
        game.play(Position.BOTTOM_MIDDLE);
        game.play(Position.MIDDLE_RIGHT);
        game.play(Position.BOTTOM_RIGHT);

        assertThat(game.summary(), is(Summary.WIN_FOR_X));
    }

    @Test
    public void report_if_is_won_horizontally_across_top_row_for_O() {
        game.play(Position.MIDDLE_MIDDLE);
        game.play(Position.TOP_LEFT);
        game.play(Position.BOTTOM_LEFT);
        game.play(Position.TOP_MIDDLE);
        game.play(Position.BOTTOM_RIGHT);
        game.play(Position.TOP_RIGHT);

        assertThat(game.summary(), is(Summary.WIN_FOR_O));
    }

    @Test
    public void report_if_is_won_horizontally_across_middle_row_for_O() {
        game.play(Position.TOP_RIGHT);
        game.play(Position.MIDDLE_LEFT);
        game.play(Position.BOTTOM_LEFT);
        game.play(Position.MIDDLE_MIDDLE);
        game.play(Position.TOP_LEFT);
        game.play(Position.MIDDLE_RIGHT);

        assertThat(game.summary(), is(Summary.WIN_FOR_O));
    }

    @Test
    public void report_if_is_won_horizontally_across_bottom_row_for_O() {
        game.play(Position.TOP_LEFT);
        game.play(Position.BOTTOM_LEFT);
        game.play(Position.MIDDLE_RIGHT);
        game.play(Position.BOTTOM_MIDDLE);
        game.play(Position.TOP_RIGHT);
        game.play(Position.BOTTOM_RIGHT);

        assertThat(game.summary(), is(Summary.WIN_FOR_O));
    }

    @Test
    public void report_if_is_won_diagonally_from_bottom_left_to_top_right_for_X() {
        game.play(Position.BOTTOM_LEFT);
        game.play(Position.TOP_LEFT);
        game.play(Position.MIDDLE_MIDDLE);
        game.play(Position.BOTTOM_RIGHT);
        game.play(Position.TOP_RIGHT);

        assertThat(game.summary(), is(Summary.WIN_FOR_X));
    }

    @Test
    public void report_if_is_won_diagonally_from_top_left_to_bottom_right_for_X() {
        game.play(Position.TOP_LEFT);
        game.play(Position.MIDDLE_RIGHT);
        game.play(Position.MIDDLE_MIDDLE);
        game.play(Position.TOP_RIGHT);
        game.play(Position.BOTTOM_RIGHT);

        assertThat(game.summary(), is(Summary.WIN_FOR_X));
    }

    @Test
    public void report_if_is_won_diagonally_from_bottom_left_to_top_right_for_O() {
        game.play(Position.TOP_LEFT);
        game.play(Position.BOTTOM_LEFT);
        game.play(Position.BOTTOM_RIGHT);
        game.play(Position.MIDDLE_MIDDLE);
        game.play(Position.MIDDLE_LEFT);
        game.play(Position.TOP_RIGHT);

        assertThat(game.summary(), is(Summary.WIN_FOR_O));
    }

    @Test
    public void report_if_is_won_diagonally_from_top_left_to_bottom_right_for_O() {
        game.play(Position.MIDDLE_RIGHT);
        game.play(Position.TOP_LEFT);
        game.play(Position.TOP_RIGHT);
        game.play(Position.MIDDLE_MIDDLE);
        game.play(Position.MIDDLE_LEFT);
        game.play(Position.BOTTOM_RIGHT);

        assertThat(game.summary(), is(Summary.WIN_FOR_O));
    }
}