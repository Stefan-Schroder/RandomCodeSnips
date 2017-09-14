/*Symbolic constants
it is a value that needs to keep its value for the running of the program

# - pre processor command, runs befor the compiler runs
the defines do not need to contain a type becuase the command is just copy and 
pasted over the places where you have the variable name before compilation

needs to appear at the start of the file

modifiers
x+y - addition
x-y - subtraction
x*y - multiplication
x/y - division
x%y - modulus

division will truncate the result of decimal division stored in a int
if you store it into a float and you are dividing ints it wont give u decimals
*/
#include <stdio.h>




#define MYCONST 32//my constant - name 32 - value
#define MEMORY_SIZE (100*WORD_LENGTH)
#define MSG "Hello World\n"
#define PI 3.1416

int main(void){
	printf("your mom");
	return(0);
}