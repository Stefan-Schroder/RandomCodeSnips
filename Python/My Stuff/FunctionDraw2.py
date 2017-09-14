import math


def main():
	z = "math.sqrt(((x)**2 + (y)**2))"
	function = "z<2"
	
	for Y in range(10,-10+1,-1):
		for X in range(-10,10+1):
			y=Y
			x=X
			
			xreplace = z.replace("x",str(x))
			sum = xreplace.replace("y",str(y))
			try:
				answer = eval(sum)
			except:
				print(x,y)
			#print(answer)
			
			if(eval(function.replace("z",str(answer)))):
				print(end="*")
				
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
	main()