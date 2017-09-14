#Fill grid

def fillGrid(word,y,x):
    grid = []
    PlaceHolder = 0
    for Y in range(y):
        grid.append([])
        for X in range(x):
            grid[Y].append(word[PlaceHolder])
            PlaceHolder += 1
            if(PlaceHolder == len(word)):
                PlaceHolder = 0
    
    for i in range(y):
        for k in range(x):
            print(end=grid[i][k]+" ")
        print()
        
word = input("Word: ")
y = eval(input("Y: "))
x = eval(input("X: "))
fillGrid(word,y,x)