object Q750 {
  def main(args: Array[String]) = {
    val n = io.StdIn.readLine().toInt
    Range(0, n).map(_ => io.StdIn.readLine()).sortBy(line => {
      val tokens = line.split(' ').map(_.toDouble).toSeq
      tokens(0) / tokens(1)
    }).reverse.foreach(println)
  }
}