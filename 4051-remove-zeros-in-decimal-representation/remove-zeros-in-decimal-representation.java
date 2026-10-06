class Solution {
    public long removeZeros(long n) {

        long result = 0;
        long mul = 1;

        while (n > 0) {

            long a = n % 10;

            if (a != 0) {
                result = result + (a * mul);
                mul *= 10;
            }

            n /= 10;
        }

        return result;
    }
}