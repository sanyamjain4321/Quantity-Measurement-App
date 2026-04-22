import java.util.Scanner;

public class quantitymeasurementapp {

    public enum LengthUnit {
        FEET(1.0),
        INCHES(1.0 / 12.0),
        YARDS(3.0),
        CENTIMETERS(0.393701 / 12.0);

        private final double toFeetFactor;

        LengthUnit(double toFeetFactor) {
            this.toFeetFactor = toFeetFactor;
        }

        public double toFeet(double value) {
            return value * toFeetFactor;
        }

        public double fromFeet(double feetValue) {
            return feetValue / toFeetFactor;
        }

        public static LengthUnit fromString(String unit) {
            if (unit == null) {
                throw new IllegalArgumentException("Unit cannot be null");
            }

            String normalized = unit.trim().toLowerCase();

            switch (normalized) {
                case "ft":
                case "foot":
                case "feet":
                    return FEET;
                case "in":
                case "inch":
                case "inches":
                    return INCHES;
                case "yd":
                case "yard":
                case "yards":
                    return YARDS;
                case "cm":
                case "centimeter":
                case "centimeters":
                    return CENTIMETERS;
                default:
                    throw new IllegalArgumentException("Unsupported unit: " + unit);
            }
        }
    }

    public static class QuantityLength {
        private final double value;
        private final LengthUnit unit;

        public QuantityLength(double value, LengthUnit unit) {
            this.value = value;
            this.unit = unit;
        }

        public double getValue() {
            return value;
        }

        public LengthUnit getUnit() {
            return unit;
        }

        private double toFeet() {
            return unit.toFeet(value);
        }

        public QuantityLength convertTo(LengthUnit targetUnit) {
            if (targetUnit == null) {
                throw new IllegalArgumentException("Target unit cannot be null");
            }

            double valueInFeet = this.toFeet();
            double convertedValue = targetUnit.fromFeet(valueInFeet);
            return new QuantityLength(convertedValue, targetUnit);
        }

        public static double convert(double value, LengthUnit sourceUnit, LengthUnit targetUnit) {
            if (sourceUnit == null || targetUnit == null) {
                throw new IllegalArgumentException("Units cannot be null");
            }

            double valueInFeet = sourceUnit.toFeet(value);
            return targetUnit.fromFeet(valueInFeet);
        }

        public QuantityLength add(QuantityLength other) {
            if (other == null) {
                throw new IllegalArgumentException("Other quantity cannot be null");
            }

            double thisInFeet = this.toFeet();
            double otherInFeet = other.toFeet();
            double sumInFeet = thisInFeet + otherInFeet;

            double resultInThisUnit = this.unit.fromFeet(sumInFeet);
            return new QuantityLength(resultInThisUnit, this.unit);
        }

        public static QuantityLength add(QuantityLength first, QuantityLength second) {
            if (first == null || second == null) {
                throw new IllegalArgumentException("Quantities cannot be null");
            }

            return first.add(second);
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) return true;
            if (obj == null) return false;
            if (getClass() != obj.getClass()) return false;

            QuantityLength other = (QuantityLength) obj;
            return Math.abs(this.toFeet() - other.toFeet()) < 0.0001;
        }

        @Override
        public int hashCode() {
            return Double.hashCode(Math.round(toFeet() * 10000.0) / 10000.0);
        }

        @Override
        public String toString() {
            return "Quantity(" + value + ", " + unit + ")";
        }
    }

    public static void demonstrateLengthAddition(QuantityLength q1, QuantityLength q2) {
        QuantityLength result = QuantityLength.add(q1, q2);
        System.out.println("Output: " + result);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            // Example input:
            // 1.0 feet
            // 12.0 inches
            double value1 = scanner.nextDouble();
            String unit1 = scanner.next();
            double value2 = scanner.nextDouble();
            String unit2 = scanner.next();

            QuantityLength q1 = new QuantityLength(value1, LengthUnit.fromString(unit1));
            QuantityLength q2 = new QuantityLength(value2, LengthUnit.fromString(unit2));

            QuantityLength result = q1.add(q2);
            System.out.println("Output: " + result);
        } catch (Exception e) {
            System.out.println("Output: Invalid addition");
        } finally {
            scanner.close();
        }
    }
}