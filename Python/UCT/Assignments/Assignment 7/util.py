#Stefan Schroder
#2048
#2016-04-21

def create_grid(grid):
    for y in range(4):
        grid.append([])
        for x in range(4):
            grid[y].append(0)
    return grid

def print_grid(grid):
    print("+--------------------+")
    for y in range(4):
        print(end="|")
        for x in range(4):
            if(grid[y][x]==0):
                print(end="{0:<5}".format(""))
            else:
                print(end="{0:<5}".format(grid[y][x]))
        print(end="|\n")
    print("+--------------------+")
    
def check_lost(grid):
    if(0 not in grid):
        for y in range(4):
            for x in range(4):
                if(y!=0 and grid[y][x]==grid[y-1][x]):
                    return False
                elif(y!=3 and grid[y][x]==grid[y+1][x]):
                    return False
                elif(x!=0 and grid[y][x]==grid[y][x-1]):
                    return False
                elif(x!=3 and grid[y][x]==grid[y][x+1]):
                    return False
                elif(grid[y][x]==0):
                    return False
        else:
            return True
    else:
        return False

def check_won(grid):
    for y in range(4):
        for x in range(4):
            if(grid[y][x]>=32):
                return True
    return False

def copy_grid(grid):
    CopyGrid = []
    for y in range(4):
        CopyGrid.append([])
        for x in range(4):
            PlaceHolder = grid[y][x]
            CopyGrid[y].append(PlaceHolder)
    return CopyGrid

def grid_equal(grid1,grid2):
    if(grid1==grid2):
        return True
    return False
'''
grid = [[2,1,2,5]
       ,[8,3,1,4]
       ,[2,1,5,3]
       ,[6,12,40,4]]

print(check_lost(grid))
'''