import random

def main():
    global board
    global lives
    i=0
    lives=[17 for c in range (2)]
    board=[[[" " for x in range(10)] for x in range(10)]for x in range(4)]
    generate_boats()
    while True:
        i+=1
        shoot(1,shoot1(board[3]))
        if(lives[1]<=0):
            print("Player 1 wins in "+str(i)+ " turns")
            break
        shoot(0,shoot2(board[2]))
        if(lives[0]<=0):
            print("Player 2 wins in "+str(i)+ " turns")
            break

def shoot1(gamestate):
    #player 1 code here
    #return co-ordinates
    return input("Player one shoot: ")

def shoot2(gamestate):
    #player 1 code here
    #return co-ordinates
    return input("Player two shoot: ")

def place_boat(a):
    for v in range (0,2):
        looking = True
        while looking:
            looking =False
            f=random.randrange(0,2)
            if(f==0):
                x=random.randrange(0,10-a+1)
                y=random.randrange(0,10)
                i=x
                while(i<(x+a)):
                    if board[v][y][i]=="O":
                        looking= True
                    i+=1
                if (not looking):
                    i=x
                    while(i<(x+a)):
                        board[v][y][i]="O"
                        i+=1
            else:
                x=random.randrange(0,10)
                y=random.randrange(0,10-a+1)
                i=y
                while (i<(y+a)):
                    if board[v][i][x]=="O":
                        looking= True
                    i+=1
                if (not looking):
                    i=y
                    while (i<(y+a)):
                        board[v][i][x]="O"
                        i+=1
    return

def shoot(v,xy):
    if(board[v][ord(xy[1])-65][eval(xy[1,len(xy)])-1]=="O"):
        for i in range(v,v+3,2):
            board[v][ord(xy[1])-65][eval(xy[1,len(xy)])-1]="X"
        lives[v]-=1
    elif(board[v][ord(xy[1])-65][eval(xy[1,len(xy)])-1]==" "):
        for i in range(v,v+3,2):
            board[v][ord(xy[1])-65][eval(xy[1,len(xy)])-1]="M"


def generate_boats():
    place_boat(5)
    place_boat(4)
    place_boat(3)
    place_boat(3)
    place_boat(2)

def print_board():
    global board
    for u in range(0,10):
        print("-",end="")
    print()
    for v in range(0,2):
        for y in range(0,10):
            for x in range(0,10):
                print(board[v][y][x], end="")
            print()
        for u in range(0,10):
            print("-",end="")
        print()

if (__name__=="__main__"):
    main()