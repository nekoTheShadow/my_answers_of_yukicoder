object Q537 {
  def main(args: Array[String]): Unit = {
    val n = io.StdIn.readLine().toLong
    val answer = (1 to math.sqrt(n).toInt).filter(n % _ == 0).flatMap(x => {
      val y = n / x
      Seq(s"${x}${y}", s"${y}${x}")
    }).toSet.size
    println(answer)
  }
}