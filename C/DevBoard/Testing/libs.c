#include "libs.h"
#include <stdint.h>
#define STM32F051
#include "stm32f0xx.h"
#define TRUE 1;
#define FALSE 0;

//Defining global variables (GASP!!! Not a global variable in C!!!)
int btn0_previous_state = 0;
int btn1_previous_state = 0;
int btn2_previous_state = 0;
int btn3_previous_state = 0;

void lib_init_leds(void){
	//enable the GPIOb clock
	RCC->AHBENR |= RCC_AHBENR_GPIOBEN;
	//enable GPIOB into output mode	
	GPIOB-> MODER = 0x5555;
}

void lib_write_leds(uint8_t led_val){
	//write led_val to leds
	GPIOB->ODR = led_val;
}

uint8_t lib_read_leds(void){
	//Reads the value currently displayed on leds
	uint8_t value;
	value = GPIOB->ODR;
	return value;
}

void lib_init_buttons(void){
	//enable the GPIOA clock
	RCC->AHBENR |= RCC_AHBENR_GPIOAEN;
	//Enable pull ups on switch pins
	GPIOA->PUPDR |= 0x55;
}

int lib_read_button_0(void){
	//if input data & 0001 = 0
	if((GPIOA->IDR & 0x1) == 0){
		//returns 1
		return TRUE;
	}
	else{
		//returns 0
		return FALSE;
	}
}

int lib_read_button_1(void){
	//if input data & 0010 = 0
	if((GPIOA->IDR & 0x2) == 0){
		//returns 1
		return TRUE;
	}
	else{
		//returns 0
		return FALSE;
	}
}

int lib_read_button_2(void){
	//if input data & 0100 = 0
	if((GPIOA->IDR & 0x4) == 0){
		//returns 1
		return TRUE;
	}
	else{
		//returns 0
		return FALSE;
	}
}

int lib_read_button_3(void){
	//if input data & 1000 = 0
	if((GPIOA->IDR & 0x8) == 0){
		//returns 0
		return TRUE;
	}
	else{
		//returns 1
		return FALSE;
	}
}

int lib_read_rising_edge_button0(void){
	int current_state = lib_read_button_0();
	//	switch is pressed	was previously not pressed
	if((current_state == 0) & (btn0_previous_state == 	1)){
		btn0_previous_state = current_state;
		return TRUE;
	}
	else{
		btn0_previous_state = current_state;
		return FALSE;
	}
}

int lib_read_rising_edge_button1(void){
	int current_state = lib_read_button_1();
	//	switch is pressed	was previously not pressed
	if((current_state == 0) & (btn1_previous_state == 	1)){
		btn1_previous_state = current_state;
		return TRUE;
	}
	else{
		btn1_previous_state = current_state;
		return FALSE;
	}
}

int lib_read_rising_edge_button2(void){
	int current_state = lib_read_button_2();
	//	switch is pressed	was previously not pressed
	if((current_state == 0) & (btn2_previous_state == 	1)){
		btn2_previous_state = current_state;
		return TRUE;
	}
	else{
		btn2_previous_state = current_state;
		return FALSE;
	}
}

int lib_read_rising_edge_button3(void){
	int current_state = lib_read_button_3();
	//	switch is pressed	was previously not pressed
	if((current_state == 0) & (btn3_previous_state == 	1)){
		btn3_previous_state = current_state;
		return TRUE;
	}
	else{
		btn3_previous_state = current_state;
		return FALSE;
	}
}

int lib_read_falling_edge_button0(void){
	int current_state = lib_read_button_0();
	//	switch is pressed	was previously not pressed
	if((current_state == 1) & (btn0_previous_state == 0)){
		btn0_previous_state = current_state;
		return TRUE;
	}
	else{
		btn0_previous_state = current_state;
		return FALSE;
	}
}

int lib_read_falling_edge_button1(void){
	int current_state = lib_read_button_1();
	//	switch is pressed	was previously not pressed
	if((current_state == 1) & (btn1_previous_state == 0)){
		btn1_previous_state = current_state;
		return TRUE;
	}
	else{
		btn1_previous_state = current_state;
		return FALSE;
	}
}

