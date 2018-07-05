package upsd.game.winning_positions;

import upsd.game.Position;

import java.util.Arrays;
import java.util.List;

public class WinningHorizontalPositions {

    public static List<Position> forTopRow() {
        return Arrays.asList(Position.TOP_LEFT, Position.TOP_MIDDLE, Position.TOP_RIGHT);
    }

    public static List<Position> forMiddleRow() {
        return Arrays.asList(Position.MIDDLE_LEFT, Position.MIDDLE_MIDDLE, Position.MIDDLE_RIGHT);
    }

    public static List<Position> forBottomRow() {
        return Arrays.asList(Position.BOTTOM_LEFT, Position.BOTTOM_MIDDLE, Position.BOTTOM_RIGHT);
    }
}
