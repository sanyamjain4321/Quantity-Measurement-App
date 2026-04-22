import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class quantitymeasurementappTest {

    private static final double DELTA = 0.01;

    @Test
    public void testAddition_ExplicitTargetUnit_Feet() {
        quantitymeasurementapp.QuantityLength q1 =
                new quantitymeasurementapp.QuantityLength(1.0, quantitymeasurementapp.LengthUnit.FEET);
        quantitymeasurementapp.QuantityLength q2 =
                new quantitymeasurementapp.QuantityLength(12.0, quantitymeasurementapp.LengthUnit.INCHES);

        quantitymeasurementapp.QuantityLength result =
                quantitymeasurementapp.QuantityLength.add(q1, q2, quantitymeasurementapp.LengthUnit.FEET);

        assertEquals(2.0, result.getValue(), DELTA);
        assertEquals(quantitymeasurementapp.LengthUnit.FEET, result.getUnit());
    }

    @Test
    public void testAddition_ExplicitTargetUnit_Inches() {
        quantitymeasurementapp.QuantityLength q1 =
                new quantitymeasurementapp.QuantityLength(1.0, quantitymeasurementapp.LengthUnit.FEET);
        quantitymeasurementapp.QuantityLength q2 =
                new quantitymeasurementapp.QuantityLength(12.0, quantitymeasurementapp.LengthUnit.INCHES);

        quantitymeasurementapp.QuantityLength result =
                quantitymeasurementapp.QuantityLength.add(q1, q2, quantitymeasurementapp.LengthUnit.INCHES);

        assertEquals(24.0, result.getValue(), DELTA);
        assertEquals(quantitymeasurementapp.LengthUnit.INCHES, result.getUnit());
    }

    @Test
    public void testAddition_ExplicitTargetUnit_Yards() {
        quantitymeasurementapp.QuantityLength q1 =
                new quantitymeasurementapp.QuantityLength(1.0, quantitymeasurementapp.LengthUnit.FEET);
        quantitymeasurementapp.QuantityLength q2 =
                new quantitymeasurementapp.QuantityLength(12.0, quantitymeasurementapp.LengthUnit.INCHES);

        quantitymeasurementapp.QuantityLength result =
                quantitymeasurementapp.QuantityLength.add(q1, q2, quantitymeasurementapp.LengthUnit.YARDS);

        assertEquals(0.6667, result.getValue(), DELTA);
        assertEquals(quantitymeasurementapp.LengthUnit.YARDS, result.getUnit());
    }

    @Test
    public void testAddition_ExplicitTargetUnit_Centimeters() {
        quantitymeasurementapp.QuantityLength q1 =
                new quantitymeasurementapp.QuantityLength(1.0, quantitymeasurementapp.LengthUnit.INCHES);
        quantitymeasurementapp.QuantityLength q2 =
                new quantitymeasurementapp.QuantityLength(1.0, quantitymeasurementapp.LengthUnit.INCHES);

        quantitymeasurementapp.QuantityLength result =
                quantitymeasurementapp.QuantityLength.add(q1, q2, quantitymeasurementapp.LengthUnit.CENTIMETERS);

        assertEquals(5.08, result.getValue(), DELTA);
        assertEquals(quantitymeasurementapp.LengthUnit.CENTIMETERS, result.getUnit());
    }

    @Test
    public void testAddition_ExplicitTargetUnit_SameAsFirstOperand() {
        quantitymeasurementapp.QuantityLength q1 =
                new quantitymeasurementapp.QuantityLength(2.0, quantitymeasurementapp.LengthUnit.YARDS);
        quantitymeasurementapp.QuantityLength q2 =
                new quantitymeasurementapp.QuantityLength(3.0, quantitymeasurementapp.LengthUnit.FEET);

        quantitymeasurementapp.QuantityLength result =
                quantitymeasurementapp.QuantityLength.add(q1, q2, quantitymeasurementapp.LengthUnit.YARDS);

        assertEquals(3.0, result.getValue(), DELTA);
        assertEquals(quantitymeasurementapp.LengthUnit.YARDS, result.getUnit());
    }

    @Test
    public void testAddition_ExplicitTargetUnit_SameAsSecondOperand() {
        quantitymeasurementapp.QuantityLength q1 =
                new quantitymeasurementapp.QuantityLength(2.0, quantitymeasurementapp.LengthUnit.YARDS);
        quantitymeasurementapp.QuantityLength q2 =
                new quantitymeasurementapp.QuantityLength(3.0, quantitymeasurementapp.LengthUnit.FEET);

        quantitymeasurementapp.QuantityLength result =
                quantitymeasurementapp.QuantityLength.add(q1, q2, quantitymeasurementapp.LengthUnit.FEET);

        assertEquals(9.0, result.getValue(), DELTA);
        assertEquals(quantitymeasurementapp.LengthUnit.FEET, result.getUnit());
    }

    @Test
    public void testAddition_ExplicitTargetUnit_Commutativity() {
        quantitymeasurementapp.QuantityLength q1 =
                new quantitymeasurementapp.QuantityLength(1.0, quantitymeasurementapp.LengthUnit.FEET);
        quantitymeasurementapp.QuantityLength q2 =
                new quantitymeasurementapp.QuantityLength(12.0, quantitymeasurementapp.LengthUnit.INCHES);

        quantitymeasurementapp.QuantityLength result1 =
                quantitymeasurementapp.QuantityLength.add(q1, q2, quantitymeasurementapp.LengthUnit.YARDS);

        quantitymeasurementapp.QuantityLength result2 =
                quantitymeasurementapp.QuantityLength.add(q2, q1, quantitymeasurementapp.LengthUnit.YARDS);

        assertEquals(result1.getValue(), result2.getValue(), DELTA);
        assertEquals(result1.getUnit(), result2.getUnit());
    }

    @Test
    public void testAddition_ExplicitTargetUnit_WithZero() {
        quantitymeasurementapp.QuantityLength q1 =
                new quantitymeasurementapp.QuantityLength(5.0, quantitymeasurementapp.LengthUnit.FEET);
        quantitymeasurementapp.QuantityLength q2 =
                new quantitymeasurementapp.QuantityLength(0.0, quantitymeasurementapp.LengthUnit.INCHES);

        quantitymeasurementapp.QuantityLength result =
                quantitymeasurementapp.QuantityLength.add(q1, q2, quantitymeasurementapp.LengthUnit.YARDS);

        assertEquals(1.6667, result.getValue(), DELTA);
        assertEquals(quantitymeasurementapp.LengthUnit.YARDS, result.getUnit());
    }

    @Test
    public void testAddition_ExplicitTargetUnit_NegativeValues() {
        quantitymeasurementapp.QuantityLength q1 =
                new quantitymeasurementapp.QuantityLength(5.0, quantitymeasurementapp.LengthUnit.FEET);
        quantitymeasurementapp.QuantityLength q2 =
                new quantitymeasurementapp.QuantityLength(-2.0, quantitymeasurementapp.LengthUnit.FEET);

        quantitymeasurementapp.QuantityLength result =
                quantitymeasurementapp.QuantityLength.add(q1, q2, quantitymeasurementapp.LengthUnit.INCHES);

        assertEquals(36.0, result.getValue(), DELTA);
        assertEquals(quantitymeasurementapp.LengthUnit.INCHES, result.getUnit());
    }

    @Test
    public void testAddition_ExplicitTargetUnit_LargeValues() {
        quantitymeasurementapp.QuantityLength q1 =
                new quantitymeasurementapp.QuantityLength(1000.0, quantitymeasurementapp.LengthUnit.FEET);
        quantitymeasurementapp.QuantityLength q2 =
                new quantitymeasurementapp.QuantityLength(500.0, quantitymeasurementapp.LengthUnit.FEET);

        quantitymeasurementapp.QuantityLength result =
                quantitymeasurementapp.QuantityLength.add(q1, q2, quantitymeasurementapp.LengthUnit.INCHES);

        assertEquals(18000.0, result.getValue(), DELTA);
        assertEquals(quantitymeasurementapp.LengthUnit.INCHES, result.getUnit());
    }

    @Test
    public void testAddition_ExplicitTargetUnit_InstanceMethod() {
        quantitymeasurementapp.QuantityLength q1 =
                new quantitymeasurementapp.QuantityLength(36.0, quantitymeasurementapp.LengthUnit.INCHES);
        quantitymeasurementapp.QuantityLength q2 =
                new quantitymeasurementapp.QuantityLength(1.0, quantitymeasurementapp.LengthUnit.YARDS);

        quantitymeasurementapp.QuantityLength result =
                q1.add(q2, quantitymeasurementapp.LengthUnit.FEET);

        assertEquals(6.0, result.getValue(), DELTA);
        assertEquals(quantitymeasurementapp.LengthUnit.FEET, result.getUnit());
    }

    @Test
    public void testAddition_ExplicitTargetUnit_NullFirst() {
        quantitymeasurementapp.QuantityLength q2 =
                new quantitymeasurementapp.QuantityLength(1.0, quantitymeasurementapp.LengthUnit.FEET);

        assertThrows(IllegalArgumentException.class, () ->
                quantitymeasurementapp.QuantityLength.add(null, q2, quantitymeasurementapp.LengthUnit.FEET));
    }

    @Test
    public void testAddition_ExplicitTargetUnit_NullSecond() {
        quantitymeasurementapp.QuantityLength q1 =
                new quantitymeasurementapp.QuantityLength(1.0, quantitymeasurementapp.LengthUnit.FEET);

        assertThrows(IllegalArgumentException.class, () ->
                quantitymeasurementapp.QuantityLength.add(q1, null, quantitymeasurementapp.LengthUnit.FEET));
    }

    @Test
    public void testAddition_ExplicitTargetUnit_NullTargetUnit() {
        quantitymeasurementapp.QuantityLength q1 =
                new quantitymeasurementapp.QuantityLength(1.0, quantitymeasurementapp.LengthUnit.FEET);
        quantitymeasurementapp.QuantityLength q2 =
                new quantitymeasurementapp.QuantityLength(12.0, quantitymeasurementapp.LengthUnit.INCHES);

        assertThrows(IllegalArgumentException.class, () ->
                quantitymeasurementapp.QuantityLength.add(q1, q2, null));
    }
}