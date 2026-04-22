import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class quantitymeasurementappTest {

    private static final double DELTA = 0.0001;

    @Test
    public void testAddition_SameUnit_FeetPlusFeet() {
        quantitymeasurementapp.QuantityLength q1 =
                new quantitymeasurementapp.QuantityLength(1.0, quantitymeasurementapp.LengthUnit.FEET);
        quantitymeasurementapp.QuantityLength q2 =
                new quantitymeasurementapp.QuantityLength(2.0, quantitymeasurementapp.LengthUnit.FEET);

        quantitymeasurementapp.QuantityLength result = q1.add(q2);

        assertEquals(3.0, result.getValue(), DELTA);
        assertEquals(quantitymeasurementapp.LengthUnit.FEET, result.getUnit());
    }

    @Test
    public void testAddition_SameUnit_InchesPlusInches() {
        quantitymeasurementapp.QuantityLength q1 =
                new quantitymeasurementapp.QuantityLength(6.0, quantitymeasurementapp.LengthUnit.INCHES);
        quantitymeasurementapp.QuantityLength q2 =
                new quantitymeasurementapp.QuantityLength(6.0, quantitymeasurementapp.LengthUnit.INCHES);

        quantitymeasurementapp.QuantityLength result = q1.add(q2);

        assertEquals(12.0, result.getValue(), DELTA);
        assertEquals(quantitymeasurementapp.LengthUnit.INCHES, result.getUnit());
    }

    @Test
    public void testAddition_CrossUnit_FeetPlusInches() {
        quantitymeasurementapp.QuantityLength q1 =
                new quantitymeasurementapp.QuantityLength(1.0, quantitymeasurementapp.LengthUnit.FEET);
        quantitymeasurementapp.QuantityLength q2 =
                new quantitymeasurementapp.QuantityLength(12.0, quantitymeasurementapp.LengthUnit.INCHES);

        quantitymeasurementapp.QuantityLength result = q1.add(q2);

        assertEquals(2.0, result.getValue(), DELTA);
        assertEquals(quantitymeasurementapp.LengthUnit.FEET, result.getUnit());
    }

    @Test
    public void testAddition_CrossUnit_InchPlusFeet() {
        quantitymeasurementapp.QuantityLength q1 =
                new quantitymeasurementapp.QuantityLength(12.0, quantitymeasurementapp.LengthUnit.INCHES);
        quantitymeasurementapp.QuantityLength q2 =
                new quantitymeasurementapp.QuantityLength(1.0, quantitymeasurementapp.LengthUnit.FEET);

        quantitymeasurementapp.QuantityLength result = q1.add(q2);

        assertEquals(24.0, result.getValue(), DELTA);
        assertEquals(quantitymeasurementapp.LengthUnit.INCHES, result.getUnit());
    }

    @Test
    public void testAddition_CrossUnit_YardPlusFeet() {
        quantitymeasurementapp.QuantityLength q1 =
                new quantitymeasurementapp.QuantityLength(1.0, quantitymeasurementapp.LengthUnit.YARDS);
        quantitymeasurementapp.QuantityLength q2 =
                new quantitymeasurementapp.QuantityLength(3.0, quantitymeasurementapp.LengthUnit.FEET);

        quantitymeasurementapp.QuantityLength result = q1.add(q2);

        assertEquals(2.0, result.getValue(), DELTA);
        assertEquals(quantitymeasurementapp.LengthUnit.YARDS, result.getUnit());
    }

    @Test
    public void testAddition_CrossUnit_InchesPlusYard() {
        quantitymeasurementapp.QuantityLength q1 =
                new quantitymeasurementapp.QuantityLength(36.0, quantitymeasurementapp.LengthUnit.INCHES);
        quantitymeasurementapp.QuantityLength q2 =
                new quantitymeasurementapp.QuantityLength(1.0, quantitymeasurementapp.LengthUnit.YARDS);

        quantitymeasurementapp.QuantityLength result = q1.add(q2);

        assertEquals(72.0, result.getValue(), DELTA);
        assertEquals(quantitymeasurementapp.LengthUnit.INCHES, result.getUnit());
    }

    @Test
    public void testAddition_CentimeterPlusInch() {
        quantitymeasurementapp.QuantityLength q1 =
                new quantitymeasurementapp.QuantityLength(2.54, quantitymeasurementapp.LengthUnit.CENTIMETERS);
        quantitymeasurementapp.QuantityLength q2 =
                new quantitymeasurementapp.QuantityLength(1.0, quantitymeasurementapp.LengthUnit.INCHES);

        quantitymeasurementapp.QuantityLength result = q1.add(q2);

        assertEquals(5.08, result.getValue(), 0.01);
        assertEquals(quantitymeasurementapp.LengthUnit.CENTIMETERS, result.getUnit());
    }

    @Test
    public void testAddition_ZeroValue() {
        quantitymeasurementapp.QuantityLength q1 =
                new quantitymeasurementapp.QuantityLength(5.0, quantitymeasurementapp.LengthUnit.FEET);
        quantitymeasurementapp.QuantityLength q2 =
                new quantitymeasurementapp.QuantityLength(0.0, quantitymeasurementapp.LengthUnit.INCHES);

        quantitymeasurementapp.QuantityLength result = q1.add(q2);

        assertEquals(5.0, result.getValue(), DELTA);
        assertEquals(quantitymeasurementapp.LengthUnit.FEET, result.getUnit());
    }

    @Test
    public void testAddition_NegativeValue() {
        quantitymeasurementapp.QuantityLength q1 =
                new quantitymeasurementapp.QuantityLength(5.0, quantitymeasurementapp.LengthUnit.FEET);
        quantitymeasurementapp.QuantityLength q2 =
                new quantitymeasurementapp.QuantityLength(-2.0, quantitymeasurementapp.LengthUnit.FEET);

        quantitymeasurementapp.QuantityLength result = q1.add(q2);

        assertEquals(3.0, result.getValue(), DELTA);
        assertEquals(quantitymeasurementapp.LengthUnit.FEET, result.getUnit());
    }

    @Test
    public void testAddition_StaticMethod() {
        quantitymeasurementapp.QuantityLength q1 =
                new quantitymeasurementapp.QuantityLength(1.0, quantitymeasurementapp.LengthUnit.FEET);
        quantitymeasurementapp.QuantityLength q2 =
                new quantitymeasurementapp.QuantityLength(12.0, quantitymeasurementapp.LengthUnit.INCHES);

        quantitymeasurementapp.QuantityLength result =
                quantitymeasurementapp.QuantityLength.add(q1, q2);

        assertEquals(2.0, result.getValue(), DELTA);
        assertEquals(quantitymeasurementapp.LengthUnit.FEET, result.getUnit());
    }

    @Test
    public void testAddition_NullOther() {
        quantitymeasurementapp.QuantityLength q1 =
                new quantitymeasurementapp.QuantityLength(1.0, quantitymeasurementapp.LengthUnit.FEET);

        assertThrows(IllegalArgumentException.class, () -> q1.add(null));
    }

    @Test
    public void testAddition_NullFirstInStaticMethod() {
        quantitymeasurementapp.QuantityLength q2 =
                new quantitymeasurementapp.QuantityLength(1.0, quantitymeasurementapp.LengthUnit.FEET);

        assertThrows(IllegalArgumentException.class,
                () -> quantitymeasurementapp.QuantityLength.add(null, q2));
    }

    @Test
    public void testAddition_NullSecondInStaticMethod() {
        quantitymeasurementapp.QuantityLength q1 =
                new quantitymeasurementapp.QuantityLength(1.0, quantitymeasurementapp.LengthUnit.FEET);

        assertThrows(IllegalArgumentException.class,
                () -> quantitymeasurementapp.QuantityLength.add(q1, null));
    }
}