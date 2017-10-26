package MS_LCG;

public class Evaluator {

    private int count;  //numarul de puncte din sfertul de cerc
    private final double pi = 3.14;
    private int nrPctPatrat = 10000;
    private int choose = 3;

    private MiddleSquare mso = new MiddleSquare(567496);
    private MiddleSquare mso2 = new MiddleSquare(451264);

    private Lcg lcgo = new Lcg(1,61,19,10000, 4);
    private Lcg lcgo2 = new Lcg(11,21,13,10000, 4);

    private DefaultGenerator dgo = new DefaultGenerator();
    private DefaultGenerator dgo2 = new DefaultGenerator();


    public Evaluator(int nrPctPatrat, int choose)
    {
        this.nrPctPatrat = nrPctPatrat;
        this.choose = choose;
    }

    public float accuracy()
    {
        float x = (float) 1;
        float y = (float) 11;
        float accuracy=(float)66;

        for( int i=0; i<nrPctPatrat; ++i)
        {
            if (1 == choose)
            {
                x = mso.NextSeed();
                //System.out.println("x = " + x);
                y = mso2.NextSeed();
                //System.out.println("y = " + y);

            }
            else if (2 == choose)
            {
                x = lcgo.NextSeed();
                //System.out.println(x);
                y = lcgo2.NextSeed();
                //System.out.println(y);

            }
            else if (3 == choose)
            {
                x = dgo.NextSeed();
                //System.out.println("x = " + x);
                y = dgo2.NextSeed();
                //System.out.println("y = " + y);

            }

            if (x*x + y*y <= 1)
            {
                count++;
            }
        }

        accuracy = (float) (count/2500);
        System.out.println(pi - accuracy);
        return accuracy;
    }

}
