package snake.ladder
import scala.util.Random

/**
 * Created by samikc on 19/3/16.
 */
class Dice {

  def roll(): Int = {
    var result = Random.nextInt() % 7
    if (result < 0) {
        result = - result
    } else if (result == 0) {
      while (result == 0) {
        result = roll()
      }
    }
    result
  }

}
