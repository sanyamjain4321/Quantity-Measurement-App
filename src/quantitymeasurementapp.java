import java.util.Scanner;

class quantityMeasurementApp {

    public static class Feet {
        private final double value;

        public Feet(double value) {
            this.value = value;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) return true;
            if (obj == null) return false;
            if (getClass() != obj.getClass()) return false;
            Feet other = (Feet) obj;
            return Double.compare(this.value, other.value) == 0;
        }

        @Override
        public int hashCode() {
            return Double.hashCode(value);
        }
    }

    public static class Inches {
        private final double value;

        public Inches(double value) {
            this.value = value;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) return true;
            if (obj == null) return false;
            if (getClass() != obj.getClass()) return false;
            Inches other = (Inches) obj;
            return Double.compare(this.value, other.value) == 0;
        }

        @Override
        public int hashCode() {
            return Double.hashCode(value);
        }
    }

    public static void demonstrateFeetEquality(Scanner scanner) {
        try {
            String input = scanner.nextLine();
            String[] parts = input.split(" ");

            double v1 = Double.parseDouble(parts[0]);
            double v2 = Double.parseDouble(parts[3]);

            Feet f1 = new Feet(v1);
            Feet f2 = new Feet(v2);

            if (f1.equals(f2)) {
                System.out.println("Output: Equal (true)");
            } else {
                System.out.println("Output: Not Equal (false)");
            }
        } catch (Exception e) {
            System.out.println("Output: Not Equal (false)");
        }
    }

    public static void demonstrateInchesEquality(Scanner scanner) {
        try {
            String input = scanner.nextLine();
            String[] parts = input.split(" ");

            double v1 = Double.parseDouble(parts[0]);
            double v2 = Double.parseDouble(parts[3]);

            Inches i1 = new Inches(v1);
            Inches i2 = new Inches(v2);

            if (i1.equals(i2)) {
                System.out.println("Output: Equal (true)");
            } else {
                System.out.println("Output: Not Equal (false)");
            }
        } catch (Exception e) {
            System.out.println("Output: Not Equal (false)");
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        demonstrateFeetEquality(scanner);
        demonstrateInchesEquality(scanner);
        scanner.close();
    }
}