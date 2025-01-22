import org.jetbrains.sbtidea.Keys.*

ThisBuild / intellijPluginName := "My Awesome Framework"
ThisBuild / intellijBuild := "243.22562.218"
ThisBuild / intellijPlatform := IntelliJPlatform.IdeaCommunity

lazy val myAwesomeFramework =
  project.in(file("."))
    .enablePlugins(SbtIdeaPlugin)
    .settings(
      version := "0.0.1-SNAPSHOT",
      scalaVersion := "2.13.16",
      Compile / javacOptions ++= Seq("--release", "17"),
      Compile / scalacOptions ++= Seq("--release", "17"),
      intellijPlugins += "com.intellij.properties".toPlugin,
      libraryDependencies ++= Seq(
        "com.eclipsesource.minimal-json" % "minimal-json" % "0.9.5"
      ),
      Compile / unmanagedResourceDirectories += baseDirectory.value / "resources",
      Test / unmanagedResourceDirectories += baseDirectory.value / "testResources",
    )
