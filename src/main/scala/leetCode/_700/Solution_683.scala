package leetCode._700

object Solution_683 {
  def kEmptySlots(bulbs: Array[Int], k: Int): Int = {
    val ts = collection.mutable.TreeSet.empty[Int]

    def checkSlot(slot: Int, low: Option[Int], high: Option[Int]): Boolean =
      low.exists(slot - _ == k + 1) || high.exists(_ - slot == k + 1)

    bulbs
      .zipWithIndex
      .find { case (slot, _) =>
        val low = ts.rangeImpl(None, Some(slot)).lastOption
        val high = ts.rangeImpl(Some(slot), None).headOption
        if (checkSlot(slot, low, high)) true
        else {
          ts.add(slot)
          false
        }
      }
      .map(_._2 + 1)
      .getOrElse(-1)
  }
}
