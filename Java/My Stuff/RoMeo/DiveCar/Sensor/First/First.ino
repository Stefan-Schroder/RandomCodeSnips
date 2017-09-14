int adc_key_val[5] ={50, 200, 400, 600, 800 };        
int NUM_KEYS = 5;
int adc_key_in;
int key=-1;
int oldkey=-1;
int moveSpeed = 0;
int currentLDR = 0;
int aboveCounter = 0;

void setup() {
  for(int i=4;i<=7;i++)
    pinMode(i, OUTPUT);
  // put your setup code here, to run once:
  pinMode(13, OUTPUT);
  Serial.begin(115200);
  pinMode(12, OUTPUT);
  digitalWrite(12,HIGH);
}

void loop() {
  // put your main code here, to run repeatedly:
  adc_key_in = analogRead(7);   
  digitalWrite(13,LOW);
  key = get_key(adc_key_in);  //Call the button judging function.
  checkStop();
  
  if (key != oldkey){   // Get the button pressed
      delay(50);
      adc_key_in = analogRead(7);    
      key = get_key(adc_key_in);    
      if (key != oldkey){   
        oldkey = key;
        if (key >=0){
          digitalWrite(13,HIGH);
          digitalWrite(12,HIGH);
          switch(key){          // Send messages accordingly.
             case 0:
                    stopIt(); 
                    moveSpeed = 0;
                    break;
             case 1:
                    moveSpeed = 100;   
                    break;
             case 2:
                    moveSpeed = 175;   
                    break;
             case 3:
                    moveSpeed = 250;   
                    break;      
             case 4:
                    digitalWrite(12,LOW);
                    moveSpeed = 0;   
                    break;  
          }// switch
        }// greater than 1
      }// if not old key
  }// if old key
  
  advance(moveSpeed);
  delay(50);
}

void checkStop(){

  currentLDR = analogRead(A0);
  
  Serial.println(currentLDR);
  if(moveSpeed!=0){
    
    if(currentLDR>=1020){
      aboveCounter++;   
    }else if(aboveCounter>0){
      aboveCounter--;
    }
  
    if(aboveCounter>=3){
      aboveCounter=0;
      moveSpeed=0;
      stopIt();
    }
    
  }//if movespeed
}

void advance(char a){
  analogWrite (5,a);      //PWM Speed Control
  digitalWrite(4,HIGH);
  analogWrite (6,a);
  digitalWrite(7,HIGH);
}

void stopIt(){
  analogWrite(5,0);
  digitalWrite(4,LOW);
  analogWrite(6,0);
  digitalWrite(7,LOW);
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
