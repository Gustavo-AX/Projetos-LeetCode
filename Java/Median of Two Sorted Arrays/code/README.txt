Ideia geral do algoritmo:
Não precisamos de unir os arrays para achar a mediana, podemos somente achar o ponto onde cortamos 
o array A para adicionar em um ponto em B de forma que a mediana seja encontrada.
Seja:
A = [1, 3, 8]
B = [7, 9, 10, 11]

Sabemos que temos 7 números, logo a mediana vai ser o quarto numero do array se unificassemos.
Com isso, precisamos achar o corte em A e B no qual os numeros até a mediana sejam menores
que o da parte direita. Por exemplo, comoçamos cortando A na mediana:

A_left = [1]		A_right = [3,8]
B_left = [7,9,10]	B_right = [11]

*A parte esquerda deve conter os 4 números. Agora avaliamos se faz sentido (o maior numero da parte 
esquerda de A deve ser menor que o menor numero da direita de B, o mesmo para o inverso).

1 < 11 -> OK
7 < 3  -> Não OK

Repetimos o processo deslocando o corte:
A_left = [1, 3]		A_right = [8]
B_left = [7,9]		B_right = [10, 11]
	
3 < 10 -> OK
9 < 8 -> Não OK

Repetimos o processo deslocando o corte:
A_left = [1, 3, 8]	A_right = []
B_left = [7]		B_right = [9, 10, 11]
	
8 < 9 -> OK
7 < [] -> OK

Se o conjunto A entrar todo, significa que o a parte direita será composta só por B, e como ele já está 
ordenado, não irá gerar problema. 
Com isso, a mediana é dada pelo maior elemento da parte esquerda, no caso, 8.
