package leetCode._3600

object Solution_3569 {
  private val MAXV = 100001

  val isPrime: Vector[Boolean] = {
    val arr = Array.fill(MAXV)(true)
    arr(0) = false
    arr(1) = false
    (2 to math.sqrt(MAXV).toInt)
      .withFilter(arr(_))
      .foreach(i => (i * i until MAXV by i).foreach(arr(_) = false))

    arr.toVector
  }

  case class SegmentTree(size: Int, sum: Vector[Int], max: Vector[Int]) {
    def this(n: Int) = this({
      var s = 1
      while (s < n + 2) s <<= 1
      s
    },
      Vector.fill(2 * {
        var s = 1
        while (s < n + 2) s <<= 1
        s
      })(0),
      Vector.fill(2 * {
        var s = 1
        while (s < n + 2) s <<= 1
        s
      })(0)
    )

    private def pointAdd(pos: Int, delta: Int): SegmentTree = {
      def update(i: Int, sumVec: Vector[Int], maxVec: Vector[Int]): (Vector[Int], Vector[Int]) = {
        val newSum = sumVec.updated(i, sumVec(i) + delta)
        val newMax = maxVec.updated(i, newSum(i).max(0))
        var idx = i >> 1
        var sVec = newSum
        var mVec = newMax
        while (idx > 0) {
          val left = idx << 1
          val right = left + 1
          val sumVal = sVec(left) + sVec(right)
          val maxVal = mVec(left).max(sVec(left) + mVec(right))
          sVec = sVec.updated(idx, sumVal)
          mVec = mVec.updated(idx, maxVal)
          idx >>= 1
        }
        (sVec, mVec)
      }

      val (newSum, newMax) = update(pos + size, sum, max)
      SegmentTree(size, newSum, newMax)
    }

    def applyRange(from: Int, to: Int, delta: Int): SegmentTree =
      if (from + 1 <= to) {
        val t1 = pointAdd(from + 1, delta)
        val t2 = t1.pointAdd(to + 1, -delta)
        t2
      } else this

    def getMax: Int = max(1)
  }

  import scala.collection.immutable.TreeSet

  def maximumCount(nums: Array[Int], queries: Array[Array[Int]]): Array[Int] = {
    val numsVec = nums.toVector
    val n = nums.length

    val initSegTree = new SegmentTree(n)

    val initPrimeIndices: Map[Int, TreeSet[Int]] =
      numsVec.zipWithIndex.foldLeft(Map.empty[Int, TreeSet[Int]]) { case (mp, (v, i)) =>
        if (v >= 0 && v < MAXV && isPrime(v)) mp.updated(v, mp.getOrElse(v, TreeSet.empty[Int]) + i)
        else mp
      }

    val (initTree, distinct) = initPrimeIndices.foldLeft((initSegTree, 0)) { case ((tree, cnt), (_, set)) =>
      val first = set.head
      val last = set.last
      (tree.applyRange(first, last, +1), cnt + 1)
    }

    @scala.annotation.tailrec
    def process(qs: List[(Int, Int)], numsCurr: Vector[Int], primeIdxsCurr: Map[Int, TreeSet[Int]], treeCurr: SegmentTree, distinctCurr: Int, acc: Vector[Int]): Vector[Int] = qs match {
      case Nil => acc
      case (idx, value) :: tail =>
        val old = numsCurr(idx)
        if (old == value) {
          val res = distinctCurr + treeCurr.getMax
          process(tail, numsCurr, primeIdxsCurr, treeCurr, distinctCurr, acc :+ res)
        } else {
          val (treeAfterRemove, primeIdxsAfterRemove, distinctAfterRemove) =
            if (old >= 0 && old < MAXV && isPrime(old)) {
              val set = primeIdxsCurr(old)
              val f1 = set.head
              val l1 = set.last
              val treeRemoved = treeCurr.applyRange(f1, l1, -1)
              val setRemoved = set - idx
              if (setRemoved.isEmpty) (treeRemoved, primeIdxsCurr - old, distinctCurr - 1)
              else {
                val f2 = setRemoved.head
                val l2 = setRemoved.last
                (treeRemoved.applyRange(f2, l2, +1), primeIdxsCurr.updated(old, setRemoved), distinctCurr)
              }
            } else (treeCurr, primeIdxsCurr, distinctCurr)

          val (treeAfterAdd, primeIdxsAfterAdd, distinctAfterAdd) =
            if (value >= 0 && value < MAXV && isPrime(value)) {
              if (!primeIdxsAfterRemove.contains(value)) {
                val newSet = TreeSet(idx)
                val treeAdded = treeAfterRemove.applyRange(idx, idx, +1)
                (treeAdded, primeIdxsAfterRemove + (value -> newSet), distinctAfterRemove + 1)
              } else {
                val set = primeIdxsAfterRemove(value)
                val f1 = set.head
                val l1 = set.last
                val treeRemoved = treeAfterRemove.applyRange(f1, l1, -1)
                val newSet = set + idx
                val f2 = newSet.head
                val l2 = newSet.last
                val treeAdded = treeRemoved.applyRange(f2, l2, +1)
                (treeAdded, primeIdxsAfterRemove.updated(value, newSet), distinctAfterRemove)
              }
            } else (treeAfterRemove, primeIdxsAfterRemove, distinctAfterRemove)

          val numsNew = numsCurr.updated(idx, value)
          val res = distinctAfterAdd + treeAfterAdd.getMax
          process(tail, numsNew, primeIdxsAfterAdd, treeAfterAdd, distinctAfterAdd, acc :+ res)
        }
    }

    val queriesList = queries.map(arr => (arr.head, arr(1))).toList

    process(queriesList, numsVec, initPrimeIndices, initTree, distinct, Vector.empty).toArray
  }
}
