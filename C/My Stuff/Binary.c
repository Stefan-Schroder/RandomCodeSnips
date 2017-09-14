#include <stdio.h>

int powerI(int x,int y){
	int answer = 1;
	for(y;y>0;y--){
		answer = answer*x;
	}
	return answer;
}

int main(void){
	int number = 6;
	
	char bin[32];
	
	int counter=0;
	while(number!=0){
		bin[counter] = number%2;
		number = number/2;
		counter++;
	}

	int binary = 0;
	
	for(counter--;counter>=0;counter--){
		binary = binary+bin[counter]*powerI(10,counter);
	}
	
	printf("%d",binary);
}