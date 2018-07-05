package upsd.game.winning_positions;

import upsd.game.Position;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class WinningHorizontalPositions {

    public static List<Position> forTopRow() {
        return Collections.unmodifiableList(Arrays.asList(Position.TOP_LEFT, Position.TOP_MIDDLE, Position.TOP_RIGHT));
    }

    public static List<Position> forMiddleRow() {
        return Collections.unmodifiableList(Arrays.asList(Position.MIDDLE_LEFT, Position.MIDDLE_MIDDLE, Position.MIDDLE_RIGHT));
    }

    public static List<Position> forBottomRow() {
        return Collections.unmodifiableList(Arrays.asList(Position.BOTTOM_LEFT, Position.BOTTOM_MIDDLE, Position.BOTTOM_RIGHT));
    }
}
