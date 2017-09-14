#Stefan Schroder
#Problem K
#2016-05-15

def SortList (LST):
	LSTNames = []
	for i in range(len(LST)):
		LSTNames.append(LST[i][LST[i].rfind("|")+1:])
		LST[i] = LST[i].upper()
		
	LST = sorted(LST, reverse=True)#sortz da lst into decending order for numbers and acending order of strings
	for j in range(len(LST)**2):
		for i in range(len(LST)-1):
			if(LST[i][:LST[i].rfind("|")]==LST[i+1][:LST[i+1].rfind("|")]):
				if(LST[i][LST[i].rfind("|")+1:]>LST[i+1][LST[i+1].rfind("|")+1:]):
					PlaceHolder = LST.pop(i)
					LST.insert(i+1,PlaceHolder)
	
	for i in range(len(LST)):
		CurrentName = LST[i][LST[i].rfind("|")+1:]
		Pos = -1
		for j in range(len(LST)):
			if(CurrentName == LSTNames[j].upper()):
				Pos = j
				break
		if(Pos==-1):
			print("Error")
		else:
			LST[i] = LST[i].replace(CurrentName, LSTNames[Pos])
	return LST

TeamsList = []
Line = input()
while Line!="0 0":
	TeamAmount = eval(Line[:1])
	Games = eval(Line[2:])
	#print(TeamAmount)
	#print(Games)
	for Teams in range(TeamAmount):#Create teams
		TeamsList.append([input(),0,0,0,0,0,0])
	
	
	for Gaben in range(Games):
		Line = input()
		Team1 = Line[:Line.find(" ")]#Getting da input
		Line = Line[Line.find(" ")+1:]
		Team1Gz = eval(Line[:Line.find(" ")])
		Line = Line[Line.find("-")+2:]
		Team2Gz = eval(Line[:Line.find(" ")])
		Line = Line[Line.find(" ")+1:]
		Team2 = Line
		Team1Won = True#Find da weeena
		Draw = False
		if(Team1Gz<=Team2Gz):
			Team1Won = False
		if(Team1Gz==Team2Gz):
			Draw = True
		
		for i in range(TeamAmount):
			if(TeamsList[i][0]==Team1):
				TeamsList[i][2] += 1#Adding to the games
				TeamsList[i][3] += Team1Gz#Adding goals scored
				TeamsList[i][4] += Team2Gz#Adding goals suffud
				TeamsList[i][5] += Team1Gz-Team2Gz#Making gola diff
				if(Team1Won==True and Draw==False):
					TeamsList[i][1] += 3
					#print("Team 1 weenz")
				elif(Draw==True):
					TeamsList[i][1] += 1
					#print("DREWWWW")
			
			if(TeamsList[i][0]==Team2):
				TeamsList[i][2] += 1#Adding to the games
				TeamsList[i][3] += Team2Gz#Adding goals scored
				TeamsList[i][4] += Team1Gz#Adding goals suffud
				TeamsList[i][5] += Team2Gz-Team1Gz#Making gola diff
				if(Team1Won==False and Draw==False):
					TeamsList[i][1] += 3
					#print("Team 2 weenz")
				elif(Draw==True):
					TeamsList[i][1] += 1
		#print(TeamsList)	
		#Working out the % scorez
		for Teams in TeamsList:
			if(Teams[2]==0):
				Teams[6] = "N/A"
			else:
				try:
					Teams[6] = (Teams[1]/(Teams[2]*3))*100
				except ZeroDivisionError:
					Teams[6] = 0
		
		
		
	#TeamsList = sorted(TeamsList,key=lambda l:l[0], reverse=False)
	#Sorting
	SortingList = []
	for Teamz in TeamsList:
		SortingList.append(str(Teamz[1])+"|"+
				str(Teamz[5])+"|"+
				str(Teamz[3])+"|"+
				Teamz[0])
	#print(SortingList)
	SortingList = SortList(SortingList)
	
	PrevStuff = ""
	
	#Printing results
	for i in range(len(SortingList)):
		TeamName = SortingList[i][SortingList[i].rfind("|")+1:]
		if(PrevStuff!=SortingList[i][:SortingList[i].rfind("|")]):
			print(end=str(i+1)+".")
		else:
			print(end="  ")
		PrevStuff = SortingList[i][:SortingList[i].rfind("|")]
		Pos = 10
		for Count in range(len(TeamsList)):
			if TeamsList[Count][0]==TeamName:
				Pos = Count
				break
		print(end="{0:>16}{1:>3}{2:>3}{3:>3}{4:>3}{5:>3}".format(TeamsList[Pos][0],
															TeamsList[Pos][1],
															TeamsList[Pos][2],
															TeamsList[Pos][3],
															TeamsList[Pos][4],
															TeamsList[Pos][5]))
		try:#incase the % score = not available
			print("{0:>7.2f}".format(TeamsList[Pos][6]))
		except ValueError:
			print("{0:>7}".format(TeamsList[Pos][6]))
		
		
	
	
	
	TeamsList = []
			
	Line = input()
	if(Line!="0 0"):
		print()