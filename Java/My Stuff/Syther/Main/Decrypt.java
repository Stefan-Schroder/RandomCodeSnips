
package Main;

import javax.swing.JOptionPane;

public class Decrypt {
    String ToDecrypt = "";
    String Decrypted = "";
    
    public Decrypt(){
    
    }//end constructor
    
    public void setText(String a){
        ToDecrypt = a;
    }//end set
    
    public String GetDecrypted(){
        String Decrypted = ("");
        String[] Ascii = new String[100];
                for (int i = 0; i<= Ascii.length-1; i++){
                    if(i == 127){
                        i++;
                    }//end if
                    int number = i+32;
                    char StrNum = (char)number;
                    Ascii[i] = String.valueOf(StrNum);
                }//end i
                
        String String = ToDecrypt;
        int FibFir = String.charAt(0);
        int FibSec = String.charAt(1);
        
        int x = FibFir;
        int y = FibSec;
        int z = 0;
        int repeatTimes = x+y+String.length()+Ascii.length*3;
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
         String StartValues = AllValues.substring(FibFir + FibSec, AllValues.length());
                
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
         if(FibFir<FibSec){
             PlaceHoulder = FibFir;
             FibFir = FibSec;
             FibSec = PlaceHoulder;
         }//end if
                
         double FirstDiv = FibFir;
         double SecDiv = FibSec;
         double FinalDoub = FirstDiv/SecDiv;
         int DPPos = String.valueOf(FinalDoub).indexOf(".");
         int FinalDivid = (Integer.valueOf(String.valueOf(FinalDoub).substring(DPPos+1,DPPos+2)));
         int Divider = 0;
         if (FinalDivid == 0){
             Divider = (Integer.valueOf(String.valueOf(FinalDoub).substring(0,1)));
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
                
                String [] CharacList = new String[(String.length()-2)/3];
                int CharaSelStart = 2;
                for (int i = 0 ; i<(String.length()-2)/3;i++){
                    CharacList[i] = String.substring(CharaSelStart,CharaSelStart+3);
                    CharaSelStart = CharaSelStart+3;
                }//end i
                
                for (int k=0; k<CharacList.length; k++){
                    int Occurance = Integer.valueOf(CharacList[k].substring(0,1));
                    int LoopTimes = Integer.valueOf(CharacList[k].substring(1,2));
                    String PHChara = String.valueOf(CharacList[k].substring(2));
                    int PHCharaPos = 0;
                    int PHCharaValid = 0;
                    for (int l=0;l<NewAscii.length;l++){
                        if(NewAscii[l].equals(PHChara)){
                            PHCharaPos=l;
                            PHCharaValid = 1;
                        }
                    }//end l
                    if(PHCharaValid == 0){
                        JOptionPane.showMessageDialog(null, "Invalid Character!");
                        System.exit(0);
                    }
                    int FinalCharaNumber = LoopTimes*NewAscii.length + PHCharaPos;
                    int CharacterDistance = 0;
                    for (int m=0; m<=NewAscii.length;m++){
                        if(Integer.valueOf(List[m+k]) == FinalCharaNumber){
                            if(Occurance==0){
                                CharacterDistance=m;
                                m=NewAscii.length;
                            }else{
                                Occurance--;
                            }//end else
                        }//end if
                    }//end m
                    Decrypted = (Decrypted + NewAscii[CharacterDistance]);
                }
        return Decrypted;
    }
}
