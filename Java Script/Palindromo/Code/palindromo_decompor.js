//forma mais dificil de fazer, baseado em decompor 
//usarei um vetor para armazenar valores, mas possívelmente 
//daria para fazer sem ele, economizando alguns ms
/**
 * @param {number} x
 * @return {boolean}
 */
var isPalindrome = function(x) {
    let temp = x;
    if(temp<0)
        return false;
    const vetor = new Array();
    while(temp > 9){
        let prov = temp%10;
        vetor.push(prov);
        temp = (temp - prov)/10; 
    }

    vetor.push(temp);
    //nesse ponto temos o numero colocado de forma inversa no vetor
    //ex, o numero 321 se tornou vetor = [1,2,3], agora devemos verificar 
    //se é um palindromo
    for(let i = 0; i < (vetor.length/2); i++){
        if(vetor[i] != vetor[vetor.length - i - 1]){
            return false;
        }
    }
    return 1;
    
}