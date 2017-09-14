Alpha = ["a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p","q","r","s","t","u","v","w","x","y","z"]
number  = []
for i in range(1,3):
    number.append(0)
    for j in range(len(Alpha)**len(number)):
        for k in range(len(number)-1,-1,-1):
            print(Alpha[number[k]],end="")
        print()
        for k in range(len(number)):
            if(number[k]==len(Alpha)-1):
                number[k]=0
            else:
                number[k]+=1
                break
        