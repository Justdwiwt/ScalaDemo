package leetCode

object Solution_1146 {

  class SnapshotArray(_length: Int) {
    var id = 0
    private val m = scala.collection.mutable.HashMap[(Int, Int), Int]()

    def set(index: Int, x: Int) {
      m.put((id, index), x)
    }

    def snap(): Int = {
      id += 1
      id - 1
    }

    def get(index: Int, id: Int): Int =
      if (id == -1) 0
      else if (m.contains((id, index))) m((id, index))
      else get(index, id - 1)

  }

}
