import math
Function = input("Enter a function: ")

for y in range(10,-11,-1):
    for x in range(-10,11,1):
        NewFunction = (Function.replace("x","("+str(x)+")"))
        Answer = round(eval(NewFunction))
        if(y==Answer):
            print("o",end="")
        elif(y==0 and x==0):
            print("+",end="")
        elif(y==0):
            print("-",end="")
        elif(x==0):
            print("|",end="")
        else:
            print(end=" ")
    print()
        
                    