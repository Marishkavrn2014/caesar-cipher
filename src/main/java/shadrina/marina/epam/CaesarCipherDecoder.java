package main.java.shadrina.marina.epam;

public class CaesarCipherDecoder {
    public static void main(String[] args) {
        char[] alphabetUpperCase = "АБВГДЕЁЖЗИЙКЛМНОПРСТУФХЦЧШЩЪЫЬЭЮЯ".toCharArray();
        char[] alphabetLowerCase = "абвгдеёжзийклмнопрстуфхцчшщъыьэюя".toCharArray();
        final String encryptedText = "Еъёчхф Вхзёюлх, адздёиу ф ждэщхб, " +
                "црбх еёдюэчъщъгюъв южаижжзчх, ждчъёнъгжзчдв. Ъы зёюивй жёхчгюв " +
                "бюнс ж ъы вдгивъгзхбсгрв аёхкдв. Зъеъёс вгъ дмъчющгд, мзд гъюэцъьгджзс " +
                "тздшд аёхкх фчбфъзжф жбъщжзчюъв гъждчъёнъгжзчх мъбдчъмъжадшд югщючющиивх. " +
                "Ф юэимюб чхни южздёюу ю чгыж юэвъгъгюф, здмгъъ дзёхэюч еджздфггиу юэвъгмючджзс " +
                "мъбдчъмъжаюк едёдадч. Ю зъв гъ въгъъ, еджбъщдчхбх гъищхмх. Ф еёюнъб а чрчдщи, " +
                "мзд чюгдя чжъви вдя югзъббъаз, х чдэвдьгд, вды мёъэвъёгдъ жзёъвбъгюъ ад чжъви " +
                "шхёвдгюмгдви. Гхязю ёънъгюъ вгъ едвдшбх еёдшёхввх югзиюзючгдшд зюех, жеълюхбсгд " +
                "ждэщхггхф щбф юэимъгюф деёъщъбъггрк жздёдг мъбдчъмъжадя щиню. Въгф вдьгд гхэчхзс " +
                "дзлдв Вхзёюлр, х ъы, цъэ еёъичъбюмъгюф, вхзъёсу.";
        printDecodedCaesarCipher(encryptedText, alphabetUpperCase, alphabetLowerCase);
    }

    public static int findCharIndexInArray(char[] charsArray, char desiredChar) {
        for (int i = 0; i < charsArray.length; i++) {
            if (charsArray[i] == desiredChar) {
                return i;
            }
        }
        return -1;
    }

    // printing an array of characters as regular strings
    public static void printArray(char[] charsArray) {
        System.out.println();
        for (char c : charsArray) {
            System.out.print(c);
        }
    }

    // printing all options for shifting letters of the alphabet. You can use your own alphabet.
    // Symbols ".", ",", " " are not encrypted.
    public static void printDecodedCaesarCipher(String encryptedText, char[] alphabetUpperCase,
                                                char[] alphabetLowerCase) {
        char[] oldText = encryptedText.toCharArray();
        for (int i = 1; i < alphabetUpperCase.length + 1; i++) {
            char[] newText = new char[encryptedText.length()];
            for (int j = 0; j < encryptedText.length(); j++) {
                if (oldText[j] == (' ') || oldText[j] == ('.') || oldText[j] == (',')) {
                    newText[j] = oldText[j];
                } else {
                    int newChar = 0;
                    int index = findCharIndexInArray(alphabetLowerCase, oldText[j]);
                    if (index != -1) {
                        newChar = (index + i) % alphabetLowerCase.length;
                        newText[j] = alphabetLowerCase[newChar];
                    } else {
                        index = findCharIndexInArray(alphabetUpperCase, oldText[j]);
                        newChar = (index + i) % alphabetUpperCase.length;
                        newText[j] = alphabetUpperCase[newChar];
                    }
                }
            }
            printArray(newText);
        }
    }
}
