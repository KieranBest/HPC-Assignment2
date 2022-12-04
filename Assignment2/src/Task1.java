public class Task1 {
	public static void main(String[] args) {
		
		int arraySize=10;
		
		System.out.println("Matrix");
		int[][] matrix = new int[arraySize][arraySize];
		int column = 0;
		int row = 0;
		for(row = 0; row <= matrix.length - 1; row++) {
			for (column = 0; column <= matrix.length - 1; column++) {
				matrix[row][column] = (int) (Math.random() * 10);
				System.out.print(matrix[row][column] + ",");
			}
		System.out.println("");
		}

		System.out.println("");
	

		System.out.println("Blur Kernel");
		int[][] blurKernel = new int[][] {
			new int[] {1,1,1},
			new int[] {1,1,1},
			new int[] {1,1,1}
		};
		for(row = 0; row <= blurKernel.length -1; row++) {
			for (column = 0; column <= blurKernel.length - 1; column++) {
				System.out.print(blurKernel[row][column]+",");
			}
			System.out.println("");
		}
		int sumDivideNumberBlur=blurKernel.length*blurKernel.length;
		System.out.println("");
		
		System.out.println("Blur");
		int[][] blurMatrix = new int [arraySize][arraySize];
		
		for(row = 0; row <= blurMatrix.length -1; row++) {
			for (column = 0; column <= blurMatrix.length - 1; column++) {
				int startingRow = row-1;
				int startingColumn = column-1;
				int blurSum = 0;
				if(row>0 && row<blurMatrix.length-1 && column>0 && column<blurMatrix.length-1) {
					for(int r = 0; r <= blurKernel.length -1; r++) {
						for (int c = 0; c <= blurKernel.length - 1; c++) {
							blurSum += blurKernel[r][c]*matrix[startingRow+r][startingColumn+c];
						}
					}
					blurMatrix[row][column] = blurSum/sumDivideNumberBlur;
				}else{
					for(int r = 0; r <= blurKernel.length -1; r++) {
						for (int c = 0; c <= blurKernel.length - 1; c++) {
							if(startingRow+r < 0 || startingColumn+c < 0 || startingRow+r > 9 || startingColumn+c > 9) {
								blurSum += blurKernel[r][c]*0;
							}else {
								blurSum += blurKernel[r][c]*matrix[startingRow+r][startingColumn+c];
							}
						}
					}
					blurMatrix[row][column] = blurSum/sumDivideNumberBlur;
					
				}
				System.out.print(blurMatrix[row][column] + ",");
			}
			System.out.println("");
		}
		
		System.out.println("");
		System.out.println("Sharpen Kernel");
		double[][] sharpenKernel = new double[][] {
			new double[] {0,-0.5,0},
			new double[] {-0.5,3,-0.5},
			new double[] {0,-0.5,0}
		};
		for(row = 0; row <= blurKernel.length -1; row++) {
			for (column = 0; column <= sharpenKernel.length - 1; column++) {
				System.out.print(sharpenKernel[row][column]+",");
			}
			System.out.println("");
		}
		System.out.println("");

		System.out.println("Sharpen");
		double[][] sharpenMatrix = new double [arraySize][arraySize];

		for(row = 0; row <= sharpenMatrix.length -1; row++) {
			for (column = 0; column <= sharpenMatrix.length - 1; column++) {
				int startingRow = row-1;
				int startingColumn = column-1;
				double sharpenSum = 0;
				if(row>0 && row<sharpenMatrix.length-1 && column>0 && column<sharpenMatrix.length-1) {
					for(int r = 0; r <= sharpenKernel.length -1; r++) {
						for (int c = 0; c <= sharpenKernel.length - 1; c++) {
							sharpenSum = sharpenSum + (sharpenKernel[r][c]*matrix[startingRow+r][startingColumn+c]);
						}
					}
					sharpenMatrix[row][column] = sharpenSum;
				}else{
					for(int r = 0; r <= sharpenKernel.length -1; r++) {
						for (int c = 0; c <= sharpenKernel.length - 1; c++) {
							if(startingRow+r < 0 || startingColumn+c < 0 || startingRow+r > 9 || startingColumn+c > 9) {
								sharpenSum += sharpenKernel[r][c]*0;
							}else {
								sharpenSum += sharpenKernel[r][c]*matrix[startingRow+r][startingColumn+c];
							}
						}
					}
					sharpenMatrix[row][column] = sharpenSum;
				}
				System.out.print(sharpenMatrix[row][column] + ",");
			}
			System.out.println("");
		}
	}
}
