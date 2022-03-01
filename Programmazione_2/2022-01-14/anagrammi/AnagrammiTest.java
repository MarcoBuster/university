import java.util.Scanner;
import java.util.List;
import java.util.Map;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;

public class AnagrammiTest {
    public static void main(String []args) {
        Map<Word, Boolean> words = new HashMap<>();
        Scanner input = new Scanner(System.in);
        while (input.hasNext()) {
            words.put(new Word(input.next()), false);
        }
        input.close();

        List<AnagramSet> anagrams = new LinkedList<>();
        for (Map.Entry<Word, Boolean> word : words.entrySet()) {
            if (word.getValue() == true) {
                // Skip already seen words
                continue;
            }

            words.put(word.getKey(), true);  // mark word as visited
            AnagramSet anagramSet = new AnagramSet(List.of(word.getKey()));
            for (Map.Entry<Word, Boolean> otherWord : words.entrySet()) {
                if (otherWord.getValue() == true) {
                    // Skip already seen words
                    continue;
                }
                if (!word.getKey().isAnagramOf(otherWord.getKey())) {
                    continue;
                }
                anagramSet.add(otherWord.getKey());
                words.put(otherWord.getKey(), true);  // mark word as visited
            }
            if (anagramSet.size() > 1) {
                Collections.sort(anagramSet);
                anagrams.add(anagramSet);
            }
        }
        Collections.sort(anagrams); 
        for (AnagramSet anagramSet : anagrams) {
            System.out.println(anagramSet.toString());
        }
    }
}
