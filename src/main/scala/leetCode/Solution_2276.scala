package leetCode

object Solution_2276 {
  class CountIntervals() {

    private val map = new java.util.TreeMap[Int, Int]()
    private var cnt = 0

    def add(left: Int, right: Int): Unit = {
      if (Option(map.floorKey(right)).forall(l => map.get(l) < left)) {
        map.put(left, right)
        cnt += right - left + 1
      } else {
        val (newLeft, newRight) = Iterator.iterate((left, right)) { case (left, right) =>
          val l = map.floorKey(right)
          val r = map.get(l)
          cnt -= r - l + 1
          map.remove(l)
          (left.min(l), right.max(r))
        }.dropWhile { case (left, right) =>
          Option(map.floorKey(right)).exists(l => map.get(l) >= left)
        }.next()

        map.put(newLeft, newRight)
        cnt += newRight - newLeft + 1
      }
    }

    def count(): Int = cnt

  }
}
