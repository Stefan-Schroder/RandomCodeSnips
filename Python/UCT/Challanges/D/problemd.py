Line = input()
while Line!="-1":
    A = eval(Line[:Line.find(" ")])
    Line = Line[Line.find(" ")+1:]
    B = eval(Line[:Line.find(" ")])
    Line = Line[Line.find(" ")+1:]
    C = eval(Line)
    
    for i in range(C,0,-1):
        ExtraA = A%i
        ExtraB = B%i
        if(ExtraA==ExtraB):
            print(i)
            break
    
    Line = input()