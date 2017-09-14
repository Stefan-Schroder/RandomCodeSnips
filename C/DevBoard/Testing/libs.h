#ifndef __LIBS_H_
#define __LIBS_H_

#include <stdint.h>

/*Prototypes*/
void lib_init_leds(void);
void lib_write_leds(uint8_t led_val);
uint8_t lib_read_leds(void);
void lib_init_buttons();
int lib_read_button_0(void);
int lib_read_button_1(void);
int lib_read_button_2(void);
int lib_read_button_3(void);
int lib_read_falling_edge_button0(void);
int lib_read_falling_edge_button1(void);
int lib_read_falling_edge_button2(void);
int lib_read_falling_edge_button3(void);
int lib_read_rising_edge_button0(void);
int lib_read_rising_edge_button1(void);
int lib_read_rising_edge_button2(void);
int lib_read_rising_edge_button3(void);
void lib_init_adc_6bit(void);
void lib_init_adc_8bit(void);
void lib_init_adc_10bit(void);
void lib_init_adc_12bit(void);
void lib_adc_cal(void);
void lib_init_pot0(void);
void lib_init_pot1(void);
uint16_t lib_read_pot0(void);
uint16_t lib_read_pot1(void);
void lib_init_TIM14(uint32_t prescaler, uint32_t arr);
void lib_init_TIM6(uint32_t prescaler, uint32_t arr);
void lib_TIM6_update_ARR(uint32_t arr);
void lib_TIM6_update_PSC(uint32_t psc);
void lib_TIM6_ACK(void);
void delay_ms(uint32_t count);
void delay_us(uint32_t delay);

//None hardware control functions

//Find min val of uint8 array
uint8_t lib_find_min_uint8(uint8_t* a, uint32_t len);

//Find max val of uint8 array
uint8_t lib_find_max_uint8(uint8_t* a, uint32_t len);

//Find min val of int8 array
int8_t lib_find_min_int8(int8_t* a, uint32_t len);

//Find max val of int8 array
int8_t lib_find_max_int8(int8_t* a, uint32_t len);

//Quicksort array 
void lib_quicksort(int32_t* a,uint32_t lo, uint32_t hi);

//Helper don't call!
uint32_t partition(int32_t* a,uint32_t lo, uint32_t hi);
#endif
/**/
