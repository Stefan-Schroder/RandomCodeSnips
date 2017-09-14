
/**
 * Test Suite for Collator class.
 * 
 * @author Stephan Jamieson
 * @version 19/7/2016
 */
public class TestUberService {

    private TestUberService() {}

    public static void main(final String[] args) {
   
        // Requirements A, G, H, I, J, K: check setDetails() and observers.
        // Test 1: Check getName()
        System.out.println("Test 1");
        UberService service = new UberService();
        service.setDetails("UberX", 70, 700, 500, 2500); 
        if (service.getName().equals("UberX")) {
            System.out.println("Pass");
        }
        else {
            System.out.println("Fail");
        }
                
        // Test 2: Check getCostPerMinute()
        System.out.println("Test 2");
        service = new UberService();
        service.setDetails("UberX", 70, 700, 500, 2500); 
        if (service.getCostPerMinute()==70) {
            System.out.println("Pass");
        }
        else {
            System.out.println("Fail");
        }
        
        // Test 3: Check getCostPerKilometre().
        System.out.println("Test 3");
        service = new UberService();
        service.setDetails("UberX", 70, 700, 500, 2500); 
        if (service.getCostPerKilometre()==700) {
            System.out.println("Pass");
        }
        else {
            System.out.println("Fail");
        }
        
        // Test 4: Check getBaseFare()
        System.out.println("Test 4");
        service = new UberService();
        service.setDetails("UberX", 70, 700, 500, 2500); 
        if (service.getBaseFare()==500) {
            System.out.println("Pass");
        }
        else {
            System.out.println("Fail");
        }
        
        // Test 5: Check getCancellationFee()
        System.out.println("Test 5");
        service = new UberService();
        service.setDetails("UberX", 70, 700, 500, 2500); 
        if (service.getCancellationFee()==2500) {
            System.out.println("Pass");
        }
        else {
            System.out.println("Fail");
        }

        // Requirements L, M, N, O, P: check getMethods do not change anything.
        // Test 6: Req L, check getName()
        System.out.println("Test 6");
        service = new UberService();
        service.setDetails("UberX", 70, 700, 500, 2500); 
        if (service.getName().equals(service.getName())
            &&service.getCostPerMinute()==70
            &&service.getCostPerKilometre()==700
            &&service.getBaseFare()==500
            &&service.getCancellationFee()==2500)
        {
            System.out.println("Pass");
        }
        else {
            System.out.println("Fail");
        }
                
        // Test 7: Req M, check getCostPerMinute()
        System.out.println("Test 7");
        service = new UberService();
        service.setDetails("UberXL", 70, 700, 500, 2500); 
        if (service.getCostPerMinute()==service.getCostPerMinute()
            &&service.getName().equals("UberXL")
            &&service.getCostPerKilometre()==700
            &&service.getBaseFare()==500
            &&service.getCancellationFee()==2500) 
        {
            System.out.println("Pass");
        }
        else {
            System.out.println("Fail");
        }
        
        // Test 8: req N, check getCostPerKilometre().
        System.out.println("Test 8");
        service = new UberService();
        service.setDetails("UberXL", 70, 700, 500, 2500); 
        if (service.getCostPerKilometre()==700
            &&service.getName().equals("UberXL")
            &&service.getCostPerMinute()==70
            &&service.getBaseFare()==500
            &&service.getCancellationFee()==2500) 
        {
            System.out.println("Pass");
        }
        else {
            System.out.println("Fail");
        }
        
        // Test 9: req O check getBaseFare()
        System.out.println("Test 9");
        service = new UberService();
        service.setDetails("UberX", 70, 700, 500, 2500); 
        if (service.getBaseFare()==500
            &&service.getName().equals("UberX")
            &&service.getCostPerMinute()==70
            &&service.getCostPerKilometre()==700
            &&service.getCancellationFee()==2500) 
        {
            System.out.println("Pass");
        }
        else {
            System.out.println("Fail");
        }
        
        // Test 10: req P, check getCancellationFee()
        System.out.println("Test 10");
        service = new UberService();
        service.setDetails("UberX", 70, 700, 500, 2500); 
        if (service.getCancellationFee()==2500
            &&service.getName().equals("UberX")
            &&service.getCostPerMinute()==70
            &&service.getCostPerKilometre()==700
            &&service.getBaseFare()==500) 
        {
            System.out.println("Pass");
        }
        else {
            System.out.println("Fail");
        }

        // Requirements B, R: check setName() 
        // Test 11: 
        System.out.println("Test 11");
        service = new UberService();
        service.setDetails("UberXL", 70, 700, 2000, 2500); 
        service.setName("UberExtraLarge");
        if (service.getName().equals("UberExtraLarge")
            &&service.getCostPerMinute()==70
            &&service.getCostPerKilometre()==700
            &&service.getBaseFare()==2000
            &&service.getCancellationFee()==2500)
        {
            System.out.println("Pass");
        }
        else {
            System.out.println("Fail");
        }
        
        // Requirements C, S: check setCostPerMinute()
        // Test 12:
        System.out.println("Test 12");
        service = new UberService();
        service.setDetails("UberXL", 70, 700, 2000, 2500); 
        service.setCostPerMinute(17);
        if (service.getCostPerMinute()==17
            &&service.getName().equals("UberXL")
            &&service.getCostPerKilometre()==700
            &&service.getBaseFare()==2000
            &&service.getCancellationFee()==2500)
        {
            System.out.println("Pass");
        }
        else {
            System.out.println("Fail");
        }

        // Requirements D, T: check setCostPerKilometre()
        // Test 13:
        System.out.println("Test 13");
        service = new UberService();
        service.setDetails("UberXL", 70, 700, 500, 2500); 
        service.setCostPerKilometre(633);
        if (service.getCostPerKilometre()==633
            &&service.getName().equals("UberXL")
            &&service.getCostPerMinute()==70
            &&service.getBaseFare()==500
            &&service.getCancellationFee()==2500)
        {
            System.out.println("Pass");
        }
        else {
            System.out.println("Fail");
        }
        
        // Requirements E, U: check setBaseFare()
        // Test 14:
        System.out.println("Test 14");
        service = new UberService();
        service.setDetails("UberXL", 70, 700, 2000, 2500); 
        service.setBaseFare(2300);
        if (service.getBaseFare()==2300
            &&service.getName().equals("UberXL")
            &&service.getCostPerMinute()==70
            &&service.getCostPerKilometre()==700
            &&service.getCancellationFee()==2500)
        {
            System.out.println("Pass");
        }
        else {
            System.out.println("Fail");
        }

        // Requirements F, V: check setCancellationFee()
        // Test 15:
        System.out.println("Test 15");
        service = new UberService();
        service.setDetails("UberXL", 70, 700, 500, 2500); 
        service.setCancellationFee(2300);
        if (service.getCancellationFee()==2300
            &&service.getName().equals("UberXL")
            &&service.getCostPerMinute()==70
            &&service.getCostPerKilometre()==700
            &&service.getBaseFare()==500) 
        {
            System.out.println("Pass");
        }
        else {
            System.out.println("Fail");
        }

        // Requirement Q: check calculateFare()
        // Test 16:
        System.out.println("Test 16");
        service = new UberService();
        service.setDetails("UberX", 70, 700, 500, 2500); 

        double EPSILON = 0.0000001;
        
        if (Math.abs(service.calculateFare(3.0, 7.0)-28710.0)<EPSILON) {
            System.out.println("Pass");
        }
        else {
            System.out.println("Fail"+service.calculateFare(3.0, 7.0));
        }


        // Requirement W: check calculateFare() ONLY calculates the fare.
        // Test 17:
        System.out.println("Test 17");
        service = new UberService();
        service.setDetails("UberX", 70, 700, 500, 2500); 
        
        if (Math.abs(service.calculateFare(3.0, 7.0)-28710.0)<EPSILON
            &&service.getName().equals("UberX")
            &&service.getCostPerMinute()==70
            &&service.getCostPerKilometre()==700
            &&service.getBaseFare()==500
            &&service.getCancellationFee()==2500)
        {
            System.out.println("Pass");
        }
        else {
            System.out.println("Fail");
        }
    }  
}
