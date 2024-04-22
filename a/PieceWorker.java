package a;

public class PieceWorker extends Employee {
    private final double wagePerPiece;
    private final int piecesProduced;

    public PieceWorker(String firstName, String lastName, String socialSecurityNumber, double wagePerPiece, int piecesProduced, Birthdate birthdate) {
        super(firstName, lastName, socialSecurityNumber, birthdate);

        if (wagePerPiece < 0.0) {
            throw new IllegalArgumentException("Wage per piece must be >= 0.0");
        }

        if (piecesProduced < 0) {
            throw new IllegalArgumentException("Pieces produced must be >= 0");
        }

        this.wagePerPiece = wagePerPiece;
        this.piecesProduced = piecesProduced;
    }

    public double getWagePerPiece() {
        return wagePerPiece;
    }

    public int getPiecesProduced() {
        return piecesProduced;
    }

    @Override
    public double earnings() {
        return getWagePerPiece() * getPiecesProduced();
    }

    @Override
    public String toString() {
        return String.format("%s: %s%n%s: $%,.2f; %s: %d", "piece worker", super.toString(), "wage per piece",
                getWagePerPiece(), "pieces produced", getPiecesProduced());
    }
}