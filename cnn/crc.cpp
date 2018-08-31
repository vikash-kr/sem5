#include<bits/stdc++.h>
using namespace std;

string randomData(int n){
    string data= "";
    for(int i=0; i<n;i++){
        string c;
        int randaom = rand()%100;
        if(randaom >49 )
            c=to_string(1);
        else
            c=to_string(0);
        //cout<<c<<endl;
       data += c;
    }
    return data;
}

int main(){
    string originalData=randomData(1000);
    cout << originalData << endl;
    string delimeter = to_string(01111110);

    return 0;
}
