package leetCode.LCP

object LCP_68 {
  def beautifulBouquet(flowers: Array[Int], cnt: Int): Int = {
    val M = 1000000007

    def updateCount(arr: Map[Int, Int], flower: Int, delta: Int): Map[Int, Int] =
      arr.updated(flower, arr.getOrElse(flower, 0) + delta)

    val (res, _, _) = flowers.zipWithIndex.foldLeft((0, 0, Map.empty[Int, Int])) {
      case ((sum, l, arr), (flower, r)) =>
        val updatedArr = updateCount(arr, flower, 1)

        val (newL, newArr) = Iterator.iterate((l, updatedArr)) {
          case (currentL, currentArr) => (currentL + 1, updateCount(currentArr, flowers(currentL), -1))
        }.dropWhile { case (_, currentArr) => currentArr(flowers(r)) > cnt }.next()

        val newSum = (sum + (r - newL + 1)) % M

        (newSum, newL, newArr)
    }

    res
  }
}
