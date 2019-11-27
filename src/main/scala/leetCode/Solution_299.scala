package leetCode

object Solution_299 {
  def getHint(secret: String, guess: String): String = {
    var a = 0
    var b = 0
    val m = Array.fill(10)(0)
    val n = Array.fill(10)(0)
    secret.indices.foreach(i => {
      if (secret(i) == guess(i)) a += 1
      else {
        m(secret(i) - '0') += 1
        n(guess(i) - '0') += 1
      }
    })
    (0 until 10).foreach(i => b += n(i).min(m(i)))
    a + "A" + b + "B"
  }
}
