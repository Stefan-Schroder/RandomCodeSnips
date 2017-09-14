/*data types and variables
variables:
-is a place in memoory, of a particular size, with a given name.
-an address is a reference to the specific memory location
-a variable name is an alias to that particular memory location.

Identifiers:
-Unique names for variables, functions
-they can be made up of letters and numbers, but start with letters or underscore and not keyword

Data Types:
-char (8bits/1-byte) (carrying 256 different) (0~255(unsigned) or -128~+127(signed))
-int (depends on the target processor, usually 16/32/64bits) (ours is 32bits)
-long int (double the size of the int)
-float (32-bits)
-double (64-bits)
-long double (double long)

Example:
*/

#include <stdint.h>

int main(void){
	//variable decleration
	int a,b;
	unsigned int c = 0;
	uint8_t d; //unsigned 8 bit integer
	
	int dec = 100;
	int hex = 0x64; // the 0x means that it is a hex value
	int oct = 0144; // the leading 0 tells it that it is oct
	int letter = 'd'; //char makes it a int
	int binary = 0b1100100; // the 0b makes it a binary
	
	
	
}