package leetCode._1800

object Solution_1766 {
  // fixme: stack overflow

  val gcd: Array[Array[Boolean]] = Array.ofDim[Boolean](51, 51)
  val map: Array[List[Array[Int]]] = Array.fill(51)(List[Array[Int]]())
  var g: Array[List[Int]] = _
  var vis: Array[Boolean] = _
  var res: Array[Array[Int]] = _
  var t: Int = 0

  def getCoprimes(nums: Array[Int], edges: Array[Array[Int]]): Array[Int] = {
    if (!gcd(1)(1)) (1 to 50).foreach(i => (1 to 50).foreach(j => if (gcd(i, j) == 1) gcd(i)(j) = true))

    (1 to 50).foreach(i => map(i) = List.empty[Array[Int]])

    val n: Int = nums.length
    vis = Array.fill(n)(false)
    res = Array.fill(2, n)(-1)
    g = Array.fill(n)(List.empty[Int])

    edges.foreach(e => {
      val u: Int = e(0)
      val v: Int = e(1)
      g(u) ::= v
      g(v) ::= u
    })

    dfs(nums, 0)
    res(0)
  }

  private def dfs(nums: Array[Int], u: Int): Unit = {
    vis(u) = true
    val nu: Int = nums(u)

    (1 to 50).foreach(i => if (gcd(nu)(i) && map(i).nonEmpty && map(i).head(1) > res(1)(u)) {
      res(0)(u) = map(i).head(0)
      res(1)(u) = map(i).head(1)
    })

    map(nu) ::= Array(u, {
      t += 1;
      t
    })

    g(u).withFilter(!vis(_)).foreach(dfs(nums, _))

    map(nu).tail
  }

  @scala.annotation.tailrec
  private def gcd(a: Int, b: Int): Int =
    if (b == 0) a else gcd(b, a % b)
}
