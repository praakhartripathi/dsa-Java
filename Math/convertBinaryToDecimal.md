```
int current = 0;

int[] bits = {1,0,1,1};

for(int bit : bits){
    current = current * 2 + bit;
}

System.out.println(current); // 11
```
