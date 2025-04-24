#include <stdio.h>
#include <stdlib.h>
 
void solve(int count);

int N;
int abilities[20][20];
int min = 18810;
int all[20];
int max_start = -1;
 
int main(void){
    scanf("%d", &N);
    for(int i=0; i<N; i++){
        for(int j=0; j<N; j++){
            scanf("%d", &abilities[i][j]);
        }
        all[i]=0;
    }
 
    solve(0);
    printf("%d\n", min);
}
 
void solve(int count){
    if(count == N/2){
        int start[N/2];
        int link[N/2];
        int start_count=0, link_count=0;
        for(int i=0; i<N; i++){
            if(all[i]==1){
                start[start_count]=i;
                start_count++;
            }
            else{
                link[link_count]=i;
                link_count++;
            }
        }
 
        int start_sum = 0;
        int link_sum = 0;
        for(int i=0; i<N/2; i++){
            for(int j=0; j<N/2; j++){
                start_sum += abilities[start[i]][start[j]];
                link_sum += abilities[link[i]][link[j]];
            }
        }
        int diff = abs(start_sum - link_sum);
        if(diff < min)
            min = diff;
    }
    else{
        if(count==0){
            all[0]=1;
            max_start=0;
            solve(count+1);
        }
        else{  
            for(int i=1; i<N; i++){
                if(all[i]==0 && i>max_start){
                    all[i]=1;
                    int old_max = max_start;
                    max_start=i;
                    solve(count+1);
                    all[i]=0;
                    max_start = old_max;
                }
            }
        }
    }
}