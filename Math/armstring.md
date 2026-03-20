```
    static boolean armstrong(int n) {
        int orig = n;
        int dig = 0;
        int count = 0;
        int sum = 0;

        while (n > 0) {
            n = n / 10;
            count++;
        }

        n = orig;

        while (n > 0) {
            dig = n % 10;
            int mul = 1;
            for(int i = 1; i <= count; i++) {
                mul = mul * dig;
            }
            sum += mul;
            n = n /10;
        }

        if (orig == sum) {
            return true;
        } else {
            return false;
        }
    }
```
