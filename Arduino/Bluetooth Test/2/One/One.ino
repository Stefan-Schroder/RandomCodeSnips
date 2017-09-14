#include <SoftwareSerial.h>

SoftwareSerial Genotronex(10, 11);
int ledPin = 13;
int bluetoothData;

void setup() {
  // put your setup code here, to run once:
  Genotronex.begin(115200);
  Genotronex.println("Bluetooth On please press 1 or 0 blink LED..");
  pinMode(ledPin,OUTPUT);
}

void loop() {
  // put your main code here, to run repeatedly:
  if(Genotronex.available()){
    bluetoothData = Genotronex.read();
    if(bluetoothData=='1'){
      digitalWrite(ledPin,HIGH);
      Genotronex.println("LED On D13 ON !");
    }
    if(bluetoothData=='2'){
      digitalWrite(ledPin,LOW);
      Genotronex.println("LED On D13 Off !");
    }else{
      Serial.write("nothing");
    }
  }
  delay(100);
}
