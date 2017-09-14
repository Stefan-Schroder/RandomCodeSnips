#include<Servo.h>

Servo mineServine;

void setup() {
  mineServine.attach(9);
}

void loop() {
  mineServine.writeMicroseconds(1500);
  delay(50);

  mineServine.writeMicroseconds(1000);
  delay(50);

  mineServine.writeMicroseconds(2000);
  delay(50);
}
