/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package palmPrint;

public class GaussianKernel {
    
    public static double[][] calculateGaussian(int len, double weight) {
        double kernel[][] = new double[len][len];
        int radius = len / 2;
        double a = -2.0 * radius * radius / Math.log10(weight);
        double sum = 0.0;
        for (int y = 0; y < len; y++) {
            for (int x = 0; x < len; x++) {
                //gaussian formula
                double dist = Math.sqrt((x - radius) * (x - radius) + (y - radius) * (y - radius));
                kernel[y][x] = Math.exp(-dist * dist / a);
                sum += kernel[y][x];
            }
        }
        //for Kernel-Sum of 1.0
        for (int y = 0; y < len; y++)
        {
            for (int x = 0; x < len; x++)
            {
                kernel[y][x] /= sum;
            }
        }  
        //returning 25 kernel values
        return kernel;
    }
    
}
