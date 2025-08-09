class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        int[] A = nums1;
        int[] B = nums2;
        // A deve ser o menor vetor, se não for, fazemos ser:
        if(n < m){
            A = nums2;
            B = nums1;
            n = nums1.length;
            m = nums2.length;
        }

        int left = 0;
        int right = m;
        int medianG = ((n + m + 1) / 2);

        while(left <= right){
            int i = (left + right) / 2;
            int j = medianG - i; //aqui é pois precisamos de X números na esquerda

            int maxValEsqA, minValDirB, maxValEsqB, minValDirA;

            // A
            if(i == 0){
                // não tem nada na esquerda de A
                maxValEsqA = Integer.MIN_VALUE;
            } else {
                maxValEsqA = A[i - 1];
            }

            if(i == m){
                // A todo está na esquerda
                minValDirA  = Integer.MAX_VALUE;
            } else {
                minValDirA = A[i];
            }

            // B

            if(j == 0){
                // não tem nada na esquerda de B
                maxValEsqB = Integer.MIN_VALUE;
            } else {
                maxValEsqB = B[j - 1];
            }

            if(j == n){
                // B todo está na esquerda
                minValDirB = Integer.MAX_VALUE;
            } else {
                minValDirB = B[j];
            }

            if(maxValEsqA <= minValDirB && maxValEsqB <= minValDirA){
                if ((m + n) % 2 == 1) {
                    return Math.max(maxValEsqA, maxValEsqB); // Ímpar
                } else {
                    return (Math.max(maxValEsqA, maxValEsqB) + Math.min(minValDirA, minValDirB)) / 2.0; // Par
                }
            }

            // Precisamos mover para esquerda
            else if (maxValEsqA > minValDirB) {
                right = i - 1;
            }
            // Precisamos mover para direita
            else {
                left = i + 1;
            }

        }
        return 0;
    }
}
