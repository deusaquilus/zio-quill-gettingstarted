# ZIO-Quill Getting Started

This is a very simple starter codebase using ZIO-Quill with some helpful scripts to automatically setup a postgres database. For a slighly more complete example try: [quill-examples-zymposium](https://github.com/kitlangton/quill-examples-zymposium).

* The code in `src/main/scala/example/simple` shows a really simple of example of how to use the quill-jdbc-zio context.
* The code in `src/main/scala/example/module` shows how to use the quill-jdbc-zio context using a module 2.0 pattern.


## Instructions
1. Download and install docker.
2. Clone this repo: `git clone 'https://github.com/deusaquilus/zio-quill-gettingstarted.git'`
3. Run the start script: `./start.sh`
4. Compile and run the examples: `sbt 'runMain example.simple.Main'` (or `sbt 'runMain example.module.Main'`)
   ```
   > sbt 'runMain example.simple.Main'
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
