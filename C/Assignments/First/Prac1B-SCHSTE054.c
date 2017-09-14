//********************************************************************
//*                    EEE2046F C template                           *
//*==================================================================*
//* WRITTEN BY: Stefan Schroder                 		             *
//* DATE CREATED:2017/04/07                                          *
//* MODIFIED:2017/04/14                                              *
//*==================================================================*
//* PROGRAMMED IN: Notpad++						                     *
//*==================================================================*
//* DESCRIPTION: Converts decimal input to binary                    *
//*                                                                  *
//********************************************************************
// INCLUDE FILES
//====================================================================
#include <stdio.h>
#include <math.h>
//====================================================================
// SYMBOLIC CONSTANTS
//====================================================================
#define TITLE "BINARY TO DECIMAL CONVERTOR"
#define AUTHOR "Stefan Schroder"
#define YEAR "2017"
//====================================================================
// GLOBAL VARIABLES
//====================================================================

//====================================================================
// FUNCTION DECLARATIONS
//====================================================================
int power(int x,int y){//I made this because the power function in math.h was giving me trouble
	int answer = 1;
	for(y;y>0;y--){
		answer = answer*x;
	}
	return answer;
}

int dec2bin(int number){
	/*
	This functions starts by making a 32bit char array.
	The char array is then populated by modulusing the number by 2.
	The number is then changed to the rounded down division of itself by 2
	This is done until the number is less than 0, because the answer would be the same each time
	
	The counter variable is used to keep track of where in the array to add the next binary digit.
	
	This method of getting a binary number will return it in reverse;
	so the last loop goes from the last posistion of a character in the loop and moves backwards to the start.
	these numbers are then multiplied by 10 to the power of their position in the loop and added to the final number.
	
	This binary number is then returned.
	*/
	char bin[32];
	
	int counter=0;
	while(number!=0){
		bin[counter] = number%2;
		number = number/2;
		counter++;
	}

	int binary = 0;
	
	for(counter--;counter>=0;counter--){
		binary = binary+bin[counter]*power(10,counter);
	}
	
	return binary;
}
//====================================================================
// MAIN FUNCTION
//====================================================================
void main (void){
	printf("*****************************\n");
	printf(" %s\n",TITLE);
	printf(" Wirten by: %s\n",AUTHOR);
	printf(" Date: %s\n",YEAR);
	printf("*****************************\n");
	
	int number;
		
	while(1){//This is an infinite loop to ask for the input untill loop is broken
		printf("Enter a decimal number: ");
		scanf("%d",&number);
		
		if(number<0){//Breaks out of the infinit loop before any other operations are done.
			printf("END\n");
			break;
		}
		
		printf("The number you have entered is %d\n",number);
		printf("The log2 of the number is %.2f\n",log2(number));//makes use of the log function in math.h
		printf("The number divided by 2 is %d\n",(number/2));//integer division always returns rounded down
		printf("The remainder is %d\n",(number%2));//modulus will give the remainder of a division
		printf("The binary value is %d\n",dec2bin(number));
	}
}

//====================================================================
// FUNCTION DEFINITIONS
//====================================================================

//********************************************************************
// END OF PROGRAM
//********************************************************************
