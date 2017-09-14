/*Print formatting
printf("Hello world\n");
%d - digit (char,int,long)
%x - Hexadecimalring 
%#x- Hexadecimal with 0x
%o - Octal
%c - character
%s - sting
%f - float
%.nf float(n is amout of decimals)
%e - scientific notaion
*/

#include <stdio.h>




int main(void){
	printf("Hello World\n");
	
	int i = 100;
	printf("The number is: %d\n",i);
	printf("Decimal: %d\nHex: %x\nOct:%o\n",i,i,i);
	printf("Char: %c\n",i);
	
	float j = 3.1416;
	printf("Float: %f\n2 point float: %.2f\nSI Notation: %e\n",j,j,j);
	
	getchar();
	return(0);
}