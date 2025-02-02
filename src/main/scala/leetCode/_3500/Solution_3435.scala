package leetCode._3500

object Solution_3435 {
  def supersequences(words: Array[String]): List[List[Int]] = {
    val allMask = words.foldLeft(0)((mask, word) => {
      val x = word(0) - 'a'
      val y = word(1) - 'a'
      mask | (1 << x) | (1 << y)
    })

    val graph = collection.mutable.Map[Int, List[Int]]().withDefaultValue(List.empty)
    words.foreach(word => {
      val x = word(0) - 'a'
      val y = word(1) - 'a'
      graph(x) = y :: graph(x)
    })

    def hasCycle(sub: Int): Boolean = {
      val color = Array.fill(26)(0)

      def dfs(x: Int): Boolean = {
        color(x) = 1
        val hasCycle = graph(x).exists(y => {
          if ((sub >> y & 1) == 0) {
            if (color(y) == 1 || (color(y) == 0 && dfs(y)))
              true
            else false
          } else false
        })
        color(x) = 2
        hasCycle
      }

      (0 until 26).exists(i => color(i) == 0 && (sub >> i & 1) == 0 && dfs(i))
    }

    val st = collection.mutable.Set[Int]()
    var minSize = Int.MaxValue
    var sub = allMask
    var continue = true

    while (continue) {
      val size = Integer.bitCount(sub)
      if (size <= minSize && !hasCycle(sub)) {
        if (size < minSize) {
          minSize = size
          st.clear()
        }
        st.add(sub)
      }
      sub = (sub - 1) & allMask
      if (sub == allMask) continue = false
    }

    st.map(sub => (0 until 26).map(i => (allMask >> i & 1) + (sub >> i & 1)).toList).toList
  }
}
