#Stefan Schroder
#2048 merges
#2016-04-22

def push_up(grid):
    def RemoveZeroz(grid):#Moves up all numbers till no Zero gaps
        for y in range(1,4):
            for x in range(4):
                if(grid[y][x]!=0):
                    ZeroCount = 0
                    for i in range(y-1,-1,-1):
                        if(grid[i][x]==0):
                            ZeroCount+=1
                        else:
                            break
                    if(ZeroCount!=0):
                        grid[y-ZeroCount][x]=grid[y][x]
                        grid[y][x]=0
        return grid
    
    grid = RemoveZeroz(grid)   
    
    for y in range(1,4):
        for x in range(4):
            if(grid[y-1][x]==grid[y][x] and grid[y][x]!=0):
                grid[y-1][x]+=grid[y][x]
                grid[y][x] = 0
    
    return RemoveZeroz(grid)

def push_down(grid):#Basicly cheating... im flipping the grid upside down and then pushing up
    FlipY(grid)
    push_up(grid)
    FlipY(grid)

def FlipY(grid):
    DownGrid = []
    for y in range(4):
        DownGrid.append([])
        for x in range(4):
            DownGrid[y].append(grid[y][x])
    
    for y in range(4):
        for x in range(4):
            grid[3-y][x] = DownGrid[y][x]
    return grid

def push_right(grid):#Flip the grid to the right and then pushes up and then flips right 3 times
    return FlipXY(FlipXY(FlipXY(push_up(FlipXY(grid)))))

def FlipXY(grid):#Rotates grid 90 anticlockwise
    RotateGrid = []
    for y in range(4):
        RotateGrid.append([])
        for x in range(4):
            RotateGrid[y].append(grid[y][x])
    
    for y in range(4):
        for x in range(4):
            grid[y][x] = RotateGrid[x][y]
    return FlipY(grid)

def push_left(grid):#Flips right 3 times and then pushes up and then pushes up and flips again
    return FlipXY(push_up(FlipXY(FlipXY(FlipXY(grid)))))
"""
grid = [[0,2,2,0],
        [1,2,2,2],
        [0,3,0,0],
        [0,0,2,0]]

#grid=push_up(grid)
grid=push_left(grid)    
for i in range(4):
    print(grid[i])
"""
