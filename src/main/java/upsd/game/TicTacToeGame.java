package upsd.game;

import java.util.LinkedHashMap;
import java.util.List;

import static upsd.game.winning_positions.WinningDiagonalPositions.*;
import static upsd.game.winning_positions.WinningHorizontalPositions.*;
import static upsd.game.winning_positions.WinningVerticalPositions.*;

public class TicTacToeGame {

    private Value valueToPlace = Value.X;
    private final LinkedHashMap<Position, Value> plays;
    private final int MAXIMUM_PLAYS = 9;

    public TicTacToeGame() {
        plays = new LinkedHashMap<>();
    }

    public void play(Position position) {
        throwExceptionIfPositionAlreadyTaken(position);

        if (valueToPlace == Value.X) {
            plays.put(position, Value.X);
            valueToPlace = Value.O;
            return;
        }

        plays.put(position, Value.O);
        valueToPlace = Value.X;
    }

    private void throwExceptionIfPositionAlreadyTaken(Position positionToCheck) {
        if (plays.containsKey(positionToCheck)) {
            throw new PositionAlreadyTakenException();
        }
    }

    public Value atPosition(Position position) {
        return plays.get(position);
    }

    public Summary summary() {

        boolean hasXWon = hasWon(Value.X);
        boolean hasOWon = hasWon(Value.O);

        if (!hasXWon && !hasOWon && plays.size() < MAXIMUM_PLAYS) {
            return Summary.PLAYING;
        }

        if (hasXWon) {
            return Summary.WIN_FOR_X;
        }

        if (hasOWon) {
            return Summary.WIN_FOR_O;
        }

        return Summary.DRAW;
    }

    private boolean hasWon(Value player) {
        return hasWonVertically(player)
                || hasWonHorizontally(player)
                || hasWonDiagonally(player);
    }

    private boolean hasWonDiagonally(Value player) {
        return hasWonWith(fromBottomLeftToTopRight(), player)
                || hasWonWith(fromTopLeftToBottomRight(), player);
    }

    private boolean hasWonHorizontally(Value player) {
        return hasWonWith(forTopRow(), player)
                || hasWonWith(forMiddleRow(), player)
                || hasWonWith(forBottomRow(), player);
    }

    private boolean hasWonVertically(Value player) {
        return hasWonWith(fromTopLeftToBottomLeft(), player)
                || hasWonWith(fromTopMiddleToBottomMiddle(), player)
                || hasWonWith(fromTopRightToBottomRight(), player);
    }

    private boolean hasWonWith(List<Position> positionsToSearch, Value playerToSearch) {
        return plays.entrySet()
                .stream()
                .filter(play -> positionsToSearch.contains(play.getKey()) && play.getValue() == playerToSearch)
                .count() == positionsToSearch.size();
    }
}
