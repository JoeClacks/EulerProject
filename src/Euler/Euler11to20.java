/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Euler;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.TreeMap;

/**
 *
 * @author joe
 */
public class Euler11to20 {

    public static void Problem11() {
        String s = "08 02 22 97 38 15 00 40 00 75 04 05 07 78 52 12 50 77 91 08\n"
                + "49 49 99 40 17 81 18 57 60 87 17 40 98 43 69 48 04 56 62 00\n"
                + "81 49 31 73 55 79 14 29 93 71 40 67 53 88 30 03 49 13 36 65\n"
                + "52 70 95 23 04 60 11 42 69 24 68 56 01 32 56 71 37 02 36 91\n"
                + "22 31 16 71 51 67 63 89 41 92 36 54 22 40 40 28 66 33 13 80\n"
                + "24 47 32 60 99 03 45 02 44 75 33 53 78 36 84 20 35 17 12 50\n"
                + "32 98 81 28 64 23 67 10 26 38 40 67 59 54 70 66 18 38 64 70\n"
                + "67 26 20 68 02 62 12 20 95 63 94 39 63 08 40 91 66 49 94 21\n"
                + "24 55 58 05 66 73 99 26 97 17 78 78 96 83 14 88 34 89 63 72\n"
                + "21 36 23 09 75 00 76 44 20 45 35 14 00 61 33 97 34 31 33 95\n"
                + "78 17 53 28 22 75 31 67 15 94 03 80 04 62 16 14 09 53 56 92\n"
                + "16 39 05 42 96 35 31 47 55 58 88 24 00 17 54 24 36 29 85 57\n"
                + "86 56 00 48 35 71 89 07 05 44 44 37 44 60 21 58 51 54 17 58\n"
                + "19 80 81 68 05 94 47 69 28 73 92 13 86 52 17 77 04 89 55 40\n"
                + "04 52 08 83 97 35 99 16 07 97 57 32 16 26 26 79 33 27 98 66\n"
                + "88 36 68 87 57 62 20 72 03 46 33 67 46 55 12 32 63 93 53 69\n"
                + "04 42 16 73 38 25 39 11 24 94 72 18 08 46 29 32 40 62 76 36\n"
                + "20 69 36 41 72 30 23 88 34 62 99 69 82 67 59 85 74 04 36 16\n"
                + "20 73 35 29 78 31 90 01 74 31 49 71 48 86 81 16 23 57 05 54\n"
                + "01 70 54 71 83 51 54 69 16 92 33 48 61 43 52 01 89 19 67 48";
        String[] rows = s.split("\n");

        int[][] grid = new int[rows.length][rows.length];//assumes square grid;

        for (int i = 0; i < rows.length; i++) {
            String[] cells = rows[i].split(" ");
            for (int j = 0; j < rows.length; j++) {
                grid[i][j] = Integer.parseInt(cells[j]);
            }
        }

        int size = rows.length;
        int bestProduct = -1;
        //first from right to left
        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size - 3; col++) {
                int product = 1;
                for (int i = 0; i < 4; i++) {
                    product *= grid[row][col + i];
//                    System.out.print(grid[row][col + i] + " ");

                }
//                    System.out.println("");
//                    System.out.println("product: " + product);
                if (product > bestProduct) {
                    bestProduct = product;
//                    System.out.println("row: " + row + " col: " + col);
                }
            }
        }

        //now top to bottom
        for (int row = 0; row < size - 3; row++) {
            for (int col = 0; col < size; col++) {
                int product = 1;
                for (int i = 0; i < 4; i++) {
                    product *= grid[row + i][col];
                }

                if (product > bestProduct) {
                    bestProduct = product;
                }
            }
        }

        //diagonal left to right
        for (int row = 0; row < size - 3; row++) {
            for (int col = 0; col < size - 3; col++) {
                int product = 1;
                for (int i = 0; i < 4; i++) {
                    product *= grid[row + i][col + i];
                }

                if (product > bestProduct) {
                    bestProduct = product;
                }
            }
        }

        //diagonal right to left
        for (int row = 3; row < size; row++) {
            for (int col = 0; col < size - 3; col++) {
                int product = 1;
                for (int i = 0; i < 4; i++) {
                    product *= grid[row - i][col + i];
                }

                if (product > bestProduct) {
                    bestProduct = product;
                }
            }
        }

        System.out.println(bestProduct);
    }

    public static void Problem12() {
        //...so we can find all triangle numbers through the equation
        //  n(n+1)/2
        int factorCount = -1;
        int bestFactorCount = -1;
        for (int i = 1; factorCount <= 500; i++) {
            int t = (i * (i + 1)) / 2;

            Integer[] factors = Utility.findFactors(t);
            factorCount = factors.length;

            if (factorCount > bestFactorCount) {
                bestFactorCount = factorCount;
                System.out.print(t + ":" + factorCount + ":");
                System.out.println(Utility.join(factors, " "));
            }
        }
    }

    //Highly Composite Number
    public static class HCNumber {

        public long value;
        public ArrayList<Exp> expList;
        public long divisorCount;

        public HCNumber() {
            expList = new ArrayList<>();
        }

        public HCNumber(HCNumber o) {
            value = o.value;
            divisorCount = o.divisorCount;

            expList = new ArrayList<>(o.expList.size());
            for (Exp e : o.expList) {
                expList.add(new Exp(e));
            }
        }
    }

    public static class Exp {

        public int prime;
        public int exponent;

        public Exp(int p, int e) {
            prime = p;
            exponent = e;
        }

        public Exp(Exp o) {
            prime = o.prime;
            exponent = o.exponent;
        }
    }

    public static long findDivisorCount(Collection<Exp> expList) {
        long result = 1;
        for (Exp e : expList) {
            //http://en.wikipedia.org/wiki/Highly_composite_number
            result *= (e.exponent + 1);
        }

        return result;
    }

    public static long findHCNumberValue(Collection<Exp> expList) {
        double result = 1;
        for (Exp e : expList) {
            result *= Math.pow(e.prime, e.exponent);
        }

        return (long) result;
    }

    public static ArrayList<HCNumber> findChildren(HCNumber num) {
        //we want to successivly add one until (and including) the first 0;
        ArrayList<HCNumber> ret = new ArrayList<>();
        for (int i = 0; i < num.expList.size(); i++) {
            HCNumber h = new HCNumber(num);

            Exp value = h.expList.get(i);
            value.exponent++;
            h.expList.set(i, value);

            ret.add(h);
        }

        HCNumber h = new HCNumber(num);
        Exp e = new Exp(primes[num.expList.size()], 1);
        h.expList.add(e);
        ret.add(h);

        return ret;
    }

    public static boolean isTriangleNumber(long i) {
        i = (i * 8) + 1;
        Double d = Math.sqrt(i);
        if (Math.floor(d) == d) {
            i = (d.longValue() - 1) % 2;
            if (i == 0) {
                return true;
            }
        }

        return false;
    }

    static int[] primes = {2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97, 101, 103, 107, 109, 113, 127, 131, 137, 139, 149, 151, 157, 163, 167, 173, 179, 181, 191, 193, 197, 199, 211, 223, 227, 229, 233, 239, 241, 251, 257, 263, 269, 271, 277, 281, 283, 293, 307, 311, 313, 317, 331, 337, 347, 349, 353, 359, 367, 373, 379, 383, 389, 397, 401, 409, 419, 421, 431, 433, 439, 443, 449, 457, 461, 463, 467, 479, 487, 491, 499, 503, 509, 521, 523, 541, 547, 557, 563, 569, 571, 577, 587, 593, 599, 601, 607, 613, 617, 619, 631, 641, 643, 647, 653, 659, 661, 673, 677, 683, 691, 701, 709, 719, 727, 733, 739, 743, 751, 757, 761, 769, 773, 787, 797, 809, 811, 821, 823, 827, 829, 839, 853, 857, 859, 863, 877, 881, 883, 887, 907, 911, 919, 929, 937, 941, 947, 953, 967, 971, 977, 983, 991, 997};

    public static void Problem12_2() {
        //try by finding highly composite numbers
        HCNumber h = new HCNumber();
        Exp e = new Exp(primes[0], 1);
        h.expList.add(e);
        h.value = findHCNumberValue(h.expList);
        h.divisorCount = findDivisorCount(h.expList);

        TreeMap<Long, HCNumber> resultMap = new TreeMap<>();
        resultMap.put(h.value, h);

        long maxFactors = h.divisorCount;
        while (maxFactors < 500) {
            ArrayList<HCNumber> addingList = new ArrayList<>();
            for (HCNumber n : resultMap.values()) {
                ArrayList<HCNumber> childList = findChildren(n);

                for (HCNumber c : childList) {
                    c.value = findHCNumberValue(c.expList);

                    if (!resultMap.containsKey(c.value)) {
                        if (isTriangleNumber(c.value)) {
                            c.divisorCount = findDivisorCount(c.expList);
                            if (c.divisorCount > maxFactors) {
                                maxFactors = c.divisorCount;
                            }
                        }
                        addingList.add(c);
                    }
                }
            }

            for (HCNumber n : addingList) {
                resultMap.put(n.value, n);
            }
        }

        for (HCNumber n : resultMap.values()) {
            if (isTriangleNumber(n.value) && n.divisorCount >= 500) {
                System.out.println(n.value + ":" + n.divisorCount);
            }
        }
    }

    public static void Problem13() {
        String[] numbers = ("37107287533902102798797998220837590246510135740250\n"
                + "46376937677490009712648124896970078050417018260538\n"
                + "74324986199524741059474233309513058123726617309629\n"
                + "91942213363574161572522430563301811072406154908250\n"
                + "23067588207539346171171980310421047513778063246676\n"
                + "89261670696623633820136378418383684178734361726757\n"
                + "28112879812849979408065481931592621691275889832738\n"
                + "44274228917432520321923589422876796487670272189318\n"
                + "47451445736001306439091167216856844588711603153276\n"
                + "70386486105843025439939619828917593665686757934951\n"
                + "62176457141856560629502157223196586755079324193331\n"
                + "64906352462741904929101432445813822663347944758178\n"
                + "92575867718337217661963751590579239728245598838407\n"
                + "58203565325359399008402633568948830189458628227828\n"
                + "80181199384826282014278194139940567587151170094390\n"
                + "35398664372827112653829987240784473053190104293586\n"
                + "86515506006295864861532075273371959191420517255829\n"
                + "71693888707715466499115593487603532921714970056938\n"
                + "54370070576826684624621495650076471787294438377604\n"
                + "53282654108756828443191190634694037855217779295145\n"
                + "36123272525000296071075082563815656710885258350721\n"
                + "45876576172410976447339110607218265236877223636045\n"
                + "17423706905851860660448207621209813287860733969412\n"
                + "81142660418086830619328460811191061556940512689692\n"
                + "51934325451728388641918047049293215058642563049483\n"
                + "62467221648435076201727918039944693004732956340691\n"
                + "15732444386908125794514089057706229429197107928209\n"
                + "55037687525678773091862540744969844508330393682126\n"
                + "18336384825330154686196124348767681297534375946515\n"
                + "80386287592878490201521685554828717201219257766954\n"
                + "78182833757993103614740356856449095527097864797581\n"
                + "16726320100436897842553539920931837441497806860984\n"
                + "48403098129077791799088218795327364475675590848030\n"
                + "87086987551392711854517078544161852424320693150332\n"
                + "59959406895756536782107074926966537676326235447210\n"
                + "69793950679652694742597709739166693763042633987085\n"
                + "41052684708299085211399427365734116182760315001271\n"
                + "65378607361501080857009149939512557028198746004375\n"
                + "35829035317434717326932123578154982629742552737307\n"
                + "94953759765105305946966067683156574377167401875275\n"
                + "88902802571733229619176668713819931811048770190271\n"
                + "25267680276078003013678680992525463401061632866526\n"
                + "36270218540497705585629946580636237993140746255962\n"
                + "24074486908231174977792365466257246923322810917141\n"
                + "91430288197103288597806669760892938638285025333403\n"
                + "34413065578016127815921815005561868836468420090470\n"
                + "23053081172816430487623791969842487255036638784583\n"
                + "11487696932154902810424020138335124462181441773470\n"
                + "63783299490636259666498587618221225225512486764533\n"
                + "67720186971698544312419572409913959008952310058822\n"
                + "95548255300263520781532296796249481641953868218774\n"
                + "76085327132285723110424803456124867697064507995236\n"
                + "37774242535411291684276865538926205024910326572967\n"
                + "23701913275725675285653248258265463092207058596522\n"
                + "29798860272258331913126375147341994889534765745501\n"
                + "18495701454879288984856827726077713721403798879715\n"
                + "38298203783031473527721580348144513491373226651381\n"
                + "34829543829199918180278916522431027392251122869539\n"
                + "40957953066405232632538044100059654939159879593635\n"
                + "29746152185502371307642255121183693803580388584903\n"
                + "41698116222072977186158236678424689157993532961922\n"
                + "62467957194401269043877107275048102390895523597457\n"
                + "23189706772547915061505504953922979530901129967519\n"
                + "86188088225875314529584099251203829009407770775672\n"
                + "11306739708304724483816533873502340845647058077308\n"
                + "82959174767140363198008187129011875491310547126581\n"
                + "97623331044818386269515456334926366572897563400500\n"
                + "42846280183517070527831839425882145521227251250327\n"
                + "55121603546981200581762165212827652751691296897789\n"
                + "32238195734329339946437501907836945765883352399886\n"
                + "75506164965184775180738168837861091527357929701337\n"
                + "62177842752192623401942399639168044983993173312731\n"
                + "32924185707147349566916674687634660915035914677504\n"
                + "99518671430235219628894890102423325116913619626622\n"
                + "73267460800591547471830798392868535206946944540724\n"
                + "76841822524674417161514036427982273348055556214818\n"
                + "97142617910342598647204516893989422179826088076852\n"
                + "87783646182799346313767754307809363333018982642090\n"
                + "10848802521674670883215120185883543223812876952786\n"
                + "71329612474782464538636993009049310363619763878039\n"
                + "62184073572399794223406235393808339651327408011116\n"
                + "66627891981488087797941876876144230030984490851411\n"
                + "60661826293682836764744779239180335110989069790714\n"
                + "85786944089552990653640447425576083659976645795096\n"
                + "66024396409905389607120198219976047599490197230297\n"
                + "64913982680032973156037120041377903785566085089252\n"
                + "16730939319872750275468906903707539413042652315011\n"
                + "94809377245048795150954100921645863754710598436791\n"
                + "78639167021187492431995700641917969777599028300699\n"
                + "15368713711936614952811305876380278410754449733078\n"
                + "40789923115535562561142322423255033685442488917353\n"
                + "44889911501440648020369068063960672322193204149535\n"
                + "41503128880339536053299340368006977710650566631954\n"
                + "81234880673210146739058568557934581403627822703280\n"
                + "82616570773948327592232845941706525094512325230608\n"
                + "22918802058777319719839450180888072429661980811197\n"
                + "77158542502016545090413245809786882778948721859617\n"
                + "72107838435069186155435662884062257473692284509516\n"
                + "20849603980134001723930671666823555245252804609722\n"
                + "53503534226472524250874054075591789781264330331690").split("\n");

        //General idea: add each column left to right until the first 10 digits stabalize
        long last = 0;
        for (int i = 1; i < 49; i++) {
            long result = 0;
            for (String number : numbers) {
                result += Long.parseLong(number.substring(0, i));
            }
            System.out.println(result);

            if (Long.toString(last).length() >= 10
                    && Long.toString(last).substring(0, 10).equals(Long.toString(result).substring(0, 10))) {
                break;
            }

            last = result;
        }

    }

    private static void Problem14_r(HashMap<Long, Long> results, long current) {
        long next;
        if (current % 2 == 0) {
            next = current / 2;
        } else {
            next = (current * 3) + 1;
        }

        if (!results.containsKey(next)) {
            Problem14_r(results, next);
        }

        results.put(current, results.get(next) + 1);
    }

    public static void Problem14() {
        HashMap<Long, Long> results = new HashMap<>();

        results.put(1L, 1L);

        for (long i = 1; i <= 1000000; i++) {
            if (!results.containsKey(i)) {
                Problem14_r(results, i);
            }
        }

        long best = -1;
        for (long i = 1; i <= 1000000; i++) {
            long value = results.get(i);
            if (best < value) {
                best = value;
                System.out.println(i + ":" + value);
            }
        }
    }

    public static void Problem15() {
        int size = 20;
        long[][] results = new long[size + 1][size + 1];

        //init
        for (int i = 0; i <= size; i++) {
            results[0][i] = 1;
            results[i][0] = 1;
        }

        for (int i = 1; i <= size; i++) {
            for (int j = 1; j <= size; j++) {
                results[i][j] = results[i - 1][j] + results[i][j - 1];
            }
        }

        System.out.println(results[size][size]);
    }

    public static void Problem16() {
        byte[] digits = new byte[350];

        digits[0] = 1;
        for (int i = 1; i <= 1000; i++) {
            for (int j = 348; j >= 0; j--) {
                digits[j] *= 2;
                digits[j + 1] += digits[j] / 10;
                digits[j] %= 10;
            }
        }

        for (int i = 349; i >= 0; i--) {
            System.out.print(digits[i]);
        }
        System.out.println();
        
        long result = 0;
        for (int i = 349; i >= 0; i--) {
            result += digits[i];
        }
        System.out.println(result);
    }
}
