import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class quantitymeasurementappTest {

    private static final double DELTA = 0.01;

    @Test
    public void testStandaloneUnit_ConvertToBaseUnit_Feet() {
        assertEquals(1.0, LengthUnit.FEET.convertToBaseUnit(1.0), DELTA);
    }

    @Test
    public void testStandaloneUnit_ConvertToBaseUnit_Inches() {
        assertEquals(1.0, LengthUnit.INCHES.convertToBaseUnit(12.0), DELTA);
    }

    @Test
    public void testStandaloneUnit_ConvertFromBaseUnit_Yards() {
        assertEquals(1.0, LengthUnit.YARDS.convertFromBaseUnit(3.0), DELTA);
    }

    @Test
    public void testStandaloneUnit_ConvertFromBaseUnit_Centimeters() {
        assertEquals(30.48, LengthUnit.CENTIMETERS.convertFromBaseUnit(1.0), DELTA);
    }

    @Test
    public void testEquality_BackwardCompatibility() {
        quantitymeasurementapp.QuantityLength q1 =
                new quantitymeasurementapp.QuantityLength(1.0, LengthUnit.FEET);
        quantitymeasurementapp.QuantityLength q2 =
                new quantitymeasurementapp.QuantityLength(12.0, LengthUnit.INCHES);

        assertTrue(q1.equals(q2));
    }

    @Test
    public void testConversion_BackwardCompatibility() {
        double result = quantitymeasurementapp.QuantityLength.convert(
                1.0, LengthUnit.FEET, LengthUnit.INCHES
        );

        assertEquals(12.0, result, DELTA);
    }

    @Test
    public void testAddition_BackwardCompatibility_UC6() {
        quantitymeasurementapp.QuantityLength q1 =
                new quantitymeasurementapp.QuantityLength(1.0, LengthUnit.FEET);
        quantitymeasurementapp.QuantityLength q2 =
                new quantitymeasurementapp.QuantityLength(12.0, LengthUnit.INCHES);

        quantitymeasurementapp.QuantityLength result = q1.add(q2);

        assertEquals(2.0, result.getValue(), DELTA);
        assertEquals(LengthUnit.FEET, result.getUnit());
    }

    @Test
    public void testAddition_BackwardCompatibility_UC7() {
        quantitymeasurementapp.QuantityLength q1 =
                new quantitymeasurementapp.QuantityLength(1.0, LengthUnit.FEET);
        quantitymeasurementapp.QuantityLength q2 =
                new quantitymeasurementapp.QuantityLength(12.0, LengthUnit.INCHES);

        quantitymeasurementapp.QuantityLength result =
                q1.add(q2, LengthUnit.INCHES);

        assertEquals(24.0, result.getValue(), DELTA);
        assertEquals(LengthUnit.INCHES, result.getUnit());
    }

    @Test
    public void testFromString_Feet() {
        assertEquals(LengthUnit.FEET, LengthUnit.fromString("feet"));
        assertEquals(LengthUnit.FEET, LengthUnit.fromString("ft"));
    }

    @Test
    public void testFromString_Inches() {
        assertEquals(LengthUnit.INCHES, LengthUnit.fromString("inches"));
        assertEquals(LengthUnit.INCHES, LengthUnit.fromString("inch"));
    }

    @Test
    public void testFromString_InvalidUnit() {
        assertThrows(IllegalArgumentException.class, () -> LengthUnit.fromString("meter"));
    }

    @Test
    public void testQuantityLength_ConvertTo() {
        quantitymeasurementapp.QuantityLength q =
                new quantitymeasurementapp.QuantityLength(1.0, LengthUnit.YARDS);

        quantitymeasurementapp.QuantityLength result = q.convertTo(LengthUnit.FEET);

        assertEquals(3.0, result.getValue(), DELTA);
        assertEquals(LengthUnit.FEET, result.getUnit());
    }

    @Test
    public void testQuantityLength_Add_WithExplicitTargetUnit() {
        quantitymeasurementapp.QuantityLength q1 =
                new quantitymeasurementapp.QuantityLength(36.0, LengthUnit.INCHES);
        quantitymeasurementapp.QuantityLength q2 =
                new quantitymeasurementapp.QuantityLength(1.0, LengthUnit.YARDS);

        quantitymeasurementapp.QuantityLength result =
                quantitymeasurementapp.QuantityLength.add(q1, q2, LengthUnit.FEET);

        assertEquals(6.0, result.getValue(), DELTA);
        assertEquals(LengthUnit.FEET, result.getUnit());
    }

    @Test
    public void testQuantityLength_NullUnit_Throws() {
        assertThrows(IllegalArgumentException.class,
                () -> new quantitymeasurementapp.QuantityLength(1.0, null));
    }

    @Test
    public void testQuantityLength_NaNValue_Throws() {
        assertThrows(IllegalArgumentException.class,
                () -> new quantitymeasurementapp.QuantityLength(Double.NaN, LengthUnit.FEET));
    }

    @Test
    public void testConversion_NullSource_Throws() {
        assertThrows(IllegalArgumentException.class,
                () -> quantitymeasurementapp.QuantityLength.convert(1.0, null, LengthUnit.FEET));
    }

    @Test
    public void testConversion_NullTarget_Throws() {
        assertThrows(IllegalArgumentException.class,
                () -> quantitymeasurementapp.QuantityLength.convert(1.0, LengthUnit.FEET, null));
    }

    @Test
    public void testAddition_NullTargetUnit_Throws() {
        quantitymeasurementapp.QuantityLength q1 =
                new quantitymeasurementapp.QuantityLength(1.0, LengthUnit.FEET);
        quantitymeasurementapp.QuantityLength q2 =
                new quantitymeasurementapp.QuantityLength(12.0, LengthUnit.INCHES);

        assertThrows(IllegalArgumentException.class,
                () -> quantitymeasurementapp.QuantityLength.add(q1, q2, null));
    }
}