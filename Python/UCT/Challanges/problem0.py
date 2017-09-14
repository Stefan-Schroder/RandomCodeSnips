answer = ""
'''
line = " "
while line!="":
    line = input()
    if(line!=""):
        #answer+=line
        
        print(line)
    else:
        break
    
'''

import sys
for line in sys.stdin:
    
    if(line!="\n"):
        print(line,end="")
    else:
        break

