import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class quantitymeasurementappTest {

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
    public void testEquality_InchesToInches_SameValue() {
        quantitymeasurementapp.QuantityLength q1 =
                new quantitymeasurementapp.QuantityLength(12.0, quantitymeasurementapp.LengthUnit.INCHES);
        quantitymeasurementapp.QuantityLength q2 =
                new quantitymeasurementapp.QuantityLength(12.0, quantitymeasurementapp.LengthUnit.INCHES);

        assertTrue(q1.equals(q2));
    }

    @Test
    public void testEquality_YardsToYards_SameValue() {
        quantitymeasurementapp.QuantityLength q1 =
                new quantitymeasurementapp.QuantityLength(2.0, quantitymeasurementapp.LengthUnit.YARDS);
        quantitymeasurementapp.QuantityLength q2 =
                new quantitymeasurementapp.QuantityLength(2.0, quantitymeasurementapp.LengthUnit.YARDS);

        assertTrue(q1.equals(q2));
    }

    @Test
    public void testEquality_CentimetersToCentimeters_SameValue() {
        quantitymeasurementapp.QuantityLength q1 =
                new quantitymeasurementapp.QuantityLength(2.0, quantitymeasurementapp.LengthUnit.CENTIMETERS);
        quantitymeasurementapp.QuantityLength q2 =
                new quantitymeasurementapp.QuantityLength(2.0, quantitymeasurementapp.LengthUnit.CENTIMETERS);

        assertTrue(q1.equals(q2));
    }

    @Test
    public void testEquality_YardsToFeet_SameConvertedValue() {
        quantitymeasurementapp.QuantityLength q1 =
                new quantitymeasurementapp.QuantityLength(1.0, quantitymeasurementapp.LengthUnit.YARDS);
        quantitymeasurementapp.QuantityLength q2 =
                new quantitymeasurementapp.QuantityLength(3.0, quantitymeasurementapp.LengthUnit.FEET);

        assertTrue(q1.equals(q2));
    }

    @Test
    public void testEquality_YardsToInches_SameConvertedValue() {
        quantitymeasurementapp.QuantityLength q1 =
                new quantitymeasurementapp.QuantityLength(1.0, quantitymeasurementapp.LengthUnit.YARDS);
        quantitymeasurementapp.QuantityLength q2 =
                new quantitymeasurementapp.QuantityLength(36.0, quantitymeasurementapp.LengthUnit.INCHES);

        assertTrue(q1.equals(q2));
    }

    @Test
    public void testEquality_CentimetersToInches_SameConvertedValue() {
        quantitymeasurementapp.QuantityLength q1 =
                new quantitymeasurementapp.QuantityLength(1.0, quantitymeasurementapp.LengthUnit.CENTIMETERS);
        quantitymeasurementapp.QuantityLength q2 =
                new quantitymeasurementapp.QuantityLength(0.393701, quantitymeasurementapp.LengthUnit.INCHES);

        assertTrue(q1.equals(q2));
    }

    @Test
    public void testEquality_DifferentValue() {
        quantitymeasurementapp.QuantityLength q1 =
                new quantitymeasurementapp.QuantityLength(1.0, quantitymeasurementapp.LengthUnit.YARDS);
        quantitymeasurementapp.QuantityLength q2 =
                new quantitymeasurementapp.QuantityLength(2.0, quantitymeasurementapp.LengthUnit.YARDS);

        assertFalse(q1.equals(q2));
    }

    @Test
    public void testEquality_NullComparison() {
        quantitymeasurementapp.QuantityLength q1 =
                new quantitymeasurementapp.QuantityLength(1.0, quantitymeasurementapp.LengthUnit.YARDS);

        assertFalse(q1.equals(null));
    }

    @Test
    public void testEquality_SameReference() {
        quantitymeasurementapp.QuantityLength q1 =
                new quantitymeasurementapp.QuantityLength(6.0, quantitymeasurementapp.LengthUnit.FEET);

        assertTrue(q1.equals(q1));
    }

    @Test
    public void testEquality_AllUnits_ComplexScenario() {
        quantitymeasurementapp.QuantityLength q1 =
                new quantitymeasurementapp.QuantityLength(2.0, quantitymeasurementapp.LengthUnit.YARDS);
        quantitymeasurementapp.QuantityLength q2 =
                new quantitymeasurementapp.QuantityLength(6.0, quantitymeasurementapp.LengthUnit.FEET);
        quantitymeasurementapp.QuantityLength q3 =
                new quantitymeasurementapp.QuantityLength(72.0, quantitymeasurementapp.LengthUnit.INCHES);

        assertTrue(q1.equals(q2));
        assertTrue(q2.equals(q3));
        assertTrue(q1.equals(q3));
    }

    @Test
    public void testEquality_NonNumericInput() {
        quantitymeasurementapp.QuantityLength q1 = parseQuantity("abc yards");
        quantitymeasurementapp.QuantityLength q2 = parseQuantity("1.0 yards");

        assertNull(q1);
        assertNotNull(q2);
    }

    @Test
    public void testEquality_InvalidUnitInput() {
        quantitymeasurementapp.QuantityLength q1 = parseQuantity("1.0 meter");

        assertNull(q1);
    }
}