/*Relational and logical Operators
-comparing variables.balues to each other
> 	greater than
>= 	greater than or equal to
<	less than
<=	less than equal to
==	equality (wont compare the full array of characters)
!=	not equal to


Logical Operator
&&	and
||	or
!	not
|	will check all statments before evaluating the or

The operators are used to change the flow of the program

==if/else if/ else Statments==
if(){
	if true
}
else if(){
	if top false and this true
}
else{
	nothing else is true then here
}

for C
0	false
any non-zero is true

==switch statment==
switch(int i){
	case 0://The 0 can be replaced with constant int expression
		break;
	case 1:
		break;
	case 2:
		break;
	default:
		break;
}

==Type of loops==
while(){
	
}
-----------------
do{
	
}while();
-----------------
while(condition); //This will do nothing until the condition becomes true, checks 1's a cycle
-----------------
for([variable];[condition];[update]){
	
}
-----------------

*/

#include <stdio.h>

int main(void){
	int a = 1;
	int b = 2;
	int c = 3;
	int d = 3;
	
	printf("%d\n",(a<b)&&(b<c)&&(c<d));
	printf("%d\n",(a<b)&&(c<=d));
	printf("%d\n",!(a>b)||(c<d));
	
	switch(a){
		case 0:
			printf("Is zero\n");
			break;
		case 1:
			printf("Is One\n");
			break;
		case 2:
			printf("Is Two\n");
			break;
		case 3:
			printf("Is Three\n");
			break;
		default:
			printf("nothing\n");
	}
	
	for(int i=0;i<10;i++){//the declaration within the loop doesnt work with all compiles
		printf("%d\n",i);
	}
}