package leetCode._1200

object Solution_1157 {

  class MajorityChecker(_arr: Array[Int]) {

    private val arr = _arr

    def count(x: Int): Array[Int] = {
      val B = Array.fill(20001)(0)
      (0 to x).foreach(i => B(arr(i)) += 1)
      B
    }

    private val m = scala.collection.mutable.HashMap[Int, Array[Int]]()

    def query(left: Int, right: Int, threshold: Int): Int = {
      if (left == right && threshold == 1) return arr(left)
      val ls = if (m.contains(left)) m(left) else count(left)
      val rs = if (m.contains(right)) m(right) else count(right)
      m += left -> ls
      m += right -> rs
      rs(arr(left)) += 1
      (1 to 20000).withFilter(i => rs(i) - ls(i) >= threshold).foreach(i => {
        rs(arr(left)) -= 1
        return i
      })
      rs(arr(left)) -= 1
      -1
    }

  }

}
