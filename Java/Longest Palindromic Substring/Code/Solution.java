class Solution {
    //A forma mais simples de ser feita, mas acaba que é demorada demais.
    //Farei uma abordagem mais rápida na pasta de javascript
    public String longestPalindrome(String s) {
        int size = s.length();
        String longestPalindrome = "" + s.charAt(0);
        for (int i = 0; i < size; i++) {
            for(int j = i; j < size; j++){
                String substring = s.substring(i, j + 1);
                if(isPalindrome(substring) && substring.length() > longestPalindrome.length()){
                    longestPalindrome = substring;
                }
            }
        }
        return longestPalindrome;
    }

    public boolean isPalindrome(String s){
        String inverse = "";
        for(int count = 0; count<s.length();count++){
            inverse = inverse + s.charAt(s.length() - count - 1);
        }
        return s.equals(inverse);
    }
}
