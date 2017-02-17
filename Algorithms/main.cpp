#include <iostream>
#include <vector>
#include <algorithm>

struct element{
    int origpos;
    int index;
    std::string value;
};

int read(std::vector<element*> *vec){
    int N;
    std::string init;
    std::getline(std::cin, init, '\n');
    N = std::stoi(init, 0, 10);
    std::string delim(" ");
    for(int i = 0 ; i < N ; ++i) {
        std::string line;
        std::getline(std::cin, line, '\n');
        std::string first = line.substr(0, line.find(delim));
        // std::cout << i << " " << first << std::endl;
        std::string second = line.substr(line.find(delim)+1, line.length()-1);
        // std::cout << i << " " << second << std::endl << std::endl;
        element *e = new element();
        (*e).index = std::stoi(first, 0, 10);
        (*e).origpos = i;
        (*e).value = second;
        vec->push_back(e);
    }
    return N;
}

bool compare(element *e1, element *e2){
    if(e1 && e2) {
        if ((*e1).index == (*e2).index) {
            return (*e1).origpos < (*e2).origpos;
        } else {
            return (*e1).index < (*e2).index;
        }
    }else{
        throw "Null Pointer Exception";
    }
}

int main() {
    std::vector<element*> *vec = new std::vector<element*>();
    int N = read(vec);
    std::sort((*vec).begin(), (*vec).end(), compare);
    for(std::vector<element*>::iterator it = (*vec).begin(); it != (*vec).end(); ++it){
        if((*it)->origpos < N/2){
            std::cout << "- ";
        }else{
            std::cout << (*it)->value << " ";
        }
    }
    delete(vec);
    return 0;
}
