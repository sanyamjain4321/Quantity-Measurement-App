import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class quantitymeasurementappTest {

    // Helper method for parsing user-style input
    private quantitymeasurementapp.QuantityLength parseQuantity(String input) {
        try {
            String[] parts = input.trim().split("\\s+");
            double value = Double.parseDouble(parts[0]);
            quantitymeasurementapp.LengthUnit unit =
                    quantitymeasurementapp.LengthUnit.fromString(parts[1]);

            return new quantitymeasurementapp.QuantityLength(value, unit);
        } catch (Exception e) {
            return null;
        }
    }

    @Test
    public void testEquality_FeetToFeet_SameValue() {
        quantitymeasurementapp.QuantityLength q1 =
                new quantitymeasurementapp.QuantityLength(1.0, quantitymeasurementapp.LengthUnit.FEET);
        quantitymeasurementapp.QuantityLength q2 =
                new quantitymeasurementapp.QuantityLength(1.0, quantitymeasurementapp.LengthUnit.FEET);

        assertTrue(q1.equals(q2));
    }

    @Test
    public void testEquality_FeetToFeet_DifferentValue() {
        quantitymeasurementapp.QuantityLength q1 =
                new quantitymeasurementapp.QuantityLength(1.0, quantitymeasurementapp.LengthUnit.FEET);
        quantitymeasurementapp.QuantityLength q2 =
                new quantitymeasurementapp.QuantityLength(2.0, quantitymeasurementapp.LengthUnit.FEET);

        assertFalse(q1.equals(q2));
    }

    @Test
    public void testEquality_FeetToInches_SameConvertedValue() {
        quantitymeasurementapp.QuantityLength q1 =
                new quantitymeasurementapp.QuantityLength(1.0, quantitymeasurementapp.LengthUnit.FEET);
        quantitymeasurementapp.QuantityLength q2 =
                new quantitymeasurementapp.QuantityLength(12.0, quantitymeasurementapp.LengthUnit.INCHES);

        assertTrue(q1.equals(q2));
    }

    @Test
    public void testEquality_FeetToInches_DifferentConvertedValue() {
        quantitymeasurementapp.QuantityLength q1 =
                new quantitymeasurementapp.QuantityLength(1.0, quantitymeasurementapp.LengthUnit.FEET);
        quantitymeasurementapp.QuantityLength q2 =
                new quantitymeasurementapp.QuantityLength(10.0, quantitymeasurementapp.LengthUnit.INCHES);

        assertFalse(q1.equals(q2));
    }

    @Test
    public void testEquality_NullComparison() {
        quantitymeasurementapp.QuantityLength q1 =
                new quantitymeasurementapp.QuantityLength(1.0, quantitymeasurementapp.LengthUnit.FEET);

        assertFalse(q1.equals(null));
    }

    @Test
    public void testEquality_SameReference() {
        quantitymeasurementapp.QuantityLength q1 =
                new quantitymeasurementapp.QuantityLength(1.0, quantitymeasurementapp.LengthUnit.FEET);

        assertTrue(q1.equals(q1));
    }

    @Test
    public void testEquality_NonNumericInput() {
        quantitymeasurementapp.QuantityLength q1 = parseQuantity("abc feet");
        quantitymeasurementapp.QuantityLength q2 = parseQuantity("1.0 feet");

        assertNull(q1);
        assertNotNull(q2);
    }

    @Test
    public void testEquality_InvalidUnitInput() {
        quantitymeasurementapp.QuantityLength q1 = parseQuantity("1.0 meter");

        assertNull(q1);
    }

    @Test
    public void testEquality_ParseFeetInput() {
        quantitymeasurementapp.QuantityLength q1 = parseQuantity("1.0 feet");

        assertNotNull(q1);
        assertEquals(quantitymeasurementapp.LengthUnit.FEET, q1.getUnit());
        assertEquals(1.0, q1.getValue());
    }

    @Test
    public void testEquality_ParseInchesInput() {
        quantitymeasurementapp.QuantityLength q1 = parseQuantity("12.0 inches");

        assertNotNull(q1);
        assertEquals(quantitymeasurementapp.LengthUnit.INCHES, q1.getUnit());
        assertEquals(12.0, q1.getValue());
    }
}