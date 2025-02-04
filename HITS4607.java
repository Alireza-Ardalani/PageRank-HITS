//Alireza Ardalani (4607)


import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.net.URL;

public class hits4607 {
	public static void main(String[] args) {
		int input1 = 15;
		int input2 = 1;
		String input3 = "A.txt";
		
		input1 = Integer.parseInt(args[0]);
		input2 = Integer.parseInt(args[1]);
		input3 = args[2];

		
		URL path = hits4607.class.getResource(input3);
		File file = new File(path.getFile());
		int lineNumber = -1 ;
		int nodes = 0;
		int edges = 0;
		String[] inputData = new String[100001];

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = br.readLine()) != null) {
            	lineNumber++;
            	inputData[lineNumber] = line;
            	if(lineNumber == 0) {
            		String[] data = line.split(" ");
               	 	nodes =  Integer.valueOf(data[0]);
               	 	edges = Integer.valueOf(data[1]);	
            	}
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        double [][] inputGraph = new double[nodes][nodes];
        double [][] inputReverse = new double[nodes][nodes];
        double [] A = new double[nodes];
        double [] H = new double[nodes];
        
        for (int i = 1 ; i <= lineNumber ;  i ++) {
        	
    		String[] data = inputData[i].split(" ");
       	 	int node1 =  Integer.valueOf(data[0]);
       	    int node2 = Integer.valueOf(data[1]);
       	    inputGraph[node1 ][node2 ] = 1.000000;
       	    inputReverse[node2][node1  ] = 1.000000;

        }
        if(nodes <=10) {
            if(input2 == 0) {
                for (int i = 0 ; i < nodes-1; i ++) {
                	A[i] = 0;
                	H[i] = 0;
         
                }
                String print = "Base:  0 :";
                for (int i = 0 ; i < nodes; i ++){
                	print = print + "A/H" + "[ " + i + " ]" + " = " + "0.0000000" + "/" + "0.0000000" + "  ";
                }
                System.out.println(print);
            	
            }
            else if(input2 == 1 ) {
                for (int i = 0 ; i < nodes; i ++) {
                	A[i] = 1;
                	H[i] = 1;
                }
            String print = "Base:  0 :";
            for (int i = 0 ; i < nodes; i ++){
            	print = print + "A/H" + "[ " + i + " ]" + " = " + "1.0000000" + "/" + "1.0000000" + "  ";
            }
            System.out.println(print);
            }
    	
            else if(input2 == -1) {
            	double y = 1 ;
            	double x = 0;
            	x = y / nodes;
            	
                for (int i = 0 ; i < nodes; i ++) {
                	A[i] = (x);
                	H[i] = (x);
                }
                String print = "Base:  0 :";
                for (int i = 0 ; i < nodes; i ++){
                	print = print + "A/H" + "[ " + i + " ]" + " = " + round(A[i]) + "/" + round(H[i]) + "  ";
                }
                System.out.println(print);
                }
            else if(input2 == -2) {
            	double y = 1 ;
            	double x = 0;
            	x = y / Math.sqrt(nodes);
            	
                for (int i = 0 ; i < nodes; i ++) {
                	A[i] = (x);
                	H[i] = (x);
                }
                String print = "Base: 0  :";
                for (int i = 0 ; i < nodes; i ++){
                	print = print + "A/H" + "[ " + i + " ]" + " = " + round(A[i]) + "/" + round(H[i]) + "  ";
                }
                System.out.println(print);
            	
            }
            
            if(input1 > 0) {
                int Iteration = input1;
                int j = 1;
        		while (j  <= Iteration){
                	A = Multiple(inputReverse,H,nodes);
                	H = Multiple(inputGraph,A,nodes);
                	
                	double AA1 = 0.0;
                	for (int x = 0;  x < nodes; x ++) {
                		AA1 = AA1 + (A[x]*A[x]);
                	}
                	for (int x = 0;  x < nodes; x ++) {
                		A[x] = A[x]/Math.sqrt(AA1);
                	}
                	double HH1 = 0.0;
                	for (int x = 0;  x < nodes; x ++) {
                		HH1 = HH1 + (H[x]*H[x]);
                	}
                	for (int x = 0;  x < nodes; x ++) {
                		H[x] = H[x]/Math.sqrt(HH1);
                	}
                	
                    String print1 = "";
                    if( j <= 9 ) {
                    	print1 = "Base:  " + j + " :";
                    }
                    else {
                    	print1 = "Base: " + j + " :";
                    }
                    
                    for (int i = 0 ; i < nodes; i ++){
                    	//round(200.3456, 2); 
                    	print1 = print1 + "A/H" + "[ " + i + " ]" + " = " + round(A[i]) + "/" + round(H[i]) + "  ";
                    }
                    System.out.println(print1);
                    j++;
                }
            	
            	
            }
            else if (input1 ==0 ) {
            	double error = Math.pow(10, -5);
                double [] A_1 = new double[nodes];
                double [] H_1 = new double[nodes];
                int j =1;
                
            	while(true) {
            		A_1 = A;
            		H_1 = H;
                	A = Multiple(inputReverse,H,nodes);
                	H = Multiple(inputGraph,A,nodes);
                	
                	double AA1 = 0.0;
                	for (int x = 0;  x < nodes; x ++) {
                		AA1 = AA1 + (A[x]*A[x]);
                	}
                	for (int x = 0;  x < nodes; x ++) {
                		A[x] = A[x]/Math.sqrt(AA1);
                	}
                	double HH1 = 0.0;
                	for (int x = 0;  x < nodes; x ++) {
                		HH1 = HH1 + (H[x]*H[x]);
                	}
                	for (int x = 0;  x < nodes; x ++) {
                		H[x] = H[x]/Math.sqrt(HH1);
                	}
                	
                    String print1 = "";
                    if( j <= 9 ) {
                    	print1 = "Base:  " + j + " :";
                    }
                    else {
                    	print1 = "Base: " + j + " :";
                    }
                    
                    for (int i = 0 ; i < nodes; i ++){ 
                    	print1 = print1 + "A/H" + "[ " + i + " ]" + " = " + round(A[i]) + "/" + round(H[i]) + "  ";
                    }
                    System.out.println(print1);
                    j++;
                    
                    boolean Finish = true;
                    for (int i=0; i<nodes; i++) {
                    	if( (Math.abs(A_1[i] - A[i]) > error) || (Math.abs(H_1[i] - H[i]) > error) ){
                    		Finish = false;
                    	}
                    }
                    
                    if(Finish) {
                    	break;
                    }
                    
                }
            	
            }
            else if (input1 < 0) {
            	double error = Math.pow(10, input1);
                double [] A_1 = new double[nodes];
                double [] H_1 = new double[nodes];
                int j =1;
                
            	while(true) {
            		A_1 = A;
            		H_1 = H;
                	A = Multiple(inputReverse,H,nodes);
                	H = Multiple(inputGraph,A,nodes);
                	
                	double AA1 = 0.0;
                	for (int x = 0;  x < nodes; x ++) {
                		AA1 = AA1 + (A[x]*A[x]);
                	}
                	for (int x = 0;  x < nodes; x ++) {
                		A[x] = A[x]/Math.sqrt(AA1);
                	}
                	double HH1 = 0.0;
                	for (int x = 0;  x < lineNumber; x ++) {
                		HH1 = HH1 + (H[x]*H[x]);
                	}
                	for (int x = 0;  x < nodes; x ++) {
                		H[x] = H[x]/Math.sqrt(HH1);
                	}
                	
                    String print1 = "";
                    if( j <= 9 ) {
                    	print1 = "Base:  " + j + " :";
                    }
                    else {
                    	print1 = "Base: " + j + " :";
                    }
                    
                    for (int i = 0 ; i < nodes; i ++){ 
                    	print1 = print1 + "A/H" + "[ " + i + " ]" + " = " + round(A[i]) + "/" + round(H[i]) + "  ";
                    }
                    System.out.println(print1);
                    j++;
                    
                    boolean Finish = true;
                    for (int i=0; i<nodes; i++) {
                    	if( (Math.abs(A_1[i] - A[i]) > error) || (Math.abs(H_1[i] - H[i]) > error) ){
                    		Finish = false;
                    	}
                    }
                    
                    if(Finish) {
                    	break;
                    }
                    
                }
            		
            	}
        	
        }
        else {
        	double y = 1 ;
        	double dx = 0;
        	dx = y / nodes;
        	
            for (int i = 0 ; i < nodes; i ++) {
            	A[i] = (dx);
            	H[i] = (dx);
            }
            double error = Math.pow(10, -5);
            double [] A_1 = new double[nodes];
            double [] H_1 = new double[nodes];
            int j =1;
            
        	while(true) {
        		A_1 = A;
        		H_1 = H;
            	A = Multiple(inputReverse,H,nodes);
            	H = Multiple(inputGraph,A,nodes);
            	
            	double AA1 = 0.0;
            	for (int x = 0;  x < nodes; x ++) {
            		AA1 = AA1 + (A[x]*A[x]);
            	}
            	for (int x = 0;  x < nodes; x ++) {
            		A[x] = A[x]/Math.sqrt(AA1);
            	}
            	double HH1 = 0.0;
            	for (int x = 0;  x < nodes; x ++) {
            		HH1 = HH1 + (H[x]*H[x]);
            	}
            	for (int x = 0;  x < nodes; x ++) {
            		H[x] = H[x]/Math.sqrt(HH1);
            	}
            	
                j++;
                
                boolean Finish = true;
                for (int i=0; i<nodes; i++) {
                	if( (Math.abs(A_1[i] - A[i]) > error) || (Math.abs(H_1[i] - H[i]) > error) ){
                		Finish = false;
                	}
                }
                
                if(Finish) {
                
                	System.out.println("Iter:  " + j); 
                    for (int i = 0 ; i < nodes; i ++){
                    	System.out.println("A/H" + "[ " + i + " ]" + " = " + round(A[i]) + "/" + round(H[i]));
                    }
                    
                	break;
                }
                
                j++;
            }
        }

      }
       
	static double[] Multiple(double[][] X, double[] Y,int N) {
		double[] outPut = new double[N+1]; 
		for (int i = 0 ; i< N ; i++) {
			double Sume = 0;
			for(int j = 0 ; j< N ; j++) {
				Sume = Sume + X[i][j] * Y[j];
			}
			outPut[i] = Sume;
		}
		
	return outPut;	
	}
	
	public static String round(double input) {
		 // Convert the double to BigDecimal
	    long factor = (long) Math.pow(10, 7);
	    input = input * factor;
	    long tmp = Math.round(input);
	    double X =  (double) tmp / factor;

        String roundedString = Double.toString(X);
        
        if(roundedString.indexOf('E') != -1) {
        	//roundedString = roundedString.substring(0,roundedString.indexOf('E'));
        	String Str = roundedString.substring(roundedString.indexOf("E-")+2);
        	String Str2 = roundedString.substring(0,roundedString.indexOf("E-"));
        	int pow = Integer.valueOf(Str);
        	String finall = "0.";
        	for(int i =1 ; i<pow; i++) {
        		finall = finall + "0";
        	}
        	String[] XX = Str2.split("\\.");
        	for (String i : XX) {
        		
        		finall = finall + i;
        	}
        	//System.out.println(finall);
        	roundedString = finall;
        }
        
        while(roundedString.length()<=8) {
        	roundedString = roundedString + "0";
        }
        // Convert back to double
        return roundedString;
	}
}
