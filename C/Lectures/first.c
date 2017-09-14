/*
first C program
23 march 2017 
*/

#include <stdio.h>


int main(void){
// int main(int argc, char * argv[])
	char x; 
	x = 'a';
	
	printf("Hello world.\n%c",x);
	getchar();
	return(0);
}

/*
When main function terminates:
0 = normal program ends
non-zero = abnormal termination
*/
