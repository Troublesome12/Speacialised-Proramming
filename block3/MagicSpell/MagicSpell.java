public class MagicSpell {
    public String fixTheSpell(String spell) {
        StringBuilder az = new StringBuilder();

        // Collect A and Z
        for (char c : spell.toCharArray()) {
            if (c == 'A' || c == 'Z') {
                az.append(c);
            }
        }

        // Reverse A and Z
        az.reverse();

        StringBuilder result = new StringBuilder();
        int idx = 0;

        // Build final string
        for (char c : spell.toCharArray()) {
            if (c == 'A' || c == 'Z') {
                result.append(az.charAt(idx++));
            } else {
                result.append(c);
            }
        }

        return result.toString();
    }

    // sample tests
    public static void main(String[] args) {
        MagicSpell m = new MagicSpell();
        System.out.println(m.fixTheSpell("AZ"));                   // ZA
        System.out.println(m.fixTheSpell("ABACADA"));              // ABACADA
        System.out.println(m.fixTheSpell("AABZCADZA"));            // AZBACZDAA
        System.out.println(m.fixTheSpell("AZBASGHNAZAHBNVZZGGGAGGZAZ"));
        // ZABZSGHNAZZHBNVAZGGGAGGAZA
    }
}
