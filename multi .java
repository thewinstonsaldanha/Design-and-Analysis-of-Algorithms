/*Write a program to compute square of 20-digit large integer numbers using divide and conquer 
strategy.*/

import java.util.*;
import java.lang.Math;
public class multi{
	public static int cnt=0;
	static long power(long n,long m)
	{
		long ans=1;
		while(m>0)
		{
			ans=ans*n;
			m--;
		}
		return ans;
	}
	
	//long long int
	static long square(long n1,long sz)
	{
		cnt++;
		if(sz==1)
		{
			return n1*n1;
		}
		long tmp1=(sz+1)/2;
		long pw=power(10,tmp1);
		long part1=n1-n1%pw;
		long part2=n1%pw;
		return square(part1,sz-tmp1)+2*part1*part2+square(part2,tmp1);
		
	}
	static long mul(long n1,long n2,long s1, long s2, long p1,long p2)
	{
		cnt++;
		System.out.println("After "+cnt+" iteration");
		System.out.println("number 1 : "+n1+"     number 2 : "+n2+"     power of number 1 : "+p1+"     Power of number 2 : "+p2+"");
		System.out.println("f( "+n1+" , "+n2+" , "+s1+" , "+s2+" , "+p1+" , "+p2+" )\n\n\n\n");
		if(s1==1 && s2==1)
		{
			//System.out.println("n1 : "+n1+" n2 : "+n2+" power of n1 : "+p1+" Power of p2 : "+p2);
			return n1*n2*p1*p2;
		}
		
		if(s1>1)
		{
			long tmp1=(s1+1)/2;
			long pw=power(10,tmp1);
			//cnt++;
			return mul(n1/pw,n2,s1-tmp1,s2,p1*pw,p2)+mul(n1%pw,n2,tmp1,s2,p1,p2);
		}
		else
		{
			long tmp1=(s2+1)/2;
			long pw=power(10,tmp1);
			//cnt++;
			return mul(n1,n2/pw,s1,s2-tmp1,p1,p2*pw)+mul(n1,n2%pw,s1,tmp1,p1,p2);
		}
	}
	public static void main(String[] args)
	{
		long n1,n2;
		Scanner sc=new Scanner(System.in);
		n1=sc.nextInt();
		//n2=sc.nextInt();
		//System.out.println("n1= "+n1+" n2= "+n2);
		long l1=0;
		long l2=0;
		long tmp=n1;
		while(tmp!=0)
		{
			tmp=tmp/10;
			l1++;
		}
		/*tmp=n2;
		while(tmp!=0)
		{
			tmp=tmp/10;
			l2++;
		}*/
		
		long ans=square(n1,l1);
		//long ans=mul(n1,n2,l1,l2,1,1);
		System.out.println("Multiplication is : "+ans+"    \n number of iteration : "+cnt);
	}
}
