//Divisors Of Factorial
//
//Given a number, find the total number of divisors of the factorial of the number.
//Since the answer can be very large, print answer modulo 10^9+7.
//Input
//The first line contains T, number of testcases.
//
//
//T lines follows each containing the number N.
//Output
//Print T lines of output each containing the answer.
//Constraints
//1 <= T <= 500
//
//0 <= N <= 50000
//Sample Input:
//3
//2
//3
//4
//Sample Output:
//2
//4
//8


#include <iostream>
#include <cmath>
#include <vector>
#include <algorithm>

using namespace std;

int main() {
	//Added these lines for fast input
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	
	//Sieve of Eratosthenes - start
	bool arr[50001];
	fill_n(arr,50001,true);
	int limit = sqrt(50000) + 1;
	vector<int> primes;
	int i = 2;
	while(i <= limit){
		//Cross off the multiples of the number
		for(int im=i*i; im<=50000; im+=i){
			arr[im] = false;
		}
		//Find the next number
		for(int j=i+1; j<=50000; j++){
			if(arr[j] == true){
				i = j;
				break;
			}
		}
	}
	for(int index=2; index<=50000; index++){
		if(arr[index] == true){
			primes.push_back(index);
		}
	}
	//Sieve of Eratosthenes - end
	
	//Main Program starts from here
	int t,num;
	int answer;
	cin>>t;
	for(int testcase=0; testcase<t; testcase++){
		cin>>num;
		int prime_index = 0;
		int prime_power;
		long long int total = 1;
		while(primes[prime_index] <= num){
			long long int sum = 0;
			prime_power = 1;
			while(int(num / pow(primes[prime_index],prime_power)) > 0){
				//Highest power of prime number in factorial
				sum += int(num / pow(primes[prime_index],prime_power));
				prime_power += 1;
			}
			//Go for the next prime number
			prime_index += 1;
			//Add it to total number of factors
			total = total * (sum + 1);
			total = total % 1000000007;
		}
		cout<<total%1000000007<<endl;
	}
	return 0;
}