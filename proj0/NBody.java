public class NBody{
	public static double readRadius(String s){
		In in = new In(s);
		int x = in.readInt();
		return in.readDouble();
	}
	public static Planet[] readPlanets(String s){
		In in = new In(s);
		int i = 0;
		int numbers = in.readInt();
		double xx = in.readDouble();
		Planet[] pl = new Planet[numbers];
		while(i < numbers){
			double x1=in.readDouble();
			double x2=in.readDouble();
			double x3=in.readDouble();
			double x4=in.readDouble();
			double x5=in.readDouble();
			String x6=in.readString();
			pl[i] = new Planet(x1,x2,x3,x4,x5,x6);
			i = i+1;
		}
		return pl;
	}
	public static void main(String[] args){
		double tt = 0;
		double T = Double.parseDouble(args[0]);
		double dt = Double.parseDouble(args[1]);
		String filename = args[2];
		double scale = readRadius(filename);
		Planet[] pls = readPlanets(filename);
		StdDraw.setScale(-scale, scale);
		String field = "./images/starfield.jpg";
		/*StdDraw.enableDoubleBuffering();*/
		System.out.println(scale);
		double[] xForces = new double[pls.length];
		double[] yForces = new double[pls.length];
		/*int i =0;
		while(i<pls.length){
			pls[i].draw();
			i = i+1;
		}*/
		while(tt<T){
			
			StdDraw.enableDoubleBuffering();
			StdDraw.clear();
			StdDraw.picture(0, 0, field,2*scale,2*scale);
			int j = 0;
			while(j<pls.length){
				pls[j].draw();
				xForces[j] = pls[j].calcNetForceExertedByX(pls);
				yForces[j] = pls[j].calcNetForceExertedByY(pls);
				j = j+1;
			}
			j = 0 ;
			while(j < pls.length){
				pls[j].update(dt,xForces[j],yForces[j]);
				j = j+1;
			}
			StdDraw.show();
			StdDraw.pause(1);
			tt = tt + dt;

		}
		System.out.println(pls.length);
		System.out.println(scale);
		for(int k = 0;k < pls.length;k++){
			System.out.print(String.valueOf(pls[k].xxPos));
			System.out.print("  " + String.valueOf(pls[k].yyPos));
			System.out.print("  " + String.valueOf(pls[k].xxVel));
			System.out.print("  " + String.valueOf(pls[k].yyVel));
			System.out.print("  " + String.valueOf(pls[k].mass));
			System.out.println("  " + pls[k].imgFileName);
		}
	}
}

