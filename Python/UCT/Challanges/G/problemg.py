#Stefan Schroder
#Problem G
#2016-04-12

TestCases = eval(input())
for Cases in range(TestCases):
    NDays = eval(input())
    PPartys = eval(input())
    
    Partys = []
    for i in range(PPartys):
        Partys.append(eval(input()))
        
    DaysMissed = 0
    for Days in range(1,NDays+1):
        for Partiz in range(PPartys):
            if(Days%7==0 or Days%7==6):
                break
            else:
                if(Days%Partys[Partiz]==0):
                    DaysMissed+=1
                    break
    
    print(DaysMissed)