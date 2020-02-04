import CountWords.spark
import org.apache.log4j.{Level, Logger}
import org.apache.spark.sql.{DataFrame, SparkSession}
import org.apache.spark.sql.functions._

object Madrid extends App {

  Logger.getLogger("org").setLevel(Level.ERROR)
  val spark = SparkSession.builder().
    master("local").getOrCreate()
  import spark.implicits._

  spark.sparkContext.setLogLevel("ERROR");



  val madrid = spark.read.option("header", "true").option("encoding", "windows-1252").csv("datos/206974-0-agenda-eventos-culturales-100.csv")

  madrid.printSchema()
madrid.show()
  madrid.filter(col("NOMBRE-INSTALACION").like("(Latina)") && $"TIPO".contains("kk"))
  madrid.filter(col("NOMBRE-INSTALACION").equalTo("Auditorio y sala de exposiciones Paco de Lucía (Latina)") || col("TIPO") === "jjj")
    .select(col("TITULO"),col("TIPO")).foreach(row => println(row(0)+ " "+row(1).toString.split("/")(3)))

}
