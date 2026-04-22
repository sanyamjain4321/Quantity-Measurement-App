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
            if (!Double.isFinite(value)) {
                throw new IllegalArgumentException("Value must be finite");
            }
            if (unit == null) {
                throw new IllegalArgumentException("Unit cannot be null");
            }

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
            if (!Double.isFinite(value)) {
                throw new IllegalArgumentException("Value must be finite");
            }
            if (sourceUnit == null || targetUnit == null) {
                throw new IllegalArgumentException("Units cannot be null");
            }

            double valueInFeet = sourceUnit.toFeet(value);
            return targetUnit.fromFeet(valueInFeet);
        }

        // UC6 method: result in first operand unit
        public QuantityLength add(QuantityLength other) {
            if (other == null) {
                throw new IllegalArgumentException("Other quantity cannot be null");
            }

            double sumInFeet = this.toFeet() + other.toFeet();
            double resultInThisUnit = this.unit.fromFeet(sumInFeet);
            return new QuantityLength(resultInThisUnit, this.unit);
        }

        public static QuantityLength add(QuantityLength first, QuantityLength second) {
            if (first == null || second == null) {
                throw new IllegalArgumentException("Quantities cannot be null");
            }

            return first.add(second);
        }

        // UC7 method: result in explicit target unit
        public QuantityLength add(QuantityLength other, LengthUnit targetUnit) {
            if (other == null) {
                throw new IllegalArgumentException("Other quantity cannot be null");
            }
            if (targetUnit == null) {
                throw new IllegalArgumentException("Target unit cannot be null");
            }

            double sumInFeet = this.toFeet() + other.toFeet();
            double resultInTargetUnit = targetUnit.fromFeet(sumInFeet);
            return new QuantityLength(resultInTargetUnit, targetUnit);
        }

        public static QuantityLength add(QuantityLength first, QuantityLength second, LengthUnit targetUnit) {
            if (first == null || second == null) {
                throw new IllegalArgumentException("Quantities cannot be null");
            }
            if (targetUnit == null) {
                throw new IllegalArgumentException("Target unit cannot be null");
            }

            return first.add(second, targetUnit);
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

    public static void demonstrateLengthAddition(QuantityLength q1, QuantityLength q2, LengthUnit targetUnit) {
        QuantityLength result = QuantityLength.add(q1, q2, targetUnit);
        System.out.println("Output: " + result);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            // Example input:
            // 1.0 feet
            // 12.0 inches
            // yards
            double value1 = scanner.nextDouble();
            String unit1 = scanner.next();
            double value2 = scanner.nextDouble();
            String unit2 = scanner.next();
            String targetUnitText = scanner.next();

            QuantityLength q1 = new QuantityLength(value1, LengthUnit.fromString(unit1));
            QuantityLength q2 = new QuantityLength(value2, LengthUnit.fromString(unit2));
            LengthUnit targetUnit = LengthUnit.fromString(targetUnitText);

            QuantityLength result = q1.add(q2, targetUnit);
            System.out.println("Output: " + result);
        } catch (Exception e) {
            System.out.println("Output: Invalid addition");
        } finally {
            scanner.close();
        }
    }
}