package leetCode._4100

object Solution_4027 {
  def elevatorRequests(n: Int, start: Int, requests: Array[Array[Int]]): Long = {
    val m = requests.length
    val f = Array.fill(1 << m, m)(0L)

    requests.indices.foreach(i => {
      val Array(t, x) = requests(i)
      f(1 << i)(i) = math.max(math.abs(x - start), t).toLong
    })

    (1 until (1 << m))
      .withFilter(mask => (mask & (mask - 1)) != 0)
      .foreach(mask => requests
        .indices
        .withFilter(i => (mask >> i & 1) != 0)
        .foreach(i => {
          val Array(t, x) = requests(i)
          val rest = mask ^ (1 << i)

          f(mask)(i) = math.max(requests
            .indices
            .filter(j => (rest >> j & 1) != 0)
            .map(j => f(rest)(j) + math.abs(x - requests(j)(1)))
            .min,
            t.toLong
          )
        })
      )

    f.last.min
  }
}
