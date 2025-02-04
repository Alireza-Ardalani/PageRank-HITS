//Alireza Ardalani (4607)


import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;

public class pgrk4607 {
	public static void main(String[] args) {
		int input1 = 0;
		int input2 = -1;
		String input3 = "A.txt";
		
		input1 = Integer.parseInt(args[0]);
		input2 = Integer.parseInt(args[1]);
		input3 = args[2];
		
		
		URL path = pgrk4607.class.getResource(input3);
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
        
        int [][] inputGraph = new int[nodes][nodes];
        for (int i = 1 ; i <= lineNumber ;  i ++) {
        	
    		String[] data = inputData[i].split(" ");
       	 	int node1 =  Integer.valueOf(data[0]);
       	    int node2 = Integer.valueOf(data[1]);
       	    inputGraph[node1][node2] = 1;
        }
        
        int [] outD = new int[nodes];
        int [] inD = new int[nodes];
        double [] PP = new double[nodes];
        double d = 0.85;
        
        
        if(nodes <= 10) {
        	String print = "Base: 0  :";
            if(input2==0) {
                for (int i=0; i < nodes; i ++) {
                	PP[i] = 0.00;
                	print = print + "P[" + i + "]" + " = " + round(PP[i]) + "  ";
                }
            	
            }
            else if(input2==1) {
            	
                for (int i=0; i < nodes; i ++) {
                	PP[i] = 1.00;
                	print = print + "P[" + i + "]" + " = " + round(PP[i]) + "  ";
                }
            	
            }
            else if(input2 == -1) {
            	double y = 1 ;
            	double x = 0;
            	x = y / nodes;
            	
                for (int i=0; i < nodes; i ++) {
                	PP[i] = x;
                	print = print + "P[" + i + "]" + " = " + round(PP[i]) + "  ";
                }
            	
            }
            else if(input2 == -2) {
            	double y = 1 ;
            	double x = 0;
            	x = y / Math.sqrt(nodes);
            	
                for (int i=0; i < nodes; i ++) {
                	PP[i] = y;
                	print = print + "P[" + i + "]" + " = " + round(PP[i]) + "  ";
                }
            }
            
            System.out.println(print);
            
            for (int i=0; i < nodes; i ++) {
            	int outDegree = 0;
            	int InDegree = 0;
            	for(int j=0; j < nodes; j ++) {
            		outDegree = outDegree + inputGraph[i][j];
            		InDegree = InDegree + inputGraph[j][i];
            	}
            	outD[i] = outDegree;
            	inD[i] = InDegree;
            }
            
            int Base = 1;
            while(true) {
            	double [] PPTemp = new double[nodes];
            	for(int i=0; i < nodes; i ++) {
            		double sume = 0;
            		for (int j=0; j < nodes; j ++) {
            			if(inputGraph[j][i] == 1) {
            				sume = sume + (PP[j]/outD[j]);
            			}	
            		}
            		PPTemp[i] = ((1-d)/nodes) + d*(sume);
            	}
            	
            	String print1 ="";
            	if(Base <=9) {
            		 print1 = "Iter: " + Base + "  :";
            	}
            	else {
            		 print1 = "Iter: " + Base + " :";
            	}
            	
            	for(int i = 0; i< nodes; i ++) {
            		//PP[i] = PPTemp[i];
            		print1 = print1 + "P[" + i + "]" + " = " + round(PPTemp[i]) + "  ";
            	}
            	System.out.println(print1);
            	
            	if(input1 >= 1) {
                	if(Base >= input1) {
                		break;
                	}
            		
            	}
            	if (input1 == 0) {
            		double error = Math.pow(10, -5);
            		
                    boolean Finish = true;
                    for (int i=0; i<nodes; i++) {
                    	if( (Math.abs(PPTemp[i] - PP[i]) > error)){
                    		Finish = false;
                    	}
                    }
                    
                    if(Finish) {
                    	break;
                    }
            		
            	}
            	if(input1 < 0) {
            		double error = Math.pow(10, input1);
            		
                    boolean Finish = true;
                    for (int i=0; i<nodes; i++) {
                    	if( (Math.abs(PPTemp[i] - PP[i]) > error)){
                    		Finish = false;
                    	}
                    }
                    
                    if(Finish) {
                    	break;
                    }
            		
            	}
            	
            	
            	for(int i = 0; i< nodes; i ++) {
            		PP[i] = PPTemp[i];
            		//print1 = print1 + "P[" + i + "]" + " = " + round(PPTemp[i]) + "  ";
            	}
            	Base++;
            }
        	
        }
        else {
        	double y = 1 ;
        	double x = 0;
        	x = y / nodes;
        	
            for (int i=0; i < nodes; i ++) {
            	PP[i] = x;
            }
            
            for (int i=0; i < nodes; i ++) {
            	int outDegree = 0;
            	int InDegree = 0;
            	for(int j=0; j < nodes; j ++) {
            		outDegree = outDegree + inputGraph[i][j];
            		InDegree = InDegree + inputGraph[j][i];
            	}
            	outD[i] = outDegree;
            	inD[i] = InDegree;
            }
        	
            int Base = 1;
            while(true) {
            	double [] PPTemp = new double[nodes];
            	for(int i=0; i < nodes; i ++) {
            		double sume = 0;
            		for (int j=0; j < nodes; j ++) {
            			if(inputGraph[j][i] == 1) {
            				sume = sume + (PP[j]/outD[j]);
            			}	
            		}
            		PPTemp[i] = ((1-d)/nodes) + d*(sume);
            	}
            	
            	            	
            	double error = Math.pow(10, -5);
                boolean Finish = true;
                    for (int i=0; i<nodes; i++) {
                    	if( (Math.abs(PPTemp[i] - PP[i]) > error)){
                    		Finish = false;
                    	}
                    }
                    
                    if(Finish) {
                    	
                    	System.out.println("Iter: " + Base );
                    	for(int i = 0; i< nodes; i ++) {
                    		//PP[i] = PPTemp[i];
                    		System.out.println("P[" + i + "]" + " = " + round(PPTemp[i]));
                    		
                    	}
                    	break;
                    }

            	for(int i = 0; i< nodes; i ++) {
            		PP[i] = PPTemp[i];
            	}
            	Base++;
            }
        }
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
