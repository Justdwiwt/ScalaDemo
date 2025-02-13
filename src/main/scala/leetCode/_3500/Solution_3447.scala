package leetCode._3500

object Solution_3447 {
  def assignElements(groups: Array[Int], elements: Array[Int]): Array[Int] = {
    val mx = groups.max
    val target = collection.mutable.ArrayBuffer.fill(mx + 1)(-1)

    elements.zipWithIndex.foreach { case (x, i) =>
      if (x <= mx && target(x) == -1)
        (x to mx by x).foreach(y => if (target(y) == -1) target(y) = i)
    }

    groups.map(x => if (target(x) >= 0) target(x) else -1)
  }
}
