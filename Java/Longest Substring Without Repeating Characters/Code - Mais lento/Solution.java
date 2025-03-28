class Solution {
    public int lengthOfLongestSubstring(String s) {
        
        int output = 0;

        for(int i=0; i<s.length();i++){

            String substring = new String(); 
            int count=0;

            for(int j=i; j<s.length();j++){

                String temp = String.valueOf(s.charAt(j));
                
                if(substring.contains(temp)){   
                    break;
                }

                count++;
                if(count>output){
                    output = count;
                } 
                
                substring = substring + temp;
            }
        }
        return output;
    }
}