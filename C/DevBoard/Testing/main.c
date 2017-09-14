//********************************************************************
//*                    EEE2046F C template                           *
//*==================================================================*
//* WRITTEN BY:    	                 		             *
//* DATE CREATED:                                                    *
//* MODIFIED:                                                        *
//*==================================================================*
//* PROGRAMMED IN: Eclipse Luna Service Release 1 (4.4.1)            *
//* DEV. BOARD:    UCT STM32 Development Board                       *
//* TARGET:	   STMicroelectronics STM32F051C6                    *
//*==================================================================*
//* DESCRIPTION:                                                     *
//*                                                                  *
//********************************************************************
// INCLUDE FILES
//====================================================================
#include "stm32f0xx.h"
//====================================================================
// SYMBOLIC CONSTANTS
//====================================================================
#define DELAY1 1000
#define DELAY2 2000
//====================================================================
// GLOBAL VARIABLES
//====================================================================

//====================================================================
// FUNCTION DECLARATIONS
//====================================================================
void InitPorts() {
	//=========================Buttons=============================================
	//=============================================================================
	//enable the buttons
	RCC->AHBENR |= RCC_AHBENR_GPIOAEN;

	//======================SETTING THE BUTTONS TO INPUT===========================
	GPIOA->MODER &= ~( GPIO_MODER_MODER0 |
	GPIO_MODER_MODER1 |
	GPIO_MODER_MODER2 |
	GPIO_MODER_MODER3);
	//=============================================================================

	//=========================PUSH/PULL STATE=====================================
	GPIOA->OTYPER &= ~( GPIO_OTYPER_OT_0 |
	GPIO_OTYPER_OT_1 |
	GPIO_OTYPER_OT_2 |
	GPIO_OTYPER_OT_3);
	//=============================================================================

	//===========================PULL UP RESISTORS=================================
	GPIOA->PUPDR |= ( GPIO_PUPDR_PUPDR0_0 |
	GPIO_PUPDR_PUPDR1_0 |
	GPIO_PUPDR_PUPDR2_0 |
	GPIO_PUPDR_PUPDR3_0);
	//=============================================================================

	//================= LL     EEEE   DDD  ========================================
	//================= LL     EE     D  D ========================================
	//================= LLLLL  EEEE   DDD  ========================================

	//Enable the GPIO Clock for port b
	RCC->AHBENR |= RCC_AHBENR_GPIOBEN; //0x00040000	0000 0000 0000 0100 0000 0000 0000 0000

	//=========Setting the pins in port B(LED) to be General Outputs===============
	GPIOB->MODER |= ( GPIO_MODER_MODER0_0 |
	GPIO_MODER_MODER1_0 |
	GPIO_MODER_MODER2_0 |
	GPIO_MODER_MODER3_0 |
	GPIO_MODER_MODER4_0 |
	GPIO_MODER_MODER5_0 |
	GPIO_MODER_MODER6_0 |
	GPIO_MODER_MODER7_0);
	//=To ensure that the second bit int the 2 bit number for the B ports is 0/Low=
	GPIOB->MODER &= ~( GPIO_MODER_MODER0_1 |
	GPIO_MODER_MODER1_1 |
	GPIO_MODER_MODER2_1 |
	GPIO_MODER_MODER3_1 |
	GPIO_MODER_MODER4_1 |
	GPIO_MODER_MODER5_1 |
	GPIO_MODER_MODER6_1 |
	GPIO_MODER_MODER7_1);
	//==============================================================================

	//==============Making the pins digital so that they are push-pull==============
	GPIOB->OTYPER &= ~( GPIO_OTYPER_OT_0 |
	GPIO_OTYPER_OT_1 |
	GPIO_OTYPER_OT_2 |
	GPIO_OTYPER_OT_3 |
	GPIO_OTYPER_OT_4 |
	GPIO_OTYPER_OT_5 |
	GPIO_OTYPER_OT_6 |
	GPIO_OTYPER_OT_7);
	//==============================================================================

	//================Setting all the pin speeds to high============================
	GPIOB->OSPEEDR |= ( GPIO_OSPEEDER_OSPEEDR0 |
	GPIO_OSPEEDER_OSPEEDR1 |
	GPIO_OSPEEDER_OSPEEDR2 |
	GPIO_OSPEEDER_OSPEEDR3 |
	GPIO_OSPEEDER_OSPEEDR4 |
	GPIO_OSPEEDER_OSPEEDR5 |
	GPIO_OSPEEDER_OSPEEDR6 |
	GPIO_OSPEEDER_OSPEEDR7);
	//==============================================================================

	//======================neither pull up or down=================================
	GPIOB->PUPDR &= ~( GPIO_PUPDR_PUPDR0 |
	GPIO_PUPDR_PUPDR1 |
	GPIO_PUPDR_PUPDR2 |
	GPIO_PUPDR_PUPDR3 |
	GPIO_PUPDR_PUPDR4 |
	GPIO_PUPDR_PUPDR5 |
	GPIO_PUPDR_PUPDR6 |
	GPIO_PUPDR_PUPDR7);
	//==============================================================================
	//==============================================================================
}

void Delay(void) {
	volatile int i, j;
	for (i = 0; i < DELAY1; i++) {
		for (j = 0; j < DELAY2; j++) {
			continue;
		}
	}
}

char CountUp(char value) {
	GPIOB->BRR |= 0x000000FF;
	GPIOB->BSRR |= value;

	if (value >= 255) {
		value = 0;
	} else {
		value++;
	}

	return value;
}

char CountDown(char value) {
	GPIOB->BRR |= 0x000000FF;
	GPIOB->BSRR |= value;

	if (value <= 0) {
		value = 0;
	} else {
		value--;
	}

	return value;
}
//====================================================================
// MAIN FUNCTION
//====================================================================
void main(void) {
	InitPorts();

	GPIOB->BRR |= 0x000000FF;

	int state, value = 0;
	while (1) {

		switch (state) {
		case 0:
			break;
		case 1:
			value = CountUp(value);
			break;
		case 2:
			value = CountDown(value);
			break;
		}

		while ((GPIOA->IDR & GPIO_IDR_0) == 0) {	//start counting
			value = 0;
			state = 1;
		}
		while ((GPIOA->IDR & GPIO_IDR_1) == 0) {	//counting up state 1
			state = 1;
		}
		while ((GPIOA->IDR & GPIO_IDR_2) == 0) {	//counting down state 2
			state = 2;
		}

		Delay();
	}	//infinite loop
}	// End of main

//====================================================================
// FUNCTION DEFINITIONS
//====================================================================

//********************************************************************
// END OF PROGRAM
//********************************************************************
