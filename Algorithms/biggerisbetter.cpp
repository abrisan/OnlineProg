#include <cmath>
#include <cstdio>
#include <vector>
#include <iostream>
#include <algorithm>
using namespace std;


int main() {
    /* Enter your code here. Read input from STDIN. Print output to STDOUT */   
    int s;
    cin >> s;
    for(int i = 0 ; i < s ; ++i){
        string m;
        cin >> m;
        int t = next_permutation(m.begin(),m.end());
        if(t==0){
            cout << "no answer\n" ;
        }else{
            cout << m << endl;
    
        }
        }
    return 0;
}

