number = 0.5
roundTo = 3

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

print(splits[smallest])
