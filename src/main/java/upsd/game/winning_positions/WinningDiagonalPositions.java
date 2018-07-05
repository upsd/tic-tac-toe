package upsd.game.winning_positions;

import upsd.game.Position;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class WinningDiagonalPositions {

    public static List<Position> fromBottomLeftToTopRight() {
        return Collections.unmodifiableList(Arrays.asList(Position.BOTTOM_LEFT, Position.MIDDLE_MIDDLE, Position.TOP_RIGHT));
    }

    public static List<Position> fromTopLeftToBottomRight() {
        return Collections.unmodifiableList(Arrays.asList(Position.TOP_LEFT, Position.MIDDLE_MIDDLE, Position.BOTTOM_RIGHT));
    }
}
