import sbt._

class Project(info: ProjectInfo) extends DefaultProject(info) {
  val djson = "net.databinder" %% "dispatch-json" % "0.7.8"
  val djhtp = "net.databinder" %% "dispatch-http-json" % "0.7.8"
  val ljs = "net.databinder" %% "dispatch-lift-json" % "0.7.8"
}
