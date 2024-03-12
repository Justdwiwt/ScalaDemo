package leetCode._400

object Solution_307 {

  class NumArray(_nums: Array[Int]) {

    private val vec = (0 to _nums.length).map(_ => 0).toVector
    private var curr = _nums.toVector
    private var numsList = (1 to _nums.length).foldLeft(vec)((pre, idx) => add(idx, _nums(idx - 1), pre))

    def update(idx: Int, newValue: Int): Unit = {
      numsList = add(idx + 1, newValue - curr(idx), numsList)
      curr = curr.updated(idx, newValue)
    }

    def sumRange(lIdx: Int, rIdx: Int): Int = {
      findSum(rIdx + 1, numsList) - findSum(lIdx, numsList)
    }

    def add(idx: Int, newValue: Int, numsList: Vector[Int]): Vector[Int] = {
      if (idx >= numsList.size) numsList
      else {
        val newList = numsList.updated(idx, numsList(idx) + newValue)
        add(idx + (idx & (-idx)), newValue, newList)
      }
    }

    def findSum(idx: Int, numsList: Vector[Int]): Int = {
      if (idx == 0) 0
      else numsList(idx) + findSum(idx - (idx & (-idx)), numsList)
    }
  }

}
