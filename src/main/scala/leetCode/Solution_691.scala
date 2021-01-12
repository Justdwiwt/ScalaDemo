package leetCode

object Solution_691 {
  def minStickers(stickers: Array[String], target: String): Int = {
    def f(state: Int, sticker: String, target: String): Int = {
      var next = state
      sticker.foreach(char => {
        val pos = target.indices.find(k => ((next >> k) & 1) == 0 && char == target(k))
        if (pos.nonEmpty) next = next + (1 << pos.get)
      })
      next
    }

    val N = 1 << target.length
    val dp = Array.fill(N + 1)(Int.MaxValue / 2)
    dp(0) = 0
    (0 to N - 2).withFilter(i => dp(i) < Int.MaxValue / 2).foreach(i => stickers.foreach(sticker => {
      val next = f(i, sticker, target)
      dp(next) = dp(next).min(dp(i) + 1)
    }))
    if (dp(N - 1) < Int.MaxValue / 2) dp(N - 1) else -1
  }
}
