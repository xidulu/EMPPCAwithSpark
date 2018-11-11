name := "emPca"

version := "0.1"

scalaVersion := "2.11.1"

libraryDependencies  ++= Seq(
  "org.apache.spark" %% "spark-core" % "2.3.2",
  "org.apache.spark" %% "spark-mllib"% "2.2.0",

  // Last stable release
  "org.scalanlp" %% "breeze" % "0.13.2"
)