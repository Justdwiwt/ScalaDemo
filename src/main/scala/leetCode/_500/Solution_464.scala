package leetCode._500

import scala.collection.mutable

object Solution_464 {
  def canIWin(maxChoosableInteger: Int, desiredTotal: Int): Boolean = {
    val M = 20
    val checkedPositions = new mutable.BitSet(1 << M)
    val checkedPositionsResult = new mutable.BitSet(1 << M)

    def save(pos: Int, flag: Boolean): Boolean = {
      checkedPositionsResult(pos) = flag
      checkedPositions(pos) = true
      flag
    }

    def check(firstPlayer: Boolean, pos: Int, total: Int): Boolean = {
      var idx = 0
      var flag = false
      while (idx < maxChoosableInteger && !flag) {
        val nextPosition = pos | (1 << idx)
        if (nextPosition != pos) flag |= (
          if (checkedPositions(nextPosition)) checkedPositionsResult(nextPosition)
          else {
            val nextLeftDesiredTotal = total - idx - 1
            if (nextLeftDesiredTotal <= 0) save(nextPosition, flag = true)
            else save(nextPosition, !check(!firstPlayer, nextPosition, nextLeftDesiredTotal))
          })
        idx += 1
      }
      flag
    }

    if (maxChoosableInteger * (maxChoosableInteger + 1) / 2 < desiredTotal) false
    else check(firstPlayer = true, 0, desiredTotal)
  }
}
