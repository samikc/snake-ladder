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

class Game{

  def play: Unit = {
    val players = Array[Player]( new Player("Jane") ,new Player("Jhon"))
    val board = Board.makeBoard()
    var moveCounter = 0
    var gameFinished = false
    val dice = new Dice
    board.addPlayers(players)
    while (gameFinished == false) {
      for (player <- players) {
        if (player.hasWon) {
          gameFinished = true
          println(player.name + " has won the game!!!")
        } else {
          board.movePlayer(player)
          moveCounter += 1
        }
      }
    }
    println("Game finished in "+ moveCounter + " moves.")
    for (p <- players) {
      println(p.name + "'s position is : " + p.position)
    }
  }

}
