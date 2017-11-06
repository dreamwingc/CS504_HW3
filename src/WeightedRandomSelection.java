import java.util.Random;

public class WeightedRandomSelection {

    public WeightedRandomSelection(){
    }

    public static int sumAll(int[] weights) {
        int result = 0;

        if (weights == null) {
            result = 0;
        } else {
            for (int i = 0; i < weights.length; i++) {
                result += weights[i];
            }
        }
        return result;
    }

    public static String pickedBall(String[] ballList, int[] weights){
        Random random = new Random();
        int randomNumber = random.nextInt(sumAll(weights)) + 1;
        int i = 0;

        if (randomNumber == 0){
            return "Error: Wrong input of weights";
        }else{
            while(true){
                randomNumber -= weights[i];
                if (randomNumber <= 0){
                    break;
                }else {
                    i = (i + 1) % weights.length;
                }
            }
            return ballList[i];
        }
    }

    public static void main(String[] args){
        String[] ballList = {"Red", "Yellow", "Blue"};
        int[] weights = {4, 5, 1};
        int[] times = {0, 0, 0};
        int iters = 1000;

        for(int i = 0; i < iters; i++){
            String ballName = WeightedRandomSelection.pickedBall(ballList, weights);

            if (ballName == "Red"){
                times[0] += 1;
            }else if (ballName == "Yellow"){
                times[1] += 1;
            }else{
                times[2] += 1;
            }
            System.out.println(ballName);
        }

        for(int j = 0; j < times.length; j++){
            System.out.println(ballList[j] + " ball rate is" + " " + times[j] * 1.0 / WeightedRandomSelection.sumAll(times));
        }
    }
}

