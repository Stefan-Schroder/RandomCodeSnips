#Stefan Schroder
#Palendromic Prime Recursion
#2015-05-03

import sys
sys.setrecursionlimit (300000)

def counter(N,M):
    if(N!=M+1):
        #print(x)
        if(Pala(0,str(N)) and prime(2,N)):
            print(N)
        counter(N+1,M)

def prime(x,Number):
    if(x==Number):
        return True
    elif(Number%x==0):
        return False
    else:
        return prime(x+1,Number)
    
    
    
def Pala(Pos,String):
    length = len(String)
    if(length/2<Pos):
        return True
    if(String[Pos]==String[-Pos-1]):
        return Pala(Pos+1,String)
    return False

N = eval(input("Enter the starting point N:\n"))
M = eval(input("Enter the ending point M:\n"))
print("The palindromic primes are:")
counter(N,M)