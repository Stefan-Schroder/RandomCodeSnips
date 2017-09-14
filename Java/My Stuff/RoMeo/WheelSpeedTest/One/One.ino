int adc_key_val[5] ={50, 200, 400, 600, 800 };        
int NUM_KEYS = 5;
int adc_key_in;
int key=-1;
int oldkey=-1;
int moveSpeed = 0;

void setup() {
  for(int i=4;i<=7;i++)
    pinMode(i, OUTPUT);
  // put your setup code here, to run once:
  pinMode(13, OUTPUT);
  Serial.begin(115200);
}

void loop() {
  // put your main code here, to run repeatedly:
  Serial.println(analogRead(A0));
  adc_key_in = analogRead(7);   
  digitalWrite(13,LOW);
  key = get_key(adc_key_in);  //Call the button judging function.
  
  if (key != oldkey){   // Get the button pressed
      delay(50);  
      adc_key_in = analogRead(7);    
      key = get_key(adc_key_in);    
      if (key != oldkey)    {   
        oldkey = key;
        if (key >=0){
          digitalWrite(13,HIGH);
          switch(key){          // Send messages accordingly.
             case 0:
                    moveSpeed = 50; 
                    break;
             case 1:
                    moveSpeed = 100;   
                    break;
             case 2:
                    moveSpeed = 150;   
                    break;
             case 3:
                    moveSpeed = 200;   
                    break;      
             case 4:
                    moveSpeed = 250;   
                    break;  
          }// switch
        }// greater than 1
      }// if not old key
  }// if old key

  advance(moveSpeed);
  delay(50);
}

void advance(char a){
  analogWrite (5,a);      //PWM Speed Control
  digitalWrite(4,HIGH);
}

// To know the pressed button.
int get_key(unsigned int input){
    int k;
    for (k = 0; k < NUM_KEYS; k++){
      if (input < adc_key_val[k]){     // Get the button pressed 
            return k;
      }
   }
   if (k >= NUM_KEYS)k = -1;  // No button is pressed.
   return k;
}
