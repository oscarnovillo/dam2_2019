import org.apache.log4j.{Level, Logger}
import org.apache.spark.sql.{DataFrame, SparkSession}
import org.apache.spark.sql.functions._
import java.io.File

import scala.reflect.io.Directory


object Testing {

  Logger.getLogger("org").setLevel(Level.ERROR)

  def main(args: Array[String]): Unit = {
    val spark = SparkSession.builder().
      master("local").getOrCreate()

    spark.sparkContext.setLogLevel("ERROR");


    val df2018 = spark.read.option("header", "true").csv("datos/2018.csv")
    val df2017 = spark.read.option("header", "true").csv("datos/2017.csv")

    val muertos2018 = getMuertos(df2018, "2018")
    val muertos2017 = getMuertos(df2017, "2017")


    muertos2018.union(muertos2017).groupBy("DISTRITO").sum("count").show()
    //    df2018.filter(trim(col("LESIVIDAD")).equalTo("MT")).groupBy("Num Parte").
    //      agg(count("Num Parte") as "count").filter(col("count") > 1).show()
    //df.filter(col("LESIVIDAD") === "MT").select("DISTRITO","FECHA").distinct().groupBy("DISTRITO").count().show()
//    val path = "datos/lesividad";
//    this.deleteRecursively(path)
//    df2018.select(trim(col("LESIVIDAD")) as "LESIVIDAD").distinct().repartition(1).write.json(path);


  }

  def getMuertos(data: DataFrame, año: String): DataFrame = {
    println(año)
    val muertos = data.filter(trim(col("LESIVIDAD") as "LESIVIDAD").equalTo("MT"))

   val muertosPorParte = muertos.groupBy("Num Parte").
      agg(count("Num Parte") as "count");

    val muertosDistrito = muertosPorParte.join(data ,muertosPorParte("Num Parte") === data("Num Parte"),"inner").select(col("DISTRITO"),data("Num Parte")).distinct.groupBy("DISTRITO").
      agg(count("Num Parte") as "count")

muertosPorParte.filter(col("count").lt(1))
    println(muertos.count())
    muertosPorParte.filter(col("count") > 1).show()
    return muertosDistrito
  }


  def deleteRecursively(f: String): Unit = {
    val directory = new Directory(new File(f));

    directory.deleteRecursively()
  }
}
