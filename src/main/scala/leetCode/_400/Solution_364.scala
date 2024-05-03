package leetCode._400

import scala.collection.mutable

object Solution_364 {
  trait NestedInteger {
    def isInteger: Boolean

    def getInteger: Int

    def getList: Array[NestedInteger]
  }

  def depthSumInverse(nestedList: List[NestedInteger]): Int = {
    if (nestedList == null || nestedList.isEmpty) return 0

    val queue = mutable.Queue.empty[NestedInteger]
    val levelSum = mutable.Stack[Int]()

    nestedList.foreach(queue.enqueue(_))

    while (queue.nonEmpty) {
      val size = queue.size
      var eachLevel = 0

      (0 until size).foreach(_ => {
        val temp = queue.dequeue()
        if (temp.isInteger) eachLevel += temp.getInteger
        else temp.getList.foreach(queue.enqueue(_))
      })
      levelSum.push(eachLevel)
    }

    levelSum.zipWithIndex.map { case (sum, index) => (index + 1) * sum }.sum
  }
}
