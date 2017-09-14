#This is how we have to do main methods in python

def Main():
    i = eval(input("Enter some crap: "))
    print(i)

if __name__ == "__main__":#This makes it so that it does not run if the program is access from outside this program. This is so that you only access the functions within the program and not the main method itself
    Main()