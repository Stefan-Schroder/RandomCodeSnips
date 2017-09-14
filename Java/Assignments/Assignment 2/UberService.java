import java.text.NumberFormat;
import java.text.DecimalFormat;
class UberService{
        private String name;
        private int costPerMin;
        private int costPerKM;
        private int baseFee;
        private int cancellationFee;
        private NumberFormat formatter;
		
        public void setDetails(String Name, int costPerMin, int costPerKM,int baseFee,int cancellationFee){
                this.name = Name;
                this.costPerMin = costPerMin;
                this.costPerKM = costPerKM;
                this.baseFee = baseFee;
                this.cancellationFee = cancellationFee;
				this.formatter  = new DecimalFormat(0.00);
        }
         
        public void setName(String Name){
                name = Name;
        }
        
        public String getName(){
                return name;
        }
        
        public void setCostPerMinute(int cost){
                costPerMin = cost;
        }
        
        public int getCostPerMinute(){
                return costPerMin;
        }
        
        public void setCostPerKilometre(int cost){
                costPerKM = cost;
        }
        
        public int getCostPerKilometre(){
                return costPerKM;
         }
         
         public void setBaseFare(int cost){
                baseFee = cost;
         }
         
         public int getBaseFare(){
                return baseFee;
         }
         
         public void setCancellationFee(int cost){
                cancellationFee = cost;
         }
         
         public int getCancellationFee(){
                return cancellationFee;
         }
         
         public double calculateFare(double minutes, double distance){
                double answer = (double)baseFee+(double)costPerKM*distance+(double)costPerMin*minutes;
                return (double)formatter.format(answer);
        }
}