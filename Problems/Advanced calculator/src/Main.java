/* Please, do not rename it */
class Problem {

    public static void main(String[] args) {
        String operator = args[0];
        int[] newmass = new int[args.length-1];
        for (int i=1,j=0;i<args.length;i++,j++){
            newmass[j]=Integer.parseInt(args[i]);
        }
        int max=Integer.MIN_VALUE, min=Integer.MAX_VALUE, sum=0;
        switch (operator){
            case "MAX": {
                for (int i = 0; i < newmass.length; i++) {
                    if (newmass[i] > max) max = newmass[i];
                }
                System.out.println(max);
                break;
            }
            case "MIN":{
                for (int i = 0; i < newmass.length; i++) {
                    if (newmass[i] < min) min = newmass[i];
                }
                System.out.println(min);
                break;
            }
            case "SUM":{
                for (int i = 0; i < newmass.length; i++) {
                    sum+=newmass[i];
                }
                System.out.println(sum);
                break;
            }
        }
    }
}