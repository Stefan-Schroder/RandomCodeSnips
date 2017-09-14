
package Main;

import javax.swing.JOptionPane;

public class Encrypt {
    String ToEncrypt = "";
    String Encrypted;
    
    public  Encrypt(){
        
    }//end the constructor
    
    public void setText(String a){
        ToEncrypt = a;
    }//end set
    
    public String GetEncypted(){
                String Encrypted = "";
                String[] Ascii = new String[100];
                for (int i = 0; i<= Ascii.length-1; i++){
                    if(i == 127){
                        i++;
                    }
                    int number = i+32;
                    char StrNum = (char)number;
                    Ascii[i] = String.valueOf(StrNum);
                }//end i
                
                String String = ToEncrypt;
                
                int RandFir = ((int)(Math.random()*Ascii.length))+32;
                int RandSec = ((int)(Math.random()*Ascii.length))+32;
                char FirstRandChar = (char)RandFir; 
                char SecRandChar = (char)RandSec;
                Encrypted = (Encrypted + FirstRandChar + SecRandChar);
                
                int x = RandFir;
                int y = RandSec;
                int z = 0;
                int repeatTimes = RandFir+RandSec+String.length()+Ascii.length*3;
                String AllValues = (String.valueOf(x) + String.valueOf(y));
                for (int i = 1; i <= repeatTimes; i++){
                    z =  x + y;
                    if(String.valueOf(z).startsWith("-")){
                        AllValues = (AllValues + String.valueOf(z).substring(1));
                    }else{
                        AllValues = (AllValues + String.valueOf(z));
                    }//end else
                    x = y;
                    y = z;
                }//end i
                
                String StartValues = AllValues.substring(RandFir + RandSec, AllValues.length());
                
                int Start = 0;
                int End = 3;
                int Repeat = (StartValues.length()/3);
                String [] List = new String [Repeat];
                for (int i = 0; i<Repeat; i++){
                    List[i] = StartValues.substring(Start,End);
                    Start = Start+3;
                    End = End+3;
                }//end i
                
                int PlaceHoulder;
                if(RandFir<RandSec){
                    PlaceHoulder = RandFir;
                    RandFir = RandSec;
                    RandSec = PlaceHoulder;
                }//end if
                
                double FirstDiv = RandFir;
                double SecDiv = RandSec;
                double FinalDoub = FirstDiv/SecDiv;
                int DPPos = String.valueOf(FinalDoub).indexOf(".");
                int FinalDivid = (Integer.valueOf(String.valueOf(FinalDoub).substring(DPPos+1,DPPos+2)));
                int Divider;
                if (FinalDivid == 0){
                    Divider = RandFir/RandSec;
                }else{
                    Divider = FinalDivid;
                }//end else
                if (Divider < 1){
                    JOptionPane.showMessageDialog(null, "Dividor is not working");
                    System.exit(0);
                }
                
                int NewAsciiLength = Ascii.length;
                String [] NewAscii = new String [NewAsciiLength];
        
                int NewAsciiCounter = 0;
                int inf = 1;
                int counter = Divider;
                for (int k = 0; k<=inf; k++){
                    int nullcount = 0;
                    for (int i = k; i<=(NewAsciiLength-1); i++){
                        if(Ascii[i] == null){
                            if (k == NewAsciiLength-1){
                                k=0;
                            }else{
                                k++;
                            }
                        }else{
                            i=NewAsciiLength;
                        }//end else
                    }//end i
            
                    if(counter == 0 && (!(Ascii[k]==null))){
                        String NewValue = Ascii[k];
                        if (Ascii[k] == null){
                            JOptionPane.showMessageDialog(null, "Null Error");
                        }
                        NewAscii[NewAsciiCounter] = NewValue;
                        Ascii[k]= null;
                        counter = Divider;
                        NewAsciiCounter++;
                    }else if((!(counter == 0)) && (!(Ascii[k]==null))){
                        counter--;
                    }//end else
                    
                    if(k>=Ascii.length-1){
                        k=-1;
                    }//end if
            
                    for (int L=0; L<=Ascii.length-1; L++){
                        if(Ascii[L]==null){
                            nullcount++;
                        }else{
                            L=Ascii.length-1;
                        }//end if
                    }//end L
            
                    if(nullcount == Ascii.length){
                        inf = k;
                    }else{
                        inf++;
                    }
                }//end k
                
                int StringStart = 0;
                for (int a = 0; a<String.length(); a++){
                    int ValidNumber = 0;
                    int CharaPos = 0;
                    String Charac = String.substring(StringStart,StringStart+1);
                    for (int b = 0; b<NewAscii.length; b++){
                        if (Charac.equals(NewAscii[b])){
                            CharaPos = b;
                            ValidNumber = 1;
                            break;
                        }//end if
                    }//end b
                    if(ValidNumber == 0){
                        JOptionPane.showMessageDialog(null, "Character " + (a+1) + " is not a valid character!");
                        System.exit(0);
                    }
                    int Occurance = 0;
                    int CharaNum = Integer.valueOf(List[CharaPos+a]);
                    for (int c = a ; c < CharaPos+a; c++){
                        if(Integer.parseInt(List[c]) == Integer.valueOf(List[CharaPos+a])){
                            Occurance++;
                        }
                    }//end c
                    
                    double LoopTimesD = 0;
                    String FinalChar;
                    if(CharaNum >= NewAscii.length){
                        LoopTimesD = CharaNum/NewAscii.length;
                        int FinalChara = (CharaNum%NewAscii.length);
                        FinalChar = NewAscii[FinalChara];
                    }else{
                        FinalChar = NewAscii[CharaNum];
                    }//end else
                    if(LoopTimesD >=10){
                            JOptionPane.showMessageDialog(null, "Fatal loop time Error!");
                            System.exit(0);
                    }if(Occurance >=10){
                            JOptionPane.showMessageDialog(null, "Fatal occurance Error!");
                            System.exit(0);
                    }//end if
                        Encrypted = (Encrypted + String.valueOf(Occurance) + ((String.valueOf(LoopTimesD)).substring(0,1)) + String.valueOf(FinalChar));
                    StringStart++;
                }//end a
        return Encrypted;
    }//end get
}
