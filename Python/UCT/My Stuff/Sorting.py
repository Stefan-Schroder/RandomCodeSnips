from time import sleep
Numbers = [4,3,6,8,3,7,9,4,2,4,7,8,4,6,7,8,9,5,2,4,5,6,3,1,3,4,0,8,3,4,6,3,0,3,2,8,8,9,4,6,3,6,3,1,3,2,4]
#Numbers = [9,8,7,6,5,4,3,2,1,0]
#Numbers = ["a","b","d","s","f","r","e","s","f","g","a","s","c","z"]
def printer(Numbers):
    for y in range(9,-1,-1):
        print(end=str(y)+"| ")
        for x in range(len(Numbers)):
            if(Numbers[x]>=y):
                print(end="|")
            else:
                print(end=" ")
        print()

def DankSort(Numbers):    
    for i in range(len(Numbers)):
        ph=Numbers[i]
        Movefrom = -1
        for j in range(i,-1,-1):
            if(Numbers[j]>ph):
                Movefrom = j
        if(Movefrom!=-1):
            for k in range(i-1,Movefrom-1,-1):
                Numbers[k+1]=Numbers[k]
                printer(Numbers)
                sleep(0.1)                
            Numbers[Movefrom]=ph
        printer(Numbers)


def bubblesort( Numbers ):
    for i in range( len( Numbers ) ):
        for k in range( len( Numbers ) - 1, i, -1 ):
            if ( Numbers[k] < Numbers[k - 1] ):
                swap( Numbers, k, k - 1 )
                printer(Numbers)
                sleep(0.1)
def swap( A, x, y ):
    tmp = A[x]
    A[x] = A[y]
    A[y] = tmp

def sort_numbers(s):
    for i in range(1, len(s)):
        # let's see what values i takes on
        print ("i = ", i)

        val = s[i]
        j = i - 1
        while (j >= 0) and (s[j] > val):
            s[j+1] = s[j]
            j = j - 1
            printer(s)
            sleep(0.1)
        s[j+1] = val

bubblesort(Numbers)