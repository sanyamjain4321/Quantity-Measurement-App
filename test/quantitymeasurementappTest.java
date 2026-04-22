import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class quantitymeasurementappTest {

    private boolean checkEquality(String input) {
        try {
            String[] parts = input.split(" ");
            double value1 = Double.parseDouble(parts[0]);
            double value2 = Double.parseDouble(parts[3]);

            quantitymeasurementapp.Feet f1 = new quantitymeasurementapp.Feet(value1);
            quantitymeasurementapp.Feet f2 = new quantitymeasurementapp.Feet(value2);

            return f1.equals(f2);
        } catch (Exception e) {
            return false;
        }
    }

    @Test
    void testEquality_SameValue() {
        assertTrue(checkEquality("1.0 ft and 1.0 ft"));
    }

    @Test
    void testEquality_DifferentValue() {
        assertFalse(checkEquality("1.0 ft and 2.0 ft"));
    }

    @Test
    void testEquality_NullComparison() {
        quantitymeasurementapp.Feet f1 = new quantitymeasurementapp.Feet(1.0);
        assertFalse(f1.equals(null));
    }

    @Test
    void testEquality_NonNumericInput() {
        assertFalse(checkEquality("abc ft and xyz ft"));
    }

    @Test
    void testEquality_SameReference() {
        quantitymeasurementapp.Feet f1 = new quantitymeasurementapp.Feet(1.0);
        assertTrue(f1.equals(f1));
    }
}