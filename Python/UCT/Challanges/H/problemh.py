#Stefan Schroder
#Problem h
#2016-04-12
case = 1
import sys
for line in sys.stdin:
    if(line!="\n"):
        String = str(line)
        Test = eval(input())
        print("Case "+str(case)+":")
        for i in range(Test):
            Number = input()
            a = eval(Number[:Number.find(" ")])
            b = eval(Number[Number.find(" ")+1:])
            if(a>b):
                ph = a
                a = b
                b = ph
            if(String[a:b+1].find("0")!=-1 and String[a:b+1].find("1")!=-1):
                print("No")
            else:
                print("Yes")
        case+=1
    else:
        break