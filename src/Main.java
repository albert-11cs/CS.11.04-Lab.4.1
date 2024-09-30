public class Main {
    public static void main(String[] args) {
        System.out.println(parenthesesCheck(")(()))"));
        System.out.println(reverseInteger(1234));
        System.out.println(encryptThis("Hello good day"));
        System.out.println(decipherThis("72olle 103doo 100ya"));
    }

    // 1. parenthesesCheck
    public static boolean parenthesesCheck(String parentheses) {
        int open = 0;
        int closed = 0;
        for (int a = 0; a < parentheses.length(); a++) {
            if (parentheses.charAt(a) == '(' ) {
                open++;
            } else {
                closed++;
            }
        }
        return (open == closed) && (parentheses.charAt(0) == '(') && (parentheses.charAt(parentheses.length() - 1) == ')');
    }

    // 2. reverseInteger
    public static String reverseInteger(int b) {
        String one = Integer.toString(b);
        String two = "";
        for (int c = one.length() - 1; c >= 0; c--) {
            two += one.charAt(c);
        }
        return two;
    }

    // 3. encryptThis
    public static String encryptThis(String encrypt) {
        String[] words = encrypt.split(" ");
        String encrypted1 = "";
        String encrypted2 = "";
        for (String word : words) {
            for (int d = 0; d < word.length(); d++) {
                if (d == 0) {
                    encrypted1 += (int) word.charAt(0);
                } else if (d == 1) {
                    encrypted1 += word.charAt(word.length() - 1);
                } else if (d == word.length() - 1) {
                    encrypted1 += word.charAt(1);
                } else {
                    encrypted1 += word.charAt(d);
                }
            }
            encrypted1 += " ";
            encrypted2 += encrypted1;
            encrypted1 = "";
        }
        return encrypted2;
    }

    // 4. decipherThis
    public static String decipherThis(String thisLabIsHard) {
        String[] words = thisLabIsHard.split(" ");
        String decipheredWord = "";
        String decipheredStr = "";
        String firstLetterNo = "";
        int firstLetterNoIndex = 0;
        char firstLetter;
        for (String word : words) {
            for (int i = 0; Character.isDigit(word.charAt(i)); i++) {
                firstLetterNoIndex = i;
            }
            firstLetterNo = word.substring(0, firstLetterNoIndex+1);
            firstLetter = (char) Integer.parseInt(firstLetterNo);
            decipheredWord += firstLetter;
            firstLetterNo = "";
            for (int i = firstLetterNoIndex+1; i < word.length(); i++) {
                if(i == firstLetterNoIndex+1) {
                    decipheredWord += word.charAt(word.length()-1);
                }
                else if(i == word.length()-1) {
                    decipheredWord += word.charAt(firstLetterNoIndex+1);
                }
                else {
                    decipheredWord += word.charAt(i);
                }
            }
            decipheredWord += " ";
            decipheredStr += decipheredWord;
            decipheredWord = "";
        }
        return decipheredStr;
    }
}