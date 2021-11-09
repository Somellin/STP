package labs.stp.fraction.exception;

public class FractionStringException extends Exception{
    public FractionStringException() {
        super("FractionStringException\n try: <number> / <number>");
    }
}
