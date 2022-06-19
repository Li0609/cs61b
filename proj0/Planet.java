public class Planet{
	public double xxPos;
	public double yyPos;
	public double xxVel;
	public double yyVel;
	public double mass;
	public String imgFileName;
	public Planet(double xP, double yP, double xV,
              double yV, double m, String img){
			xxPos=xP;
			yyPos = yP;
			xxVel = xV;
			yyVel = yV;
			mass = m;
			imgFileName =img;
	}
	public Planet(Planet p){
		xxPos=p.xxPos;
		yyPos = p.yyPos;
		xxVel = p.xxVel;
		yyVel = p.yyVel;
		mass = p.mass;
		imgFileName =p.imgFileName;
	}
	public double calcDistance(Planet pl){
		double dx = this.xxPos - pl.xxPos;
		double dy = this.yyPos - pl.yyPos;
		double r2 = dx*dx + dy*dy;
		return Math.sqrt(r2);
	}
	public double calcForceExertedBy(Planet pl){
		double g = 6.67e-11;
		double rs = this.calcDistance(pl) * this.calcDistance(pl);
		double f = g * this.mass * pl.mass / rs;
		return f;
	}
	public double calcNetForceExertedByX(Planet[] pl){
		int i =0;
		double sum =0;
		while(i<pl.length){
			if(this.equals(pl[i])){
				sum =sum;
			}else{
				sum=sum + this.calcForceExertedBy(pl[i]) * (-this.xxPos + pl[i].xxPos) /this.calcDistance(pl[i]);
			}
			i = i+1;
		}
		return sum;
	}
	public double calcNetForceExertedByY(Planet[] pl){
		int i =0;
		double sum =0;
		while(i<pl.length){
			if(this.equals(pl[i])){
				sum =sum;
			}else{
				sum =sum + this.calcForceExertedBy(pl[i]) * (-this.yyPos + pl[i].yyPos) /this.calcDistance(pl[i]);
			}
			i=i+1;
		}
		return sum;
	}
	public void update(double dt,double fX,double fY){
		double ax = fX / this.mass;
		double ay = fY /this.mass;
		this.xxVel = this.xxVel + ax * dt;
		this.yyVel = this.yyVel + ay * dt;
		this.xxPos = this.xxPos + this.xxVel * dt;
		this.yyPos = this.yyPos + this.yyVel * dt;
	}
	public void draw(){
		StdDraw.picture(this.xxPos,this. yyPos,"./images/"+this.imgFileName);
	}
}