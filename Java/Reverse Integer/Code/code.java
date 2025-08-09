class Solution {
    public int pot (int base, int expr){
    int x = base;
        for(int i = 0; i<expr-1; i++){
            x *= base;
        }
    if(expr == 0){
        return 1;
    }
    return x;
    }

    public int reverse(int x) {
        long n = x;
        int expr = 0;
        long inverse = 0;
        boolean neg = false;

        // Se o número for negativo, guardamos essa informação e tratamos como positivo
        if(x < 0){
            neg = true;
            n = n * -1;
        }

        // Achamos a ordem do numero (ex: 123 é expresso por 1,23 * 10^2, onde 2 é o expr)
        long aux = n;
        while(aux > 9){
            aux = aux/10;
            expr++;
        }

        for(int i = 0; i < expr; i++){
            inverse += (n/pot(10, expr - i)) * pot (10, i);
            n = n % pot(10, expr - i);
        }

        inverse += n * pot(10, expr);


        if ( inverse > Integer.MAX_VALUE || inverse < Integer.MIN_VALUE ) {
            return (int) 0;
        }

        if(neg){
            return (int) inverse * -1;
        } else {
            return (int) inverse;
        }
    }
}
