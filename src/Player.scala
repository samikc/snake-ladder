/**
 *
 * Copyright 2016 Samik Chakraborty
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 * Created by samikc on 20/3/16.
 */
package snake.ladder

class Player (val name:String, var position: Int = 0) {
  var hasWon = false

  def apply(name:String) = new Player(name)

  def move(dice : Dice) : Int = {
    val num = dice.roll
    if (position == 0 && num == 1) {
      position = 1
    } else if (position != 0) {
      val pos = position + num
      if (  pos > 100) {
        position = position
      } else if (pos < 100) {
        position = pos
      } else if (pos == 100) {
        position = pos
        hasWon = true
      }
    } else if (position == 0 && num != 1) {
      position = 0
    }
    position
  }
}
