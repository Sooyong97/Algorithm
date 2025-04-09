#include <stdio.h>

#define quarter 25
#define dime 10
#define nickel 5

int take_coin(int *cents, int coin_value);

void calc(int cents) {
    int q, d, n;
    q = take_coin(&cents, quarter);
    d = take_coin(&cents, dime);
    n = take_coin(&cents, nickel);
    printf("%d %d %d %d\n", q, d, n, cents);
    return;
}

int take_coin(int *cents, int coin_value) {
    int counts = *cents / coin_value;
    *cents %= coin_value;
    return counts;
}

int main() {
    int tc = 0;
    scanf("%d", &tc);

    for (int i = 0; i < tc; i++) {
        int cents = 0;
        scanf("%d", &cents);
        calc(cents);
    }
    return 0;
}