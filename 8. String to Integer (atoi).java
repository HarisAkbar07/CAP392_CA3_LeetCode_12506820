class Solution {
    public int myAtoi(String s) {
        int i = 0, n = s.length(), sign = 1, res = 0;

        while (i < n && s.charAt(i) == ' ') i++; // skip leading spaces

        if (i < n && (s.charAt(i) == '+' || s.charAt(i) == '-')) {
            sign = s.charAt(i) == '-' ? -1 : 1; // optional sign
            i++;
        }

        while (i < n && s.charAt(i) >= '0' && s.charAt(i) <= '9') { // stop at first non-digit
            int d = s.charAt(i) - '0';
            if (res > (Integer.MAX_VALUE - d) / 10) { // res * 10 + d would overflow
                return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
            res = res * 10 + d;
            i++;
        }
        return res * sign;
    }
}
