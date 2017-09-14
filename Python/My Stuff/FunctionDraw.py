import math

def Rounder(number,roundTo):
	isPositive = True
	if(number<0):
		isPositive = False
	
	number = abs(number)
	bigNum = math.floor(number)
	number = number-bigNum
	split = 1/roundTo

	splits = []
	for i in range(roundTo+1):
		splits.append(i*split)


	smallest = -1
	smallestNum = 1
	for i in range(len(splits)):
		if(abs(splits[i]-number)<=smallestNum):
			smallest = i
			smallestNum = abs(splits[i]-number)
	
	answer = splits[smallest]+bigNum
	if(not isPositive):
		answer*=-1
	return answer

def Main():
	sums = ["(x**2)-1","((x-1)**2)*(x+2)"]
	chars = ["x","o"]

	zoom = 2

	for Y in range(10*zoom,-10*zoom+1,-1):
		for X in range(-10*zoom,10*zoom+1):
			y=Y/zoom
			x=X/zoom
			
			answers =[]	
			for sum in sums:
				answers.append(Rounder(eval(sum.replace("x",str(x))),zoom))
				
			if(y in answers):
				for i in range(len(sums)):
					if(answers[i]==y):
						print(end=chars[i])
			
			elif(x==0 and y==0):
				print(end="+")
			
			elif(x==0):
				print(end="|")
			
			elif(y==0):
				print(end="-")
			
			else:
				print(end=" ")
			
		print()

if __name__=="__main__":
	Main()