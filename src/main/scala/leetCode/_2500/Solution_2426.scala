package leetCode._2500

object Solution_2426 {
  def numberOfPairs(a: Array[Int], nums2: Array[Int], diff: Int): Long = {
    val modifiedA = a.indices.map(i => a(i) - nums2(i)).toArray
    val sorted = modifiedA.distinct.sorted

    val t = new BIT(sorted.length + 1)

    modifiedA.foldLeft(0L)((res, x) => {
      res + t.query(lowerBound(sorted, x + diff + 1)).toLong + {
        t.add(lowerBound(sorted, x) + 1)
        0L
      }
    })
  }

  private def lowerBound(a: Array[Int], x: Int): Int = {
    @scala.annotation.tailrec
    def binarySearch(left: Int, right: Int): Int =
      if (left >= right) left
      else {
        val mid = left + (right - left) / 2
        if (a(mid) < x) binarySearch(mid + 1, right)
        else binarySearch(left, mid)
      }

    binarySearch(0, a.length)
  }
}

class BIT(n: Int) {
  private val tree = Array.fill(n)(0)

  def add(x: Int): Unit = {
    @scala.annotation.tailrec
    def update(idx: Int): Unit =
      if (idx < tree.length) {
        tree(idx) += 1
        update(idx + (idx & -idx))
      }

    update(x)
  }

  def query(x: Int): Int = {
    @scala.annotation.tailrec
    def sum(idx: Int, res: Int): Int =
      if (idx > 0) sum(idx & (idx - 1), res + tree(idx))
      else res

    sum(x, 0)
  }
}
