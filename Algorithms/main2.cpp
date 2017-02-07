//
// Created by Alexandru Brisan on 2/7/17.
//m
#include <iostream>

void display_vec(int*arr, int len){
    for(int i = 0 ; i < len ; ++i){
        std::cout << *(arr+i) << " ";
    }
}

int partition(int *arr, int lo, int hi, int len) {
    int pivot = *(arr+hi);
    int i = lo;
    for(int j = lo; j < hi-1 ; ++j){
        if(arr[j] <= pivot){
            int cop = arr[i];
            arr[i] = arr[j];
            arr[j] = cop;
            ++i;
        }
    }
    int cop = arr[i];
    arr[i] = pivot;
    arr[hi] = cop;
    display_vec(arr, len);
    return i;
}

void quicksort(int *arr, int lo, int hi, int len){
    if(lo < hi){
        int p = partition(arr, lo, hi, len);
        quicksort(arr, lo, p-1,len);
        quicksort(arr, p+1, hi,len);
    }
}


int main(){
    int N;
    std::cin >> N;
    int *arr = (int *) malloc(sizeof(int) * N);
    for(int i = 0 ; i < N ; ++i){
        int m;
        std::cin >> m;
        *(arr+i) = m;
    }
    quicksort(arr, 0, N, N);
    return 0;
}


