
/**
 * 
 * A Collator object manages information on a sequence of readings. 
 * It records the number of readings, the maximum, then minimum, and the average.
 * 
 * @author Stephan Jamieson
 * @version 19/07/2016
 */
public class Collator
{
    private String label;
    
    private int numReadings;
    private int total;
    private int maximum;
    private int minimum;

    Collator(String label) {
        this.label = label;
        numReadings = 0;
        total = 0;
        maximum = 0;
        minimum = 0; 
    }

    void label(String label) { 
        this.label = label;
    }
    
    String label() { return label; }
    
    void recordReading(int reading) {
        if (numReadings<1) {
            // This must be the first reading
            total = reading;
            maximum = reading;
            minimum = reading;
            numReadings = 1;
        }
        else {
            // Update total and number of readings.
            total = total+reading;
            numReadings++;
            
            // Check for a new maximum
            if (reading>maximum) {
                maximum = reading;
            }

            // Check for a new minimum
            if (reading<minimum) {
                minimum = reading;
            }
        } 
    }
    public int maximum() {
            return maximum;
    }

    public int minimum() {
            return minimum;
    }
    
    public double average() {
            return total/(double)numReadings;
    }
    
    public int numberOfReadings() { return numReadings; } 

}

