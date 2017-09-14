Amount = eval(input())
Answer = ""
for i in range(Amount):
    Line = input()
    L = eval(Line[:Line.find(" ")])
    Line = Line[Line.find(" ")+1:]
    W = eval(Line[:Line.find(" ")])
    Line = Line[Line.find(" ")+1:]
    B = eval(Line)
    if (L<=50 and B <=50 and W<=50):
        Answer+="Case "+str(i+1)+": good."
    else:
        Answer+="Case "+str(i+1)+": bad."
        
for i in range (Amount):
    Line = Answer[:Answer.find(".")]
    print(Line)
    Answer = Answer[Answer.find(".")+1:]