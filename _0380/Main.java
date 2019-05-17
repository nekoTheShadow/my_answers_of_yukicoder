package _0380;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = stdin.readLine()) != null) {
            String ans = isOK(line) ? "CORRECT (maybe)" : "WRONG!";
            System.out.println(ans);
        }
    }
    
    public static Set<Character> letters = new HashSet<>();
    
    public static boolean isOK(String line) {
        if (letters.isEmpty()) {
            for (char ch = 'a'; ch <= 'z'; ch++) letters.add(ch);
            for (char ch = 'A'; ch <= 'Z'; ch++) letters.add(ch);
            for (char ch = '0'; ch <= '9'; ch++) letters.add(ch);
        }
        
        // 1行を最大2つに分割。分割できない場合は異常。
        String[] tokens = line.split(" ", 2);
        if (tokens.length != 2) {
            return false;
        }
        
        String who = tokens[0];
        String speech = tokens[1].toLowerCase();
        
        // digiの全てのセリフはnyoか，nyoの末尾に記号を1～3文字つけたもので終わる
        // petitの全てのセリフはnyuか，nyuの末尾に記号を1～3文字つけたもので終わる
        // gemaの全てのセリフはgemaか，gemaの末尾に記号を1～3文字つけたもので終わる
        // piyoの全てのセリフはpyoか，pyoの末尾に記号を1～3文字つけたもので終わる
        if (who.equals("digi"))  return endsWith(speech, "nyo");
        if (who.equals("petit")) return endsWith(speech, "nyu");
        if (who.equals("gema"))  return endsWith(speech, "gema");
        if (who.equals("piyo"))  return endsWith(speech, "pyo");
        
        // rabiの全てのセリフは記号でない文字を少なくても1文字含む
        if (who.equals("rabi")) {
            for (char ch : speech.toCharArray()) {
                if (letters.contains(ch)) return true;
            }
            return false;
        }
        
        // だれともマッチしなかった。
        return false;
    }
    
    public static boolean endsWith(String word, String suffix) {
        // 最大3個まで末尾の記号を除去する。
        for (int i = 0; i < 3; i++) {
            if (word.isEmpty()) {
                break;
            }
            
            char c = word.charAt(word.length() - 1);
            if (letters.contains(c)) {
                break;
            }
            
            word = word.substring(0, word.length() - 1);
        }
        
        return word.endsWith(suffix);
    }
}
