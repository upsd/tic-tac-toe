package upsd.game;

import upsd.game.winning_positions.WinningDiagonalPositions;
import upsd.game.winning_positions.WinningHorizontalPositions;
import upsd.game.winning_positions.WinningVerticalPositions;

import java.util.LinkedHashMap;
import java.util.List;

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

        boolean hasXWon = getWinner(Value.X);
        boolean hasOWon = getWinner(Value.O);

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

    private boolean getWinner(Value player) {
        return hasWonVertically(player)
                || hasWonHorizontally(player)
                || hasWonDiagonally(player);
    }

    private boolean hasWonDiagonally(Value player) {
        return hasWonDiagonallyWith(WinningDiagonalPositions.fromBottomLeftToTopRight(), player)
                || hasWonDiagonallyWith(WinningDiagonalPositions.fromTopLeftToBottomRight(), player);
    }

    private boolean hasWonHorizontally(Value player) {
        return hasWonHorizontallyWith(WinningHorizontalPositions.forTopRow(), player)
                || hasWonHorizontallyWith(WinningHorizontalPositions.forMiddleRow(), player)
                || hasWonHorizontallyWith(WinningHorizontalPositions.forBottomRow(), player);
    }

    private boolean hasWonVertically(Value player) {
        return hasWonVerticallyWith(WinningVerticalPositions.fromTopLeftToBottomLeft(), player)
                || hasWonVerticallyWith(WinningVerticalPositions.fromTopMiddleToBottomMiddle(), player)
                || hasWonVerticallyWith(WinningVerticalPositions.fromTopRightToBottomRight(), player);
    }

    private boolean hasWonDiagonallyWith(List<Position> positionsToSearch, Value playerToSearch) {
        return hasWonWith(positionsToSearch, playerToSearch);
    }

    private boolean hasWonHorizontallyWith(List<Position> positionsToSearch, Value playerToSearch) {
        return hasWonWith(positionsToSearch, playerToSearch);
    }

    private boolean hasWonVerticallyWith(List<Position> positionsToSearch, Value playerToSearch) {
        return hasWonWith(positionsToSearch, playerToSearch);
    }

    private boolean hasWonWith(List<Position> positionsToSearch, Value playerToSearch) {
        return plays.entrySet()
                .stream()
                .filter(play -> positionsToSearch.contains(play.getKey()) && play.getValue() == playerToSearch)
                .count() == positionsToSearch.size();
    }
}
