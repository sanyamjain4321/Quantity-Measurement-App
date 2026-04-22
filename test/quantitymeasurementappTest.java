import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class quantitymeasurementappTest {

    private static final double DELTA = 0.0001;

    @Test
    public void testConvert_FeetToInches() {
        double result = quantitymeasurementapp.QuantityLength.convert(
                1.0,
                quantitymeasurementapp.LengthUnit.FEET,
                quantitymeasurementapp.LengthUnit.INCHES
        );

        assertEquals(12.0, result, DELTA);
    }

    @Test
    public void testConvert_YardsToFeet() {
        double result = quantitymeasurementapp.QuantityLength.convert(
                3.0,
                quantitymeasurementapp.LengthUnit.YARDS,
                quantitymeasurementapp.LengthUnit.FEET
        );

        assertEquals(9.0, result, DELTA);
    }

    @Test
    public void testConvert_InchesToYards() {
        double result = quantitymeasurementapp.QuantityLength.convert(
                36.0,
                quantitymeasurementapp.LengthUnit.INCHES,
                quantitymeasurementapp.LengthUnit.YARDS
        );

        assertEquals(1.0, result, DELTA);
    }

    @Test
    public void testConvert_CentimetersToInches() {
        double result = quantitymeasurementapp.QuantityLength.convert(
                1.0,
                quantitymeasurementapp.LengthUnit.CENTIMETERS,
                quantitymeasurementapp.LengthUnit.INCHES
        );

        assertEquals(0.393701, result, DELTA);
    }

    @Test
    public void testConvert_ZeroValue() {
        double result = quantitymeasurementapp.QuantityLength.convert(
                0.0,
                quantitymeasurementapp.LengthUnit.FEET,
                quantitymeasurementapp.LengthUnit.INCHES
        );

        assertEquals(0.0, result, DELTA);
    }

    @Test
    public void testConvert_NegativeValue() {
        double result = quantitymeasurementapp.QuantityLength.convert(
                -1.0,
                quantitymeasurementapp.LengthUnit.FEET,
                quantitymeasurementapp.LengthUnit.INCHES
        );

        assertEquals(-12.0, result, DELTA);
    }

    @Test
    public void testConvert_LargeValue() {
        double result = quantitymeasurementapp.QuantityLength.convert(
                1000000.0,
                quantitymeasurementapp.LengthUnit.FEET,
                quantitymeasurementapp.LengthUnit.INCHES
        );

        assertEquals(12000000.0, result, DELTA);
    }

    @Test
    public void testConvert_SmallValue() {
        double result = quantitymeasurementapp.QuantityLength.convert(
                0.001,
                quantitymeasurementapp.LengthUnit.FEET,
                quantitymeasurementapp.LengthUnit.INCHES
        );

        assertEquals(0.012, result, DELTA);
    }

    @Test
    public void testConvert_SameUnit() {
        double result = quantitymeasurementapp.QuantityLength.convert(
                5.0,
                quantitymeasurementapp.LengthUnit.FEET,
                quantitymeasurementapp.LengthUnit.FEET
        );

        assertEquals(5.0, result, DELTA);
    }

    @Test
    public void testConvertTo_InstanceMethod() {
        quantitymeasurementapp.QuantityLength q =
                new quantitymeasurementapp.QuantityLength(1.0, quantitymeasurementapp.LengthUnit.FEET);

        quantitymeasurementapp.QuantityLength converted =
                q.convertTo(quantitymeasurementapp.LengthUnit.INCHES);

        assertEquals(12.0, converted.getValue(), DELTA);
        assertEquals(quantitymeasurementapp.LengthUnit.INCHES, converted.getUnit());
    }

    @Test
    public void testConvert_FeetToCentimeters() {
        double result = quantitymeasurementapp.QuantityLength.convert(
                1.0,
                quantitymeasurementapp.LengthUnit.FEET,
                quantitymeasurementapp.LengthUnit.CENTIMETERS
        );

        assertEquals(30.48, result, 0.01);
    }

    @Test
    public void testConvert_InvalidNullSourceUnit() {
        assertThrows(IllegalArgumentException.class, () ->
                quantitymeasurementapp.QuantityLength.convert(
                        1.0,
                        null,
                        quantitymeasurementapp.LengthUnit.FEET
                )
        );
    }

    @Test
    public void testConvert_InvalidNullTargetUnit() {
        assertThrows(IllegalArgumentException.class, () ->
                quantitymeasurementapp.QuantityLength.convert(
                        1.0,
                        quantitymeasurementapp.LengthUnit.FEET,
                        null
                )
        );
    }
}