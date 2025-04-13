/**
 * @param {number} x
 * @return {boolean}
 */
//forma mais fácil de fazer o palindromo
var isPalindrome = function(x) {
    const normal= x.toString();
    const size = normal.length;
    let inverse = "";
    for(let count = 0; count < size; count++){
        inverse = inverse + normal.charAt(size - count - 1);
    }
    if(inverse == normal){
        return true;
    } else {
        return false;
    }
}