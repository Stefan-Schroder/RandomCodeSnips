#Prime
#Stefan Schroder
#2016-03-12

N = eval(input("Enter the start point N:\n"))
M = eval(input("Enter the end point M:\n"))

print("The palindromic primes are:")


for Number in range(N+1,M):
    for Prime in range(2,Number):
        if(Number%Prime==0):
            break
    else:
        StringPrime = str(Number)
        StringBackPrime = StringPrime[::-1]
        if(StringPrime==StringBackPrime):
            print(Number)