int lib_read_falling_edge_button2(void){
	int current_state = lib_read_button_2();
	//	switch is pressed	was previously not pressed
	if((current_state == 1) & (btn0_previous_state == 0)){
		btn2_previous_state = current_state;
		return TRUE;
	}
	else{
		btn2_previous_state = current_state;
		return FALSE;
	}
}

int lib_read_falling_edge_button3(void){
	int current_state = lib_read_button_3();
	//	switch is pressed	was previously not pressed
	if((current_state == 1) & (btn0_previous_state == 0)){
		btn3_previous_state = current_state;
		return TRUE;
	}
	else{
		btn3_previous_state = current_state;
		return FALSE;
	}
}

void lib_init_adc_6bit(void){
	//start clock for ADC
	RCC->APB2ENR |= RCC_APB2ENR_ADCEN;
	//Configure the resolution
	ADC1->CFGR1 |= 0x18;
	//enable the ADC
	ADC1->CR |= ADC_CR_ADEN;
	
	//wait till ADC flag is ready
	while ((ADC1->ISR & 0x1)!=1);
}

void lib_init_adc_8bit(void){
	//start clock for ADC
	RCC->APB2ENR |= RCC_APB2ENR_ADCEN;
	//Configure the resolution
	ADC1->CFGR1 |= 0x10;
	//enable the ADC
	ADC1->CR |= ADC_CR_ADEN;
	
	//wait till ADC flag is ready
	while ((ADC1->ISR & 0x1)!=1);
}

void lib_init_adc_10bit(void){
	//start clock for ADC
	RCC->APB2ENR |= RCC_APB2ENR_ADCEN;
	//Configure the resolution
	ADC1->CFGR1 |= 0x8;
	//enable the ADC
	ADC1->CR |= ADC_CR_ADEN;
	
	//wait till ADC flag is ready
	while ((ADC1->ISR & 0x1)!=1);
}

void lib_init_adc_12bit(void){
	//start clock for ADC
	RCC->APB2ENR |= RCC_APB2ENR_ADCEN;
	//Configure the resolution
	ADC1->CFGR1 |= 0x0;
	//enable the ADC
	ADC1->CR |= ADC_CR_ADEN;
	
	//wait till ADC flag is ready
	while ((ADC1->ISR & ADC_ISR_ADRDY)!= 1);
}

void lib_adc_cal(void){
	ADC1->CR = ADC_CR_ADCAL;
	while((ADC1->CR & ADC_CR_ADCAL) == 1);
}

void lib_init_pot0(void){
	GPIOA->MODER |= GPIO_MODER_MODER5;
}

void lib_init_pot1(void){
	GPIOA->MODER |= GPIO_MODER_MODER6;
}

uint16_t lib_read_pot0(void){
	//16 bits to store ADC val (6bit to 12 bit)
	uint16_t pot0_value;
	//Select channel 5 in adc
	ADC1->CHSELR = ADC_CHSELR_CHSEL5;
	//Begin the ADC conversion
	ADC1->CR |= ADC_CR_ADSTART;
	//Wait for conversion
	while((ADC1->ISR & ADC_ISR_EOC) == 0);
	//set the value to what is in the ADC data register
	pot0_value = ADC1->DR;
	
	return pot0_value;
}

uint16_t lib_read_pot1(void){
	//16 bits to store ADC val (6bit to 12 bit)
	uint16_t pot1_value;
	//Select channel 5 in adc
	ADC1->CHSELR = ADC_CHSELR_CHSEL6;
	//Begin the ADC conversion
	ADC1->CR |= ADC_CR_ADSTART;
	//Wait for conversion
	while((ADC1->ISR & ADC_ISR_EOC) == 0);
	//set the value to what is in the ADC data register
	pot1_value = ADC1->DR;
	
	return pot1_value;
}

