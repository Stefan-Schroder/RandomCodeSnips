void setup() {
  Serial.begin(115200);  //initial the Serial
}
 
void loop() {
  if (Serial.available())  {
    Serial.write(Serial.read()+"Hello this is a test");//send what has been received
    Serial.println();   //print line feed character
  }
  //Serial.println("Hello");
  delay(100);
}
