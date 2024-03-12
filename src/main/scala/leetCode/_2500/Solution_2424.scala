package leetCode._2500

object Solution_2424 {
  class LUPrefix(_n: Int) {

    val st = scala.collection.mutable.Set.empty[Int]
    var mx = 0

    def upload(video: Int) {
      st.add(video)
      while (st.contains(mx + 1))
        mx += 1
    }

    def longest(): Int = mx

  }
}
