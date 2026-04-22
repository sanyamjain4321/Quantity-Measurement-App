import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class quantitymeasurementappTest {

    private static final double DELTA = 0.01;

    @Test
    public void testWeightEquality_KilogramToKilogram() {
        quantitymeasurementapp.QuantityWeight q1 =
                new quantitymeasurementapp.QuantityWeight(1.0, WeightUnit.KILOGRAM);
        quantitymeasurementapp.QuantityWeight q2 =
                new quantitymeasurementapp.QuantityWeight(1.0, WeightUnit.KILOGRAM);

        assertTrue(q1.equals(q2));
    }

    @Test
    public void testWeightEquality_GramToGram() {
        quantitymeasurementapp.QuantityWeight q1 =
                new quantitymeasurementapp.QuantityWeight(1000.0, WeightUnit.GRAM);
        quantitymeasurementapp.QuantityWeight q2 =
                new quantitymeasurementapp.QuantityWeight(1000.0, WeightUnit.GRAM);

        assertTrue(q1.equals(q2));
    }

    @Test
    public void testWeightEquality_PoundToPound() {
        quantitymeasurementapp.QuantityWeight q1 =
                new quantitymeasurementapp.QuantityWeight(2.0, WeightUnit.POUND);
        quantitymeasurementapp.QuantityWeight q2 =
                new quantitymeasurementapp.QuantityWeight(2.0, WeightUnit.POUND);

        assertTrue(q1.equals(q2));
    }

    @Test
    public void testWeightEquality_KgToGram() {
        quantitymeasurementapp.QuantityWeight q1 =
                new quantitymeasurementapp.QuantityWeight(1.0, WeightUnit.KILOGRAM);
        quantitymeasurementapp.QuantityWeight q2 =
                new quantitymeasurementapp.QuantityWeight(1000.0, WeightUnit.GRAM);

        assertTrue(q1.equals(q2));
    }

    @Test
    public void testWeightEquality_KgToPound() {
        quantitymeasurementapp.QuantityWeight q1 =
                new quantitymeasurementapp.QuantityWeight(1.0, WeightUnit.KILOGRAM);
        quantitymeasurementapp.QuantityWeight q2 =
                new quantitymeasurementapp.QuantityWeight(2.20462, WeightUnit.POUND);

        assertTrue(q1.equals(q2));
    }

    @Test
    public void testWeightEquality_GramToPound() {
        quantitymeasurementapp.QuantityWeight q1 =
                new quantitymeasurementapp.QuantityWeight(453.59237, WeightUnit.GRAM);
        quantitymeasurementapp.QuantityWeight q2 =
                new quantitymeasurementapp.QuantityWeight(1.0, WeightUnit.POUND);

        assertTrue(q1.equals(q2));
    }

    @Test
    public void testWeightConversion_KgToGram() {
        double result = quantitymeasurementapp.QuantityWeight.convert(
                1.0, WeightUnit.KILOGRAM, WeightUnit.GRAM
        );

        assertEquals(1000.0, result, DELTA);
    }

    @Test
    public void testWeightConversion_GramToKg() {
        double result = quantitymeasurementapp.QuantityWeight.convert(
                1000.0, WeightUnit.GRAM, WeightUnit.KILOGRAM
        );

        assertEquals(1.0, result, DELTA);
    }

    @Test
    public void testWeightConversion_KgToPound() {
        double result = quantitymeasurementapp.QuantityWeight.convert(
                1.0, WeightUnit.KILOGRAM, WeightUnit.POUND
        );

        assertEquals(2.20462, result, 0.01);
    }

    @Test
    public void testWeightConversion_PoundToKg() {
        double result = quantitymeasurementapp.QuantityWeight.convert(
                1.0, WeightUnit.POUND, WeightUnit.KILOGRAM
        );

        assertEquals(0.45359237, result, 0.01);
    }

    @Test
    public void testWeightAddition_SameUnit() {
        quantitymeasurementapp.QuantityWeight q1 =
                new quantitymeasurementapp.QuantityWeight(1.0, WeightUnit.KILOGRAM);
        quantitymeasurementapp.QuantityWeight q2 =
                new quantitymeasurementapp.QuantityWeight(2.0, WeightUnit.KILOGRAM);

        quantitymeasurementapp.QuantityWeight result = q1.add(q2);

        assertEquals(3.0, result.getValue(), DELTA);
        assertEquals(WeightUnit.KILOGRAM, result.getUnit());
    }

    @Test
    public void testWeightAddition_DifferentUnits_DefaultFirstUnit() {
        quantitymeasurementapp.QuantityWeight q1 =
                new quantitymeasurementapp.QuantityWeight(1.0, WeightUnit.KILOGRAM);
        quantitymeasurementapp.QuantityWeight q2 =
                new quantitymeasurementapp.QuantityWeight(500.0, WeightUnit.GRAM);

        quantitymeasurementapp.QuantityWeight result = q1.add(q2);

        assertEquals(1.5, result.getValue(), DELTA);
        assertEquals(WeightUnit.KILOGRAM, result.getUnit());
    }

    @Test
    public void testWeightAddition_WithExplicitTargetUnit_Gram() {
        quantitymeasurementapp.QuantityWeight q1 =
                new quantitymeasurementapp.QuantityWeight(1.0, WeightUnit.KILOGRAM);
        quantitymeasurementapp.QuantityWeight q2 =
                new quantitymeasurementapp.QuantityWeight(500.0, WeightUnit.GRAM);

        quantitymeasurementapp.QuantityWeight result = q1.add(q2, WeightUnit.GRAM);

        assertEquals(1500.0, result.getValue(), DELTA);
        assertEquals(WeightUnit.GRAM, result.getUnit());
    }

    @Test
    public void testWeightAddition_WithExplicitTargetUnit_Pound() {
        quantitymeasurementapp.QuantityWeight q1 =
                new quantitymeasurementapp.QuantityWeight(1.0, WeightUnit.KILOGRAM);
        quantitymeasurementapp.QuantityWeight q2 =
                new quantitymeasurementapp.QuantityWeight(1.0, WeightUnit.KILOGRAM);

        quantitymeasurementapp.QuantityWeight result = q1.add(q2, WeightUnit.POUND);

        assertEquals(4.409, result.getValue(), 0.02);
        assertEquals(WeightUnit.POUND, result.getUnit());
    }

    @Test
    public void testWeightVsLengthIncompatibility() {
        quantitymeasurementapp.QuantityWeight weight =
                new quantitymeasurementapp.QuantityWeight(1.0, WeightUnit.KILOGRAM);
        quantitymeasurementapp.QuantityLength length =
                new quantitymeasurementapp.QuantityLength(1.0, LengthUnit.FEET);

        assertFalse(weight.equals(length));
    }

    @Test
    public void testWeightNullComparison() {
        quantitymeasurementapp.QuantityWeight q1 =
                new quantitymeasurementapp.QuantityWeight(1.0, WeightUnit.KILOGRAM);

        assertFalse(q1.equals(null));
    }

    @Test
    public void testWeightZeroValue() {
        quantitymeasurementapp.QuantityWeight q1 =
                new quantitymeasurementapp.QuantityWeight(0.0, WeightUnit.KILOGRAM);
        quantitymeasurementapp.QuantityWeight q2 =
                new quantitymeasurementapp.QuantityWeight(0.0, WeightUnit.GRAM);

        assertTrue(q1.equals(q2));
    }

    @Test
    public void testWeightNegativeValue() {
        quantitymeasurementapp.QuantityWeight q1 =
                new quantitymeasurementapp.QuantityWeight(-1.0, WeightUnit.KILOGRAM);
        quantitymeasurementapp.QuantityWeight q2 =
                new quantitymeasurementapp.QuantityWeight(-1000.0, WeightUnit.GRAM);

        assertTrue(q1.equals(q2));
    }

    @Test
    public void testWeightLargeValueConversion() {
        double result = quantitymeasurementapp.QuantityWeight.convert(
                1000.0, WeightUnit.KILOGRAM, WeightUnit.GRAM
        );

        assertEquals(1000000.0, result, DELTA);
    }

    @Test
    public void testWeightAddNullOther() {
        quantitymeasurementapp.QuantityWeight q1 =
                new quantitymeasurementapp.QuantityWeight(1.0, WeightUnit.KILOGRAM);

        assertThrows(IllegalArgumentException.class, () -> q1.add(null));
    }

    @Test
    public void testWeightAddNullTargetUnit() {
        quantitymeasurementapp.QuantityWeight q1 =
                new quantitymeasurementapp.QuantityWeight(1.0, WeightUnit.KILOGRAM);
        quantitymeasurementapp.QuantityWeight q2 =
                new quantitymeasurementapp.QuantityWeight(1.0, WeightUnit.GRAM);

        assertThrows(IllegalArgumentException.class, () -> q1.add(q2, null));
    }

    @Test
    public void testWeightInvalidUnitParsing() {
        assertThrows(IllegalArgumentException.class, () -> WeightUnit.fromString("stone"));
    }
}