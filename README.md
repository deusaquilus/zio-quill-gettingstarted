# ZIO-Quill Getting Started

This is a trivial example using ZIO-Quill with some helpful scripts to automatically setup a postgres database.
For a slighly more complete example try: [quill-examples-zymposium](https://github.com/kitlangton/quill-examples-zymposium).

## Instructions
1. Download and install docker.
2. Run the start script: `./start.sh`
3. Compile and run the examples: `sbt 'runMain example.Main'`
   ```
   > sbt 'runMain example.Main'
   [info] compiling 1 Scala source to /path/zio-quill-gettingstarted/target/scala-2.13/classes ...
   [info] /path/zio-quill-gettingstarted/src/main/scala/example/Main.scala:30:9: SELECT x.name, x.age FROM person x
   [info]      run(query[Person]).provide(env)
   [info]         ^
   [info] /path/zio-quill-gettingstarted/src/main/scala/example/Main.scala:32:9: SELECT p.name, p.age FROM person p WHERE p.age > ?
   [info]      run(query[Person].filter(p => p.age > lift(age))).provide(env)
   [info]         ^
   [info] running example.Main
   Results: List(Person(Joe Bloggs,22), Person(Jim Roggs,33), Person(Vlad Dracul,321))
   ```
4. Open the project with your favorite scala IDE or editor and explore! VS Code is one option.
   (Download Visual Studio Code and Metals)
   ```
   code .
   ```
5. Stop the container `./stop.sh`
