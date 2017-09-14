TestCases = eval(input())
PopulationRating = [" ",".","x","W"]
for TestCase in range(TestCases):
    
    Nothing = input()    
    #Set First agar plate (all pop density of 0, agar[20] pop = 1)
    AgarNew = []
    for Set in range(1,41):
        if(Set==20):
            AgarNew.append(1)
        else:
            AgarNew.append(0)
        
    #Setting DNA array to input
    DNArray=[]
    Line = str(input())
    for i in range (0,9):
        PlaceHolder = eval(Line[:Line.find(" ")])
        DNArray.append(PlaceHolder)
        Line = Line[Line.find(" ")+1:]
    DNArray.append(eval(Line))
    
    #Start simulation
    for Days in range(0,50):
        #printing the Agar State
        for i in range(0,40):
            print(PopulationRating[AgarNew[i]],end=(""))
        print()
        AgarOld = AgarNew
        
        #Calculation new AgarDay
        AgarNew = []
        for j in range(40):
            #far Left
            if(j==0):
                AgarNew.append(DNArray[AgarOld[0]+AgarOld[1]])
            elif(j==39):#Far right
                AgarNew.append(DNArray[AgarOld[38]+AgarOld[39]])
            else:#between
                AgarNew.append(DNArray[AgarOld[j-1]+AgarOld[j]+AgarOld[j+1]])
    if(TestCase!=TestCases-1):
        print()