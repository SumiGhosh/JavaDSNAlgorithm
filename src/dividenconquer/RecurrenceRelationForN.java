package dividenconquer;

public class RecurrenceRelationForN {

    /*
    * Total amount of time taken to execute the below functions is
    * T(n) = T(n-1) + 1
    *
    * So
    *
    * T(n) = T(n-1) + 1 when n > 0
    * And T(n) = 1 when n = 0
    *
    * T(n-1) = T(n-2) + 1
    *
    * Substituting to T(n-1)
    *
    * T(n) = T(n-2) + 2
    *
    * Similarly till T(k) times and assuming n-k = 0, hence n=k
    *
    * So T(k) = T(n-k) + k
    *
    * substituting k=n
    *
    * T(k) = T(0) + n
    * T(k) = n +1 where T(0) is 1
    *
    * So the function has just Order of n or simply O(n)
    * */

    public static void recurrence(int n){ //T(n)
        if(n>0){// executed 1 times
            recurrence(n-1);//executed T(n-1) times
        }
    }
}
