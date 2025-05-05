var longestPalindrome = function(s) {
    if (s.length === 0) return "";

    let max_size = 1;
    let longest_Substring = s[0];

    for (let i = 0; i < s.length; i++) {
        // Verificação para palíndromos ímpares
        let counter_odd = 1;
        let temp_substring_odd = s[i];
        let left = i - 1;
        let right = i + 1;

        //Parto a partir de i a expandir para o lado e para o outro 
        while (left >= 0 && right < s.length && s[left] === s[right]) {
            counter_odd += 2;
            temp_substring_odd = s[left] + temp_substring_odd + s[right];

            if (counter_odd > max_size) {
                max_size = counter_odd;
                longest_Substring = temp_substring_odd;
            }
            left--;
            right++;
        }

        // Verificação para palíndromos pares:
        if (i + 1 < s.length && s[i] === s[i + 1]) {
            let counter_even = 2;
            let temp_substring_even = s[i] + s[i + 1];
            left = i - 1;
            right = i + 2;

            //A partir dos dois centrais, expande para os lados
            while (left >= 0 && right < s.length && s[left] === s[right]) {
                counter_even += 2;
                temp_substring_even = s[left] + temp_substring_even + s[right];
                left--;
                right++;
            }

            //Faço a comparação entre o atual
            if (counter_even > max_size) {
                max_size = counter_even;
                longest_Substring = temp_substring_even;
            }
        }
    }

    return longest_Substring;
};