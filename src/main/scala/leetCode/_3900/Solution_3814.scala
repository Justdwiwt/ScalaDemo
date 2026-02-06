package leetCode._3900

object Solution_3814 {
  def maxCapacity(costs: Array[Int], capacity: Array[Int], budget: Int): Int = {
    val machines = costs
      .zip(capacity)
      .filter(_._1 < budget)
      .sortBy(_._1)

    val stack = collection.mutable.ArrayBuffer((0, 0))

    machines.foldLeft(0) {
      case (ans, (cost, cap)) =>
        while (stack.length > 1 && cost + stack.last._1 >= budget)
          stack.remove(stack.length - 1)

        val best = math.max(ans, cap + stack.last._2)

        if (cap > stack.last._2) stack += ((cost, cap))
        best
    }
  }
}