void lib_init_TIM14(uint32_t prescaler, uint32_t arr){
	//enable the TIM6 clock
	RCC->APB1ENR |= RCC_APB1ENR_TIM14EN;
	//Set prescaler
	TIM14->PSC = prescaler;
	//Set ARR
	TIM14->ARR = arr;
	//Enable the timer interrupt
	TIM14->DIER |= TIM_DIER_UIE;
	//enable the counter
	TIM14->CR1 |= TIM_CR1_CEN;
	//Buffer the ARR value
	TIM14->CR1 |= TIM_CR1_ARPE;
	//Finally enable the TIM14 interrupt in the interrupt manager (NVIC_ISER)
	*(uint32_t*)0xE000E100 |= 0x20000;
}

void lib_init_TIM6(uint32_t prescaler, uint32_t arr){
	//enable the TIM6 clock
	RCC->APB1ENR |= RCC_APB1ENR_TIM6EN;
	//Set prescaler
	TIM6->PSC = prescaler;
	//Set ARR
	TIM6->ARR = arr;
	//Enable the timer interrupt
	TIM6->DIER |= TIM_DIER_UIE;
	//enable the counter
	TIM6->CR1 |= TIM_CR1_CEN;
	//Buffer the ARR value
	TIM6->CR1 |= TIM_CR1_ARPE;
	//Finally enable the TIM6 interrupt in the interrupt manager (NVIC_ISER)
	*(uint32_t*)0xE000E100 |= 0x20000;
}

void lib_TIM6_update_ARR(uint32_t arr){
	TIM6->ARR = arr;
}

void lib_TIM6_update_PSC(uint32_t psc){
	TIM6->PSC = psc;
}

void lib_TIM6_ACK(void){
	TIM6->SR &= ~TIM_SR_UIF;
}

void delay_ms(uint32_t count){
	// delay set for the input value in milliseconds
	int delay = count*735;
	while(delay>0){
		delay -= 1;
	}
}

void delay_us(uint32_t delay){
	// delay set for the input value in +- microseconds
	volatile uint32_t counter =0;
	//delay = delay*3;
	for(; counter < delay; counter++){
		__asm("NOP");
	}
}





/* Non hardware control functions */


//Find min in array of uint8
uint8_t lib_find_min_uint8(uint8_t* a, uint32_t len) {
    uint8_t min = a[0];
    uint32_t i;
    for (i = 1; i < len; i++){
        if(a[i] < min) {
            min = a[i];
        }
    }
    return min;
}

//Find max in array of unint8
uint8_t lib_find_max_uint8(uint8_t* a, uint32_t len) {
    uint8_t max = a[0];
    uint32_t i;
    for (i = 1; i < len; i++){
        if(a[i] > max) {
            max = a[i];
        }
    }
    return max;
}

//Find min in array of uint8
int8_t lib_find_min_int8(int8_t* a, uint32_t len) {
    int8_t min = a[0];
    uint32_t i;
    for (i = 1; i < len; i++){
        if(a[i] < min) {
            min = a[i];
        }
    }
    return min;
}

//Find max in array of unint8
int8_t lib_find_max_int8(int8_t* a, uint32_t len) {
    int8_t max = a[0];
    uint32_t i;
    for (i = 1; i < len; i++){
        if(a[i] > max) {
            max = a[i];
        }
    }
    return max;
}

/**
 * Insort a int32 array using quicksort algorithm.
 * Based on Lomuto partion scheme.
 */
void lib_quicksort(int32_t* a,uint32_t lo, uint32_t hi) {
    if( lo < hi) {
        uint32_t p = partition(a, lo, hi);
        lib_quicksort(a, lo, p - 1);
        lib_quicksort(a, p + 1, hi);
    }
}

//Helper function for quicksort
uint32_t partition(int32_t* a,uint32_t lo, uint32_t hi){
    int32_t pivot = a[hi];
    uint32_t i = lo;
    uint32_t j;
    for(j = lo; j < (hi - 1); j++){
        if(a[j] <= pivot){
            int32_t tmp = a[i];
            a[i] = a[j];
            a[j] = tmp;
            i++;
        }
    }
    int32_t tmp2 = a[i];
    a[i] = a[hi];
    a[hi] = tmp2;
    return i;
}
