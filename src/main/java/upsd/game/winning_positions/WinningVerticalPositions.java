package upsd.game.winning_positions;

import upsd.game.Position;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class WinningVerticalPositions {

    public static List<Position> fromTopLeftToBottomLeft() {
        return Collections.unmodifiableList(Arrays.asList(Position.TOP_LEFT, Position.MIDDLE_LEFT, Position.BOTTOM_LEFT));
    }

    public static List<Position> fromTopMiddleToBottomMiddle() {
        return Collections.unmodifiableList(Arrays.asList(Position.TOP_MIDDLE, Position.MIDDLE_MIDDLE, Position.BOTTOM_MIDDLE));
    }

    public static List<Position> fromTopRightToBottomRight() {
        return Collections.unmodifiableList(Arrays.asList(Position.TOP_RIGHT, Position.MIDDLE_RIGHT, Position.BOTTOM_RIGHT));
    }
}
