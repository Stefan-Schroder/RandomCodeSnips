#Stefan Schroder
#problemj
#2016-05-15

FullLib = []
Line = input()
while Line!="END":
	Title = Line[1:Line.rfind("\"")]
	Author = Line[Line.rfind("by ")+3:]
	FullLib.append(Author+">|<"+Title)
	Line = input()

FullLib.sort()

#Copy Lib
CurrentLib = []
for Words in FullLib:#in case of any stupid list errorz
	PlaceHolder = Words
	CurrentLib.append(PlaceHolder)

Line = input()
ToReturn = []
while Line!="END":
	
	if(Line[:Line.find(" ")]=="BORROW"):
		Book = Line[Line.find("\"")+1:Line.rfind("\"")]
		BookPos = -1
		for i in range(len(CurrentLib)):
			if Book in CurrentLib[i]:
				BookPos = i
				break
		if(BookPos==-1):
			print("Book not here")
		else:
			CurrentLib.remove(CurrentLib[BookPos])
	
	if(Line[:Line.find(" ")]=="RETURN"):
		Book = Line[Line.find("\"")+1:Line.rfind("\"")]
		FullIndex = ""
		for i in range(len(FullLib)):
			if Book in FullLib[i]:
				FullIndex = FullLib[i]
				break
		if(FullIndex== ""):
			print("No such book")
		else:
			ToReturn.append(FullIndex)
		ToReturn.sort()
	
	if(Line=="SHELVE"):
		for i in range(len(ToReturn)):
			Book = ToReturn[i][ToReturn[i].find(">|<")+3:]#Book name
			#Author = ToReturn[i][:ToReturn[i].find(">|<")]#Author name
			if(len(CurrentLib)==0):#First book
				CurrentLib.append(ToReturn[i])
				print("Put \""+Book+"\" first")
			else:#Tricky part
				BookPos = FullLib.index(ToReturn[i])
				NextTo = ""
				PutPos = -1
				for j in range(BookPos,-1,-1):
					if FullLib[j] in CurrentLib:
						NextTo = FullLib[j][FullLib[j].find(">|<")+3:]
						PutPos = CurrentLib.index(FullLib[j])
						break
				#print(PutPos)
				CurrentLib.insert(PutPos+1, ToReturn[i])
				#print(CurrentLib)
				if(NextTo==""):
					print("Put \""+Book+"\" first")
				else:
					print("Put \""+Book+"\" after \""+NextTo+"\"")
				
		del ToReturn[:]
		print("END")
	Line=input()

#print(CurrentLib)