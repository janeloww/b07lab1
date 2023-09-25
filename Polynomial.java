public class Polynomial{
    double[] coeff;

    public Polynomial(){ //no-arg constructor
    }
    public Polynomial(double[] arr){
        int n = arr.length;
        this.coeff = new double[n];
        for(int i= 0;i<arr.length;i++){
            this.coeff[i] = arr[i];
        }
    }
    public Polynomial add(Polynomial poly){
        //initialize a new poly and set it to the given argument
        Polynomial added = poly;

        // determine length of shortest poly
    
        int shortest = this.coeff.length;
        if(poly.coeff.length <= this.coeff.length){
            shortest = poly.coeff.length;
            added = new Polynomial(this.coeff); // now the one we want to add to is the longest poly
            //case 1: add the polys but only up to the length of the shortest poly
            for(int i=0;i<shortest;i++){
                added.coeff[i] += poly.coeff[i];
            }
        }

        // case 2: add the polys but only up to the length of the shortest poly
        for(int i=0;i<shortest;i++){
            added.coeff[i] += this.coeff[i];
        }
        
        return added;
    }
    public double evaluate(double x){
        double result = 0;
        if(this.coeff != null){
            for(int i=0;i<this.coeff.length;i++){
            result += (Math.pow(x, i)*this.coeff[i]);
            }
        }
        
        return result;
    }
    public boolean hasRoot(double is_root){
        double root = evaluate(is_root);
        
        if(root == 0){
            return true;
        }
        return false;
    }
}