Line = eval(input())
for j in range(0,Line):
    Line = input()
    One = 0
    Two = 0
    Three = 0
    
    #Check One
    Word = "one"
    for i in range(3):
        if(Line[i]!=Word[i]):
            One +=1
            
    #Check Two
    Word = "two"
    for i in range(3):
        if(Line[i]!=Word[i]):
            Two += 1
            
    #Check Three
    if(len(Line)==5):
        Word = "three"
        for i in range(5):
            if(Line[i]!=Word[i]):
                Three += 1
    else:
        Three = 3
    
    if(One<=1):
        print("1")
    if(Two<=1):
        print("2")
    if(Three<=1):
        print("3")
    