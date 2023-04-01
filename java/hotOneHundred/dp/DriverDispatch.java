package hotOneHundred.dp;

/**
 * 一组司机被分配去 A/B两个中心，收入不一致，求最大的整体收入
 */
public class DriverDispatch {

    public static void main(String[] args) {


    }


    public int resolve(int[][] incomes) {
        if (incomes == null || incomes.length < 2 || (incomes.length & 1) != 0) {
            return 0;
        }
        int N = incomes.length;
        int M = N / 2;
        return process(incomes, 0, M);
    }

    public static int process(int[][] incomes, int index, int Arest) {
        if(index == incomes.length){
            return 0;
        }
        if (incomes.length - index == Arest) {
            return incomes[index][0] + process(incomes, index + 1, Arest - 1);
        }

        if (index < incomes.length && Arest == 0) {
            return incomes[index][1] + process(incomes, index + 1, Arest);
        }

        return Math.max(incomes[index][0] + process(incomes, index + 1, Arest - 1),
                incomes[index][1] + process(incomes, index + 1, Arest)
        );

    }
}

