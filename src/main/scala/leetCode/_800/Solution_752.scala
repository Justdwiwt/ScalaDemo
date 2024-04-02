package leetCode._800

import scala.collection.immutable.Queue
import scala.collection.mutable

object Solution_752 {
  def openLock(deadends: Array[String], target: String): Int = {
    val deadendSet = deadends.toSet
    val seen = mutable.Set.empty[String]

    def expand(combo: Array[Char], turns: Int): Queue[(Array[Char], Int)] = {
      combo.zipWithIndex.foldLeft(Queue.empty[(Array[Char], Int)]) { case (cum, (digit, index)) =>
        val (childUp, childDown) = (combo.clone, combo.clone)
        childUp(index) = Character.forDigit((digit.asDigit + 1) % 10, 10)
        val digitDown = digit.asDigit - 1
        childDown(index) = Character.forDigit(if (digitDown == -1) 9 else digitDown, 10)

        def childToQueue(child: Array[Char]): Array[Char] = {
          val childAsStr = child.mkString
          if (!deadendSet.contains(childAsStr) && !seen.contains(childAsStr)) {
            seen += childAsStr
            child
          } else Array.empty[Char]
        }

        cum ++ Queue(childToQueue(childUp), childToQueue(childDown)).collect {
          case child if child.nonEmpty => (child, turns + 1)
        }
      }
    }

    @scala.annotation.tailrec
    def tryCombo(combos: Queue[(Array[Char], Int)], minSoFar: Int): Int = combos.headOption match {
      case None => minSoFar
      case Some((combo, turns)) if combo.mkString == target => tryCombo(combos.tail, minSoFar.min(turns))
      case Some((combo, turns)) => tryCombo(combos.tail ++ expand(combo, turns), minSoFar)
    }

    lazy val res = tryCombo(Queue(("0000".toCharArray, 0)), Int.MaxValue)
    if (deadendSet.contains("0000") || res == Int.MaxValue) -1 else res
  }
}
