class Solution {
    public int countDaysTogether(String arriveAlice, String leaveAlice,
                                 String arriveBob, String leaveBob) {

        int[] days = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

        int a1 = getDay(arriveAlice, days);
        int a2 = getDay(leaveAlice, days);
        int b1 = getDay(arriveBob, days);
        int b2 = getDay(leaveBob, days);

        int start = Math.max(a1, b1);
        int end = Math.min(a2, b2);

        if (start <= end) {
            return end - start + 1;
        }

        return 0;
    }

    private int getDay(String s, int[] days) {
        int m = (s.charAt(0) - '0') * 10 + (s.charAt(1) - '0');
        int d = (s.charAt(3) - '0') * 10 + (s.charAt(4) - '0');

        int total = d;

        for (int i = 0; i < m - 1; i++) {
            total += days[i];
        }

        return total;
    }
}