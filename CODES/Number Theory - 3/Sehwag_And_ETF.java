//Sehwag And ETF
//
//Sehwag has been solving a lot of mathematical problems recently. He was learning ETF (Euler Totient Function) and found the topic quite interesting. So, he tried solving a question on ETF. He will be given two numbers L and R. He has to find the probability that the ETF of a number in the range [L, R] is divisible by a number K.
//Input:
//The first line contains the number of test cases i.e. T.
//The next T lines will contain three integers L, R and K.
//Output:
//Print the answer in a new line after rounding off the first 6 digits after the decimal place.
//Constraints:
//1 <= T <= 10
//1 <= L <= R <= 10^12
//0 <= R - L <= 10^5
//1 <= K <= 10^6
//Sample Input:
//3
//1 4 2
//2 5 2
//3 10 4
//Sample Output:
//0.500000
//0.750000
//0.375000


#include <stdio.h>
#include <math.h>
 
long long int a[1000001],c[100001][3];
float val1,ans;
 
long long int gcd(long long int a,long long int b)
{
    if(b==0)
    return a;
    return gcd(b,a%b);
}
 
void soe()
{
    long long int i,j;
    for(i=2;i<=1000000;i++)
    {
        if(a[i]==i)
        {
            for(j=2*i;j<=1000000;j+=i)
            a[j]=(a[j]*(i-1))/i;
            a[i]=i-1;
        }
    }
}
 
int main()
{
    long long int t,l,r,k,i,j,x,y,z,cnt,val;
	for(i=0;i<=1000000;i++)
	a[i]=i;
	soe();
    scanf("%lld",&t);
    for(i=1;i<=t;i++)
    {
    	scanf("%lld %lld %lld",&l,&r,&k);
    	for(j=0;j<r-l+1;j++)
    	{
    	    c[j][0]=1;
    	    c[j][1]=j+l;
    	    c[j][2]=0;
    	}
    	for(j=1000000;j>=2;j--)
    	{
    	    x=l%j;
    	    if(x==0)
    	    y=0;
    	    else
    	    y=(l/j)*j+j-l;
    	    while(y<r-l+1)
    	    {
    	        if(c[y][1]%j==0)
    	        {
    	            z=gcd(c[y][1]/j,j);
    	            if(z==1)
    	            {
    	                c[y][0]*=a[j];
    	                c[y][1]/=j;
    	            }
    	            else
    	            c[y][2]=1;
    	        }
    	        y+=j;
    	    }
    	}
    	for(j=0;j<r-l+1;j++)
    	{
    	    if(c[j][1]!=1 && c[j][2]!=1)
    	    c[j][0]=c[j][0]*(c[j][1]-1);
    	}
    	for(j=0;j<r-l+1;j++)
    	{
    	    if(c[j][1]!=1 && c[j][2]==1)
    	    {
    	        x=j+l;
    	        y=2;
    	        z=j+l;
    	        while(y<=sqrt(z))
    	        {
    	            if(z%y==0)
    	            {
    	                while(z%y==0)
    	                z/=y;
    	                x=(x*(y-1))/y;
    	            }
    	            y++;
    	        }
    	        if(z>1)
    	        x=(x*(z-1))/z;
    	        c[j][0]=x;
    	    }
    	}
    	val=0;
    	for(j=0;j<r-l+1;j++)
    	{
    	    if(j==0 && l==1)
    	    {
    	        if(k==1)
    	        val++;
    	    }
    	    else if(c[j][0]%k==0)
    	    val++;
    	}
    	
    	val1=val;
    	ans=val1/((r-l+1)*1.0);
    	printf("%f\n",ans);
    }
    return 0;
}