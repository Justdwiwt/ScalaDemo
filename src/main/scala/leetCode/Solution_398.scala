package leetCode

object Solution_398 {

  class Solution(_nums: Array[Int]) {

    def pick(target: Int): Int = _nums.foldLeft((-1, 1, 0)) {
      case ((idx, cnt, i), num) =>
        if (num == target) {
          if (util.Random.nextInt(cnt) == 0) (i, cnt + 1, i + 1)
          else (idx, cnt + 1, i + 1)
        }
        else (idx, cnt, i + 1)
    }._1

  }

}
