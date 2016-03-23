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

import scala.collection.mutable.ArrayBuffer

class Board(val snakes: Array[Snake], val ladders: Array[Ladder], val dice: Dice = new Dice){

  val players = new ArrayBuffer[Player]()
  val cells = ArrayBuffer[Cell]()
  for (i <- 1 to 100) {
    var snakeToAdd : Snake = null
    for (snake <- snakes) {
      if (snake.head == i) {
        snakeToAdd = snake
      }
    }
    var ladderToAdd : Ladder = null
    for (ladder <- ladders) {
      if (ladder.tail == i) {
        ladderToAdd = ladder
      }
    }
    cells += new Cell(i, snakeToAdd,ladderToAdd)
  }
  def addPlayers(ps : Array[Player]) : Unit = {
    players ++= ps
  }

  def movePlayer(p : Player): (Int, Boolean) = {
    val status = p.move(dice)
    var playerPos = status._1
    val hasWon = status._2

    if (playerPos < 100) {
      val cell = cells(playerPos)
      if (cell.hasLadderTail()) {
        playerPos = cell.ladder.head
        println(p.name +" has got ladder")
      } else if (cell.hasSnakeHead()) {
        playerPos = cell.snake.tail
        println(p.name +" has got snake")
      } else {
        playerPos = playerPos
      }
      p.position = playerPos
      println("GAME PROGRESS: Player : "+p.name+"'s Position: "+playerPos)
    }
    (playerPos, hasWon)
  }
}

object Board{
  def makeBoard(): Board = {
    val snakes = new Array[Snake](5)
    snakes(0) = new Snake(20,11);
    snakes(1) = new Snake(40,35);
    snakes(2) = new Snake(50,7);
    snakes(3) = new Snake(98,5);
    snakes(4) = new Snake(78,32);

    val ladders = new Array[Ladder](5)
    ladders(0) = new Ladder(22,13)
    ladders(1) = new Ladder(42,37)
    ladders(2) = new Ladder(52,9)
    ladders(3) = new Ladder(99,12)
    ladders(4) = new Ladder(88,29)
    val board = new Board(snakes, ladders)
    board
  }
}