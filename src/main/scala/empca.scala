//import org.apache.spark.ml.linalg.Matrices
import breeze.linalg.{inv, DenseMatrix => DM, DenseVector => BDV, SparseVector => BSV, Vector => BV}

import org.apache.spark.mllib.linalg.distributed.RowMatrix
import org.apache.spark.{SparkConf, SparkContext}
import org.apache.spark.mllib.linalg.{DenseMatrix, Matrices, Matrix, Vector, Vectors}
import org.apache.spark.rdd.RDD

import scala.util.Random

object empca {
  private lazy val conf = new SparkConf().setAppName("kmeans").setMaster("local")
  private lazy val sc = new SparkContext(conf)
  private val inputDir = "directory"
  var W: DM[Double] = _
  var M_inverse: DM[Double] = _
  var mu : BDV[Double] = _
  var sigma : Double = _

  def generateRandomPoints(n: Int, d: Int): List[Vector] = {
    val l = for {
      _ <- 1 to n
    } yield Vectors.dense(
      ((1 to d) map (_ => Random.nextDouble() * 100)).toArray
    )
    l.toList
  }

  def readData(): RDD[BDV[Double]] = {
    val File = sc.textFile(inputDir)
    File.map(x => x.split(',').map(_.toDouble).toArray).map(array => BDV(array))
  }

  def converge(): Boolean = {
    //fixme
    false
  }

  def run(): Unit = {
    val data = readData()
    val rddSize = data.count()
    val vectorSize = data.first().size
    while(!converge()) {
      // E-step
      val loc= data.map(x => M_inverse * W.t * (x - mu))
      val scale = data.map(x => sigma * M_inverse +
        (M_inverse * W.t * (x - mu)) *
          (M_inverse * W.t * (x - mu)).t )
      loc.cache()
      scale.cache()
      // M-step
      val w_new = data.map(x =>
        (x - mu) * (M_inverse * W.t * (x - mu)).t
      ).reduce(_ + _) * scale.reduce(_ + _)
      val sigma_new = 0 //fixme
    }

  }

  def main(args: Array[String]): Unit = {


  }
}
