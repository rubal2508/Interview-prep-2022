# Maths

## Sieve of Eratosthenes

- How to check if a number $n$ is prime? It is prime if there are no factors of it from 2 to $\sqrt{n}$
- Sieve of Eratosthenes gives list of all prime numbers from $2$ to $n$
- Time Complexity: $O(N*log(log(N)))$
- Auxiliary Space: $O(N)$


``` java
// Java program to print all primes smaller than or equal to
// n using Sieve of Eratosthenes

class SieveOfEratosthenes {

	void sieveOfEratosthenes(int n) {
		// Create a boolean array "prime[0..n]" and initialize
		// all entries it as true. A value in prime[i] will
		// finally be false if i is Not a prime, else true.
		
        boolean prime[] = new boolean[n+1];
		for(int i=0;i<=n;i++) prime[i] = true;
		
        prime[0] = false;
        prime[1] = false;

		for(int p = 2; p*p <=n; p++) {
			// If prime[p] is not changed, then it is a prime
			if(prime[p] == true) {
				// Update all multiples of p
				for(int i = p*p; i <= n; i += p)
					prime[i] = false;
			}
		}
		
		// Print all prime numbers
		for(int i = 2; i <= n; i++) {
			if(prime[i] == true)
				System.out.print(i + " ");
		}
	}

}
```

``` java
class SieveOfEratosthenes {

	void sieveOfEratosthenes(int n) {
		boolean prime[] = new boolean[n+1];
		for(int i=0;i<=n;i++) prime[i] = true;
		
        prime[0] = false;
        prime[1] = false;

		for(int p = 2; p<=n; p++) {
            // change p*p <=n to p<=n to print all primes inside only. second loop will never run
			if(prime[p] == true) {   
                System.out.print(p + " ");
				for(int i = p*p; i <= n; i += p)
					prime[i] = false;
			}
		}
	}
}
```

## Greatest Common Divisor

- $gcd(a,b) = gcd(b,a\%b)$ 
- Base case: $gcd(a,0) = a$

``` java
int gcd(int a, int b){
    if(b==0) return a;
    return gcd(b,a%b);
}
```

## Fast Power

``` java
int power(int x, unsigned int y) {
	int res = 1; // Initialize result

	while (y > 0) {
		// If y is odd, multiply x with result
		if (y & 1 == 1)
			res = res * x;

		// n must be even now
		y = y >> 1; // y = y/2
		x = x * x; // Change x to x^2
	}
	return res;
}
```

## Modulo Arithmetics

- $(a + b) \% m = ((a \% m) + (b \% m) + m) \% m$
- $(a * b) \% m = ((a \% m) * (b \% m)) \% m$
- $(a - b) \% m = ((a \% m) - (b \% m) + m) \% m$
- $(a/b)\% m =  ((a\%m) * (b^{m-2}\%m))\%m$
- How to handle negative numbers? add m to be safe
- `(a^b) % m` see code below 

``` java
int pow(a, b, mod){
	if (b == 0) return 1;
	int val = pow(a, b / 2, mod);
	int sq = (val * val) % mod;
	if (b % 2){
		return (sq*a)%mod;
	} else {
		return sq
	}
}
```


## Number of Zeros in factorial

- Trailing 0s in n! = Count of 5s in prime factors of n! = floor(n/5) + floor(n/25) + floor(n/125) + ….
  
``` java
static int findTrailingZerosInFactorial(int n){
    // Negative Number Edge Case
    if (n < 0) return -1;
    int count = 0;

    // Keep dividing n by powers of 5 and update count
    for (int i = 5; n/i >= 1; i *= 5)
        count += n/i;

    return count;
}
```

## Big Integer

## Catalan Numbers

## Pigeon hole principle

## Inclusion Exclusion
