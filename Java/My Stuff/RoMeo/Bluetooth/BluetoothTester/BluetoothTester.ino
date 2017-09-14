 boolean Blink;
 void setup() {
  // start serial port at 9600 bps and wait for port to open:
  Blink = false;
  Serial.begin(115200);
  while (!Serial) {
    Serial.println("Stuck");
    ; // wait for serial port to connect. Needed for native USB port only
  }

  pinMode(13, OUTPUT);
  establishContact();  // send a byte to establish contact until receiver responds
}

void loop() {
  delay(100);
  // if we get a valid byte, read analog ins:
  if (Serial.available() > 0) {
    // get incoming byte:
    char Input = Serial.read();
    if(Input=='1'){
      Blink = true;
    }else if(Input=='2'){
      Blink = false;
    }else{
      delay(50);
      Serial.println("Testing");
    }
    if(Blink){
      digitalWrite(13, HIGH);
    }else{
      digitalWrite(13, LOW);
    }
  }
}

void establishContact() {
  while (Serial.available() <= 0) {
    Serial.println("0,0,0");   // send an initial string
    delay(300);
  }
}

